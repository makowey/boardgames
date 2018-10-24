package info.makowey.boardgames.chilipir.service;

import com.jaunt.ResponseException;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;

import java.io.IOException;
import java.util.List;

public interface CollectorService {

	List<BoardGame> traceAll();

	void storeBoardGames(List<BoardGame> boardGames);

	int deleteAll();

	List<BoardGame> search( String name, BoardGameExtractor boardGameExtractor ) throws ResponseException, IOException;
}
