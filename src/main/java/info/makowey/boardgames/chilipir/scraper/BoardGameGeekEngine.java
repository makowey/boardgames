package info.makowey.boardgames.chilipir.scraper;

import com.jaunt.*;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import info.makowey.boardgames.chilipir.scraper.model.CollectionBggFilter;
import info.makowey.boardgames.chilipir.scraper.model.PlaysBggFilter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.lang.String.format;

// https://boardgamegeek.com/xmlapi2/thing?id=167791
// https://boardgamegeek.com/xmlapi2/search?query=terraforming%20mars
//https://boardvsgame.com/search.php?q=terraf autocomplete!!!
@Slf4j
public class BoardGameGeekEngine {

    private static final String THING_URL = "https://boardgamegeek.com/xmlapi2/thing?id=";
    private static final String SEARCH_URL = "https://boardgamegeek.com/xmlapi2/search?query=";
    private static final String COLLECTION_URL = "https://boardgamegeek.com/xmlapi2/collection?username=";
    private static final String PLAYS_URL = "https://boardgamegeek.com/xmlapi2/plays?username=";
    private static final String USER_URL = "https://boardgamegeek.com/xmlapi2/user?name=";
    private static final String NO_IMAGE = "NO_IMAGE";
    private static final String NO_ID = "0";

    private static Map<Integer, BoardGame> boardGamesGeek = new HashMap<>();

    private static final UserAgent userAgent = new UserAgent();

    public static Map<Integer, BoardGame> lookupById(List<Integer> ids) throws ResponseException {

        String url = THING_URL;
        for (int id : ids) {
            url = url.concat(id + ",");
        }

        userAgent.visit(url);
        Elements elements = userAgent.doc.findEach("<item>");

        elements.toList()
                .forEach(element -> {

                    String gameName = "", gameImage = "";
                    int bggId = 0;
                    try {

                        bggId = Integer.parseInt(element.getAt("id"));
                        gameName = element.findFirst("name").getAt("value");
                        gameImage = element.findFirst("thumbnail").getTextContent();

                    } catch (NotFound notFound) {
                        log.error("No stats found for {}", gameName);
                    }

                    boardGamesGeek.putIfAbsent(
                            bggId,
                            BoardGame.builder()
                                    .name(gameName)
                                    .bggId(bggId)
                                    .urlImage(gameImage)
                                    .store(Store.builder()
                                            .logo("https://static-cdn.jtvnw.net/jtv_user_pictures/boardgamegeektv-profile_image-f9dae59383f6d6e0-300x300.png")
                                            .url("https://boardgamegeek.com/boardgame/".concat(String.valueOf(bggId)))
                                            .build())
                                    .build());
                });

        return boardGamesGeek;
    }

    public static String lookupByName(String name) throws ResponseException, NotFound {
        userAgent.visit(SEARCH_URL.concat(name));
        return Optional.ofNullable(
                userAgent.doc
                        .findFirst("<item>")
                        .getAt("id")).orElse(NO_ID);
    }

