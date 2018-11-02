package info.makowey.boardgames.chilipir.scraper.stores;

import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

@Slf4j
//https://boardgamegeek.com/api/geekmarket/products/search?ajax=1&marketdomain=boardgame&q=azul
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GeekMarketScrapperGame implements BoardGameExtractor {

    public static final GeekMarketScrapperGame INSTANCE = new GeekMarketScrapperGame();
    private static final OkHttpClient client = new OkHttpClient();
    private final static String UNKNOWN = "N/A";
    private static Source source = Source.GEEKMARKET;
    private static String IMAGE_UNKNOWN_URL = "https://vignette.wikia.nocookie.net/lyricwiki/images/d/dd/Unknown.png/revision/latest?cb=20080726074744";

    public static void main(String[] args) throws IOException {
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

    @Override
    public List<BoardGame> search(String name) {
        return Collections.emptyList();
    }

    public List<BoardGame> searchOnline(String name) throws IOException {
        String apiBoardGameGeek = "https://api.geekdo.com/api/geekmarket/products?";
        int boardGameId = getFirstGameId(findBGGByString(name));
        String parameters = format("ajax=1&browsetype=browse&condition=any&country=any&displaymode=list&eventid=0&"
                        + "inventorytype=any&marketdomain=boardgame&nosession=1&objectid=%d&objecttype=thing&pageid=1&productst",
                boardGameId);

        parameters = parameters
                .concat("&productstate=active&shipareas%5B%5D=europe&sort=lowprice&stock=instock");

        Request request = new Request.Builder()
                .url(apiBoardGameGeek.concat(parameters))
                .get()
                .build();

        Response response = client.newCall(request).execute();

        String jsonData = Objects.requireNonNull(response.body()).string();
        JSONObject Jobject = new JSONObject(jsonData);
        JSONArray elements = Jobject.getJSONArray("products");

        List<BoardGame> boardGames = new ArrayList<>();
        for (int i = 0; i < elements.length(); i++) {
            JSONObject object = elements.getJSONObject(i);
            boardGames.add(convertToBoardGame(object));
        }
        return boardGames.stream()
                .filter(boardGame -> !boardGame.getName().equals(UNKNOWN))
                .collect(Collectors.toList());
    }

    private int getFirstGameId(List<BoardGame> games) {
        return games.isEmpty() ? 1 : games.get(0).getBggId();
    }

    private BoardGame convertToBoardGame(JSONObject jsonObject) {
        String urlImage = jsonObject.getJSONObject("objectlink")
                .getJSONObject("image")
                .getJSONObject("images")
                .getJSONObject("square200")
                .getString("url");

        String urlProduct = source.getBaseUrl()
                .concat(jsonObject.getString("producthref"));

        String username = jsonObject.getJSONObject("linkeduser").getString("username");
        String name = jsonObject.getJSONObject("objectlink")
                .getString("name");

        JSONObject version;
        try {
            version = jsonObject.getJSONObject("version");
            name = version.getString("name");
        } catch (JSONException e) {
            log.error("Version game not found for {}, will be excluded", name);
            name = UNKNOWN;
            return BoardGame.builder()
                    .name(name)
                    .build();
        }

        Store store = Store.builder()
                .name(source.getSiteName()
                        .concat(" - ").concat(username))
                .url(urlProduct)
                .logo(source.getLogo())
                .lastVisit(LocalDate.now())
                .build();

        Optional<CURRENCY> currencyValue = CURRENCY.byName(jsonObject.getString("currency"));
        double price = jsonObject.getDouble("price");
        if (currencyValue.isPresent()) {
            price = price * currencyValue.get().value;
        }

        return BoardGame.builder()
                .id(UUID.nameUUIDFromBytes(name.concat(username)
                        .getBytes()).toString())
                .bggId(0)
                .store(store)
                .name(name)
                .currentPrice(price)
                .urlImage(urlImage)
                .build();
    }

    public List<BoardGame> findBGGByString(String name) throws IOException {
        String baseUrl = "https://boardgamegeek.com";
        String apiBoardGameGeek = "/api/geekmarket/products/search?ajax=1&marketdomain=boardgame&q="
                .concat(name);

        Request request = new Request.Builder()
                .url(baseUrl.concat(apiBoardGameGeek))
                .get()
                .build();

        Response response = client.newCall(request).execute();

        String jsonData = Objects.requireNonNull(response.body()).string();
        JSONObject Jobject = new JSONObject(jsonData);
        JSONArray elements = Jobject.getJSONArray("items");

        List<BoardGame> boardGames = new ArrayList<>();
        for (int i = 0; i < elements.length(); i++) {
            JSONObject object = elements.getJSONObject(i);
            String imageUrl;
            try {
                imageUrl = object.getString("imageurl");
            } catch (JSONException ex) {
                imageUrl = IMAGE_UNKNOWN_URL;
            }
            boardGames.add(BoardGame.builder()
                    .bggId(object.getInt("objectid"))
                    .name(object.getString("name"))
                    .store(Store.builder()
                            .name("BoardGameGeek")
                            .url(baseUrl.concat(object.getString("href")))
                            .build())
                    .urlImage(imageUrl)
                    .build());
        }
        return boardGames;
    }

    private enum CURRENCY {
        EUR("euro", 4.6630),
        GBP("lira", 5.2576),
        CAD("canadian dollar", 3.1231),
        USD("dollar", 4.1067),
        AUD("astralian dollar", 2.95);

        private String type;
        private double value;

        CURRENCY(String type, double value) {
            this.type = type;
            this.value = value;
        }

        public static Optional<CURRENCY> byName(String name) {
            return Stream.of(CURRENCY.values())
                    .filter(currency -> name.toUpperCase().equals(currency.name()))
                    .findFirst();
        }
    }
}
