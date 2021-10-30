package model;

public class Classroom {

	private String name;
	private int totalStudents;
	private Student first;
	private Student last;
	
	public Classroom(String name, int totalStudents) {
		this.setName(name);
		this.setTotalStudents(totalStudents);
//		this.setFirst(null);
//		this.setLast(null);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTotalStudents() {
		return totalStudents;
	}
	
	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}
	
	public Student getFirst() {
		return first;
	}
	
	public void setFirst(Student first) {
		this.first = first;
	}
	
	public Student getLast() {
		return last;
	}
	
	public void setLast(Student last) {
		this.last = last;
	}
	
	public void addStudent(Student s) {
		
		totalStudents++;
		
		if(first == null) {
			
			first = s;
			last = first;
			first.setNext(last);
			last.setPrev(first);
			
		} else{
			
			s.setNext(first);
			first.setPrev(s);
			s.setPrev(last);
			last.setNext(s);
			first = s;
		}
	}
	
	public void addOrderedStudent(Student s) {

		totalStudents++;
		
		if(first == null) {
			
			first = s;
			last = first;
			first.setNext(last);
			last.setPrev(first);
			 
		} else if(first == last) {
			
			first.setNext(s);
			s.setPrev(first);
			last = s;
			last.setNext(first);
			first.setPrev(last);
			
		} else {
			
			last.setNext(s);
			s.setPrev(last);
			last = s;
			last.setNext(first);
			first.setPrev(last);
		}
	}
	
	public int removeStudents(String name) {

		int count = 0;
		
		 
		
		return count;
	}
	
	public String printStudents() {
		
		String result = "";
		String code = "";
		
		if(first != null) {
			
			Student temp = first;
			
			while(!code.equalsIgnoreCase(last.getCode())) {
				
				result += temp.toString() + "\n";
				temp = temp.getNext();
				code = temp.getCode();
			}
			
			result += temp.toString();
			
		} else {
			
			result += "--No students";
		}
		
		return result;
	}
}
