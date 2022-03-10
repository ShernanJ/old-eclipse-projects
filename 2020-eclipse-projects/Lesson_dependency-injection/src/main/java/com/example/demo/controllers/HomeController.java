package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.beans.School;

@Controller
public class HomeController {
	
	//Property-Based Injection
	
	// By using the @Autowired annotation, we are asking
	// the framework to supply us the instance it has in
	// the waiting.
	// Notice the variable name 'school' could be anything
	// it's the type (School) that the framework uses when
	// finding the instance to serve up.
	
//	@Autowired
//	private School school; // This usage is frowned upon...

/////////////////////////////////////////////////////////////////
    //Setter-Based Injection	
	
//	private School school;
//	
//	/**
//	 * Now we created a setter method and marked it as Autowired.
//	 * This is preferred over property-based injection, and it
//	 * really *smells* better as well, from a best-practices
//	 * perspective.
//	 * @param school The framework will inject its instance here.
//	 */
//	
//	@Autowired
//	public void setSchool(School school) {
//		this.school = school;
//	}
//////////////////////////////////////////////////////////////////
	//Constructor-Based Injection
	private School school;
	
	@Autowired // the annotation is optional for constructors.
	public HomeController(School school) {
		this.school = school;
	}
	
	@GetMapping("/")
	public String goHome() {
		System.out.println("--- From controller");
		System.out.println(school);
		return "index";
	}
}
