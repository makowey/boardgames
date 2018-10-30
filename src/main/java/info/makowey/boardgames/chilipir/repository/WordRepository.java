package info.makowey.boardgames.chilipir.repository;

import info.makowey.boardgames.chilipir.model.Word;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableMongoRepositories
@CrossOrigin(origins = "http://localhost:4200")
public interface WordRepository extends MongoRepository<Word, String> {

	Word findByName(String word);
}
