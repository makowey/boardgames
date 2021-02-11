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
public class BestKidsScrapperGame implements BoardGameExtractor {
	//https://www.bestkids.ro/searchadv.aspx?CategoryID=92&IsSubmit=true&SearchTerm=catan&submit.x=47&submit.y=10
	public static final BestKidsScrapperGame INSTANCE = new BestKidsScrapperGame();

	private static Source source = Source.BESTKIDS;

	public static void main( String[] args ) throws ResponseException {
		INSTANCE.search( "catan" )
				.forEach( System.out::println );
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
	public List<BoardGame> search( String name ) throws ResponseException {
		UserAgent userAgent = new UserAgent();
		String fullPath = source.getBaseUrl()
				.concat( "/searchadv.aspx?CategoryID=92&IsSubmit=true&SearchTerm=" )
				.concat( name );

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
				.logo( source.getLogo() )
				.lastVisit( LocalDate.now() )
				.build();

		String name = populateName( element );
		String hash = UUID.nameUUIDFromBytes( name.concat(source.name()).getBytes() ).toString();
		return BoardGame.builder()
				.id( hash )
				.identifier(hash)
				.bggId( 0 )
				.store( store )
				.name( name )
				.currentPrice( parsePrice( element ) )
				.urlImage( populateUrlImage( element ) )
				.build();
	}

	@Override
	public String populateUrl( Element element ) throws NotFound {
		return element
				.findFirst( "<div class=search_image>" )
				.findFirst( "<a>" )
				.getAtString( "href" );
	}

	@Override
	public String populateUrlImage( Element element ) throws NotFound {
		return element
				.findFirst( "<div class=search_image>" )
				.findFirst( "<a>" )
				.findFirst( "<img>" )
				.getAt( "src" );
	}

	@Override
	public String populateName( Element element ) throws NotFound {
		return element.findFirst( "<div class='search_product_description clearfix'>" )
				.findFirst( "<a>" )
				.getChildText();
	}

	@Override
	public Double parsePrice( Element element ) throws NotFound {

		String price = element
				.findFirst( "<div class='search_product_description clearfix'>" )
				.findFirst( "<span class=product_newprice>" )
				.getTextContent();

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
