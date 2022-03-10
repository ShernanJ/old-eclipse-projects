package ca.sheridancollege.javiersh.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Student {
	
	private Long id;
	@NonNull
	private String name;
	// To show if the student is the admin
	private Boolean admin;
}
