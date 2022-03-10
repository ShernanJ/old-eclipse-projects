package ca.sheridancollege.javiersh.repositories;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import ca.sheridancollege.javiersh.beans.Course;
import lombok.Data;

@Component
@Data
public class CourseListImpl implements CourseList {
	
	private List<Course> courseList = new CopyOnWriteArrayList<Course>();
	
//	@Override
//	public List<Course> getCourseList() {
//		// TODO Auto-generated method stub
//		return courseList;
//	}
//
//	@Override
//	public void setCourseList(List<Course> courseList) {
//		this.courseList = courseList;
//		
//	}
//
//	@Override
//	public String toString() {
//		return "CourseListImpl [courseList=" + courseList + ", getCourseList()=" + getCourseList() + ", getClass()="
//				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}

	@Override
	public void emptyList() {
		// TODO Auto-generated method stub
		courseList.clear();
	}
	

}
