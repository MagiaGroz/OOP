package src.Users;

import java.util.Vector;

import src.Order;
import java.io.Serializable;


	import java.util.Vector;


	public class ITguy extends  Employee implements Serializable {
	 public static Vector<Order> orders =  new Vector<Order>();
	 public ITguy(String login, String password) {
	  super(login,password);
	 }
	 public ITguy(String login, String password, int salary) {
		  super(login,password);
		  this.setSalary(salary);
		 }
	 public ITguy(String login, String password,Vector<Order> orders){
	     super(login,password);
	  this.orders = orders;

	    }
	 public Vector<Order> getOrders() {
	  return orders;
	 }

	 
	 public void setOrders(Vector<Order> orders) {
	  this.orders = orders;
	 }
	 public static String viewOrders() {
	  return "Orders= " + orders ;
	 }
	 
	 
	 public static void acceptOrder(Order newOrder) {
	  if(newOrder.isDone == false) {
	   orders.add(newOrder);
	  }
	 }


	
}

