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

		System.out.println(
				"Select an option:\n" + 
						"(1) Add Student\n" + 
						"(2) Remove Student\n" + 
						"(3) Print Students" + 

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
			addStudent();
			break;

		case 2:
			removeStudent();
			break;
			
		case 3:
			System.out.println(classroom.printStudents());
			break;
		}
	}
	
	public void addStudent() {
		
		System.out.print("Code: ");
		String code = sc.nextLine();
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		Student s = new Student(code, name);
		
//		classroom.addStudent(s);
		classroom.addOrderedStudent(s);
	}
	
	public void removeStudent() {
		
		
	}
}