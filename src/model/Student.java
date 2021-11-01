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

	//	@Override
	//	public String toString() {
	//
	//		String result = "";
	//
	//		result = "Code: " + code + ", Name: " + name;
	//
	//		if(next != null) {
	//
	//			result += ", Next: " + next.getCode();
	//		}
	//
	//		if(prev != null) {
	//
	//			result += ", Prev: " + prev.getCode();
	//		}
	//
	//		return result;
	//	}

	@Override
	public String toString() {

		return "[" + prev.getCode() + "] <-- [" + "Code: " + code + ", Name: " + name + "] --> [" + next.getCode() + "]";
	}
}
