package info.makowey.boardgames.chilipir.service;

import com.jaunt.ResponseException;
import com.mongodb.client.result.DeleteResult;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Word;
import info.makowey.boardgames.chilipir.repository.BoardGameRepository;
import info.makowey.boardgames.chilipir.repository.WordRepository;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import info.makowey.boardgames.chilipir.scraper.stores.GeekMarketScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.OLXScrapperGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class CollectorServiceImpl implements CollectorService {

    private final BoardGameRepository boardGameRepository;
    private final WordRepository wordRepository;

    private final MongoTemplate mongoTemplate;
    private Comparator<BoardGame> byCurrentPrice = Comparator.comparing(BoardGame::getCurrentPrice);
	private final List<String> allIds;

    @Autowired
    public CollectorServiceImpl(BoardGameRepository boardGameRepository,
                                WordRepository wordRepository,
                                MongoTemplate mongoTemplate) {
        this.boardGameRepository = boardGameRepository;
        this.wordRepository = wordRepository;
        this.mongoTemplate = mongoTemplate;

		allIds = traceAll().stream()
				.map( BoardGame::getId )
				.collect( Collectors.toList() );
		Collections.shuffle( allIds );
    }

    private List<String> getAllIds() {
		return allIds;
    }

    @Override
    public List<BoardGame> traceAll() {
        Query query = new Query();
        //query.skip(pageNumber * pageSize);
		query.addCriteria( Criteria.where( "currentPrice" ).gte( 100 ) );
		query.limit( 300 );
        return mongoTemplate.find(query, BoardGame.class);
    }

    @Override
    public void storeBoardGames(List<BoardGame> boardGames) {
        boardGameRepository.saveAll(boardGames);
    }

    @Override
    public DeleteResult deleteByName(Source source, String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(name, "i")
                .andOperator(Criteria.where("store.name").is(source.getSiteName())));
        return mongoTemplate.remove(query, BoardGame.class);
    }

    @Override
    public DeleteResult deleteByStoreName(String storeName, String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("store.name").is(storeName));
        log.info("Deleting items from {} ", storeName);
        return mongoTemplate.remove(query, BoardGame.class);
    }

    private DeleteResult deleteBySouce(Source source) {
        Query query = new Query();
        query.addCriteria(Criteria.where("store.name").is(source.getSiteName()));
        log.info("Deleting items from {} ", source.getSiteName());
        return mongoTemplate.remove(query, BoardGame.class);
    }

    @Override
    public int count() {
        return Math.toIntExact(boardGameRepository.count());
    }

    @Override
    public List<BoardGame> search(String name, BoardGameExtractor boardGameExtractor) throws
            ResponseException,
            IOException {
        log.info("Extracting from " + boardGameExtractor.name());

        List<BoardGame> games = boardGameExtractor.search(name.replaceAll(" ", "%20"));

		games.forEach( game -> Optional.ofNullable( findById( game.getId() ) )
                .ifPresentOrElse(
                        boardGame -> {
                            boardGameRepository.delete(game);

                            boardGame.setCurrentPrice(game.getCurrentPrice());

                            if (boardGame.getLowestPriceEver() < 1)
                                boardGame.setLowestPriceEver(boardGame.getCurrentPrice());

                            if (boardGame.getNormalPrice() < 1)
                                boardGame.setNormalPrice(boardGame.getCurrentPrice());

                            if (boardGame.getCurrentPrice() < boardGame.getLowestPriceEver()) {
                                boardGame.setLowestPriceEver(boardGame.getCurrentPrice());
                            }

                            double percent = (boardGame.getCurrentPrice() * 100) / boardGame.getNormalPrice();
                            boardGame.setPercent((int) (100 - percent));

                            boardGameRepository.save(boardGame);
                        }, () -> boardGameRepository.save(game)));

        return games;
    }

    @Override
    public List<BoardGame> findByName(String name) {
        String[] words = name.split(" ");
        Query query = new Query();
        Criteria criteria = new Criteria();
        Criteria[] criteriaList = new Criteria[words.length];
        int index = 0;
        for (String word : words) {
            word = word.replaceAll("[-.+*?\\[^\\]$(){}=!<>|:\\\\]", "\\\\$0");
            criteriaList[index++] = Criteria.where("name").regex(word, "i");
        }
        criteria.andOperator(criteriaList);
        query.addCriteria(criteria);
        query.limit(100);

        return mongoTemplate.find(query, BoardGame.class).stream()
                .sorted(byCurrentPrice)
                .collect(Collectors.toList());
    }

	@Override
	public BoardGame findById( String id ) {
		Query query = new Query();
		query.addCriteria( Criteria.where( "_id" ).is( id ) );
		query.limit( 1 );
		List<BoardGame> result = mongoTemplate.find( query, BoardGame.class );
		return result.isEmpty() ?
				null :
				result.get( 0 );
	}

	@Override
    public List<BoardGame> findBGGByName(String name) throws IOException {
        return GeekMarketScrapperGame.INSTANCE.searchOnline(name);
    }

    @Override
    public List<BoardGame> findAll(String name, String geekMarket) throws IOException {
        List<BoardGame> allGames = new ArrayList<>(findByName(name));
        if (Boolean.valueOf(geekMarket))
            allGames.addAll(findBGGByName(name));

        return allGames.stream()
                .sorted(byCurrentPrice.reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Double getCurrentPrice(String name) {
        return findByName(name).stream()
                .filter(boardGame -> boardGame.getStore().getName() != null)
                .filter(boardGame -> !boardGame.getStore().getName().equals(Source.EMAG.name()))
                .filter(boardGame -> !boardGame.getStore().getName().equals(Source.ELEFANT.name()))
                .mapToDouble(BoardGame::getCurrentPrice)
                .average()
                .orElse(0.0);
    }

    public void countWords(String name) {
        String[] words = name.split("%20");
        Stream.of(words)
                .filter(s -> !s.isEmpty())
                .forEach(s -> {
                    Word word = wordRepository.findByName(s);
                    Optional.ofNullable(word)
                            .ifPresentOrElse(sameWord -> {
                                sameWord.setCount(Objects.requireNonNull(sameWord).getCount() + 1);
                                wordRepository.save(sameWord);
                            }, () -> wordRepository.save(Word.builder().name(s).count(1).build()));
                });
    }

    public int countWords() {
        return Math.toIntExact(wordRepository.count());
    }

    public Word findWordByName(String name) {
        return wordRepository.findByName(name);
    }

    @Override
    public BoardGame getOne() {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(getAllIds().iterator().next()));
        BoardGame boardGame = mongoTemplate.findOne(query, BoardGame.class);

        List<BoardGame> boardGames = findByName(Objects.requireNonNull(boardGame).getName());
        OptionalDouble bestPrice = boardGames.stream()
                .mapToDouble(BoardGame::getCurrentPrice)
                .min();

        Optional<BoardGame> first = boardGames.stream()
                .filter(boardGame1 -> boardGame1.getCurrentPrice() == bestPrice.getAsDouble())
                .findFirst();

        first.ifPresent(game -> {
            game.setBestPrice(bestPrice.orElse(0.0));
            boardGameRepository.save(boardGame);
        });

        return first.orElse(boardGame);
    }

    @Override
    public List<BoardGame> blackFriday(short percent) {
        Query query = new Query();
        query.addCriteria(Criteria.where("percent").gte(percent));
        query.limit(300);
        return mongoTemplate.find(query, BoardGame.class);
    }

    @Scheduled(fixedRate = 12 * 60 * 60 * 1_000)
    private void updateOLX() {
        deleteBySouce( Source.OLX );
        boardGameRepository.saveAll( OLXScrapperGame.INSTANCE.fetchAllGames() );
        getOne();
    }

    @Scheduled(cron = "0 1 1 * * *", zone = "Europe/Istanbul")
    //@Scheduled(fixedRate = 10 * 60 * 60 * 1_000)
    private void reloadAllGames() {
        //boardGameRepository.deleteAll();

        List<Word> words = wordRepository.findAll();
        log.info("Loaded {} words!", words.size());

        final Set<String> bggUsers = new HashSet<>();
        final Set<String> splittedWords = new HashSet<>();
        final Set<String> finalWords = words.stream()
                .map(Word::getName)
                .distinct()
                .filter(s -> s.length() > 3)
                .peek(s -> {
                    if (s.startsWith("@") && s.endsWith("@"))
                        bggUsers.add(s);

                    splittedWords.addAll(Arrays.asList(s.split(" ")));
                })
                .collect(Collectors.toSet());

        finalWords.addAll(splittedWords);

        log.info("Obtained {} final words!", finalWords.size());
        log.info("Found {} bgg users using this system", bggUsers.size());
        finalWords.parallelStream()
                .forEach(s -> Arrays.stream(Source.values())
                        .forEach(source -> {
                            try {
                                search(s, source.getBGEInstance());
                                log.info("Saved for {} from {}", s, source.getBGEInstance().name());
                                Thread.sleep(700);
                            } catch (ResponseException | IOException | InterruptedException e) {
                                log.error("some error...");
                            }
                        }));

        getOne();
    }
}
