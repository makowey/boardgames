package info.makowey.boardgames.chilipir.controller;

import info.makowey.boardgames.chilipir.model.BoardGame;
import info.makowey.boardgames.chilipir.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectorController {

	private CollectorService collectorService;

	@Autowired
	public void setCollectorService( CollectorService collectorService ) {
		this.collectorService = collectorService;
	}

	@GetMapping("/greeting")
	public String greeting(
			@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model ) {

		model.addAttribute( "name", name );
		return "Greeting ".concat( name );
	}

	@GetMapping(path = "/all")
	public List<BoardGame> traceAll() {
		return collectorService.traceAll();
	}
}
