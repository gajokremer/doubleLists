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
	
	public void setUpScenario2() {
		
		classroom = new Classroom("Test Classroom", 0);
		
		Student s1 = new Student("1", "GK");
		Student s2 = new Student("2", "SZ");
		Student s3 = new Student("3", "SM");
		Student s4 = new Student("4", "GK");
		Student s5 = new Student("5", "SH");
		Student s6 = new Student("6", "GK");
		Student s7 = new Student("7", "CD");
		Student s8 = new Student("8", "GK");

		classroom.addOrderedStudent(s1);
		classroom.addOrderedStudent(s2);
		classroom.addOrderedStudent(s3);
		classroom.addOrderedStudent(s4);
		classroom.addOrderedStudent(s5);
		classroom.addOrderedStudent(s6);
		classroom.addOrderedStudent(s7);
		classroom.addOrderedStudent(s8);
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
		
		Student s1 = new Student("1", "GK");
		Student s2 = new Student("2", "SZ");
		Student s3 = new Student("3", "SM");
		
		classroom.addStudent(s1);
		classroom.addStudent(s2);
		classroom.addStudent(s3);
		
		assertEquals(3, classroom.getTotalStudents());
	}
	
	@Test
	public void testRemove() {
		
		setUpScenario2();
		
		int currentTotal = classroom.getTotalStudents();
		
		String name = "GK";
		
		System.out.println(classroom.removeStudents(name));
		
		assertNotEquals(currentTotal, classroom.getTotalStudents());
	}
}
