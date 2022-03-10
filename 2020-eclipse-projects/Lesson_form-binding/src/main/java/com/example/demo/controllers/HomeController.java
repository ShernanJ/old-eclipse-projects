package com.example.demo.controllers;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.beans.Avenger;

@Controller
public class HomeController {
	
	// create a thread-safe ArrayList. You would want to
	// do this in production systems where hundreds/thousands
	// of users could potentially access it at the same time
	private CopyOnWriteArrayList<Avenger> avengerList = new CopyOnWriteArrayList<>();
	
	/**
	 * Map requests for root to the index page
	 * @param model Model object supplied by Spring MVC.
	 * @return "index"
	 */
	@GetMapping("/")
	public String goHome(Model model) {
		
		// because we are displaying the list in index.html
		// we have to send it there via the model
		model.addAttribute("avengerList",avengerList);
		return "index";
	}
	
	/**
	 * @param model Model object supplied by Spring MVC.
	 * @Return "add_avenger" the form page
	 */
	@GetMapping("/addPage")
	public String goToAdd(Model model) {
		
		// Here we are adding a new instance of Avenger
		// to the model. It will be bound to the form
		model.addAttribute("avenger", new Avenger());
		return "add_avenger";
	}
	
	/**
	 * @param model 	Model object supplied by Spring MVC
	 * @param avenger 	is a ModelAttribute. A special instance that
	 * 					was populated with values the user entered on the form.
	 * @return "index"	Send the user back to the listing
	 */
	@PostMapping("/addAvenger")
	public String addAvenger(Model model,
			@ModelAttribute Avenger avenger) {
		
		// Add it to our list
		avengerList.add(avenger);
		model.addAttribute("avengerList", avengerList);
		return "index";
	}
}
