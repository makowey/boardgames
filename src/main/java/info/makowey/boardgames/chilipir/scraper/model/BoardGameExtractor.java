package info.makowey.boardgames.chilipir.scraper.model;
import com.jaunt.ResponseException;
import info.makowey.boardgames.chilipir.model.BoardGame;

import java.util.List;

public interface BoardGameExtractor extends ScapperGame, GameFinder {

	List<BoardGame> fetchAllGames() throws ResponseException;
}
