package ca.sheridancollege.javiersh.database;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.javiersh.beans.Student;

@Repository
public class DatabaseAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertStudent() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO student(name, school, program, favourite) VALUES ('Frank', 'Sheridan', 'SDNE', 'Java')";
		int rowsAffected = jdbc.update(query, namedParameters);
		if(rowsAffected > 0)
			System.out.println("Inserted student into database.");
	}
	
	// Insert the name entered by the user
	public void insertStudent(Student student) {
		
		//To use for parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		// Specify the query
		String query = "INSERT INTO student(name, school, program, favourite) VALUES (:name, :school, :program, :favourite)";
		
		// Specify the name
		namedParameters.addValue("name", student.getName());
		namedParameters.addValue("school", student.getSchool());
		namedParameters.addValue("program", student.getProgram());
		namedParameters.addValue("favourite", student.getFavourite());
		
		// Insert the row to the DB and check the return value
		int rowsAffected = jdbc.update(query, namedParameters);
		
		// Check if any rows were updated.
		if(rowsAffected > 0)
			System.out.println("Inserted student into database.");
	}
	
	
	public List<Student> getStudentList(){
		
		// To use for Parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		// Get all students from the DB
		String query = "SELECT * FROM student";
		
		// Return the list of students
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Student>(Student.class));
		
	}
}
