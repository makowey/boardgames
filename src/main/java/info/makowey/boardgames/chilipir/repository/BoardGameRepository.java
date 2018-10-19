package info.makowey.boardgames.chilipir.repository;

import info.makowey.boardgames.chilipir.model.BoardGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@EnableMongoRepositories
@CrossOrigin(origins = "http://localhost:4200")
public interface BoardGameRepository extends MongoRepository<BoardGame, String> {

	BoardGame findByName( String name );

	List<BoardGame> findByBggId( int bggId );
}
