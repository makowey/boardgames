package info.makowey.boardgames.chilipir.scraper;

import com.jaunt.*;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegatScrapperGame implements BoardGameExtractor {

    public static final RegatScrapperGame INSTANCE = new RegatScrapperGame();

    private static Source source = Source.REGAT;

    public static void main(String[] args) throws ResponseException {

//        INSTANCE.fetchAllGames()
//                .forEach(System.out::println);

        INSTANCE.search("catan")
                .forEach(System.out::println);
    }

    @Override
    public List<BoardGame> fetchAllGames() throws ResponseException {
        return null;
    }

    private BoardGame convertToBoardGame(Element element) throws NotFound {

        Store store = Store.builder()
                .name(source.getSiteName())
                .url(populateUrl(element))
                .lastVisit(LocalDate.now())
                .build();

        String name = populateName(element);
        return BoardGame.builder()
                .id(UUID.nameUUIDFromBytes(name.getBytes()).toString())
                .bggId(0)
                .store(store)
                .name(name)
                .currentPrice(parsePrice(element))
                .urlImage(populateUrlImage(element))
                .build();
    }

    @Override
    public List<BoardGame> search(String name) throws ResponseException {
        UserAgent userAgent = new UserAgent();
        userAgent.visit(
                source.getBaseUrl()
                        .concat("/index.php?main_page=advanced_search_result&search_in_description=0&x=0&y=0&keyword=")
                        .concat(name));

        Elements elements = userAgent.doc.findEach(source.getProductDiv());

        return elements.toList().stream()
                .map(element -> {
                    try {
                        return convertToBoardGame(element);
                    } catch (NotFound notFound) {
                        System.err.println("No games found. Reason: " + notFound.getMessage());
                        return null;
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public String populateUrl(Element element) throws NotFound {
        return null;
    }

    @Override
    public String populateUrlImage(Element element) throws NotFound {
        return null;
    }

    @Override
    public String populateName(Element element) throws NotFound {
        return element.getChildText();
    }

    @Override
    public Double parsePrice(Element element) throws NotFound {
        return 0.0;
    }
}
