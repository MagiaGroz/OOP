package lab5;

interface Moveable{  // интерфейс "может ли ходить"
	boolean IsMoveable();
}
interface Runnable extends Moveable{ // интерфейс может ли бегать
	boolean CanRun();
}

class Runner implements Runnable{ // класс бегун который наследует интерфейс бег который наследует интерфейс ходьбы

	int legs;
	Runner(int legs){
	this.legs=legs;
	}
	@Override
	public boolean IsMoveable() { 
		if(this.legs==2) // если у человека две ноги он может ходить
			return true;
		return false;
	}

	@Override
	public boolean CanRun() {
		if(IsMoveable()) // если человек может ходить тогда он может и бегать
			return true;
		return false;
	}
	
}

public class Task1B {

	public static void main(String[] args) {

	}

}
