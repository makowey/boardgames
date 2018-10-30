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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class CollectorServiceImpl implements CollectorService {

    private final BoardGameRepository boardGameRepository;
    private final WordRepository wordRepository;

    private final MongoTemplate mongoTemplate;

    Comparator<BoardGame> byCurrentPrice = Comparator.comparing(BoardGame::getCurrentPrice);
    Comparator<BoardGame> byName = Comparator.comparing(BoardGame::getName);

    @Autowired
    public CollectorServiceImpl( BoardGameRepository boardGameRepository,
            WordRepository wordRepository,
            MongoTemplate mongoTemplate ) {
        this.boardGameRepository = boardGameRepository;
        this.wordRepository = wordRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<BoardGame> traceAll() {
        Query query = new Query();
        //query.skip(pageNumber * pageSize);
        query.addCriteria(Criteria.where("currentPrice").gte(150));
        query.limit(100);
        return mongoTemplate.find(query, BoardGame.class);
    }

    @Override
    public void storeBoardGames(List<BoardGame> boardGames) {
        boardGameRepository.saveAll(boardGames);
    }

    @Override
    public DeleteResult deleteByName( Source source, String name ) {
        Query query = new Query();
        query.addCriteria( Criteria.where( "name" ).regex( name, "i" )
                .andOperator( Criteria.where( "store.name" ).is( source.getSiteName() ) ) );
        return mongoTemplate.remove( query, BoardGame.class );
    }

    private DeleteResult deleteBySouce( Source source ) {
        Query query = new Query();
        query.addCriteria( Criteria.where( "store.name" ).is( source.getSiteName() ) );
        log.info( "Deleting items from {} ", source.getSiteName() );
        return mongoTemplate.remove( query, BoardGame.class );
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
        return boardGameRepository.saveAll(boardGameExtractor.search(name));
    }

    @Override
    public List<BoardGame> findByName(String name) {
        String[] words = name.split(" ");
        Query query = new Query();
        Criteria criteria = new Criteria();
        Criteria[] criteriaList = new Criteria[words.length];
        int index = 0;
        for (String word : words) {
            word = word.replaceAll("[-.\\+*?\\[^\\]$(){}=!<>|:\\\\]", "\\\\$0");
            criteriaList[index++] = Criteria.where("name").regex(word, "i");
        }
        criteria.andOperator(criteriaList);
        query.addCriteria(criteria);

        return mongoTemplate.find(query, BoardGame.class).stream()
                .sorted(byCurrentPrice)
                .collect(Collectors.toList());
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
                .filter( boardGame -> ! boardGame.getStore().getName().equals( Source.EMAG.name() ) )
                .filter( boardGame -> ! boardGame.getStore().getName().equals( Source.ELEFANT.name() ) )
                .mapToDouble(BoardGame::getCurrentPrice)
                .average()
                .orElse(0.0);
    }

    public void countWords( String name ) {
        String[] words = name.split( "%20" );
        Stream.of( words )
                .filter( s -> ! s.isEmpty() )
                .forEach( s -> {
                    Word word = wordRepository.findByName( s );
                    Optional.ofNullable( word )
                            .ifPresentOrElse( sameWord -> {
                                word.setCount( Objects.requireNonNull( word ).getCount() + 1 );
                                wordRepository.save( sameWord );
                            }, () -> wordRepository.save( Word.builder().name( s ).count( 1 ).build() ) );
                } );
    }

    public int countWords() {
        return Math.toIntExact( wordRepository.count() );
    }

    public Word findWordByName( String name ) {
        return wordRepository.findByName( name );
    }
}
