package info.makowey.boardgames.chilipir.scraper.stores;

import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;

import java.io.IOException;
import java.util.List;

public class PionulScrapperGame extends SimpleJsonScrapperGame implements BoardGameExtractor {

    public static final PionulScrapperGame INSTANCE = new PionulScrapperGame(Source.PIONUL);

    private PionulScrapperGame(Source source) {
        super(source);
    }

    public static void main(String[] args) throws IOException {
        INSTANCE.search("memoir")
                .forEach(System.out::println);
    }

    @Override
    public List<BoardGame> fetchAllGames() {
        return null;
    }
}
