package lab2;

public class Student {
	public String name;
	public int id;
	int YOS=1;
	public Student(String name, int id){
		this.id = id;
		this.name=name;
	}
	
	void Name(){
System.out.println(name);		
	}
	
	public String toString() {
		String s = name +", id: "+ id;
		return s;
	}
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	void id() {
		System.out.println(id);
	}
	
	void Inc() {
		YOS++;
	}
	

}
