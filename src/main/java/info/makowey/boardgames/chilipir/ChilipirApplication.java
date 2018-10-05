package info.makowey.boardgames.chilipir;

import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.repository.BoardGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChilipirApplication implements CommandLineRunner {

	@Autowired
	private BoardGameRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ChilipirApplication.class, args);
	}

	@Override
	public void run( String... args ) {
		repository.deleteAll();

		// save a couple of boardgames
		repository.save( BoardGame.builder()
				.name( "Carcassone" )
				.bestPrice( 110.12 )
				.currentPrice( 140.00 )
				.bggId( 101 )
				.build() );
		repository.save( BoardGame.builder()
				.name( "Mombasa" )
				.bestPrice( 140.58 )
				.currentPrice( 180.00 )
				.bggId( 123 )
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
