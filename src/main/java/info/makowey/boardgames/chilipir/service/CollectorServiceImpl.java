package info.makowey.boardgames.chilipir.service;

import com.jaunt.ResponseException;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.repository.BoardGameRepository;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class CollectorServiceImpl implements CollectorService {

    private final BoardGameRepository boardGameRepository;

    @Autowired
    public CollectorServiceImpl(BoardGameRepository boardGameRepository) {
        this.boardGameRepository = boardGameRepository;
    }

    @Override
    public List<BoardGame> traceAll() {
        return boardGameRepository.findAll();
    }

    @Override
    public void storeBoardGames(List<BoardGame> boardGames) {
        boardGameRepository.saveAll(boardGames);
    }

    @Override
    public int deleteAll() {
        int items = Math.toIntExact(boardGameRepository.count());
        boardGameRepository.deleteAll();
        return items;
    }

    @Override
    public List<BoardGame> search(String name, BoardGameExtractor boardGameExtractor) throws
            ResponseException,
            IOException {
        log.info("Extracting from " + boardGameExtractor.name());
        return boardGameRepository.saveAll(boardGameExtractor.search(name));
    }
}
