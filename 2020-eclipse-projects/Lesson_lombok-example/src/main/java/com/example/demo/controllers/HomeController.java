package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.beans.School;

@Controller
public class HomeController {
	
	private School school;
	
	@Autowired // The annotation is optional for constructors.
	public HomeController(School school) {
		this.school = school;
	}
	
	@GetMapping("/")
	public String goHome() {
		System.out.println("--- From controller");
		System.out.println(school); //Will invoke the toString()...
		return "index.html";
	}
}
