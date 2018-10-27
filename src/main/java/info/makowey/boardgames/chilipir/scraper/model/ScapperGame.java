package info.makowey.boardgames.chilipir.scraper.model;
import com.jaunt.Element;
import com.jaunt.NotFound;

public interface ScapperGame {

	default String populateUrl( Element element ) throws NotFound {
		return "PUT YOUR IMPLEMENTATION";
	}

	default String populateUrlImage( Element element ) throws NotFound {
		return "PUT YOUR IMPLEMENTATION";
	}

	default String populateName( Element element ) throws NotFound {
		return "PUT YOUR IMPLEMENTATION";
	}

	default Double parsePrice( Element element ) throws NotFound {
		return 0.0;
	}

}
