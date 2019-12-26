package lab5;

interface Moveable{  // ��������� "����� �� ������"
	boolean IsMoveable();
}
interface Runnable extends Moveable{ // ��������� ����� �� ������
	boolean CanRun();
}

class Runner implements Runnable{ // ����� ����� ������� ��������� ��������� ��� ������� ��������� ��������� ������

	int legs;
	Runner(int legs){
	this.legs=legs;
	}
	@Override
	public boolean IsMoveable() { 
		if(this.legs==2) // ���� � �������� ��� ���� �� ����� ������
			return true;
		return false;
	}

	@Override
	public boolean CanRun() {
		if(IsMoveable()) // ���� ������� ����� ������ ����� �� ����� � ������
			return true;
		return false;
	}
	
}

public class Task1B {

	public static void main(String[] args) {

	}

}
