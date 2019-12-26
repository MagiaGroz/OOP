package lab3;

class Animal{
	int ras;
	int eyes;
	Animal(int ras){
		this.ras = ras;
	}
	Animal(){
		ras=0;
		eyes=2;
	}
	
	void jump() {
		System.out.println("I jumped "+ras+"metres");
	}
	
	void eat() {
		System.out.println("Eating meat");
	}
}

class Cat extends Animal{
	int foots;
	String name;
	Cat(int ras, String name){
		super(ras);
		this.name = name;
		
	}
	{
		foots=4;
		name = "DefaultCat";
	}
	Cat(){
		super();
	}
	
	public String toString() {
		
		String s= "name "+name+" foots = "+foots;
		return s;
	}
	void eat() {
		System.out.println("Eating whiskas");
	}
	
	
}
public class Problem1 {
	public static void main(String[] args) {
	Cat c1 = new Cat(4,"Murka");
	Cat c2= new Cat();
	c1.eat();
	c2.jump();
	System.out.println(c1.toString());
	System.out.println(c2.toString());
	Animal a = new Animal(3);
	a.jump();
	a.eat();
	}
}