    public static List<BoardGame> getCollectionForUsername(String username, CollectionBggFilter filter) throws ResponseException {
        List<BoardGame> boardGames = new ArrayList<>();
        String urlToVisit = COLLECTION_URL.concat(username).concat("&stats=1");

        if (filter.isWishlist()) {
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
                        log.error("No stats found for {}, user: {}", gameName, username);
                    }

                    String bggDetails = format(" You played %s times, you rate %s when average is %s (Rank: %s)",
                            numberOfPlays, myRate, averageRate, bggPosition);

                    if (bggId.isEmpty()) bggId = "0";

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

    public static List<BoardGame> getPlaysForUsername(String username, PlaysBggFilter filter) throws ResponseException, InterruptedException, NotFound {
        String urlToVisit = PLAYS_URL.concat(username);

        if (filter.getMinDate().matches("\\d{4}-\\d{2}-\\d{2}")) {
            urlToVisit = urlToVisit.concat("&mindate=")
                    .concat(String.valueOf(filter.getMinDate()));
        }

        if (filter.getMaxDate().matches("\\d{4}-\\d{2}-\\d{2}")) {
            urlToVisit = urlToVisit.concat("&maxdate=")
                    .concat(String.valueOf(filter.getMaxDate()));
        }


        userAgent.visit(urlToVisit);
        Elements elements = userAgent.doc.findEach("<play>");
        List<Element> allElements = elements.toList();

        int numberOfPlaysEntries = Integer.parseInt(userAgent.doc.findFirst("<plays>").getAt("total"));
        int page = Integer.parseInt(userAgent.doc.findFirst("<plays>").getAt("page"));

        if (numberOfPlaysEntries > 100) {
            Thread.sleep(1500L);
            int pages = numberOfPlaysEntries / 100;
            while (page <= pages) {
                userAgent.visit(urlToVisit.concat("&page=").concat(String.valueOf(++page)));
                allElements.addAll(userAgent.doc.findEach("<play>").toList());
            }
        }

        log.info("Loaded {} plays for {} [{}]", allElements.size(), username, filter.getYear());

        final Map<String, AtomicInteger> numberOfPlays = new HashMap<>();
        final Map<String, AtomicInteger> wins = new HashMap<>();
        final Map<String, BoardGame> games = new HashMap<>();
        final Map<String, Integer> maxScore = new HashMap<>();
        allElements
                .forEach(element -> {

                    String gameName = "";
                    String gameImage = "https://cf.geekdo-images.com/thumb/img/yFqQ569DfL8NSTGTUw0vF9SCR7k=/fit-in/200x150/pic3536616.jpg";
                    String bggId = "";
                    try {

                        gameName = element.findFirst("item").getAt("name");
                        bggId = element.findFirst("item").getAt("objectid");

                        AtomicInteger initialValuePlays = numberOfPlays.getOrDefault(bggId, new AtomicInteger(0));
                        initialValuePlays.incrementAndGet();
                        numberOfPlays.putIfAbsent(bggId, initialValuePlays);

                        AtomicInteger initialValueWins = wins.getOrDefault(bggId, new AtomicInteger(0));
                        wins.putIfAbsent(bggId, initialValueWins);

                        String finalBggId = bggId;
                        element.findFirst("players").findEvery("player").getChildElements()
                                .forEach(player -> {
                                    try {
                                        if (player.getAt("username").equalsIgnoreCase(username)) {
                                            if (player.getAt("win").equalsIgnoreCase("1")) {
                                                wins.get(finalBggId).incrementAndGet();
                                            }

                                            String stringScore = player.getAt("score");
                                            int score = stringScore.isEmpty() ? 0 : Integer.parseInt(stringScore);
                                            int currentScore = maxScore.getOrDefault(finalBggId, 0);
                                            maxScore.put(finalBggId, score > currentScore ? score : currentScore);
                                        }
                                    } catch (NotFound notFound) {
                                        System.err.println("Not found username...");
                                    }
                                });

                    } catch (NotFound notFound) {
                        log.error("No stats found for {}, user: {}", gameName, username);
                    }

                    if (bggId.isEmpty()) bggId = "0";

                    games.putIfAbsent(
                            bggId,
                            BoardGame.builder()
                                    .name(gameName)
                                    .bggId(Integer.parseInt(bggId))
                                    .urlImage(gameImage)
                                    .store(Store.builder()
                                            .logo("https://static-cdn.jtvnw.net/jtv_user_pictures/boardgamegeektv-profile_image-f9dae59383f6d6e0-300x300.png")
                                            .url("https://boardgamegeek.com/boardgame/".concat(bggId))
                                            .build())
                                    .build());
                });

        Thread.sleep(300L);

        lookupById(games.values().stream()
                .map(BoardGame::getBggId)
                .collect(Collectors.toList())
        );

        games.values().forEach(boardGame -> {
            boardGame.setUrlImage(
                    boardGamesGeek.get(boardGame.getBggId())
                            .getUrlImage());

            String bggId = String.valueOf(boardGame.getBggId());
            int numberOfGames = numberOfPlays.get(bggId).get();
            int winGames = wins.get(bggId).get();
            int max = Optional.ofNullable(maxScore.get(bggId)).orElse(0);

            String bggDetails = format(" This year you played this game for %d times. You won %d times. Max scores: %d",
                    numberOfGames, winGames, max);
            games.get(bggId).setBggDetails(bggDetails);
            games.get(bggId).setCurrentPrice(numberOfGames);
            games.get(bggId).setStore(Store.builder()
                    .logo("https://dummyimage.com/300x250/fff/000&text=".concat(max != 0 ? String.valueOf(max) : "x"))
                    .build());
        });

        return new ArrayList<>(games.values());
    }

    public static void main(String[] args) throws ResponseException {
        lookupById(Arrays.asList(167791, 33160));
        System.err.println(boardGamesGeek);
        //lookupByName("terraforming%20mars");

//        System.out.println(getPlaysForUsername("makowey", PlaysBggFilter.builder()
//                .minDate("2019-01-01")
//                .maxDate("2019-12-31")
//                .build()));
    }
}
