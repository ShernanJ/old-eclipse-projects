package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HiddenFieldController {
	
	@GetMapping("/startHidden")
	public String startHidden(Model model) {
		
		model.addAttribute("name", "Black Widow");
		
		return "hidden_1";
	}
	
	@GetMapping("/hidden2")
	public String nextHidden(
			@RequestParam( required=false) String name, Model model) {
		
		//Commenting out if statement will remove session.
		if(name != null) {
			model.addAttribute("name", name);
		}
		
		// hidden_2 will just display the name if its there.
		return "hidden_2";
	}
}
