package ca.sheridancollege.eadeeb.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StudentTest {
	
	@Test
	public void buildStudent() {
		
		// Creating a student object
		Student testStu = Student.builder()
		.id(Long.valueOf(15)) // Set the id
		.name("Joseph") // Set the name
		.build(); // Complete the creation of the Student object
		
		// Check if the id is 10
		assertEquals(testStu.getId(),Long.valueOf(15));
		// Check if the name is "Joseph"
		assertEquals(testStu.getName(), "Joseph");
		
	}

}
