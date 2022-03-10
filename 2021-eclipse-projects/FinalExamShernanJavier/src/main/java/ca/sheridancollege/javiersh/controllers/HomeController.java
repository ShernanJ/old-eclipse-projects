package ca.sheridancollege.javiersh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.javiersh.beans.Book;
import ca.sheridancollege.javiersh.database.DatabaseAccess;
import ca.sheridancollege.javiersh.email.Email;

@Controller
public class HomeController {
	
	@Autowired
	@Lazy
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/secure")
	public String secureIndex(Model model) {
		
		model.addAttribute("book", new Book());
		model.addAttribute("bookList", new Book());
		
		return "/secure/index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/permission-denied")
	public String permissionDenied() {
		return "/error/permission-denied";
	}
	
	@GetMapping("/register")
	public String getRegister() {
		return "register";
	}
	
	@PostMapping("/registerUser")
	public String postRegister(@RequestParam String firstName, @RequestParam String username, @RequestParam String password) {
		
		da.addUser(firstName, username, password);
		long userId = da.findUserAccount(username).getUserId();
		da.addRole(userId, Long.valueOf(1));
		da.addRole(userId, Long.valueOf(2));
		return "redirect:/";
	}
	
	@GetMapping("/deleteBookById/{id}")
	public String deleteBookById(Model model, @PathVariable long id) {
		da.deleteBookById(id);
		model.addAttribute("book", new Book());
		model.addAttribute("bookList", da.getBookList());
		return "/secure/index";
	}
	
	@GetMapping("/editBookById/{id}")
	public String editStudentById(Model model, @PathVariable long id) {
		Book book = da.getBookListById(id).get(0);
		model.addAttribute("book", book);
		da.deleteBookById(id);
		model.addAttribute("studentList", da.getBookList());
		return "/secure/index";
	}
	
	@PostMapping("/insertBook")
	public String insertBook(Model model, @ModelAttribute Book book) {
		
		// Insert the book specified by the user to DB
		da.insertBook(book);
		
		// Add the list to the model for the view to use it
		model.addAttribute("bookList", da.getBookList());
		
		// Create a blank book
		model.addAttribute("book", new Book());
		
		
		return "/secure/index";
	}
	
	@Autowired
	private Email email;
	
	@GetMapping("/sendMessage")
	public String sendMessage() {
		
		email.sendEmail("shernanjavier@gmail.com", "AllBooks email confirmation", "Confirm your Email.");
		return "redirect:/secure";
	}
}
