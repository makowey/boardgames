package info.makowey.boardgames.chilipir.scraper.model;
import com.jaunt.Element;
import com.jaunt.NotFound;

public interface ScapperGame {

	String populateUrl( Element element ) throws NotFound;

	String populateUrlImage( Element element ) throws NotFound;

	String populateName( Element element ) throws NotFound;

	Double parsePrice( Element element ) throws NotFound;

}
