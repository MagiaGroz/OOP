package lab3;

public class Staff extends Person5 {
String school;
double pay;

	Staff(String name, String address, String school,double pay){
		super(name,address);
		this.school=school;
		this.pay=pay;
	}
	Staff(){
		
	}
	
	String getSchool() {
		return school;
	}
	
	void setSchool(String school) {
		this.school=school;
	}
	
	double getPay(){
		return pay;
	}
	
	void setPay(double pay) {
		this.pay=pay;
	}
	
	public String toString() {
		String s = super.toString()+ "school = "+school+"pay = "+pay;
		return s;
	}
}
