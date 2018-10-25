package info.makowey.boardgames.chilipir.scraper.model;

import com.jaunt.ResponseException;
import info.makowey.boardgames.chilipir.model.BoardGame;

import java.io.IOException;
import java.util.List;

public interface GameFinder {

    List<BoardGame> search(String name) throws ResponseException, IOException;
}
