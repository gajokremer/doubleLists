package ui;

import java.util.Scanner;

import model.Classroom;
import model.Student;

public class Main {

	private Scanner sc;
	private Classroom classroom;

	public Main() {

		sc = new Scanner(System.in);
		classroom = new Classroom("Class 1", 0);
	}

	public static void main(String[] args) {

		System.out.println("----------APPLICATION STARTS----------");

		Main main = new Main();

		int option = 0;

		do {

			option = main.mainMenu();
			main.excecuteOption(option);

		} while (option != 0);
	}

	public int mainMenu() {

		String option = "";

		System.out.println("\n\n--------MAIN MENU--------\n");

		System.out.println("--Total Students: " + classroom.getTotalStudents());

		System.out.println(
				"\nSelect an option:\n" + 
						"(1) Add Student to Head\n" + 
						"(2) Add Student to Tail\n" + 
						"(3) Remove Student\n" + 
						"(4) Print Students" + 

				"\n(0) Exit");

		option = sc.nextLine();
		int o = Integer.parseInt(option);

		return o;
	}

	public void excecuteOption(int option) {

		switch(option) {

		default:
			System.out.println("\n---Invalid Option");
			break;

		case 0:
			System.out.println("\n-----OPERATION ENDED-----\n");
			break;

		case 1:
			//			addStudentToHead();
			addStudent(option);
			break;

		case 2:
			//			addStudentToTail();
			addStudent(option);
			break;

		case 3:
			removeStudents();
			break;

		case 4:
			System.out.println(classroom.printStudents());
			break;

		case 5:
			addExamples();
			break;
		}
	}

	//	public void addStudentToHead() {
	//		
	//		System.out.print("\nCode: ");
	//		String code = sc.nextLine();
	//		
	//		System.out.print("Name: ");
	//		String name = sc.nextLine();
	//		
	//		Student s = new Student(code, name);
	//		
	//		classroom.addStudent(s);
	//	}
	//	
	//	public void addStudentToTail() {
	//		
	//		System.out.print("\nCode: ");
	//		String code = sc.nextLine();
	//		
	//		System.out.print("Name: ");
	//		String name = sc.nextLine();
	//		
	//		Student s = new Student(code, name);
	//		
	//		classroom.addOrderedStudent(s);
	//	}

	public void addStudent(int n) {

		System.out.print("\nCode: ");
		String code = sc.nextLine();

		System.out.print("Name: ");
		String name = sc.nextLine();

		Student s = new Student(code, name);

		if(n == 1) {

			classroom.addStudent(s);

		} else {

			classroom.addOrderedStudent(s);
		}
	}

	public void removeStudents() {

		System.out.print("\nName to search: ");
		String name = sc.nextLine();

		//		System.out.println("\n--Students removed: " + classroom.removeStudents(name));
		System.out.println("\n--Students removed: " + classroom.removeStudents1(name));
	}

	public void addExamples() {

		Student s1 = new Student("1", "GK");
		Student s2 = new Student("2", "SZ");
		Student s3 = new Student("3", "SM");
//		Student s4 = new Student("4", "GK");

		//		Student s1 = new Student("1", "GK");
		//		Student s2 = new Student("2", "SZ");
		//		Student s3 = new Student("3", "SM");
		//		Student s4 = new Student("4", "GK");
		//		Student s5 = new Student("3", "SH");

		//		classroom.addStudent(s1);
		//		classroom.addStudent(s2);
		//		classroom.addStudent(s3);
		//		classroom.addStudent(s4);
		//		classroom.addStudent(s5);

		classroom.addOrderedStudent(s1);
		classroom.addOrderedStudent(s2);
		classroom.addOrderedStudent(s3);
//		classroom.addOrderedStudent(s4);
	}
}