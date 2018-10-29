package info.makowey.boardgames.chilipir.scraper.stores;

import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.lang.String.format;

@Slf4j
public class CarturestiScrapperGame implements BoardGameExtractor {

    public static final CarturestiScrapperGame INSTANCE = new CarturestiScrapperGame();

    public static final MediaType JSON
            = MediaType.parse( "application/json; charset=utf-8" );
    private static final String COOKIE_VALUE = "PHPSESSID=8pgghsok1a162gvr44t09gjeqm; _csrf=962ec660bc8874fe6d9588a735c5a20dbf65bbe272a7eb52da0d9d49d51cf36fa%3A2%3A%7Bi%3A0%3Bs%3A5%3A%22_csrf%22%3Bi%3A1%3Bs%3A32%3A%22kn9oY0WOITyFS7PLMPK-ST3vaS3xvHgb%22%3B%7D; _gcl_aw=GCL.1540481422.~Cj0KCQjw08XeBRC0ARIsAP_gaQDE3fZC6591higQYYzpUjXMhQNvZbnfFSk7TU8Jt0L6-QQ6178RT2AaAvk_EALw_wcB; _ga=GA1.2.1355205669.1540481424; _gid=GA1.2.151800216.1540481424; _gac_UA-8367043-6=1.1540481424.Cj0KCQjw08XeBRC0ARIsAP_gaQDE3fZC6591higQYYzpUjXMhQNvZbnfFSk7TU8Jt0L6-QQ6178RT2AaAvk_EALw_wcB; _fbp=fb.1.1540481425779.329380273; _gat=1";
    private static final String TOKEN_VALUE = "eIrpM3Kx6R5-x8ZDRD4SDxzshDPJ3Z-Vnr-Vnr5a9wcT5NBcK4G-UTeTvwUXCUJDUbzPHpqJrOP_7KbmyBKQZQ==";
    private static final OkHttpClient client = new OkHttpClient();

    private static Source source = Source.CARTURESTI;

    public static void main( String[] args ) throws IOException {
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
    public List<BoardGame> search( String name ) throws IOException {

        String json = "{\"settings\":{\"context\":\"search\",\"contextId\":\"%s\",\"url\":\"/product/json-search\",\"checkBoxSize\":7,\"term\":\"%s\",\"listName\":\"Search page\"},\"attributes\":[],\"preferences\":[],\"search\":{\"stock_label\":\"in-stoc,stoc-limitat\",\"per-page\":\"90\",\"id_product_type\":\"45\"}}";
        RequestBody body = RequestBody.create( JSON, format( json, name, name ) );
        String carturestiUrl = "https://carturesti.ro/product/json-search";
        Request request = new Request.Builder()
                .url( carturestiUrl )
                .post( body )
                .header( "Cookie",
                        COOKIE_VALUE )
                .header( "X-CSRF-Token",
                        TOKEN_VALUE )
                .build();

        Response response = client.newCall( request ).execute();

        String jsonData = Objects.requireNonNull( response.body() ).string();
        JSONObject Jobject = new JSONObject( jsonData );
        JSONArray elements = Jobject.getJSONArray( "products" );

        List<BoardGame> boardGames = new ArrayList<>();
        for (int i = 0; i < elements.length(); i++) {
            JSONObject object = elements.getJSONObject( i );
            boardGames.add( convertToBoardGame( object ) );
        }
        return boardGames;
    }

    private BoardGame convertToBoardGame( JSONObject jsonObject ) {

        String urlImage = String.valueOf( jsonObject.get( "imgUrl" ) );
        urlImage = ! urlImage.startsWith( "http" ) ?
                source.getBaseUrl().concat( urlImage ) :
                urlImage;

        String urlProduct = String.valueOf( jsonObject.get( "url" ) );
        urlProduct = ! urlProduct.startsWith( "http" ) ?
                source.getBaseUrl().concat( urlProduct ) :
                urlProduct;

        Store store = Store.builder()
                .name(source.getSiteName())
                .url( urlProduct )
                .logo(source.getLogo())
                .lastVisit(LocalDate.now())
                .build();

        String name = String.valueOf( jsonObject.get( "name" ) );
        return BoardGame.builder()
                .id(UUID.nameUUIDFromBytes(name.getBytes()).toString())
                .bggId(0)
                .store(store)
                .name(name)
                .currentPrice( jsonObject.getDouble( "price" ) )
                .urlImage( urlImage )
                .build();
    }
}
