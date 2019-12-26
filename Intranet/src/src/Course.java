package src;
import java.lang.*;
import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

import src.Users.Student;

public class Course implements Serializable {
  private String name;
  private String textbook;
  public boolean openReg;
  private ArrayList <CourseFile> files = new ArrayList <CourseFile> ();
  ArrayList<Student> students  = new ArrayList<Student>();
  
  public Course (String name, String textbook) {
    this.name = name;
    
    this.textbook = textbook;  
    this.openReg = false;
  }
  
  public void addStudent(Student s) {
    students.add(s);
  }
  
  
     public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getTextbook() {
    return textbook;
  }
  
  public void setTextbook(String textbook) {
    this.textbook = textbook;
  }
  
public ArrayList<Student> getStudents(){
	return students;
}
  
   public void addFile(CourseFile file) {
          files.add(file);
      }
   
   
   public void deleteFile(String title) {
          for (CourseFile courseFile: files) {
              if (courseFile.getTitle().equals(title)) {
                  files.remove(courseFile);
                  break;
              }
          }
      }

  
   public ArrayList<CourseFile> getFiles() {
          return files;
      }
   
   public String toString() {
     return "Course name: " + name + '\n' + "Textbook: " + textbook + '\n';
   }
   
   public boolean equals(Object obj) {
          if (obj == this) return true;
          if (!(obj instanceof Course)) return false;
          Course c = (Course) obj;
          return c.name.equals(name) && c.textbook.equals(textbook);
      }
   public int hashCode() { return name.hashCode() + textbook.hashCode(); }
  
  
}
