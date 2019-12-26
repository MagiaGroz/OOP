package lab4;

import java.io.Serializable;

public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 742152759846760793L;
	String courseTitle;
	Textbook te;
	Instructor in;
	Course(String courseTitle,int isbn, String title, String author,
			String firstName,String lastName, String department,String email){
		this.courseTitle=	courseTitle;
		te = new Textbook(isbn,title,author);
		in = new Instructor(firstName,lastName,department,email);
	}

	String getCourseTitle() {
		return courseTitle;
	}

	void setcourseTitle(String courseTitle) {
		this.courseTitle=courseTitle;
	}

	Textbook getTextbook() {
		return te;
	}

	void setTextbook(Textbook te) {
		this.te=te;
	}

	Instructor getInstructor() {
		return in;
	}

	void setInstructor(Instructor in) {
		this.in=in;
	}

	public String toString() {
		String s = courseTitle + "\n"+te.toString()+"\n"+in.toString();
		return s;
	}

	public int hashCode() {
		int prime = 31;
		int result=1;
		result=result*prime+courseTitle.length();
		result=result*prime+te.hashCode();
		result=result*prime+in.hashCode();
		return result;
	}
	public boolean equals(Object e) {
		if(e==null)
			return false;
		if(e.getClass()!=this.getClass())
			return false;
		if(e.hashCode()!=this.hashCode())
			return false;
		Course t = (Course)e;

		if(t.courseTitle!=this.courseTitle)
			return false;
		if(!t.te.equals(this.te))
			return false;
		if(!t.in.equals(this.in))
			return false;
		return true;

	}
}
