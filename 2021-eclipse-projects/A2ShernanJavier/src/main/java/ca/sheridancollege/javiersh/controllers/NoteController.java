package ca.sheridancollege.javiersh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.javiersh.beans.Note;
import ca.sheridancollege.javiersh.database.DatabaseAccess;

/**
 * PROG32758 - Assignment 2
 * 
 * @author Shernan Javier
 * Student ID: 991572411
 * Date: 2/26/2021
 * 
 * Application Name: CRUD Notes
 * 
 * Class: NoteController
 * 
 * The main controller for an application that demonstrates the basic understanding 
 * of CRUD functions. A note pad application where users are able to create and
 * save their notes, which is organized by different categories. Users are able to
 * delete them as well.
 * 
 * To Do's:
 * [X] Meet basic requirements
 * [X] Make the application stylish with CSS.
 * [X] Organize the Notes in different subjects.
 * [ ] Allow user to create more categories/subjects.
 * [/] Dynamically render content to allow above. (Kind of did it but controller is full of hard-coded methods)
 * [ ] Finish the styling.
 * [ ] Allow users to edit their content.
 * [ ] Integrate note creation in landing page as a Pop up Modal window.
 */

@Controller
public class NoteController {
	
	/**
	 * Create a DatabaseAccess object.
	 */
	@Autowired
	private DatabaseAccess da;
	
	/**
	 * The Go Home method / The Landing Page.
	 * 
	 * index.html contains a welcome message and a button for users to create a
	 * note, below that contains all the different categories/subjects for each
	 * note. Clicking on a note will bring the user to another page which is
	 * rendered by Thymeleaf depending on what category you clicked on.
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("note", new Note());
		return "index";
	}
	
	/**
	 * The createNote method.
	 * 
	 * When the user clicks on the 'Create a Note' button in the landing page,
	 * this method is called to then redirect the user to the note creation page.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/createNote")
	public String createNote(Model model) {
		model.addAttribute("note", new Note());
		return "createNote";
	}
	
	/**
	 * The postNote method.
	 * 
	 * Gathers user input and inserts into the database and updates model.
	 * 
	 * @param model
	 * @param note
	 * @return
	 */
	@PostMapping("/postNote")
	public String postNote(Model model, @ModelAttribute Note note) {

		// Insert the note
		da.insertNote(note);

		// Add list to model
		model.addAttribute("allNotesList", da.getAllNotesList());

		model.addAttribute("note", new Note());

		return "index";
	}
	
	/**
	 * The viewNote method
	 *
	 * when the user clicks on a note, the method checks which subject it is then
	 * renders the viewNote page depending on what was clicked.
	 * 
	 * Next step for this method:
	 * [ ] Make it dynamically rendered..
	 * 
	 * (I was only able to get 20% of what I wanted to do for this part sadly)
	 * 
	 * @param model
	 * @param subject
	 * @return
	 */

	@GetMapping("/viewNote/{subject}")
	public String viewNote(Model model, @PathVariable String subject) {
		
		model.addAttribute("note", new Note());
		model.addAttribute("subject", subject);

		if(subject.contains("General")) {
			model.addAttribute("noteList", da.getGeneralNotesList());
		} 
		else if(subject.contains("Grocery")) {
			model.addAttribute("noteList", da.getGroceryNotesList());			
		}
		else if(subject.contains("School")) {
			model.addAttribute("noteList", da.getSchoolNotesList());			
		}
		else if(subject.contains("Work")) {
			model.addAttribute("noteList", da.getWorkNotesList());			
		}
		else if(subject.contains("Chores")) {
			model.addAttribute("noteList", da.getChoresNotesList());			
		}
		else if(subject.contains("Game")) {
			model.addAttribute("noteList", da.getGameNotesList());			
		}
		else if(subject.contains("Hobby")) {
			model.addAttribute("noteList", da.getHobbyNotesList());			
		}
		else if(subject.contains("Other")) {
			model.addAttribute("noteList", da.getOtherNotesList());			
		}else {
			System.out.println("The subject: " + subject + " does not exist.");
			return "redirect:/"; // Could not get /error page to work for some reason, maybe Spring Boot has a strict guideline to making one.
		}
		
		return "viewNote";
	}
	
	/**
	 * The deleteContent method.
	 * 
	 * When the delete button (red X) in the viewing note page is clicked, calls
	 * this method to remove from database and page.
	 * 
	 * @param model
	 * @param subject
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteContent/{subject}/{id}")
	public String deleteContent(@PathVariable String subject, @PathVariable int id) {
		da.deleteContent(subject, id);
		return "redirect:/viewNote/{subject}";
	}

}
