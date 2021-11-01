package model;

public class Student {

	private String code;
	private String name;
	private Student next;
	private Student prev;

	public Student(String code, String name) {
		this.setCode(code);
		this.setName(name);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getNext() {
		return next;
	}

	public void setNext(Student next) {
		this.next = next;
	}

	public Student getPrev() {
		return prev;
	}

	public void setPrev(Student prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		
		String result = "";
		
		if(prev != null && next != null) {
			
			result = "[" + prev.getCode() + "] <-- [" + "Code: " + code + ", Name: " + name + "] --> [" + next.getCode() + "]";
		
		} else if(prev == null && next == null) {
			
			result = "[-] <-- [" + "Code: " + code + ", Name: " + name + "] --> [-]";
			
		} else if(prev == null) {
			
			result = "[-] <-- [" + "Code: " + code + ", Name: " + name + "] --> [" + next.getCode() + "]";
			
		} else if(next == null) {
			
			result = "[" + prev.getCode() + "] <-- [" + "Code: " + code + ", Name: " + name + "] --> [-]";
		}

//		return "[" + prev.getCode() + "] <-- [" + "Code: " + code + ", Name: " + name + "] --> [" + next.getCode() + "]";
	
		return result;
	}
}
