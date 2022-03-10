package ca.sheridancollege.javiersh.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
	
	private Long id;
	private String name;
	private String author;
}
