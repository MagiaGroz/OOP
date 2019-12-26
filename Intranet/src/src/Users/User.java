package src.Users;

public abstract class User {
    private String login;
    private String password;
    protected int ID;
    
    User(String login, String password){
    	this.login=login;
    	this.password=password;
    }
    public String getlogin(){
    	return login;
    }
    
    public void setlogin(String login) {
    	this.login=login;
    }
    public String getpassword(){
    	return password;
    }
    
    public void setpassword(String password) {
    	this.password=password;
    }
    public int getID(){
    	return ID;
    }
    
    public void setID(int ID) {
    	this.ID=ID;
    }
}

