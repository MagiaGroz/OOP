package lab3;

public class Student extends Person5 {
String program;
int year;
double fee;
	Student(String name, String address, String program, int year, double fee){
		super(name,address);
		this.program=program;
		this.year=year;
		this.fee=fee;
	}
	
	Student(){
		super();
	}
	String getProgram() {
		return program;
	}
	void setProgram(String program) {
		this.program=program;
	}
	int getYear() {
		return year;
	}
	void setYear(int year){
		this.year=year;
	}
	double getFee() {
		return fee;
	}
	void setFee(double fee) {
		this.fee=fee;
	}
	
	public String toString() {
		String s = super.toString() + "program = "+program+"year = "+year+"fee = "+fee;
		return s;
	}
}
