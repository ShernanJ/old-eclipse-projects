package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exercise1Controller {
	
	@GetMapping("/about")
	public String getAbout() {
		return "about.html";
	}
	
	@GetMapping("/hobbies")
	public String getHobbies() {
		return "hobbies.html";
	}
	
	@GetMapping("/career")
	public String getCareer() {
		return "career.html";
	}
}
