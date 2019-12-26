package lab3;

import java.util.HashSet;
import java.util.Vector;

class Person{ // extends Object
	protected String name;
	public Person(String name){
		this.name = name;
	}
	Person(){
		name="default";
	}
	String getName(){
		return name;
	}
	void setName(String name) { // setter
		this.name=name;
	}
	@Override  //знак перезаписывания
	public String toString() {                // method of Object
		String s = name;
		return s;
	}
	@Override
	public int hashCode() {   // коллизия может быть при легком алгоритме
		final int prime = 31;
		int result = 1;
		result = prime * result + name.length();
		return result;
	}
	@Override
	public boolean equals(Object obj) { // сравнение 
		if(this==obj) { // this = object of this class
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(obj.getClass()!=Person.class) {
			return false;
		}
		
		Person p = (Person)obj; // typecasting 
		
		if(p.name!=name)
			return false;
		
		return true;
	}
}



class Manager extends Employee{
	Vector<Employee> vec;
	int bonus;
	Manager(String name,double salary, int year, String insuranceNumber,int bonus, Vector<Employee> vec){
		super(name,salary,year,insuranceNumber);
		this.bonus=bonus;
		this.vec=vec;
	}
	int getBonus(){
		return bonus;
	}
	void setbonus(int bonus) {
		this.bonus=bonus;
	}
	Vector<Employee> getTeam() {
		return vec;
	}
	@Override
	public String toString() {
		String s = super.toString() + " bonus = " + bonus +"\n";
		for(int i=0;i<vec.size();i++) {
			s+=vec.get(i).toString()+"\n";
		}
		return s;
	}
	@Override
	public int hashCode() {
		int result;
		final int prime = 31;
		result=super.hashCode();
		result=prime*result + bonus;
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
		if(obj.getClass()!=Manager.class) {
			return false;
		}
		
		Manager m = (Manager)obj;
		if(vec.size()!=m.vec.size())
			return false;
		
		for(int i=0;i<vec.size();i++) {
			if(vec.get(i).name!=m.vec.get(i).name || vec.get(i).year!=m.vec.get(i).year ||
					vec.get(i).insuranceNumber!=m.vec.get(i).insuranceNumber ||
					vec.get(i).salary!=m.vec.get(i).salary)
				return false;
		}
		if(bonus!=m.bonus)
			return false;
		
		return true;
}
}
public class Problem3 {

	public static void main(String[] args) {
		Employee e1 = new Employee("Plankton",1000, 2019,"2kme12");
		Employee e2 = new Employee("Plankton",1000, 2018,"2kme12");
		Employee e3 = new Employee("Plankton",1000, 2018,"2kme12");
		Employee e4 = new Employee("Plankton",1000, 2019,"2kme12");
HashSet<Employee> h = new HashSet<Employee>();
h.add(e1);
h.add(e2);
h.add(e3);
h.add(e4);
System.out.println("size = " + h.size());

Vector<Employee> v = new Vector<Employee>();
v.add(e1);
v.add(e2);
v.add(e3);
v.add(e4);
Manager m = new Manager("Top Manager Vitya",5000,2017,"ewkfowpe3", 50, v);
System.out.println(m.toString());
HashSet<Manager> ha = new HashSet<Manager>();
Manager m2 = new Manager("Top Manager Vitya",5000,2017,"ewkfowpe", 500, v);
ha.add(m);
ha.add(m2);
System.out.println(ha.size());
System.out.println(m.equals(m2));
	}

}
