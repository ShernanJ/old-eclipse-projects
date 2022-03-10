package ca.sheridancollege.javiersh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String goToHome() {
		return "index";
	}
	
	@GetMapping("/hairColour")
	public String goToHair() {
		return "hairColour.html";
	}
	
	@GetMapping("/height")
	public String goToHeight() {
		return "height.html";
	}
	
	@GetMapping("/name")
	public String goToName() {
		return "name.html";
	}
}
