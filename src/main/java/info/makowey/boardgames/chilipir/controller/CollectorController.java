package info.makowey.boardgames.chilipir.controller;

import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Word;
import info.makowey.boardgames.chilipir.scraper.BoardGameGeekEngine;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import info.makowey.boardgames.chilipir.scraper.stores.CarturestiScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.ElefantScraperGame;
import info.makowey.boardgames.chilipir.scraper.stores.EmagScrapperGame;
import info.makowey.boardgames.chilipir.service.CollectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CollectorController {

    private static final String ELEFANT = "ELEFANT";

    private CollectorService collectorService;

    @Autowired
    public void setCollectorService(CollectorService collectorService) {
        this.collectorService = collectorService;
    }

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {

        model.addAttribute("name", name);
        return "Greeting ".concat(name);
    }

    @GetMapping(path = "/all")
    public List<BoardGame> traceAll() {
        return collectorService.traceAll();
    }

    @PostMapping(path = "/collectGames")
    public String collectGames(
            @RequestParam(name = "name", required = false, defaultValue = ELEFANT) String name) throws
            ResponseException {

        Source source = Source.getByName(name);
        List<BoardGame> boardGames = source.getBGEInstance().fetchAllGames();
        collectorService.storeBoardGames(boardGames);
        return format("Collected %d games from %s!", boardGames.size(), name);
    }

    @DeleteMapping(path = "/clean")
    public String deleteByName(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "extractor") String extractor) {
        return format("Deleted all the %d boardgames from the repository from %s with name containing %s!",
                collectorService.deleteByName(Source.getByName(extractor), name).getDeletedCount(),
                extractor,
                name);
    }

    @GetMapping("/find")
    public List<BoardGame> findLocal(
            @RequestParam(name = "name", defaultValue = "Catan") String name) {
        return collectorService.findByName(name);
    }

    @GetMapping("/findbgg")
    public List<BoardGame> findBGGByName(
            @RequestParam(name = "name", defaultValue = "Catan") String name) throws IOException {
        return collectorService.findBGGByName(name);
    }

    @GetMapping("/findall")
    public List<BoardGame> findAll(
            @RequestParam(name = "name", defaultValue = "Catan") String name,
            @RequestParam(name = "geekmarket", defaultValue = "false") String geekMarket) throws IOException {
        return collectorService.findAll(name, geekMarket);
    }

    @GetMapping("/count")
    public int count() {
        return collectorService.count();
    }

    @GetMapping("/search")
    public Set<BoardGame> search(
            @RequestParam(name = "name", defaultValue = "Rummy") String name,
            @RequestParam(name = "clean", defaultValue = "NONE") String clean) {

        Set<BoardGame> boardGames = new HashSet<>();

        if (!clean.equals("NONE")) {
            BoardGameExtractor extractor = Source.getByName(clean).getBGEInstance();
            if (extractor instanceof CarturestiScrapperGame ||
                    extractor instanceof ElefantScraperGame ||
                    extractor instanceof EmagScrapperGame) {
                extractor.setCleanable(true);
            }
        }

        collectorService.countWords(name);
        Stream.of(Source.values())
                .parallel()
                .map(Source::getBGEInstance)
                .forEach(boardGameExtractor -> {
                    try {
                        boardGames.addAll(
                                collectorService.search(name, boardGameExtractor));
                    } catch (ResponseException | IOException e) {
                        log.error("Collector error: " + e.getMessage());
                    }
                });

        return boardGames;
    }

    @GetMapping("/findCollections")
    public List<BoardGame> getCollectionGamesForUsername(
            @RequestParam(name = "username", defaultValue = "makowey") String username) throws NotFound, ResponseException {
        List<BoardGame> collection = BoardGameGeekEngine
                .getCollectionForUsername(username.replace("@", ""));

        if (collection.isEmpty())
            return collection;
        collectorService.countWords(username);

        return collection
                .parallelStream()
                .peek(boardGame -> {
                    final AtomicInteger currentPrice = new AtomicInteger( collectorService.getCurrentPrice(
                            boardGame.getName().replaceAll( "%20", " " ) ).intValue() );

                    if (currentPrice.get() < 1.0) {
                        OptionalDouble geekAveragePrice = OptionalDouble.empty();
                        try {
                            List<BoardGame> games = findBGGByName( boardGame.getName() );

                            geekAveragePrice = games.stream()
                                    .mapToDouble( BoardGame::getCurrentPrice )
                                    .average();
                        } catch (IOException e) {
                            log.error( "Geekmarket, not found for {}", boardGame.getName() );
                        }

                        geekAveragePrice.ifPresent( value -> currentPrice.set( (int) value ) );
                    }

                    boardGame.setCurrentPrice( currentPrice.get() );
                    collectorService.storeBoardGames( Collections.singletonList( boardGame ) );
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/getOne")
    public BoardGame getOne() {
        return collectorService.getOne();
    }

    @GetMapping("/countWords")
    public int countWords() {
        return collectorService.countWords();
    }

    @GetMapping("/findWord")
    public Word findWord(@RequestParam(name = "word") String word) {
        return collectorService.findWordByName(word);
    }
}
