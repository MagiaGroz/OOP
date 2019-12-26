package src.Users;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import src.Systems;


public class Admin extends Employee {
    public Admin(String login, String password) {
		super(login, password);
	}
    public Admin(String login, String password, int salary) {
  		super(login, password);
  		this.setSalary(salary);
  	}
	
    public static void addUser(User u) {
    	Systems.usersdb.add(u);
    }

  
    public static void removeUser(User u) {
    	Systems.usersdb.remove(u);
    }

    
    public void updateUser() {
    	
    }

   
    public static String seeLog() throws FileNotFoundException {
    	BufferedReader reader = new BufferedReader(new FileReader("src\\src\\log.txt"));
		String line = "";
		try {
			while(reader.readLine()!=null) {
				line+=reader.readLine()+"\n";
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return line;
    }
}

