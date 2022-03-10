package ca.sheridancollege.javiersh.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
	
	private Long id;
	private String name;
	private String school;
	private String program;
	private String favourite;
}
