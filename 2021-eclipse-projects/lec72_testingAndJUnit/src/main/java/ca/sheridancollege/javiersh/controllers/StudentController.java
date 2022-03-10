package ca.sheridancollege.javiersh.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.javiersh.beans.Student;
import ca.sheridancollege.javiersh.database.DatabaseAccess;

@Controller
public class StudentController {
	
	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String goHome(Model model) {
		
		da.insertStudent();
		// This will be used to insert an object to the DB
		model.addAttribute("student", new Student());
		return "index";
	}
	
	@GetMapping("/deleteStudentById/{id}")
	public String deleteStudentById(Model model, @PathVariable long id) {
		da.deleteStudentById(id);
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudentList());
		return "index";
	}
	
	@GetMapping("/editStudentById/{id}")
	public String editStudentById(Model model, @PathVariable long id) {
		Student student = da.getStudentListById(id).get(0);
		model.addAttribute("student", student);
		da.deleteStudentById(id);
		model.addAttribute("studentList", da.getStudentList());
		return "index";
	}
	
	@PostMapping("/insertStudent")
	public String insertStudent(Model model, @ModelAttribute Student student) {
		
		// Insert the student specified by the user to DB
		da.insertStudent(student);
		
		// Add the list to the model for the view to use it
		model.addAttribute("studentList", da.getStudentList());
		
		// Create a blank student
		model.addAttribute("student", new Student());
		
		
		return "index";
	}
}
