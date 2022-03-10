package ca.sheridancollege.javiersh.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.javiersh.beans.Student;

@Controller
public class HomeController {

	@GetMapping("/viewStudents")
	public String viewStudents(Model model, RestTemplate restTemplate) {
		ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/students",
				Student[].class);
		model.addAttribute("studentList", responseEntity.getBody());
		return "viewStudents";
	}

	@GetMapping(value = "/getStudent/{id}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getStudent(@PathVariable int id, RestTemplate restTemplate) {
		Map<String, Object> data = new HashMap<String, Object>();
		ResponseEntity<Student> responseEntity = restTemplate.getForEntity("http://localhost:8080/students/" + id,
				Student.class);
		data.put("student", responseEntity.getBody());
		return data;
	}
}
