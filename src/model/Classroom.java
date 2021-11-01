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
			
		} else {
			
			s.setNext(first);
			first.setPrev(s);
			first = s;
		}
	}

	public void addOrderedStudent(Student s) {
		
		totalStudents++;

		if(first == null) {

			first = s;

		} else if(first.getNext() == null) {

			first.setNext(s);
			s.setPrev(first);
			last = s;

		} else {

			s.setPrev(last);
			last.setNext(s);
			last = s;
		}
	}
	
	public void addStudentCircular(Student s) {

		totalStudents++;

		if(first == null) {

			first = s;
			last = first;
			first.setNext(last);
			last.setPrev(first);

		} else {

			s.setNext(first);
			first.setPrev(s);
			s.setPrev(last);
			last.setNext(s);
			first = s;
		}
	}

	public void addOrderedStudentCircular(Student s) {

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

	public String printStudents() {

		String result = "";

		if(first != null) {

			Student temp = first;

			for(int i = 0; i < totalStudents && temp != null; i++) {

				result += temp.toString() + "\n";
				temp = temp.getNext();
			}

		} else {

			result += "--No students";
		}

		return result;
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

	public int removeStudents1(String name) {

		int count = 0;
		Student current = first;
		Student prev = first.getPrev();

		if(first != null) {

			do {

				if(current.getName().equalsIgnoreCase(name)) { // compara el valor del dato current con el buscado

					if(current == first){

						if(first == last) {

							first = null; 
							last = null; 

							count++;
							totalStudents--;

						} else {

							first = first.getNext();
							last.setNext(first); 
							first.setPrev(last);

							count++;
							totalStudents--;

						}

					} else if (current == last){

						last = prev;
						first.setPrev(last);
						last.setNext(first);

						count++;
						totalStudents--;

					} else{

						prev.setNext(current.getNext());
						current.getNext().setPrev(prev);;
						System.out.println(current);

						if(count != 0) {

							prev.setNext(current.getNext());
							current.getNext().setPrev(prev);;

							System.out.println("n");
						}

						count++;
						totalStudents--;

					}

				}

				prev = current; //referencia del prev al que vas a eliminar 
				current = current.getNext();


			}  while(current != first && first != null);
		}

		return count ;
	}

	public int remove(String name) {

		int count = 0;

		Student current = first;
		Student aux = first.getNext();
		boolean found = false;
		
		if(first != null) {
			
			while(current != null) {
				
				if(current.getName().equalsIgnoreCase(name)) {
					
					if(current == first) {
						
						if(aux == null) {
							
							first = null;
							count++;
							totalStudents--;
							
						} else {
							
							first = current.getNext();
							aux = first.getNext();
							first.setPrev(null);
							
							count++;
							totalStudents--;
						}
						
					} else if(current == last) {
						
						last = current.getPrev();
						last.setNext(null);
						count++;
						totalStudents--;
						
					} else {
						
						current = current.getPrev();
						aux = aux.getPrev();
						
						current.setNext(aux.getNext());
						aux.getNext().setPrev(current);
						aux = aux.getNext();
						
						count++;
						totalStudents--;
					}
				}
				
				current = current.getNext();
				
				if(aux.getNext() != null) {
					
					aux = aux.getNext();
				}
			}
		}
		

//		if(first != null) {
//
//			do {
//
//				if(first == last && first.getName().equalsIgnoreCase(name)) {
//
//					first = null;
//					last = null;
//					count++;
//					totalStudents--;
//
//				} else if(current == last) {
//
//					last = prev;
//					last.setNext(first);
//					first.setPrev(last);
//					count++;
//					totalStudents--;
//
//				} else {
//
//					prev.setNext(current.getNext());
//					current.getNext().setPrev(prev);
//					count++;
//					totalStudents--;
//				}
//
//				found = true;
//
//				prev = current;
//				current = current.getNext();
//
//			} while (current != first && !found);
//		}

		return count;
	}
}