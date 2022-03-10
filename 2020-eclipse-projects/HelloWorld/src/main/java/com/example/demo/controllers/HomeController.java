package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	//Mapping on root.
	@GetMapping("/")
	public String goHome() {
		return "home.html";
	}
}
