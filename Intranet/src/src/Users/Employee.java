package src.Users;

/**
 */
public abstract class Employee extends User {
	Employee(String login, String password){
    	super(login,password);
    }
   
	private int salary;
	int getSalary(){
		return salary;
	}
	
	void setSalary(int s) {
		salary=s;
	}
    
}

