package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	/**
	 * @param model Model object supplied by Spring MVC.
	 * @return "add_avenger" the form page
	 */
	@GetMapping("/addPage")
	public String goToAdd(Model model) {
		
		// Recall form binding..
		model.addAttribute("avenger", new Avenger());
		return "add_avenger";
	}
	
	/**
	 * @param avenger is a ModelAttribute. A special instance that was populated
	 * 				  with values the user entered on the form.
	 * @return "redirect:/" Redirects the request to the '/' resource
	 */
	@PostMapping("/addAvenger")
	public String addAvenger(@ModelAttribute Avenger avenger) {
		
		// Call the addAvenger method of the DatabaseAccess class
		int returnValue = database.addAvenger(avenger);
		
		// We're not doing anything with this now, but we could send a message
		// back through the model, use Elvis...
		System.out.println("Return value is: " + returnValue);
		
		// Redirect to '/', so we don't have to add to the model...
		return "redirect:/";
	}
	
	@GetMapping("/deleteAvenger/{id}")
	public String deleteAvenger(@PathVariable Long id) {
		int returnValue = database.deleteAvenger(id);
		System.out.println("Return value is: " + returnValue);
		
		return "redirect:/";
	}
	
	@GetMapping("/editAvenger/{id}")
	public String editAvenger(@PathVariable Long id, Model model) {
		Avenger avenger = database.getAvenger(id);
		if(avenger == null) {
			//Alert error
			System.out.println("Avenger is Null");
			return "index";
		}else {
			model.addAttribute("avenger", avenger);
			return "edit_avenger";
		}
	}
	
	@PostMapping("/updateAvenger")
	public String updateAvenger(@ModelAttribute Avenger avenger) {
		
		// Call the updateAvenger method of the DatabaseAccess class
		int returnValue = database.updateAvenger(avenger);
		
		System.out.println("Return value is " + returnValue);
		
		return "redirect:/";
	}
	
}
