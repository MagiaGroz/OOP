package lab4;

import java.io.Serializable; // библиотека для сериализации

public class Instructor implements Serializable {

	private static final long serialVersionUID = -7236600711871743311L; //уникальное число для проверки целостности данных

	String firstName;  
	String lastName;
	String department;
	String email;
	Instructor(String firstName,	 String lastName, String department,	 String email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.department=department;
		this.email=email;
	}
	Instructor(){

	}

	String getFirstName() {
		return firstName;
	}
	void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	String getLastName() {
		return lastName;
	}
	void setlastName(String lastName) {
		this.lastName=lastName;
	}

	String getDepartment() {
		return department;
	}
	void setDepartment(String department) {
		this.department=department;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email=email;
	}
	
	
	public String toString() {    //overriding
		String s ="first name = "+firstName + " last name = "+lastName+" department = "+department+" email = "+email;
		return s;
	}

	public int hashCode() {      //overriding
		int prime = 31;
		int result=1;
		result=result*prime+firstName.length();
		result=result*prime+lastName.length();
		result=result*prime+department.length();
		result=result*prime+email.length();
		return result;
	}
	public boolean equals(Object e) { //overriding
		if(e==null)
			return false;
		if(e.getClass()!=this.getClass())
			return false;
		if(e.hashCode()!=this.hashCode())
			return false;
		Instructor t = (Instructor)e;
		if(t.lastName!=this.lastName)
			return false;
		if(t.firstName!=this.firstName)
			return false;
		if(t.department!=this.department)
			return false;
		if(t.email!=this.email)
			return false;
		return true;

	}

}
