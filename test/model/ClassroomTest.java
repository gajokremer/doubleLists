package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClassroomTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	private Classroom classroom;

	public void setUpScenario1() {
		
		classroom = new Classroom("Test Classroom", 0);
	}
	
	@Test
	public void testClassroom() {
		
		setUpScenario1();
		
		assertTrue(classroom.getTotalStudents() == 0);
		assertTrue(classroom.getFirst() == null);
		assertTrue(classroom.getLast() == null);
	}
	
	@Test
	public void testAddStudent() {
		
		setUpScenario1();
		
		Student s = new Student("1", "GK");
		
		classroom.addStudent(s);
		
		assertEquals(1, classroom.getTotalStudents());
	}
	
	
}
