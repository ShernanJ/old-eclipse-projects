package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.beans.Avenger;
import com.example.demo.database.DatabaseAccess;

@Controller
public class HomeController {
	
	// We will be calling on this class to access the database
	private DatabaseAccess database;
	
	/**
	 * Our one arg constructor for dependency injection
	 * @param database will be injected by Spring at runtime
	 */
	public HomeController(DatabaseAccess database) {
		this.database=database;
	}
	
	@GetMapping("/")
	public String goHome(Model model) {
		
		List<Avenger> avengers = database.getAvengers();
		
		model.addAttribute("avengerList", avengers);
		
		return "index";
	}
}
