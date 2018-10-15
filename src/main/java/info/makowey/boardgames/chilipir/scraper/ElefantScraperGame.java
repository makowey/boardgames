package info.makowey.boardgames.chilipir.scraper;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Builder
public class ElefantScraperGame implements BoardGameExtractor {

	private static int counterPage = 1;

	private static final ElefantScraperGame INSTANCE = ElefantScraperGame.builder().build();

	public static void main( String[] args ) throws ResponseException {

		INSTANCE.fetchAllGames( Source.ELEFANT )
				.forEach( System.out::println );
	}

	public List<BoardGame> fetchAllGames( Source source ) throws ResponseException {
		return fetchAllProducts( source ).parallelStream()
				.map( element -> {
					try {
						return convertToBoardGame( element, source );
					} catch (NotFound notFound) {
						notFound.printStackTrace();
					}
					return null;
				} )
				.filter( Objects::nonNull )
				.peek( ElefantScraperGame::selectBestPrice )
				.collect( Collectors.toList() );
	}

	private void findBggId( BoardGame boardGame ) {
		String id = null;
		String name = boardGame.getName();
		name = name
				.replaceAll( "Joc", "" )
				.replaceAll( " ", "%20" );

		try {
			id = BoardGameGeekEngine.lookupByName( name );
		} catch (ResponseException | NotFound e) {
			e.printStackTrace();
		}

		Optional.ofNullable( id )
				.ifPresent( bggId -> boardGame.setBggId( Integer.parseInt( bggId ) ) );
	}

	private static void selectBestPrice( BoardGame boardGame ) {
		if (boardGame.getBestPrice() > 0) {
			boardGame.setBestPrice(
					boardGame.getCurrentPrice() < boardGame.getBestPrice() ?
							boardGame.getCurrentPrice() :
							boardGame.getBestPrice() );
		} else {
			boardGame.setBestPrice( boardGame.getCurrentPrice() );
		}
	}

	private static List<Element> fetchAllProducts( Source source ) throws ResponseException {
		List<Element> elements = fetchProducts( source ).toList();
		while(elements.size() == source.getNumberOfProductsPerPage()) {
			elements.addAll( fetchProducts( source ).toList() );
		}

		resetCounter();
		return elements;
	}

	private static Elements fetchProducts( Source source ) throws ResponseException {
		UserAgent userAgent = new UserAgent();
		userAgent.visit( source.getPath( counterPage ) );

		counterPage++;
		return userAgent.doc.findEach( source.getProductDiv() );
	}

	private static void resetCounter() {
		counterPage = 1;
	}

	private BoardGame convertToBoardGame( Element element,
			Source source ) throws NotFound {

		Store store = Store.builder()
				.name( source.getSiteName() )
				.url( populateUrl( element ) )
				.lastVisit( LocalDate.now() )
				.build();

		return BoardGame.builder()
				.store( store )
				.name( populateName( element ) )
				.currentPrice( parsePrice( element ) )
				.urlImage( populateUrlImage( element ) )
				.build();
	}

	public Double parsePrice( Element element ) throws NotFound {
		return Double.parseDouble( element.findFirst( "<span class=\"elf-price\">" )
				.getChildText()
				.replaceAll( "[^0-9.,]+", "" )
				.replaceAll( ",", "." ) );
	}

	public String populateUrl( Element element ) throws NotFound {
		return element.findFirst( "<a href>" ).getAt( "href" );
	}

	public String populateUrlImage( Element element ) throws NotFound {
		return element.findFirst( "<a href>" ).findFirst( "<img>" ).getAt( "data-original" );
	}

	public String populateName( Element element ) throws NotFound {
		return element.findFirst( "<a href>" ).getAt( "title" );
	}

	@Override
	public BoardGame search( String name ) {
		// http://www.elefant.ro/search/jucarii?query=catan
		return BoardGame.builder().build();
	}
}

// Scheduler http://www.quartz-scheduler.org/
