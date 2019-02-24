package info.makowey.boardgames.chilipir.controller;

import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.model.Store;
import info.makowey.boardgames.chilipir.model.Word;
import info.makowey.boardgames.chilipir.scraper.BoardGameGeekEngine;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import info.makowey.boardgames.chilipir.scraper.model.CollectionBggFilter;
import info.makowey.boardgames.chilipir.scraper.model.PlaysBggFilter;
import info.makowey.boardgames.chilipir.scraper.stores.CarturestiScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.ElefantScraperGame;
import info.makowey.boardgames.chilipir.scraper.stores.EmagScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.GeekMarketScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.PersonalScrapperGame;
import info.makowey.boardgames.chilipir.service.CollectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
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

    @GetMapping(path = "/game/{id}")
    public BoardGame findById(@PathVariable String id) {
        return Optional.ofNullable(collectorService.findById(id))
                .orElse(BoardGame.builder().name("NO GAME FOUND!!!").build());
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
    public String deleteByStoreName(
            @RequestParam(name = "store") String storeName,
            @RequestParam(name = "name") String name) {
        return format("Deleted all the %d boardgames from the repository from %s with name containing %s!",
                collectorService.deleteByStoreName(storeName.toUpperCase(), name).getDeletedCount(),
                storeName,
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
                .filter(boardGameExtractor -> !(boardGameExtractor instanceof GeekMarketScrapperGame))
                .forEach(boardGameExtractor -> {
                    try {
                        List<BoardGame> games = collectorService.search(name, boardGameExtractor);
                        if (!(boardGameExtractor instanceof PersonalScrapperGame)) boardGames.addAll(games);
                    } catch (ResponseException | IOException e) {
                        log.error("Collector error {}: {}", boardGameExtractor.name(), e.getMessage());
                    }
                });

        return boardGames;
    }

    @GetMapping("/findCollections")
    public List<BoardGame> getCollectionGamesForUsername(
            @RequestParam(name = "username", defaultValue = "makowey") String username) throws ResponseException, InterruptedException, NotFound {

        String type = "o";

        if (username.endsWith("/p")) {
            username = username.replaceAll("/p", "");
            username = username.replaceAll("@", "");
            String year = String.valueOf(LocalDate.now().getYear());
            return BoardGameGeekEngine.getPlaysForUsername(username, PlaysBggFilter.builder()
                    .minDate(format("%s-01-01", year))
                    .maxDate(format("%s-12-31", year))
                    .year(year)
                    .build());
        }

        if (username.endsWith("/o")) {
            type = "o";
            username = username.replaceAll("/o", "");
        }
        if (username.endsWith("/w")) {
            type = "w";
            username = username.replaceAll("/w", "");
        }

        final String usernameQuery = username.replace("@", "");

        CollectionBggFilter filter = CollectionBggFilter.builder()
                .owned(type.equalsIgnoreCase("o"))
                .wishlist(type.equalsIgnoreCase("w"))
                .priority(1)
                .build();

        List<BoardGame> collection = new ArrayList<>();
        Arrays.asList(1, 2, 3)
                .forEach(priority -> {
                    try {
                        filter.setPriority(priority);
                        collection.addAll(BoardGameGeekEngine.getCollectionForUsername(usernameQuery, filter));

                        Thread.sleep(1000L);
                    } catch (ResponseException | InterruptedException exception) {
                        System.err.printf("Could not load all the games for %s with priority %d\n", usernameQuery, priority);
                    }
                });

        if (filter.isWishlist()) {
            final List<BoardGame> prices = new ArrayList<>();
            collection.parallelStream()
                    .distinct()
                    .forEach(boardGame -> {
                        try {
                            prices.addAll(
                                    collectorService.findAll(boardGame.getName(), "false"));
                        } catch (IOException exception) {
                            System.err.println("Could not find prices for " + exception.getLocalizedMessage());
                        }
                    });
            return prices;
        }

        if (collection.isEmpty())
            return collection;

        collectorService.countWords(username);

        return collection
                .parallelStream()
                .peek(boardGame -> {
                    final AtomicInteger currentPrice = new AtomicInteger(collectorService.getCurrentPrice(
                            boardGame.getName().replaceAll("%20", " ")).intValue());

                    if (currentPrice.get() < 1.0) {
                        OptionalDouble geekAveragePrice = OptionalDouble.empty();
                        try {
                            List<BoardGame> games = findBGGByName(boardGame.getName());

                            geekAveragePrice = games.stream()
                                    .mapToDouble(BoardGame::getCurrentPrice)
                                    .average();
                        } catch (IOException e) {
                            log.error("Geekmarket, not found for {}", boardGame.getName());
                        }

                        geekAveragePrice.ifPresent(value -> currentPrice.set((int) value));
                    }

                    boardGame.setCurrentPrice(currentPrice.get() > 2000 ? 0 : currentPrice.get());
                    boardGame.setStore(Store.builder().name(Source.GEEKMARKET.name()).build());
                    //collectorService.storeBoardGames( Collections.singletonList( boardGame ) );
                })
                .distinct()
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

    @GetMapping("/blackFriday")
    public List<BoardGame> blackFriday(@RequestParam(name = "percent", defaultValue = "10") String percent) {
        return collectorService.blackFriday(Short.parseShort(percent.replaceAll("[^0-9]", "")));
    }

}
