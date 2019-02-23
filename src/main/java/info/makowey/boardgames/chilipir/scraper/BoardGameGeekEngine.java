package info.makowey.boardgames.chilipir.scraper;

import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import info.makowey.boardgames.chilipir.scraper.model.CollectionBggFilter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

// https://boardgamegeek.com/xmlapi2/thing?id=167791
// https://boardgamegeek.com/xmlapi2/search?query=terraforming%20mars
//https://boardvsgame.com/search.php?q=terraf autocomplete!!!
@Slf4j
public class BoardGameGeekEngine {

    private static final String THING_URL = "https://boardgamegeek.com/xmlapi2/thing?id=";
    private static final String SEARCH_URL = "https://boardgamegeek.com/xmlapi2/search?query=";
    private static final String COLLECTION_URL = "https://boardgamegeek.com/xmlapi2/collection?username=";
    private static final String NO_IMAGE = "NO_IMAGE";
    private static final String NO_ID = "0";

    private static final UserAgent userAgent = new UserAgent();

    public static String lookupById(int id) throws ResponseException, NotFound {
        userAgent.visit(THING_URL.concat(String.valueOf(id)));
        return Optional.ofNullable(
                userAgent.doc
                        .findFirst("<image>").getChildText()).orElse(NO_IMAGE);
    }

    public static String lookupByName(String name) throws ResponseException, NotFound {
        userAgent.visit(SEARCH_URL.concat(name));
        return Optional.ofNullable(
                userAgent.doc
                        .findFirst("<item>")
                        .getAt("id")).orElse(NO_ID);
    }

    public static List<BoardGame> getCollectionForUsername(String name, CollectionBggFilter filter) throws ResponseException {
        List<BoardGame> boardGames = new ArrayList<>();
        String urlToVisit = COLLECTION_URL.concat(name).concat("&stats=1");

        if(filter.isWishlist()) {
            urlToVisit = urlToVisit.concat("&whishlist=1&wishlistpriority=")
                    .concat(String.valueOf(filter.getPriority()));
        }

        userAgent.visit(urlToVisit);
        Elements elements = userAgent.doc.findEach("<item>");

        elements.toList()
                .forEach(element -> {

                    String gameName = "";
                    String gameImage = "";
                    String numberOfPlays = "";
                    String bggId = "", myRate, averageRate, bggPosition = "?";
                    try {

                        // FILTER owned
                        if (filter.isOwned() && !element.findFirst("status").getAtString("own").equals("1"))
                            return;

                        gameName = element.findFirst("name").getTextContent();
                        gameImage = element.findFirst("thumbnail").getTextContent();
                        numberOfPlays = element.findFirst("numplays").getTextContent();
                        bggId = element.getAt("objectid");

                        myRate = element
                                .findFirst("stats")
                                .findFirst("rating")
                                .getAt("value");

                        averageRate = element
                                .findFirst("stats")
                                .findFirst("rating")
                                .findFirst("average")
                                .getAt("value");

                        bggPosition = element
                                .findFirst("stats")
                                .findFirst("rating")
                                .findFirst("ranks")
                                .findFirst("rank")
                                .getAtString("value");

                    } catch (NotFound notFound) {
                        myRate = "-";
                        averageRate = "?";
                        log.error("No stats found for {}, user: {}", gameName, name);
                    }

                    String bggDetails = format(" You played %s times, you rate %s when average is %s (Rank: %s)",
                            numberOfPlays, myRate, averageRate, bggPosition);

                    if(bggId.isEmpty()) bggId = "0";

                    boardGames.add(BoardGame.builder()
                            .name(gameName)
                            .bggId(Integer.parseInt(bggId))
                            .urlImage(gameImage)
                            .bggDetails(bggDetails)
                            .store(Store.builder()
                                    .logo("https://static-cdn.jtvnw.net/jtv_user_pictures/boardgamegeektv-profile_image-f9dae59383f6d6e0-300x300.png")
                                    .url("https://boardgamegeek.com/boardgame/".concat(bggId))
                                    .build())
                            .build());
                });
        return boardGames;
    }

    public static void main(String[] args) throws NotFound, ResponseException {
        lookupById(167791);
        lookupByName("terraforming%20mars");
    }
}
