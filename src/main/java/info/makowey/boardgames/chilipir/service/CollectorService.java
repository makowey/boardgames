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

	List<BoardGame> findByName( String name );

	List<BoardGame> findBGGByName( String name ) throws IOException;

	int count();

	List<BoardGame> findAll(String name, String geekMarket) throws IOException;

	Double getCurrentPrice(String name);
}
