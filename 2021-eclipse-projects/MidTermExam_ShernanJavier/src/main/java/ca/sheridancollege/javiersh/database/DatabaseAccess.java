package ca.sheridancollege.javiersh.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.javiersh.beans.PizzaOrder;

@Repository
public class DatabaseAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	//Insert the Order
	public void insertPizzaOrder(PizzaOrder pizzaOrder) {
		
		// Parameter stuff
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		//Specify the query
		String query = "INSERT INTO pizzaOrder(firstName, totalPizzas, sizeOfPizza, totalToppings, dateWritten, timeWritten, pizzaPrice, totalPrice) VALUES (:firstName, :totalPizzas, :sizeOfPizza, :totalToppings, :dateWritten, :timeWritten, :pizzaPrice, :totalPrice) ";
		
		//Specify the name
		namedParameters.addValue("firstName", pizzaOrder.getFirstName());
		namedParameters.addValue("totalPizzas", pizzaOrder.getTotalPizzas());
		namedParameters.addValue("sizeOfPizza", pizzaOrder.getSizeOfPizza());
		namedParameters.addValue("totalToppings", pizzaOrder.getTotalToppings());
		namedParameters.addValue("dateWritten", pizzaOrder.getDateWritten());
		namedParameters.addValue("timeWritten", pizzaOrder.getTimeWritten());
		namedParameters.addValue("pizzaPrice", pizzaOrder.getPizzaPrice());
		namedParameters.addValue("totalPrice", pizzaOrder.getTotalPrice());
		
		// Insert to DB
		int rowsAffected = jdbc.update(query, namedParameters);
		
		//Check if rows were updated.
		if( rowsAffected > 0 ) {
			System.out.println("Inserted Pizza Order into database");
		}
	}
	
	// Acquire list of Orders.
	public List<PizzaOrder> getPizzaOrderList(){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		// Get all Orders from DB
		String query = "SELECT * FROM pizzaOrder";
		
		// Return list of Pizza Orders.
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<PizzaOrder>(PizzaOrder.class));
	}
}
