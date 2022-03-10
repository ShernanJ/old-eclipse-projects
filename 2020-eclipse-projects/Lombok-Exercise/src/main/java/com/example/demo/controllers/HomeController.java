package com.example.demo.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.beans.School;
import com.example.demo.database.DatabaseAccess;

@Controller
public class HomeController {
	
	private DatabaseAccess da; // Will be injected by the Framework
	/**
	 * One arg constructor
	 * @param da will be injected by Spring.
	 */
	public HomeController(DatabaseAccess da) { this.da = da; }
	
	@GetMapping("/addSchoolForm")
	public String addSchoolForm() { return "addSchool"; }
	
	@PostMapping("/add")
	public String AddSchool(
			@RequestParam String name, @RequestParam String address,
			@RequestParam int numStudents) {
		
		School school = new School(name, address, numStudents);
		da.getSchoolList().add(school);
		
		return "index";
	}
	
	@GetMapping("removeAll")
	public String removeAll() {
		da.getSchoolList().clear();
		System.out.println("Cleared Database");
		return "index";
	}
	
	@GetMapping("/viewSchools")
	public String viewSchools(HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		String schools = da.getSchoolList().isEmpty() ? "There are no schools listed" : "";
		for(School s: da.getSchoolList()) {
			schools += "<li>" + s.toString() + "</li>";
		}
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>School Management</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<h1>Welcome to our School Management Application</h1>\r\n" +
				"<br><ul>" + schools + "</ul><br><a href='/'>Back to home page</a>" +
				"</body>\r\n" + 
				"</html>");
		
		System.out.println(da);
		
		return null;
	}

}
