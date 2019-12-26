package src.Users;

import java.util.HashMap;
import java.util.Map.Entry;

import src.Course;
import src.Mark;
import src.YoS;

import java.io.Serializable;

public class Student extends User implements Serializable {
  
	private static final long serialVersionUID = 1L;

private String name;
  
  private Faculty dep;
  
  private YoS yos;
  
  public HashMap<Course, Mark> crsmarks = new HashMap<Course, Mark>();
  public HashMap<Course, Teacher> crsteachers = new HashMap<Course, Teacher>();

  public Student(String login,String password){
	    super(login,password);
	  }
  
  public Student(String login,String password, String name,Faculty dep, YoS yos){
	  super(login,password);
    this.name = name;
    this.dep = dep;
    this.yos = yos;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public Faculty getDep() { return dep; }
  public void setDep(Faculty dep) { this.dep = dep; }
  
  public String getFiles(String crsname) {
	  for (Entry<Course, Mark> entry: crsmarks.entrySet()) { 
  		if(entry.getKey().getName().contentEquals(crsname)) {
  			return entry.getKey().getFiles().toString();
  		};
  }
	  return "No such File";
  }
    public Mark viewMark(Course c) {
      Mark mark = crsmarks.get(c);
      return mark;
    }
    public String viewMark(String c) {
    	for (Entry<Course, Mark> entry: crsmarks.entrySet()) { 
    		if(entry.getKey().getName().contentEquals(c)) {
    			return entry.getValue().toString();
    		};
    		}
    	return "No such course";
      }
    public void regCourse(Course c) {
      if (c.openReg) {
      crsmarks.put(c, new Mark());
      c.addStudent(this);
      crsteachers.put(c,null);
      }
    }
   
    public String viewInfoTeacher(Course c) {
      Teacher t = crsteachers.get(c);
      return t.toString();
       
    }
    public  String viewInfoTeacher(String name) {
    	for (Entry<Course, Teacher> entry: crsteachers.entrySet()) { 
    		if(entry.getValue().getlogin().contentEquals(name)) {
    			return entry.getValue().toString();
    		};
    		}
  	  return "No such teacher";
    }
    
    public String toString() {
      return "Name : " +  name + ". Faculty: "  + dep + ". Year of Study : " + yos;
    }
    
    public void viewFiles(Course c){
      System.out.println(c.getFiles());
    }
    
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return s.name.equals(name) && s.dep.equals(dep) && s.yos.equals(yos);
    }
    

   public int hashCode() { 
     return name.hashCode() + dep.hashCode() + yos.hashCode(); 
     }

public void setMark(Course c, Mark mark) {
	crsmarks.put(c, mark);
	
}
    
}
