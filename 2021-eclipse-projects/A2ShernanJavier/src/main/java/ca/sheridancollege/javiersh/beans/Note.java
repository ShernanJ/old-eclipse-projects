package ca.sheridancollege.javiersh.beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import lombok.Data;

@Data
public class Note {
	
	private int id;
	private String subject;
	private String content;
	private LocalDate dateWritten = LocalDate.now();
	private LocalTime timeWritten = LocalTime.now();
	
	// Old String Array for hard-coded values for subjects.
	//	private String[] subjects = {"General", "Grocery", "School", "Work", "Chore", "Video Game", "Hobby", "Other"};
	
	// New ArrayList array for subjects with predetermined values and allows for additional subjects (if implemented).
	ArrayList<String> subjects = new ArrayList<String>(Arrays.asList("General", "Grocery", "School", "Work", "Chores", "Game", "Hobby", "Other"));

}
