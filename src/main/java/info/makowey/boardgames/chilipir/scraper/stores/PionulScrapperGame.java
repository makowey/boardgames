package info.makowey.boardgames.chilipir.scraper.stores;

import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
