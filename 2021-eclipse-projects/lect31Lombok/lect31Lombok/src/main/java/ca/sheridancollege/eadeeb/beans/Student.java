package ca.sheridancollege.eadeeb.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4268363362620770686L;

	private Long id;    // represents the id
	@NonNull
	private String name; // represents the name of the student
	//private String lastName;
	
	

}
