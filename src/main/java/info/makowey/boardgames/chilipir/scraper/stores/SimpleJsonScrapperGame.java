package info.makowey.boardgames.chilipir.scraper.stores;

import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import info.makowey.boardgames.chilipir.scraper.Source;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
public class SimpleJsonScrapperGame {
    private static final OkHttpClient client = new OkHttpClient();
    protected Source source;

    public SimpleJsonScrapperGame(Source source) {
        this.source = source;
    }

    public String name() {
        return source.name();
    }

    public List<BoardGame> search(String name) throws IOException {
        String baseUrl = source.getBaseUrl().concat("/index.php?route=journal2/search&search=".concat(name));
        Request request = new Request.Builder()
                .url(baseUrl)
                .get()
                .build();

        Response response = client.newCall(request).execute();

        String jsonData = Objects.requireNonNull(response.body()).string();
        JSONObject Jobject = new JSONObject(jsonData);
        JSONArray elements = Jobject.getJSONArray("results");

        List<BoardGame> boardGames = new ArrayList<>();
        for (int i = 0; i < elements.length(); i++) {
            JSONObject object = elements.getJSONObject(i);
            boardGames.add(convertToBoardGame(object));
        }
        return boardGames;
    }

    private BoardGame convertToBoardGame(JSONObject jsonObject) {
        String urlImage = jsonObject.getString("image");
        String urlProduct = jsonObject.getString("url");
        String name = jsonObject.getString("name");
        Store store = Store.builder()
                .name(source.getSiteName())
                .url(urlProduct)
                .logo(source.getLogo())
                .lastVisit(LocalDate.now())
                .build();

        double price = Double.parseDouble(jsonObject.getString("price")
                .replaceAll("[^0-9.,]+", "")
                .replaceAll(",", "."));

        String hash = UUID.nameUUIDFromBytes( name.concat(source.name()).getBytes() ).toString();
        return BoardGame.builder()
                .id( hash )
                .identifier(hash.hashCode())
                .bggId(0)
                .store(store)
                .name(name)
                .currentPrice(price)
                .urlImage(urlImage)
                .build();
    }

}
