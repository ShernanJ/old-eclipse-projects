package ca.sheridancollege.javiersh.beans;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NonNull
@RequiredArgsConstructor
public class Student {
	private long id;
	private String name;
	
}
