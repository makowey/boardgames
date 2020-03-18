package info.makowey.boardgames.chilipir.scraper.stores;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class BarlogGameExtractor extends SimpleJsonScrapperGame implements BoardGameExtractor {
	public static final BarlogGameExtractor INSTANCE = new BarlogGameExtractor( Source.BARLOG );

	private BarlogGameExtractor( Source source ) {
		super( source );
	}

	public static void main( String[] args ) throws IOException {
		INSTANCE.search( "terra" )
				.forEach( System.out::println );
	}

	@Override
	public List<BoardGame> search( String name ) throws IOException {
		String baseUrl = source.getBaseUrl()
				.concat( "/wp-admin/admin-ajax.php?action=basel_ajax_search&number=10&post_type=product&query="
						.concat( name ) );

		Request request = new Request.Builder()
				.url( baseUrl )
				.get()
				.build();

		Response response = client.newCall( request ).execute();

		String jsonData = Objects.requireNonNull( response.body() ).string();
		JSONObject Jobject = new JSONObject( jsonData );
		JSONArray elements = Jobject.getJSONArray( "suggestions" );

		return IntStream.range( 0, elements.length() )
				.mapToObj( elements::getJSONObject )
				.map( this::convertToBoardGame )
				.collect( Collectors.toList() );
	}

	protected BoardGame convertToBoardGame( JSONObject jsonObject ) {

		try {
			jsonObject.getString( "thumbnail" );
		} catch (JSONException exception) {
			return BoardGame.builder().build();
		}

		String urlImage = jsonObject.getString( "thumbnail" );
		String urlProduct = jsonObject.getString( "permalink" );
		String name = jsonObject.getString( "value" );
		Store store = Store.builder()
				.name( source.getSiteName() )
				.url( urlProduct )
				.logo( source.getLogo() )
				.lastVisit( LocalDate.now() )
				.build();

		double price = Double.parseDouble( jsonObject.getString( "price" )
				.replaceAll( "[^0-9.,]+", "" )
				.replaceAll( ",", "." ) );

		String hash = UUID.nameUUIDFromBytes( name.concat( source.name() ).getBytes() ).toString();
		return BoardGame.builder()
				.id( hash )
				.identifier( hash.hashCode() )
				.bggId( 0 )
				.store( store )
				.name( name )
				.currentPrice( price )
				.urlImage( urlImage
						.split( "class=\"attachment-woocommerce_thumbnail" )[0]
						.replaceAll( "class=\"attachment-woocommerce_thumbnail", "" )
						.replaceAll( "<img width=\"189\" height=\"189\" src=\"", "" ) )
				.build();
	}

	@Override
	public List<BoardGame> fetchAllGames() {
		return null;
	}
}
