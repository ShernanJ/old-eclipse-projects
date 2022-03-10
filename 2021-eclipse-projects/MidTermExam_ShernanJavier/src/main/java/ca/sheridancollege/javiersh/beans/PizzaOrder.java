package ca.sheridancollege.javiersh.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

// Renamed class to 'PizzaOrder' since the name 'Order' conflicted with SQL statement.

@Data
public class PizzaOrder {
	
	private int id; // Auto Incrementing id
	private String firstName; // Input Box
	private int totalPizzas; // Selected number of pizza(s)
	private String sizeOfPizza; // Selected size of pizza
	private int totalToppings; // Selected number of Toppings.
	private LocalDate dateWritten = LocalDate.now(); // Date posted.
	private LocalTime timeWritten = LocalTime.now(); // Time Posted
	private int[] numberOfPizzas = {1, 2, 3, 4}; // Number of Pizza options
	private int[] numberOfToppings = {1, 2, 3, 4, 5}; // Number of Topping options.
	private String[] sizes = {"Small", "Medium", "Large"}; // Size of Pizza Options.
	private double pizzaPrice; // Calculated Pizza price depending on Size..
	private double totalPrice; // Total Price of Pizza.
	
}
