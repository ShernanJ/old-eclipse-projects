package ca.sheridancollege.javiersh.repositories;

import java.util.List;

import ca.sheridancollege.javiersh.beans.Course;

public interface CourseList {
	
	public List<Course> getCourseList();
	
	public void setCourseList(List<Course> courseList);
	
	public void emptyList();

}
