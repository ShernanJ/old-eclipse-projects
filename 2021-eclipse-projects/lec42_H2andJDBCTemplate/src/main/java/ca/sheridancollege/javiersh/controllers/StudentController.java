package ca.sheridancollege.javiersh.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.javiersh.beans.Student;
import ca.sheridancollege.javiersh.database.DatabaseAccess;

@Controller
public class StudentController {
	
	@Autowired
	private DatabaseAccess da;

	List<Student> studentList = new CopyOnWriteArrayList<Student>();
	
	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", studentList);
		da.insertStudent();
		return "index.html";
	}
	
	@PostMapping("/insertStudent")
	public String insertStudent(Model model, @ModelAttribute Student student) {
		studentList.add(student);
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", studentList);
		return "index";
	}
}
