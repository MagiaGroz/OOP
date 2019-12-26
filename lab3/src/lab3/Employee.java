package lab3;

public class Employee extends Person {
	protected double salary;
	protected int year;
	protected String insuranceNumber;

	Employee(String name,double salary, int year, String insuranceNumber){
		super(name);
		this.salary=salary;
		this.year=year;
		this.insuranceNumber=insuranceNumber;
	}
	Employee(){
		super();
		salary=1;
		year=2019;
		insuranceNumber = "default";
	}
	double getSalary(){
		return salary;
	}
	void setSalary(int salary) {
		this.salary=salary;
	}
	int getYear() {
		return year;
	}
	void setYear(int year) {
		this.year=year;
	}
	String insuranceNumber() {
		return insuranceNumber;
	}
	@Override
	public String toString() {
		String s =super.toString()+ " year = " + year+ " insuranceNumber = " + insuranceNumber+" salary = " + salary;
		return s;
	}
	@Override
	public int hashCode() {      
		final int prime = 31;
		int result = 1;
		result = super.hashCode();
		result = prime * result + (int)salary;
		result = prime * result + year;
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
		if(e.name!=name || e.year!=year || e.insuranceNumber!=insuranceNumber || e.salary!=salary)
			return false;
		
		
		return true;
	}
	
}
