package src;
import java.util.*;

import src.Users.Admin;
import src.Users.Faculty;
import src.Users.ITguy;
import src.Users.Manager;
import src.Users.Student;
import src.Users.Teacher;
import src.Users.User;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;


public class Systems {
private static Systems instance;
	
	public static synchronized Systems getInstance() {
		if (instance == null) {
			instance = new Systems();
		}
		return instance;
	}
    public static Vector<User> usersdb = new Vector<User>();
    
	 public static void main(String[] args) throws IOException, InvalidLogException {
		 Admin a = new Admin("Admin","pass");
		 Course crs = new Course("OOP","Basic of oop");
		 Manager m = new Manager("Hinam","123");
		 Manager.coursedb.add(crs);
		 Teacher t = new Teacher("Pakita","12");
		 Student s1 = new Student("Lolik","1","Somebody",Faculty.FIT,YoS.FIRST);
		 s1.crsmarks.put(crs, new Mark(12,28,20));
		 Manager.students.add(s1);
		 Vector<Student> v1 = new Vector<Student>();
		 v1.add(s1);
		 t.courses.put(crs, v1);
		 Systems.usersdb.add(a);
		 Systems.usersdb.add(m);
		 Systems.usersdb.add(t);
		 Systems.usersdb.add(s1);
		 
			Scanner in = new Scanner(System.in); // буффер для чтения с консоли	

		 main:while(true) {
		 System.out.println("Enter your login");
		 String log = in.nextLine();
		 System.out.println("Enter your password");
		 String pass = in.nextLine();
		 
		 if(authentification(log,pass) instanceof Admin) {
			 
					System.out.println("Welcome!");
					menu : while(true){
						System.out.println("What do you want to do?");
						System.out.println("\n 1) Add User \n 2) Remove User  \n 3) See log \n 4) Exit");
						
						int choice = in.nextInt();
						
					//	System.err.println(choice);
						if(choice==1){
							addUser: while(true){
								System.out.println("Enter login for him: ");	
								String tempLog= in.nextLine();
								in.nextLine();
								System.out.println("Enter password for him: ");
								String tempPass = in.nextLine();
							
								System.out.println("Enter type of User: ");
								String type = in.nextLine();
									switch(type) {
									case "Teacher": 
										Admin.addUser(new Teacher(tempLog,tempPass));
										break;
									case "Manager": 
										Admin.addUser(new Manager(tempLog,tempPass));
										break;
									case "Admin": 
										Admin.addUser(new Admin(tempLog,tempPass));
										break;
									case "ITguy": 
										Admin.addUser(new ITguy(tempLog,tempPass));
										break;
									case "Student": 
										Admin.addUser(new Student(tempLog,tempPass));
										break;
											
									}
							
								System.out.println("User added! ");
								writeUsingFiles(LocalDateTime.now() +" User with login "+tempLog+" and password: "+tempPass +"is added");
								System.out.println("\n 1) Add another User  \n 2) Return back \n 3) Exit");
								choice = in.nextInt();
								if(choice==1) continue addUser;
								if(choice==2) continue menu;
								if(choice==3) {System.out.println("Bye!!!");  break main;}
								break;
							}
						}
						else if (choice==2){
							RemoveCourse: while(true){
								System.out.println("Enter login of User: ");
								in.nextLine();
								String login = in.nextLine();;
								for(int i=0;i<usersdb.size();i++) {
									if(usersdb.get(i).getlogin()==login)
										usersdb.remove(i);
								}
								System.out.println("User deleted! ");
								writeUsingFiles(LocalDateTime.now() +" User with login "+login+" is deleted");
								System.out.println("\n 1) Remove another user  \n 2) Return back \n 3) Exit");
								choice = in.nextInt();
								if(choice==1) continue RemoveCourse;
								if(choice==2) continue menu;
								if(choice==3) {System.out.println("Bye!!!");  break main;}
								break;
							}
						}
						else if (choice==3) {
							
							System.out.println(Admin.seeLog());
							System.out.println(" \n 1) Return back \n 2) Exit");
							
							
							choice = in.nextInt();
							
							if(choice==1) continue menu;
							if(choice==2) {System.out.println("Bye!!!");  break main;}
							break;
						}
						else if (choice==4){
							System.out.println("Bye"); 
							
							continue main;
						}
					}
		 }
		 
		 else if(authentification(log,pass) instanceof Manager) {
			 System.out.println("Welcome!");
				menu : while(true){
					System.out.println("What do you want to do?");
					System.out.println("\n 1) View list of all students \n 2) View list of all teachers \n 3) Open registration for course \n 4) Start course \n 5) Send message to teacher \n 6) Return back \n 7) Exit");
					
					int choice = in.nextInt();
					switch(choice) {
					case 1: System.out.println(Manager.getAllStudents().toString());
						break;
					case 2: System.out.println(Manager.getAllTeachers().toString());
						break;
					case 3: System.out.println("Enter the name of course");
							in.nextLine();
						if(Manager.openCrsReg(in.nextLine()))
							System.out.println("Course is opened!");
						else
							System.out.println("Course is not found :(");
						break;
					case 4: System.out.println("Enter the name of course");
							in.nextLine();
							System.out.println(Manager.startCourse(in.nextLine()));
						break;
					case 5: System.out.println("Enter the login of teacher");
					in.nextLine();
							String nameTeacher = in.nextLine();
							System.out.println("Enter the message");
							Manager.sendMessage(nameTeacher,in.nextLine());
					case 6: continue main;
					case 7: System.out.println("Bye");
						break main;
					}
				}
		 }
		 
		 else if(authentification(log,pass) instanceof Student) {
			 Student tempStudent = (Student)authentification(log,pass);
			 System.out.println("Welcome!");
				menu : while(true){
					System.out.println("What do you want to do?");
					System.out.println("\n 1) View Mark \n 2) Register for a course \n 3) View info about teacher \n 4) View files of course \n 5) Return back \n 6) Exit");
					
					int choice = in.nextInt();
					switch(choice) {
					case 1: System.out.println("Enter the name of course");
					in.nextLine();
							String name = in.nextLine();
							System.out.println(tempStudent.viewMark(name));
						break;
					case 2: System.out.println("Choose course from list");
							
					for(int i=0;i<Manager.coursedb.size();i++) {
							System.out.println(i+") "+Manager.coursedb.get(i).toString() + "\n");
					}
					int ch = in.nextInt();
					tempStudent.regCourse(Manager.coursedb.get(ch));
						break;
					case 3: System.out.println("Enter the name of teacher");
					in.nextLine();
							System.out.println(tempStudent.viewInfoTeacher(in.nextLine()));
						break;
					case 4: System.out.println("Enter the name of course");
							in.nextLine();
							System.out.println(tempStudent.getFiles(in.nextLine()));
						break;
					case 5: continue main;
					case 6: System.out.println("Bye");
						break main;
					}
				}
		 }
		 
//		 else if(authentification(log,pass) instanceof Student) {
//			 Student tempStudent = (Student)authentification(log,pass);
//			 System.out.println("Welcome!");
//				menu : while(true){
//					System.out.println("What do you want to do?");
//					System.out.println("\n 1) View Mark \n 2) Register for a course \n 3) View info about teacher \n 4) View files of course \n 5) Exit");
//					
//					int choice = in.nextInt();
//					switch(choice) {
//					case 1: System.out.println("Enter the name of course");
//					in.nextLine();
//							String name = in.nextLine();
//							System.out.println(tempStudent.viewMark(name));
//						break;
//					case 2: System.out.println("Choose course from list");
//							
//					for(int i=0;i<Manager.coursedb.size();i++) {
//							System.out.println(i+") "+Manager.coursedb.get(i).toString() + "\n");
//					}
//					int ch = in.nextInt();
//					tempStudent.regCourse(Manager.coursedb.get(ch));
//						break;
//					case 3: System.out.println("Enter the name of teacher");
//					in.nextLine();
//							System.out.println(tempStudent.viewInfoTeacher(in.nextLine()));
//						break;
//					case 4: System.out.println("Enter the name of course");
//							in.nextLine();
//							System.out.println(tempStudent.getFiles(in.nextLine()));
//						break;
//					case 5: System.out.println("Bye");
//						break main;
//					}
//				}
//		 }
		 
		 else if(authentification(log,pass) instanceof Teacher) {
			 Teacher tempTeacher = (Teacher)authentification(log,pass);
			 System.out.println("Welcome!");
				menu : while(true){
					System.out.println("What do you want to do?");
					System.out.println("\n 1) Put Mark \n 2) Send Order to tech support \n 3) View info about student \n 4) Create course \n 5) Return back \n 6) Exit");
					
					int choice = in.nextInt();
					switch(choice) {
					case 1: 
							System.out.println("Enter mark");
							in.nextLine();
							String[] mrk = in.nextLine().split(" ");
							Mark m1 = new Mark(Integer.parseInt(mrk[0]),Integer.parseInt(mrk[1]),Integer.parseInt(mrk[2]));
							System.out.println("Choose student from the list below");
							for(int i=0;i<Manager.students.size();i++) {
								System.out.println(i+") "+Manager.students.get(i).getlogin()+"\n");
							}
							int st1 = in.nextInt();
							System.out.println("Choose course from the list below");
							for(int i=0;i<Manager.coursedb.size();i++) {
								System.out.println(i+") "+Manager.coursedb.get(i).getName()+"\n");
								
							}
							int ch = in.nextInt();
							tempTeacher.putMark(Manager.coursedb.get(ch),Manager.students.get(st1),m1);
						break;
					case 2: System.out.println("Enter the description of order");
						in.nextLine();
							tempTeacher.sendOrderToSupport(new Order(in.nextLine(), new Date()));
							break;
					case 3:  System.out.println("Enter the name of course");
					in.nextLine();
					System.out.println(tempTeacher.viewStudents(in.nextLine()));
				      break;
					case 4: System.out.println("Enter the name of course");
					in.nextLine();
					String n1 = in.nextLine();
					
					System.out.println("Enter textbook");
					String t1 = in.nextLine();
					
					Course c2 = new Course(n1,t1);
					tempTeacher.addCourse(c2);
					Manager.coursedb.add(c2);
					System.out.println("Course added! \n");
					break;
					case 5: continue main;
					case 6: System.out.println("Bye");
						break main;
					}
				}
		 }
		 
		 else if(authentification(log,pass) instanceof ITguy && authentification(log,pass).getlogin()!="-1") {
			 System.out.println("Welcome!");
				menu : while(true){
					System.out.println("What do you want to do?");
					System.out.println("\n 1) View list of orders \n 2) Add orders \n 3)Return back 4) Exit");
					
					int choice = in.nextInt();
					switch(choice) {
					case 1: System.out.println(ITguy.viewOrders());
						break;
					case 2: System.out.println("Enter description of order");
						in.nextLine();
						String descr = in.nextLine();
						ITguy.acceptOrder(new Order(descr,new Date()));
						break;
					case 3: continue main;
					case 4: System.out.println("Bye");
						break main;
					}
				}
		 }
		 else {
			 //throw new InvalidLogException;
			 System.err.println("Invalid login or password");
			 continue;
		 }
		 }
		 }
	 
	 

			private static void writeUsingFiles(String data) {
				data+="\n";
		        try {
		            Files.write(Paths.get("src\\src\\log.txt"), data.getBytes(),StandardOpenOption.APPEND);
		       } catch (IOException e) {
		            e.printStackTrace();
		        }
		    } 
  
    public static User authentification(String log, String pass) {
    	for(int i=0;i<usersdb.size();i++) {
    		if(usersdb.get(i).getlogin().contentEquals(log)) {
    		if(usersdb.get(i).getpassword().contentEquals(pass)) {
    			return usersdb.get(i);
    		}
    		}
    	}
        return new ITguy("-1","-1");
    }



		class InvalidLogException extends Exception {
			private static final long serialVersionUID = -3329924916426778688L;
			public InvalidLogException() { super(); }
			  public InvalidLogException(String message) { super(message); }
			}
		
}