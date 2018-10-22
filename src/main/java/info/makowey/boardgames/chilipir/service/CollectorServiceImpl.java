package info.makowey.boardgames.chilipir.service;

import com.jaunt.ResponseException;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.repository.BoardGameRepository;
import info.makowey.boardgames.chilipir.scraper.ElefantScraperGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<BoardGame> search(String name) throws ResponseException {
        //boardGameRepository.findByNameContaining(name);
        return ElefantScraperGame.INSTANCE.search(name);
    }
}
