package src;

import src.Users.Admin;
import src.Users.ITguy;
import src.Users.Manager;
import src.Users.Teacher;
import src.Users.User;

class Factory {
    public static User getUser(String inputos,String log, String pass) {
        User u = null;
        if (inputos.equals("Teacher")) {
            u = new Teacher(log,pass);
        } else if (inputos.equals("Manager")) {
        	u = new Manager(log,pass);
        } else if (inputos.equals("ITguy")) {
        	u = new ITguy(log,pass);
        } else if (inputos.equals("Admin")) {
        	u = new Admin(log,pass);
        }
        return u;
    }
    public static User getEmployee(String inputos,String log, String pass, int salary) {
        User u = null;
        if (inputos.equals("Teacher")) {
            u = new Teacher(log,pass,salary);
        } else if (inputos.equals("Manager")) {
        	u = new Manager(log,pass,salary);
        } else if (inputos.equals("ITguy")) {
        	u = new ITguy(log,pass,salary);
        } else if (inputos.equals("Admin")) {
        	u = new Admin(log,pass,salary);
        }
        return u;
    }
    public static User getITguy(String log, String pass,int salary) {
        User u = new ITguy(log,pass,salary);
        return u;
    }
    public static User getAdmin(String log, String pass, int salary) {
        User u = new Admin(log,pass,salary);
        return u;
    }
    public static User getManager(String log, String pass, int salary) {
        User u = new Manager(log,pass,salary);
        return u;
    }
}

