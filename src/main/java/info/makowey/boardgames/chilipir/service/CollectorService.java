package info.makowey.boardgames.chilipir.service;

import com.jaunt.ResponseException;
import info.makowey.boardgames.chilipir.model.BoardGame;

import java.util.List;

public interface CollectorService {

	List<BoardGame> traceAll();

	void storeBoardGames(List<BoardGame> boardGames);

	int deleteAll();

	List<BoardGame> search(String name) throws ResponseException;
}
