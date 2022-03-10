package com.example.demo.database;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.beans.School;

import lombok.Data;

/**
 * A simple class marked up as a repository to simulate
 * database access.
 * Data annotation is asking Lombok to create the getters/setters for us
 * Will use injection in controller class to access it.
 * @author shern
 *
 */

@Repository
@Data
public class DatabaseAccess {
	
	// Used to simulate a table...
	private ArrayList<School> schoolList = new ArrayList<>();
}
