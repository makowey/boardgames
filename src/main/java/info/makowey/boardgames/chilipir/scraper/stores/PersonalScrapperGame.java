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
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
public class PersonalScrapperGame implements BoardGameExtractor {
    public static final PersonalScrapperGame INSTANCE = new PersonalScrapperGame();

    private Source source = Source.PERSONAL;

    public static void main(String[] args) throws ResponseException {
        INSTANCE.fetchAllGames().forEach(System.out::println);
    }

    @Override
    public String name() {
        return source.name();
    }

    @Override
    public List<BoardGame> fetchAllGames() throws ResponseException {
        return search("all");
    }

    @Override
    public List<BoardGame> search(String name) throws ResponseException {
        UserAgent userAgent = new UserAgent();
        String fullPath = source.getBaseUrl().concat(source.getFormatter());
        userAgent.visit(fullPath);

        Elements elements = userAgent.doc.findEach(source.getProductDiv());
        return elements.toList().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private BoardGame convertToBoardGame(Element element) throws NotFound {

        Store store = Store.builder()
                .name(source.getSiteName())
                .url("https://boardgamegeek.com/user/makowey")
                .logo(source.getLogo())
                .lastVisit(LocalDate.now())
                .build();

        String name = populateName(element);
        return BoardGame.builder()
                .id(UUID.nameUUIDFromBytes(name.concat(source.name()).getBytes())
                        .toString())
                .bggId(0)
                .store(store)
                .name(name)
                .currentPrice(parsePrice(element))
                .urlImage(populateUrlImage(element))
                .build();
    }

    @Override
    public String populateUrl(Element element) {
        return "mailto:makowey@gmail.com";
    }

    @Override
    public String populateUrlImage(Element element) throws NotFound {
        return element
                .findFirst("<td class=image>")
                .findFirst("<img>")
                .getAt("src");
    }

    @Override
    public String populateName(Element element) throws NotFound {
        return element.findFirst("<td class=name>").getChildText();
    }

    @Override
    public Double parsePrice(Element element) throws NotFound {

        String price = element.findFirst("<td class=price>").getTextContent();
        return Double.parseDouble(price);
    }

    private BoardGame convert(Element element) {
        try {
            return convertToBoardGame(element);
        } catch (NotFound notFound) {
            System.err.println("No games found. Reason: " + notFound.getMessage());
            return BoardGame.builder().build();
        }
    }
}
