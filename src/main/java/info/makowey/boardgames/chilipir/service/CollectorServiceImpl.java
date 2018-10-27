package info.makowey.boardgames.chilipir.service;

import com.jaunt.ResponseException;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.repository.BoardGameRepository;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CollectorServiceImpl implements CollectorService {

    private final BoardGameRepository boardGameRepository;

    private final MongoTemplate mongoTemplate;

    Comparator<BoardGame> byCurrentPrice = Comparator.comparing( BoardGame::getCurrentPrice );
    Comparator<BoardGame> byName = Comparator.comparing( BoardGame::getName );

    @Autowired
    public CollectorServiceImpl( BoardGameRepository boardGameRepository, MongoTemplate mongoTemplate ) {
        this.boardGameRepository = boardGameRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<BoardGame> traceAll() {
        Query query = new Query();
        //query.skip(pageNumber * pageSize);
        query.limit( 100 );
        return mongoTemplate.find( query, BoardGame.class );
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

    @Override
    public int count() {
        return Math.toIntExact( boardGameRepository.count() );
    }

    @Override
    public List<BoardGame> search(String name, BoardGameExtractor boardGameExtractor) throws
            ResponseException,
            IOException {
        log.info("Extracting from " + boardGameExtractor.name());
        return boardGameRepository.saveAll(boardGameExtractor.search(name));
    }

    @Override
    public List<BoardGame> findByName( String name ) {
        Query query = new Query();
        query.addCriteria( Criteria.where( "name" ).regex( name, "i" ) );
        query.limit( 15 );
        return mongoTemplate.find( query, BoardGame.class ).stream()
                .sorted( byCurrentPrice.reversed() )
                .collect( Collectors.toList() );
    }
}
