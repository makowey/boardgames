package info.makowey.boardgames.chilipir.scraper;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ElefantScraperGame implements BoardGameExtractor {

    private static int counterPage = 1;

    public static final ElefantScraperGame INSTANCE = new ElefantScraperGame();

    private static Source source = Source.ELEFANT;

    public static void main(String[] args) throws ResponseException {

        INSTANCE.search("catan")
                .forEach(System.out::println);
    }

    @Override
    public String name() {
        return source.name();
    }

    public List<BoardGame> fetchAllGames() throws ResponseException {
        return fetchAllProducts(source).parallelStream()
                .map(element -> {
                    try {
                        return convertToBoardGame(element);
                    } catch (NotFound notFound) {
                        notFound.printStackTrace();
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .peek(ElefantScraperGame::selectBestPrice)
                .collect(Collectors.toList());
    }

    private void findBggId(BoardGame boardGame) {
        String id = null;
        String name = boardGame.getName();
        name = name
                .replaceAll("Joc", "")
                .replaceAll(" ", "%20");

        try {
            id = BoardGameGeekEngine.lookupByName(name);
        } catch (ResponseException | NotFound e) {
            e.printStackTrace();
        }

        Optional.ofNullable(id)
                .ifPresent(bggId -> boardGame.setBggId(Integer.parseInt(bggId)));
    }

    private static void selectBestPrice(BoardGame boardGame) {
        if (boardGame.getBestPrice() > 0) {
            boardGame.setBestPrice(
                    boardGame.getCurrentPrice() < boardGame.getBestPrice() ?
                            boardGame.getCurrentPrice() :
                            boardGame.getBestPrice());
        } else {
            boardGame.setBestPrice(boardGame.getCurrentPrice());
        }
    }

    private List<Element> fetchAllProducts(Source source) throws ResponseException {
        List<Element> elements = fetchProducts(source).toList();
        while (elements.size() == source.getNumberOfProductsPerPage()) {
            elements.addAll(fetchProducts(source).toList());
        }

        resetCounter();
        return elements;
    }

    private Elements fetchProducts(Source source) throws ResponseException {
        UserAgent userAgent = new UserAgent();
        userAgent.visit(source.getPath(counterPage));

        counterPage++;
        return userAgent.doc.findEach(source.getProductDiv());
    }

    private static void resetCounter() {
        counterPage = 1;
    }

    private BoardGame convertToBoardGame(Element element) throws NotFound {

        Store store = Store.builder()
                .name(source.getSiteName())
                .logo(source.getLogo())
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

    public Double parsePrice(Element element) throws NotFound {
        return Double.parseDouble(element.findFirst("<span class=\"elf-price\">")
                .getChildText()
                .replaceAll("[^0-9.,]+", "")
                .replaceAll(",", "."));
    }

    public String populateUrl(Element element) throws NotFound {
        return element.findFirst("<a href>").getAt("href");
    }

    public String populateUrlImage(Element element) throws NotFound {
        return element.findFirst("<a href>").findFirst("<img>").getAt("data-original")
                .replace("http://", "https://");
    }

    public String populateName(Element element) throws NotFound {
        return element.findFirst("<a href>").getAt("title");
    }

    @Override
    public List<BoardGame> search(String name) throws ResponseException {
        UserAgent userAgent = new UserAgent();
        userAgent.visit(
                source.getBaseUrl()
                        .concat("/search/jucarii?query="
                                .concat(name)));

        Elements elements = userAgent.doc.findEach(source.getProductDiv());

        return elements.toList().stream()
                .map(element -> {
                    try {
                        return convertToBoardGame(element);
                    } catch (NotFound notFound) {
                        System.err.println("No games found. Reason: " + notFound.getMessage());
                        return BoardGame.builder().build();
                    }
                })
                .collect(Collectors.toList());
    }
}
// http://www.elefant.ro/search/jucarii?query=catan
// Scheduler http://www.quartz-scheduler.org/
