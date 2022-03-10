package ca.sheridancollege.javiersh.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.javiersh.beans.Student;

@Controller
public class StudentController {
	
	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("serverDate", LocalDate.now());
		return "index";
	}
	
	@GetMapping("/getStudent")
	public String getStudent(Model model) {
		Student student = new Student(Long.valueOf(5), "Frank");
		model.addAttribute("student", student);
		return "getStudent";
	}
	
	
	List<Student> studentList = new CopyOnWriteArrayList<Student>();
	
 	@GetMapping("/getStudentList")
	public String getStudentList(Model model) {
 		studentList.add(new Student(Long.valueOf(1), "Frank"));
 		studentList.add(new Student(Long.valueOf(2), "Sally"));
 		studentList.add(new Student(Long.valueOf(3), "Angela"));
 		model.addAttribute("studentList", studentList);
		return "getStudentList";
	}
}
