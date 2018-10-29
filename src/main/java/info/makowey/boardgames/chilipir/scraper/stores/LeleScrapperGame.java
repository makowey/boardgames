package info.makowey.boardgames.chilipir.scraper.stores;

import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;

import java.io.IOException;
import java.util.List;

public class LeleScrapperGame extends SimpleJsonScrapperGame implements BoardGameExtractor {

    public static final LeleScrapperGame INSTANCE = new LeleScrapperGame(Source.LELEGAMES);

    private LeleScrapperGame(Source source) {
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
