package ca.sheridancollege.javiersh.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.javiersh.beans.Game;

@Controller
public class GameController {
	
	List<Game> gameList = new CopyOnWriteArrayList<Game>();
	
	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("gameList", gameList);
		return "index";
	}
	
	@PostMapping("/addGame")
	public String addGame(Model model, @ModelAttribute Game game) {
		gameList.add(game);
		model.addAttribute("game", new Game());
		model.addAttribute("gameList", gameList);
		return "index";
	}
}
