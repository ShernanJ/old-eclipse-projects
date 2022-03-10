package ca.sheridancollege.javiersh.database;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.sheridancollege.javiersh.beans.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class TestDatabaseAccess {
	
	@Autowired
	private DatabaseAccess da;
	
	@Test
	public void whenInsertStudent_getStudents() {
		// setup
		Student student = new Student();
		student.setName("Jaspreet");
		// when
		da.insertStudent(student);
		//then (the actual test)
		Assert.assertTrue(da.getStudentList().size() > 0);
	}
}
