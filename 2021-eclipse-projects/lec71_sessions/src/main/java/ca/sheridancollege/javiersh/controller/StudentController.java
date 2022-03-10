package ca.sheridancollege.javiersh.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.javiersh.bean.Student;

@Controller
public class StudentController {
	
	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("student", new Student());
		return "index";
	}
	
	@GetMapping("/test")
	public String test(HttpSession session) {
		if(session.isNew()) {
			session.setAttribute("myTest", "New Session");
		} else {
			session.setAttribute("myTest", "Welcome Back");
		}
		return "test";
	}
	
	@PostMapping("/insertStudent")
	public String insertStudent(HttpSession session, Model model, @ModelAttribute Student student) {
		List<Student> studentList;
		if(session.isNew()) {
			studentList = new CopyOnWriteArrayList<Student>();
		} else {
			studentList = (CopyOnWriteArrayList<Student>)session.getAttribute("studentList");
		}
		studentList.add(student);
		session.setAttribute("studentList", studentList);
		model.addAttribute("student", new Student());
		return "index";
	}
}
