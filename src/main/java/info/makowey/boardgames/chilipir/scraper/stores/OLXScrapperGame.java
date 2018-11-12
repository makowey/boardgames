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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Slf4j
public class OLXScrapperGame implements BoardGameExtractor {

    public static final OLXScrapperGame INSTANCE = new OLXScrapperGame();

    private static Source source = Source.OLX;

    private int counterPage, numberOfItems;

    public static void main(String[] args) {
        INSTANCE.fetchAllGames()
                .forEach(System.out::println);
    }

    @Override
    public String name() {
        return source.name();
    }

    @Override
    public List<BoardGame> fetchAllGames() {
        final Set<String> gameNames = Set.of("joc-de-societate", "boardgame", "board-game");
        final Set<BoardGame> finalList = new HashSet<>();

        gameNames.forEach(gameName -> {
            counterPage = 1;
            numberOfItems = 0;

            List<BoardGame> list = new ArrayList<>();
            try {
                list = search(gameName);
            } catch (ResponseException ignored) {
            }

            while (!list.isEmpty() &&
                    counterPage * source.getNumberOfProductsPerPage() < numberOfItems) {
                finalList.addAll(list);
                counterPage++;
                try {
                    list = search(gameName);
                } catch (ResponseException ignored) {
                }
            }
        });

        finalList.removeIf(boardGame -> boardGame.getId() == null);
        finalList.removeIf(boardGame -> boardGame.getCurrentPrice() == 0.0);

        log.info("Loaded {} boardgames from {}", finalList.size(), name());
        return new ArrayList<>(finalList);
    }

    @Override
    public List<BoardGame> search(String name) throws ResponseException {
        UserAgent userAgent = new UserAgent();
        String fullPath = source.getBaseUrl()
                .concat(format(source.getFormatter(), name, counterPage));

        userAgent.visit(fullPath);
        if (numberOfItems == 0) {
            try {
                numberOfItems = Integer.parseInt(userAgent.doc.findFirst("<div class='dontHasPromoted section clr rel' data-cy='search_results_info_results_count'>")
                        .findFirst("<h2>").getChildText().replaceAll("[^0-9]", ""));
            } catch (NotFound notFound) {
                log.error("Not div found to extract number of items on {}", name());
                return Collections.emptyList();
            }
        }

        Elements elements = userAgent.doc.findEach(source.getProductDiv());

        return elements.toList().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private BoardGame convertToBoardGame(Element element) throws NotFound {

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
        return element
                .findFirst("<a>")
                .getAtString("href");
    }

    @Override
    public String populateUrlImage(Element element) throws NotFound {
        return element
                .findFirst("<a>")
                .findFirst("<img>")
                .getAt("src");
    }

    @Override
    public String populateName(Element element) throws NotFound {
        return element
                .findFirst("<a>")
                .getAtString("title");
    }

    @Override
    public Double parsePrice(Element element) throws NotFound {

        String price = element
                .getParent()
                .findFirst("<div class='price '>")
                .getTextContent();

        return Double.parseDouble(price
                .replaceAll("[^0-9.,]+", "")
                .replaceAll(",", "."));
    }

    private BoardGame convert(Element element) {
        try {
            return convertToBoardGame(element);
        } catch (NotFound notFound) {
            return BoardGame.builder().build();
        }
    }
}
