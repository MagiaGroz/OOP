package lab3;

class Person5{
	String name;
	String address;
	public Person5(String name, String address){
		this.name=name;
		this.address=address;
		
	}
	Person5(){
		
	}
	String getName(){
		return name;
	}
	String getAddress() {
		return address;
	}
	void setAddress(String address) {
		this.address=address;
	}
	public String toString() {
		String s = "Person name: "+name+" address: "+address;
		return s;
	}
}
