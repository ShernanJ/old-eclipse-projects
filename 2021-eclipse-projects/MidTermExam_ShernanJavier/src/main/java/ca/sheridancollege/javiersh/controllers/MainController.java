package ca.sheridancollege.javiersh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.javiersh.beans.PizzaOrder;
import ca.sheridancollege.javiersh.database.DatabaseAccess;


// MidTerm Exam
// Student: Shernan Javier
// Student ID: 991572411
// Email: javiersh@sheridancollege.ca

@Controller
public class MainController {
	
	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("pizzaOrder", new PizzaOrder());
		return "index";
	}
	
	@PostMapping("/orderPizza")
	public String orderPizza(Model model, @ModelAttribute PizzaOrder pizzaOrder) {
		
		// Gets the size of pizza to calculate the total price of order.
		switch(pizzaOrder.getSizeOfPizza()) {
		case "Small":
			pizzaOrder.setPizzaPrice(8.50);
			break;
		case "Medium":
			pizzaOrder.setPizzaPrice(9.75);
			break;
		case "Large":
			pizzaOrder.setPizzaPrice(11.75);
			break;
		}
		
		pizzaOrder.setTotalPrice(pizzaOrder.getPizzaPrice() * pizzaOrder.getTotalPizzas());
		
		// Insert Order
		da.insertPizzaOrder(pizzaOrder);
		
		
		//Add List to Model
		model.addAttribute("pizzaOrderList", da.getPizzaOrderList());
		
		model.addAttribute("pizzaOrder", new PizzaOrder());
		
		return "orderSummary";
	}
}
