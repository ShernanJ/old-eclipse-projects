package ca.sheridancollege.javiersh.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertStudent() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO student(name) VALUES ('Frank')";
		int rowsAffected = jdbc.update(query, namedParameters);
		if(rowsAffected > 0)
			System.out.println("Inserted student into database.");
	}
}
