package com.example.demo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/register_page")
	public String goRegister() {
		return "register";
	}
	
	/**
	 * An example of sending dynamic content to the user, a much better way!
	 * @param firstName		A request parameter coming in from the form.
	 * @param lastName		Another request parameter coming in from the form.
	 * @param model			An instance of Model that can be used to send data
	 * 						back to the forwarded .html resource.
	 * @return "success" 	An html file marked up with Thymeleaf
	 * @throws IOException
	 */
	@PostMapping("/register")
	public String registerUser(
			@RequestParam String firstName,
			@RequestParam String lastName,
			Model model) throws IOException {
			
		// We can store objects in the model, which will be available
		// in our .html file!
		// We are adding an attribute called "firstName"
		// With the String reference firstName (the parameter)
		model.addAttribute("firstName", firstName);
		
		// Same with lastName
		model.addAttribute("lastName", lastName);
		
		//Thymeleaf will do the rest
		return "success";
	}
	
	/**
	 * An example of sending a list of items to the View 
	 * @param model			An instance of Model that can be used to send
	 * 						data back to the forwarded .html resource.
	 * @return "listing" 	This is an html file marked up with Thymeleaf
	 */
	@GetMapping("/getListing")
	public String getListing(Model model) {
		
		//Harcorded Listing
		List<String> members = new ArrayList<>();
		
		// Add a few Avengers...
		members.add("Iron Man"); members.add("Gamora");
		members.add("Thor"); members.add("Nebula");
		
		model.addAttribute("members", members);
		
		return "listing";
	}
}
