package info.makowey.boardgames.chilipir.scraper.stores;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegatScrapperGame implements BoardGameExtractor {

    public static final RegatScrapperGame INSTANCE = new RegatScrapperGame();

    private static Source source = Source.REGAT;

    public static void main(String[] args) throws ResponseException {

        INSTANCE.search("catan")
                .forEach(System.out::println);
    }

    @Override
    public String name() {
        return source.name();
    }

    @Override
    public List<BoardGame> fetchAllGames() {
        return null;
    }

    private BoardGame convertToBoardGame(Element image, Element title, Element price) throws NotFound {

        Store store = Store.builder()
                .name(source.getSiteName())
                .url(populateUrl(title))
                .logo(source.getLogo())
                .lastVisit(LocalDate.now())
                .build();

        String name = populateName(title);
        String hash = UUID.nameUUIDFromBytes( name.concat(source.name()).getBytes() ).toString();
        return BoardGame.builder()
                .id( hash )
                .identifier(hash)
                .bggId(0)
                .store(store)
                .name(name)
                .currentPrice(parsePrice(price))
                .urlImage(populateUrlImage(image))
                .build();
    }

    @Override
    public List<BoardGame> search(String name) throws ResponseException {
        UserAgent userAgent = new UserAgent();
        String fullPath = source.getBaseUrl()
                .concat("/index.php?main_page=advanced_search_result&search_in_description=0&x=0&y=0&keyword=")
                .concat(name)
                .concat("&max_display=")
                .concat(String.valueOf(source.getNumberOfProductsPerPage()));

        userAgent.visit(fullPath);

        Elements images = userAgent.doc.findEvery("<img class=listingProductImage>");
        Elements names = userAgent.doc.findEvery("<h3 class=itemTitle>");
        Elements prices = userAgent.doc.findEvery("<td class=productlisting_price>");

        AtomicInteger index = new AtomicInteger(0);
        return images.toList().stream()
                .map(image -> {
                    try {
                        BoardGame boardGame = convertToBoardGame(
                                image,
                                names.toList().get(index.get()),
                                prices.toList().get(index.get())
                        );

                        index.incrementAndGet();
                        return boardGame;
                    } catch (NotFound notFound) {
                        System.err.println("No games found. Reason: " + notFound.getMessage());
                        return BoardGame.builder().build();
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public String populateUrl(Element element) throws NotFound {
        return element.getElement(0).getAt("href");
    }

    @Override
    public String populateUrlImage(Element element) throws NotFound {
        return element.getAt("src");
    }

    @Override
    public String populateName(Element element) throws NotFound {
        return element.getElement(0).getChildText();
    }

    @Override
    public Double parsePrice(Element element) throws NotFound {

        String price = element.innerHTML();
        if (price.contains("productSpecialPrice")) {
            Element localElement = new Element(element.outerHTML());
            price = localElement.getChildElements().get(1).getTextContent();
        }

        if (price.isEmpty()) return 0.0;
        return Double.parseDouble(price
                .replaceAll("[^0-9.,]+", "")
                .replaceAll(",", "."));
    }
}
