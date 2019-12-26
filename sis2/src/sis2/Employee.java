package sis2;
import java.util.Date;

public class Employee extends Person  implements Comparable<Employee>, Cloneable {
	protected double salary;
	protected Date hireDate;
	protected String insuranceNumber;
	
	public int compareTo(Employee e){
		if(this.salary>e.salary)
			return 1;
		else if(this.salary==e.salary)
			return 0;
		else return -1;
	}
	
	public Object clone(){
		Employee e = new Employee();
		e.name=this.name;
		e.salary=this.salary;
		e.hireDate=(Date)this.hireDate.clone();
		e.insuranceNumber=this.insuranceNumber;
		return e;
	}
	
	Employee(String name,double salary, Date hireDate, String insuranceNumber){
		super(name);
		this.salary=salary;
		this.hireDate=hireDate;
		this.insuranceNumber=insuranceNumber;
	}
	Employee(){
		super();
		salary=1;
		insuranceNumber = "default";
	}
	double getSalary(){
		return salary;
	}
	void setSalary(int salary) {
		this.salary=salary;
	}
	Date getYear() {
		return hireDate;
	}
	void setYear(Date hireDate) {
		this.hireDate=hireDate;
	}
	String insuranceNumber() {
		return insuranceNumber;
	}
	@Override
	public String toString() {
		String s =super.toString()+ " hireDate = " + hireDate+ " insuranceNumber = " + insuranceNumber+" salary = " + salary;
		return s;
	}
	@Override
	public int hashCode() {      
		final int prime = 31;
		int result = 1;
		result = super.hashCode();
		result = prime * result + (int)salary;
		result = prime * result + hireDate.getYear();
		result = prime * result + insuranceNumber.length();
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(obj.getClass()!=Employee.class) {
			return false;
		}
		Employee e = (Employee)obj;
		if(e.name!=name || e.hireDate!=hireDate || e.insuranceNumber!=insuranceNumber || e.salary!=salary)
			return false;
		
		
		return true;
	}
	
}

