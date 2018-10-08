package info.makowey.boardgames.chilipir.scraper;

import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

import java.util.Optional;

// https://boardgamegeek.com/xmlapi2/thing?id=167791
// https://boardgamegeek.com/xmlapi2/search?query=terraforming%20mars
public class BoardGameGeekEngine {

	private static final String THING_URL = "https://boardgamegeek.com/xmlapi2/thing?id=";
	private static final String SEARCH_URL = "https://boardgamegeek.com/xmlapi2/search?query=";
	private static final String NO_IMAGE = "NO_IMAGE";
	private static final String NO_ID = "0";

	private static final UserAgent userAgent = new UserAgent();

	public static String lookupById( int id ) throws ResponseException, NotFound {
		userAgent.visit( THING_URL.concat( String.valueOf( id ) ) );
		return Optional.ofNullable(
				userAgent.doc
						.findFirst( "<image>" ).getChildText() ).orElse( NO_IMAGE );
	}

	public static String lookupByName( String name ) throws ResponseException, NotFound {
		userAgent.visit( SEARCH_URL.concat( name ) );
		return Optional.ofNullable(
				userAgent.doc
						.findFirst( "<item>" )
						.getAt( "id" ) ).orElse( NO_ID );
	}

	public static void main( String[] args ) throws NotFound, ResponseException {
		lookupById( 167791 );
		lookupByName( "terraforming%20mars" );
	}
}
