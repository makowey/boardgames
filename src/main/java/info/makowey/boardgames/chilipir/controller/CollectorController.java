package info.makowey.boardgames.chilipir.controller;

import com.jaunt.ResponseException;
import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.scraper.Source;
import info.makowey.boardgames.chilipir.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.String.format;

@RestController
public class CollectorController {

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
    @CrossOrigin(origins = "http://localhost:4200")
    public List<BoardGame> traceAll() {
        return collectorService.traceAll();
    }

    @PostMapping(path = "/collectGames")
    public String collectGames(
            @RequestParam(name = "name", required = false, defaultValue = "ELEFANT") String name) throws
            ResponseException {

        Source source = Source.getByName(name);
        List<BoardGame> boardGames = source.getBGEInstance().fetchAllGames();
        collectorService.storeBoardGames(boardGames);
        return format("Collected %d games from %s!", boardGames.size(), name);
    }

    @DeleteMapping(path = "/clean")
    public String deleteAll() {
        return format("Deleted all the %d boardgames from the repository!",
                collectorService.deleteAll());
    }

    @GetMapping("/search")
    public List<BoardGame> search(
            @RequestParam(name = "name", required = true, defaultValue = "Rummy") String name) {
        return collectorService.search(name);
    }
}
