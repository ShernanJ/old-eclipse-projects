package com.example.demo.beans;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component // Spring-managed component
@Data /* @ToString + @EqualsAndHashCode + @Getter + @Setter +
		 @RequiredArgsConstructor */
@AllArgsConstructor
public class School {
	
	private String name;
	private String address;
	private int numStudents;
	
	public School() {
		
		//calling a 3-arg overloaded constructor
		this("Sheridan", "Oakville", 23000);
		
		//Eclipse does not like this at all because it currently
		//doesn't know that Lombok is adding the constructor to
		//the corresponding byte-code
	}

}
