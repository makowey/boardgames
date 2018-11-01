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
import java.util.stream.Collectors;

import static java.lang.String.format;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmagScrapperGame implements BoardGameExtractor {

    public static final EmagScrapperGame INSTANCE = new EmagScrapperGame();
    public static final String UNKNOWN = "UNKNOWN";

    private static Source source = Source.EMAG;

    private boolean isCleanable = false;

    public static void main(String[] args) throws ResponseException {
        INSTANCE.search("azul")
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

    @Override
    public List<BoardGame> search(String name) throws ResponseException {
        UserAgent userAgent = new UserAgent();
        String fullPath = source.getBaseUrl()
                .concat( format( "/search/jocuri-societate/stoc/%s/c", name ) );
        userAgent.visit(fullPath);

        Elements elements = userAgent.doc.findEach(source.getProductDiv());

        return elements.toList().stream()
                .map(this::convert)
                .filter( boardGame -> ! boardGame.getName().equals( UNKNOWN ) )
                .collect(Collectors.toList());
    }

    private BoardGame convertToBoardGame(Element element) throws NotFound {

        if (! element.getAtString( "data-category-name" ).equals( "Jocuri de societate" ))
            return BoardGame.builder().name( UNKNOWN ).build();

        Store store = Store.builder()
                .name(source.getSiteName())
                .url(populateUrl(element))
                .logo(source.getLogo())
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
    public String populateUrl(Element element) throws NotFound {
        return element.findFirst("<h2 class='card-body product-title-zone'>")
                .findFirst("<a>")
                .getAt("href");
    }

    @Override
    public String populateUrlImage(Element element) throws NotFound {
        return element
                .findFirst("<div class=thumbnail>")
                .findFirst("<img>")
                .getAt("src");
    }

    @Override
    public String populateName(Element element) throws NotFound {
        return element.findFirst("<h2 class='card-body product-title-zone'>")
                .findFirst("<a>")
                .getChildText();
    }

    @Override
    public Double parsePrice(Element element) throws NotFound {

        String price = element.findFirst("<p class=product-new-price>").getChildText();

        return Double.parseDouble(price
                .replaceAll("[^0-9.,]+", "")
                .replaceAll(",", "."));
    }

    private BoardGame convert(Element element) {
        try {
            return convertToBoardGame(element);
        } catch (NotFound notFound) {
            System.err.println("No games found. Reason: " + notFound.getMessage());
            return BoardGame.builder().build();
        }
    }

    @Override
    public boolean cleanable() {
        return isCleanable;
    }

    public void setCleanable( boolean cleanable ) {
        isCleanable = cleanable;
    }
}
