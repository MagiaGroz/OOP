package lab5;

abstract class Animal{
	int eyes;
	abstract void sound();
	abstract void eat();
}


class Cat extends Animal{
	
	void sound() {
		System.out.println("Meow!");
	}
	
	void eat() {
		System.out.println("I eat only whiskas");
	}

}

class Dog extends Animal{	
	void sound() {
	System.out.println("Woof!");
}

void eat() {
	System.out.println("I eat only meat");
}

}

interface Eatable{
	void IsEatable();
}

class Pizza implements Eatable{
	 public void IsEatable() {
		System.out.println("yes");
	}
}

class Sheep implements Eatable{
	 public void IsEatable() {
		System.out.println("yes");
	}
}

class Wood implements Eatable{
	public void IsEatable() {
		System.out.println("No");
	}
}

public class Task1A {

	public static void main(String[] args) {
		

	}

}
