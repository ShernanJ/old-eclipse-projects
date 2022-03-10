package ca.sheridancollege.javiersh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.javiersh.beans.Course;
import ca.sheridancollege.javiersh.repositories.CourseList;

@Controller
public class CourseController {
	
	public CourseController(CourseList courseList) {
		super();
		this.courseList = courseList;
	}

	private CourseList courseList;
	


	@GetMapping("/")
	public String goToHome() {
		return "index";
	}

	@PostMapping("/processForm")
	public String processForm(
			@RequestParam int id, 
			@RequestParam int code, 
			@RequestParam String prefix,
			@RequestParam String name
			) {
		
		Course course = Course.builder().id(id).prefix(prefix).code(code).name(name).build(); // Builder Pattern
		
		courseList.getCourseList().add(course);
		System.out.println("***");
		
		for(Course c : courseList.getCourseList()) {
			System.out.println(c);
		}
		
		System.out.println("Clearing List");
		courseList.emptyList();

		return "redirect:/";
	}

	public CourseList getCourseList() {
		return courseList;
	}

	public void setCourseList(CourseList courseList) {
		this.courseList = courseList;
	}

}
