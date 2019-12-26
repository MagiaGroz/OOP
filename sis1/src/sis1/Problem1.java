package sis1;


class Temperature{
	private double value;
	private char scale;
	
	Temperature(int value){
		this.value = value;
		scale = 'C';
	}
	
	Temperature(char scale){
		this.scale = scale;
		value = 0;
	}
	
	Temperature(int value, char scale){
		this.value = value;
		this.scale = scale;
	}
	
	Temperature(){
		value = 0;
		scale = 'C';
	}
	
	double getFah() {
		if(scale == 'F')
			return value;
		else 
			return  (9*(value/5) + 32);
	}
	
	
	double getCel() {
		if(scale == 'C')
			return value;
		else 
			return  5*(value-32)/9;
	}
	
	void setValue(double value){
		this.value = value;
	}
	void setScale(char scale) {
		this.scale = scale;
	}
	void setBoth(double value, char scale) {
		this.value = value;
		this.scale = scale;
	}
	double getValue(){
		return value;
	}
	
	char getScale(){
		return scale;
	}
	
}
public class Problem1 {

	public static void main(String[] args) {
		Temperature temp1 = new Temperature(30,'C');
		Temperature temp2 = new Temperature('F');
		Temperature temp3 = new Temperature(40);
		Temperature temp4= new Temperature();
		
		
		
		System.out.println("Celsius of temp2 = " + temp2.getCel());
		System.out.println("Fahrenheit of temp2 = " + temp2.getFah());

	}

}
