package com.example.demo.database;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Avenger;

@Repository
public class DatabaseAccess {
	
	private NamedParameterJdbcTemplate jdbc;
	
	public DatabaseAccess(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public List<Avenger> getAvengers(){
		//Not a lot if being down with this right now
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM AVENGERS";
		
		// Uncomment these lines to see the named parameters in action
//		query = "SELECT * FROM avengers WHERE age >:minAge";
//		namedParamters.addValue("minAge", 26); //Play around with different number
		
		//Will map a row coming in to an instance of Avenger
		BeanPropertyRowMapper<Avenger> avengerMapper = new BeanPropertyRowMapper<Avenger>(Avenger.class);
		
		// Now that we prepared the helper objects,
		// this one call does it all!
		List<Avenger> avengers = jdbc.query(query, namedParameters, avengerMapper);
		
		return avengers;
	}
	
	/**
	 * Adds an Avenger to the database
	 * @param avenger: the Avenger to add
	 * @return the number of rows affected; 1 - successful, 0 = not.
	 */
	public int addAvenger(Avenger avenger) {
		
		// Create a new instance of MapSqlParameterSource for our use.
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "INSERT INTO avengers (name, age) VALUES (:name, :age)";
		
		//Add the parameters to our map
		namedParameters
			.addValue("name", avenger.getName())
			.addValue("age", avenger.getAge());
		
		int returnValue = jdbc.update(query, namedParameters);
		
		return returnValue;
	}
	
	public int deleteAvenger(Long id) {
		
		// Create a new instance of MapSqlParameterSource for us to use.
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "DELETE FROM avengers WHERE id = :id";
		
		// Add parameters to map
		namedParameters
			.addValue("id", id);
		
		return jdbc.update(query, namedParameters);
	}
	
	public Avenger getAvenger(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM avengers WHERE id = :id";
		namedParameters.addValue("id", id);
		BeanPropertyRowMapper<Avenger> avengerMapper = new BeanPropertyRowMapper<Avenger>(Avenger.class);
		List<Avenger> avengers = jdbc.query(query, namedParameters, avengerMapper);
		if(avengers.isEmpty()) {
			return null;
		}else {
			return avengers.get(0);
		}
	}
	
	public int updateAvenger(Avenger avenger) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "UPDATE avengers SET name=:name, age=:age WHERE id=:id";
		namedParameters
			.addValue("name", avenger.getName())
			.addValue("age", avenger.getAge())
			.addValue("id", avenger.getId());
		return jdbc.update(query, namedParameters);
	}
}
