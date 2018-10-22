package info.makowey.boardgames.chilipir.scraper;

import com.jaunt.ResponseException;
import info.makowey.boardgames.chilipir.model.BoardGame;

import java.util.List;

public interface GameFinder {

    List<BoardGame> search(String name) throws ResponseException;
}
