package info.makowey.boardgames.chilipir.repository;

import info.makowey.boardgames.chilipir.model.BoardGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface BoardGameRepository extends MongoRepository<BoardGame, String> {

	BoardGame findByName( String name );

	List<BoardGame> findByBggId( int bggId );
}
