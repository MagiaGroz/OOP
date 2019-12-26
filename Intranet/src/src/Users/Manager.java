package src.Users;

import java.util.*;

import src.Course;

import java.io.IOException;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 */
public class Manager extends Employee { 
	 
    public static Vector<Course> coursedb = new Vector<Course>();
 public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Teacher> teachers = new ArrayList<>();
    
public Manager(String login, String password){
    super(login,password);
   }   
public Manager(String login, String password, int salary){
    super(login,password);
    this.setSalary(salary);
   }   
	
    static public ArrayList<Student> getAllStudents(){
        return students;
    }
    static public ArrayList<Teacher> getAllTeachers(){
    	return teachers; }
    
  public static String ViewInfoAboutStudents(){
         String s = "";
         ArrayList<Student> students = getAllStudents();
         for(int i = 0; i < students.size(); i++)
         {
             s += i+1 + " " + students.get(i).getlogin() + " " + students.get(i).getID() + "\n";
         }
         return s;
     }
  
     public static String ViewInfoAboutTeachers()
     {
         String s = "";
         ArrayList<Teacher> teachers = getAllTeachers();
         for(int i = 0; i < teachers.size(); i++)
         {
             s += i+1 + " " + teachers.get(i).getlogin() + " " + teachers.get(i).getID() + "\n";
         }

         return s;
     
   }

public static boolean openCrsReg(String n) {
	for(int i=0;i<coursedb.size();i++) {
		if(coursedb.get(i).getName().contentEquals(n)) {
			 coursedb.get(i).openReg=true;
			 return true;
		}
	}
	return false;
   
   }
 public static String startCourse(String n) {
	 for(int i=0;i<coursedb.size();i++) {
			if(coursedb.get(i).getName()==n) {
				if(coursedb.get(i).getStudents().size()>=15)
					 return "Course will be in this semester!";
			}
		}
	 return "Not enough students registered for this course";
 }
   public static void sendMessage(String teacher,String message){
		writeUsingFiles(teacher+" "+message);
      // teacher.messages.add(message);
   }
	private static void writeUsingFiles(String data) {
		data+="\n";
        try {
            Files.write(Paths.get("src\\src\\Messages.txt"), data.getBytes(),StandardOpenOption.APPEND);
       } catch (IOException e) {
            e.printStackTrace();
        }
    } 
  
}






