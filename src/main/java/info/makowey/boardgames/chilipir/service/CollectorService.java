package info.makowey.boardgames.chilipir.service;

import com.jaunt.ResponseException;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.result.DeleteResult;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Word;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;

import java.io.IOException;
import java.util.List;

public interface CollectorService {

	List<BoardGame> traceAll();

	void storeBoardGames(List<BoardGame> boardGames);

	DeleteResult deleteByName( Source source, String name);

	List<BoardGame> search( String name, BoardGameExtractor boardGameExtractor ) throws ResponseException, IOException;

	List<BoardGame> findByName( String name );

	List<BoardGame> findBGGByName( String name ) throws IOException;

	int count();

	int countWords();

	void countWords( String name );

	List<BoardGame> findAll(String name, String geekMarket) throws IOException;

	Double getCurrentPrice(String name);

	Word findWordByName(String name);

	BoardGame getOne();

	DeleteResult deleteByStoreName(String storeName, String word);
}
