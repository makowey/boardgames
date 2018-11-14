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

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LexshopScrapperGame implements BoardGameExtractor {

	public static final LexshopScrapperGame INSTANCE = new LexshopScrapperGame();

	private static Source source = Source.LEXSHOP;

	public static void main( String[] args ) throws ResponseException {
		INSTANCE.search( "catan" )
				.forEach( System.out::println );
	}

	@Override
	public String name() {
		return source.name();
	}

	@Override
	public List<BoardGame> fetchAllGames() throws ResponseException {
		return null;
	}

	@Override
	public List<BoardGame> search( String name ) throws ResponseException {
		UserAgent userAgent = new UserAgent();
		String fullPath = source.getBaseUrl()
				.concat( "?page=produse&categorie=8&qs=" )
				.concat( name )
				.concat( "&sort=0&nrpg=" )
				.concat( String.valueOf( source.getNumberOfProductsPerPage() ) );

		userAgent.visit( fullPath );

		Elements elements = userAgent.doc.findEach( source.getProductDiv() );

		return elements.toList().stream()
				.map( this::convert )
				.collect( Collectors.toList() );
	}

	private BoardGame convertToBoardGame( Element element ) throws NotFound {

		Store store = Store.builder()
				.name( source.getSiteName() )
				.url( populateUrl( element ) )
				.logo(source.getLogo())
				.lastVisit( LocalDate.now() )
				.build();

		String name = populateName( element );
		String hash = UUID.nameUUIDFromBytes( name.concat(source.name()).getBytes() ).toString();
		return BoardGame.builder()
				.id( hash )
				.identifier(hash.hashCode())
				.bggId( 0 )
				.store( store )
				.name( name )
				.currentPrice( parsePrice( element ) )
				.urlImage( populateUrlImage( element ) )
				.build();
	}

	@Override
	public String populateUrl( Element element ) throws NotFound {
		return source.getBaseUrl()
				.concat( element.getAt( "data-href" ) );
	}

	@Override
	public String populateUrlImage( Element element ) throws NotFound {
		return element
				.findFirst( "<div class=product_img_container>" )
				.findFirst( "<a>" )
				.findFirst( "<img>" )
				.getAt( "data-original" );
	}

	@Override
	public String populateName( Element element ) throws NotFound {
		return element.findFirst( "<div class=prod_title_container>" )
				.getElement( 0 ).getChildText();
	}

	@Override
	public Double parsePrice( Element element ) throws NotFound {

		String price = element.findFirst( "<span class=actual_price>" ).getTextContent();

		return Double.parseDouble( price
				.replaceAll( "[^0-9.,]+", "" )
				.replaceAll( ",", "." ) );
	}

	private BoardGame convert( Element element ) {
		try {
			return convertToBoardGame( element );
		} catch (NotFound notFound) {
			System.err.println( "No games found. Reason: " + notFound.getMessage() );
			return BoardGame.builder().build();
		}
	}
}
