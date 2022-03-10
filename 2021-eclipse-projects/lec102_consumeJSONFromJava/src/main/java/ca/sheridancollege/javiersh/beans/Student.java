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
	private Integer grade;
	private String letterGrade;
	private boolean attended;
	private boolean participated;

	private String assignLetter(Integer grade) {
		if (grade >= 90)
			return "A+";
		else if (grade >= 85)
			return "A";
		else if (grade >= 80)
			return "A-";
		else if (grade >= 75)
			return "B+";
		else if (grade >= 70)
			return "B";
		else if (grade >= 65)
			return "C+";
		else if (grade >= 60)
			return "C";
		else if (grade >= 55)
			return "D+";
		else if (grade >= 50)
			return "D";
		else
			return "F";
	}

	public Student(String name, Integer grade, Boolean attended, Boolean participated) {
		this.name = name;
		this.grade = grade;
		letterGrade = assignLetter(grade);
		this.attended = attended;
		this.participated = participated;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
		letterGrade = assignLetter(grade);
	}
}