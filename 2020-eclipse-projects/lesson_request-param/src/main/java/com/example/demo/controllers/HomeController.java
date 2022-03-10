package com.example.demo.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/register_page")
	public String goRegister() {
		return "register";
	}
	
	@GetMapping("/register")
	public String registerUser(
			@RequestParam String firstName,
			@RequestParam String lastName,
			HttpServletResponse response) throws IOException {
		
		//Get an instance of the PrintWriter from response
		PrintWriter out = response.getWriter();
		
		// Ugly part
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Success</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<h1>Registration Successful!</h1>\r\n" +
				"<h2>Welcome " + firstName + " " + lastName + "<h2>\n" +
				"</body>\r\n" + 
				"</html>");
		
		return null;
	}
}
