package info.makowey.boardgames.chilipir.service;

import com.jaunt.ResponseException;
import com.mongodb.client.result.DeleteResult;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.repository.BoardGameRepository;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import info.makowey.boardgames.chilipir.scraper.stores.EmagScrapperGame;
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
import java.util.stream.Collectors;

@Service
@Slf4j
public class CollectorServiceImpl implements CollectorService {

    private final BoardGameRepository boardGameRepository;

    private final MongoTemplate mongoTemplate;

    Comparator<BoardGame> byCurrentPrice = Comparator.comparing(BoardGame::getCurrentPrice);
    Comparator<BoardGame> byName = Comparator.comparing(BoardGame::getName);

    @Autowired
    public CollectorServiceImpl(BoardGameRepository boardGameRepository, MongoTemplate mongoTemplate) {
        this.boardGameRepository = boardGameRepository;
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
    public int deleteAll() {
        int items = count();
        boardGameRepository.deleteAll();
        return items;
    }

    public DeleteResult deleteByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(name, "i"));
        return mongoTemplate.remove(query, BoardGame.class);
    }

    public DeleteResult deleteBySouce( Source source ) {
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

        // clean some not boardgames related objects....
        if (boardGameExtractor instanceof EmagScrapperGame)
            deleteBySouce( Source.EMAG );

        //deleteBySouce( Source.ELEFANT );

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
                .mapToDouble(BoardGame::getCurrentPrice)
                .average()
                .orElse(0.0);
    }
}
