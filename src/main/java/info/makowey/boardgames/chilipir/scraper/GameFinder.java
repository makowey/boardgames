package info.makowey.boardgames.chilipir.scraper;

import info.makowey.boardgames.chilipir.model.BoardGame;

public interface GameFinder {

	BoardGame search(String name);
}
