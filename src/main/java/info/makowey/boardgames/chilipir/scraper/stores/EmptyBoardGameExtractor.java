package info.makowey.boardgames.chilipir.scraper.stores;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;

import java.util.Collections;
import java.util.List;

public class EmptyBoardGameExtractor implements BoardGameExtractor {
	public static final EmptyBoardGameExtractor INSTANCE = new EmptyBoardGameExtractor();

	@Override
	public String name() {
		return "EMPTY";
	}

	@Override
	public List<BoardGame> fetchAllGames() {
		return Collections.emptyList();
	}

	@Override
	public List<BoardGame> search( String name ) {
		return Collections.emptyList();
	}
}
