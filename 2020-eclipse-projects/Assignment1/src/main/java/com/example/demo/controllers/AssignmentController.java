package com.example.demo.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssignmentController {
	
	@GetMapping("/form")
	public String goToForm() {
		return "javaFun";
	}
	
	@PostMapping("/submitForm")
	public String showResults(
			@RequestParam(defaultValue="yes") String answer,
			@RequestParam(required=true) String name,
			@RequestParam(required=true) String email,
			@RequestParam(required=false) boolean mailing,
			HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		String reply = answer.contains("yes") ? "Glad you're having fun!" : "Hope it gets better!";
		
		String mailingReply = mailing ? "We'll add your email: " + email + " to our list" : "We won't add you to our mailing list";
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>" +
				"<h1>Thanks for filling out the form, " + name +
				"<br>" + reply + "<br>" + mailingReply);
				return null;
		
	}
}
