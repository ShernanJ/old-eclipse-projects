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
}
