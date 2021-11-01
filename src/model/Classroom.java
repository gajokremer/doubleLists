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
		
		System.out.println("NAME: " + name);
		
		int total = totalStudents;
		int count = 0;

		if(first != null) {

			if(first == last && first.getName().equalsIgnoreCase(name)) {
				
				first = null;
				last = null;
				count++;
				totalStudents--;
				
			} else {
				
				Student current = first;
				Student aux = first.getNext();
				
				while(total != 0) {
					
//					if(current.getName().equalsIgnoreCase(name)) {
//	
//						aux.setPrev(current.getPrev());
//						current.getPrev().setNext(aux);
//						
//						count++;
//						totalStudents--;
//					}
					
					if(aux.getName().equalsIgnoreCase(name)) {
						
						current.setNext(aux.getNext());
						
					}
					
					total--;
					current = current.getNext();
					aux = aux.getNext();
				}
				
//				for(int i = 1; i <= totalStudents; i++) {
//					
//					if(current.getName().equalsIgnoreCase(name)) {
//						
//						current.getNext().setPrev(current.getPrev());
//						current.getPrev().setNext(current.getNext());
//						
//						count++;
//						totalStudents--;
//					}
//					
//					current = current.getNext();
//				}
			}
			
		}

		return count;
	}

	public String printStudents() {

		String result = "";
		String code = "";

		if(first != null) {

			Student temp = first;

//			while(!code.equalsIgnoreCase(last.getCode())) {
//				
//				System.out.println("print while");
//
//				result += temp.toString() + "\n";
//				temp = temp.getNext();
//				code = temp.getCode();
//			}
			
			for(int i = 1; i < totalStudents; i++) {
				
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
	
	public boolean removeStudents1(String name) {

		Student current;
		boolean found = false;
		current = last;

		if(first != null) {

			while(current.getNext() != last && !found) {

				found = current.getNext().getName().equals(name);

				if(!found) {

					current = current.getNext();
				}
			}

			found = current.getNext().getName().equals(name);

			if(found) {

				Student aux = current.getNext();
				if(last == last.getNext()) {

					last=null; 

				} else {

					if(aux == last) {

						last=current;
					}

					current.setNext(aux.getNext());
				}

				aux=null; 
			}
		}

		return found == true;
	}
	
	public int remove(String name) {

		int count = 0;

		Student current = first;
		Student prev = first.getPrev();
		boolean found = false;

		if(first != null) {

			do {

				if(first == last && first.getName().equalsIgnoreCase(name)) {

					first = null;
					last = null;
					count++;
					totalStudents--;

				} else if(current == last) {

					last = prev;
					last.setNext(first);
					first.setPrev(last);
					count++;
					totalStudents--;

				} else {

					prev.setNext(current.getNext());
					current.getNext().setPrev(prev);
					count++;
					totalStudents--;
				}

				found = true;

				prev = current;
				current = current.getNext();

			} while (current != first && !found);
		}

		return count;
	}
}
