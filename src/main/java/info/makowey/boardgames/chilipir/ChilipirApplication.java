package info.makowey.boardgames.chilipir;

import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import info.makowey.boardgames.chilipir.repository.BoardGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChilipirApplication implements CommandLineRunner {

	private final BoardGameRepository repository;

	@Autowired
	public ChilipirApplication( BoardGameRepository repository ) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ChilipirApplication.class, args);
	}

	@Override
	public void run( String... args ) {

		repository.deleteAll();
		repository.save( BoardGame.builder()
				.name( "Carcassone" )
				.bestPrice( 110.12 )
				.lowestPriceEver( 140.00 )
				.bggId( 101 )
				.urlImage( "http://www.regatuljocurilor.ro/images/large/_Carcassonne/carcassonne_LRG.jpg" )
				.store( Store.builder()
						.name( "Regatul jocurilor" )
						.url( "http://regatuljocurilor.ro" )
						.build() )
				.build() );

		repository.save( BoardGame.builder()
				.name( "Mombasa" )
				.bestPrice( 140.58 )
				.lowestPriceEver( 180.00 )
				.bggId( 123 )
				.urlImage( "http://pionul.ro/image/cache/data/mombasa-1173-500x375.jpg" )
				.store( Store.builder()
						.name( "Pionul" )
						.url( "http://pionul.ro" )
						.build() )
				.build() );

		// fetch all boardGames
		System.out.println( "BoardGames found with findAll():" );
		System.out.println( "-------------------------------" );
		for (BoardGame boardGame : repository.findAll()) {
			System.out.println( boardGame );
		}
		System.out.println();

		// fetch an individual boardGame
		System.out.println( "BoardGame found with findByName('Mombasa'):" );
		System.out.println( "--------------------------------" );
		System.out.println( repository.findByName( "Mombasa" ) );

		System.out.println( "BoardGame found with findByBggId(123):" );
		System.out.println( "--------------------------------" );
		for (BoardGame boardGame : repository.findByBggId( 123 )) {
			System.out.println( boardGame );
		}
	}
}
