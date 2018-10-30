package info.makowey.boardgames.chilipir.scraper;

import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

// https://boardgamegeek.com/xmlapi2/thing?id=167791
// https://boardgamegeek.com/xmlapi2/search?query=terraforming%20mars
//https://boardvsgame.com/search.php?q=terraf autocomplete!!!
public class BoardGameGeekEngine {

    private static final String THING_URL = "https://boardgamegeek.com/xmlapi2/thing?id=";
    private static final String SEARCH_URL = "https://boardgamegeek.com/xmlapi2/search?query=";
    private static final String COLLECTION_URL = "https://boardgamegeek.com/xmlapi2/collection?username=";
    private static final String NO_IMAGE = "NO_IMAGE";
    private static final String NO_ID = "0";
    private static final boolean owned = true;

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

    public static List<BoardGame> getCollectionForUsername(String name) throws ResponseException, NotFound {
        List<BoardGame> boardGames = new ArrayList<>();
        userAgent.visit(COLLECTION_URL.concat(name));
        Elements elements = userAgent.doc.findEach("<item>");

        elements.toList()
                .forEach(element -> {

                    String gameName = "";
                    String gameImage = "";
                    String numberOfPlays = "";
                    String bggId = "", myRate = "", averageRate = "";
                    try {

                        // FILTER owned
                        if (owned && ! element.findFirst( "status" ).getAtString( "own" ).equals( "1" ))
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

                    } catch (NotFound notFound) {
                        notFound.printStackTrace();
                    }

                    String bggDetails = format(" You played %s times, you rate %s when average is %s",
                            numberOfPlays, myRate, averageRate);

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
