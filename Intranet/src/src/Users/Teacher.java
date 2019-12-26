package src.Users;

import java.util.*;
import java.util.Map.Entry;

import src.Course;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import src.Mark;
import src.Order; 


 public class Teacher extends Employee implements Serializable {
	private static final long serialVersionUID = -5933028959018447796L;
   private DEGREE degree;
   public String name;
   public Vector<String> messages;
   public HashMap<Course, Vector<Student>> courses = new HashMap<Course, Vector<Student>>();
   public Vector<Course> tcourses = new Vector<Course>();
     
     public Teacher(String login, String password) {
    	    super(login, password);
    	   }
     public Teacher(String login, String password, int salary) {
 	    super(login, password);
 	    this.setSalary(salary);
 	   }
     
    public Teacher(String login, String password, int salary, DEGREE degree) {
	    super(login, password);
	    setSalary(salary);
	    this.degree = degree;
   }

 

   public void addFolder() {
      }

      @Override
   public int hashCode() {
	    final int prime = 31;
	    int result = super.hashCode();
	    result = prime * result + ((courses == null) ? 0 : courses.hashCode());
	    result = prime * result + ((degree == null) ? 0 : degree.hashCode());
	    return result;
   }

   @Override
   public boolean equals(Object obj) {
	    if (this == obj)
	     return true;
	    if (!super.equals(obj))
	     return false;
	    if (getClass() != obj.getClass())
	     return false;
	    Teacher other = (Teacher) obj;
	    if (courses == null) {
	     if (other.courses != null)
	      return false;
	    } else if (!courses.equals(other.courses))
	     return false;
	    if (degree != other.degree)
	     return false;
	    return true;
   }

   public void putMark(Course c, Student student, Mark mark) {
       student.setMark(c, mark);
      }
         public void sendOrderToSupport(Order o) {
          ITguy.orders.add(o);
         }
      public String viewStudent(Student student) {
       return student.toString();
      }
      public String viewStudents(String cname) {
          
        	  for (Entry<Course, Vector<Student>> entry: courses.entrySet()) { 
        	  		if(entry.getKey().getName().contentEquals(cname)) {
        	  			return entry.getValue().toString();
        	  		};
        	  }
          
          return "No such student or he is not existing in your courses";
         }
      public Vector<Course> getCourses() {
       return (Vector<Course>) courses.keySet();
      }

      public void addCourse(Course course) {
       this.courses.put(course, null); 
      }
      public void setStudents(Course c, Vector<Student> s) {
       this.courses.put(c, s);
      }
      public String getMessages() throws FileNotFoundException {
    	  BufferedReader reader = new BufferedReader(new FileReader("src\\src\\Messages.txt"));
  		String line = "";
  		String res="";
  		try {
  			while((line=reader.readLine())!=null) {
  				String[] tm = line.split(" ");
  				if(tm[0].contentEquals(getlogin()))
  				res+=tm[1]+"\n";
  			}
  			reader.close();
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
  	
  		return res;
      }
//      public void putAttendance(Student student, Course c, ATTENDANCE a) {
//       student.putAttendance(c, a);
//      }
//      public void deserializeCourses() throws IOException {
//       if(Serialization.deserializeCoursesCollection() != null)
//       courses = Serialization.deserializeCoursesCollection();
//      }
 }
