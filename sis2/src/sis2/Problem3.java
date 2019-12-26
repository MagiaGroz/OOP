package sis2;

import java.util.Date;
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



class Manager extends Employee {
	Vector<Employee> vec;
	int bonus;
	Manager(String name,double salary, Date hireDate, String insuranceNumber,int bonus, Vector<Employee> vec){
		super(name,salary,hireDate,insuranceNumber);
		this.bonus=bonus;
		this.vec=vec;
	}
	Manager(){
		
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
	
	public Object clone() {
		Manager m = new Manager();
		m.bonus=this.bonus;
		m.hireDate=(Date)hireDate.clone();
		m.insuranceNumber=this.insuranceNumber;
		m.name=this.name;
		m.salary=this.salary;
		m.vec=(Vector<Employee>) this.vec.clone();
		return m;
	}
	
	
	@Override 
	public int compareTo(Employee e){
		
		if((Manager.class).isAssignableFrom(Employee.class)) {
		Manager m = (Manager)e;
		if(this.salary==m.salary)
			return this.bonus-m.bonus;
		}
		return (int)(this.salary-e.salary);
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
			if(vec.get(i).name!=m.vec.get(i).name || vec.get(i).hireDate!=m.vec.get(i).hireDate ||
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
		Date d1 =new Date(); Date d2 =new Date(116,05,12);
		Date d3 =new Date(118,05,12); Date d4 =new Date(117,05,12);
		Employee e1 = new Employee("PlanktonD",1000, d1,"2kme12");
		Employee e2 = new Employee("PlanktonA",1000, d2,"2kme12");
		Employee e3 = new Employee("PlanktonB",1000, d3,"2kme12");
		Employee e4 = new Employee("PlanktonC",1000, d4,"2kme12");
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
	Manager m = new Manager("Top Manager Vitya",5000,new Date(2017),"ewkfowpe3", 500, v);
	System.out.println(m.toString());
	HashSet<Manager> ha = new HashSet<Manager>();
	Manager m2 = new Manager("Top Manager Vitya",5000,new Date(2017),"ewkfowpe", 500, v);
		ha.add(m);
		ha.add(m2);
	System.out.println(ha.size());
	System.out.println(m.equals(m2));
	
	System.out.println("Comparator by NAME");
	NameComparator n = new NameComparator();
	v.sort(n);
	for(int i=0;i<4;i++) {
		System.out.println(v.get(i));
	}
	System.out.println("Comparator by DATE");
	hireDateComparator l = new hireDateComparator();
	v.sort(l);
	for(int i=0;i<4;i++) {
		System.out.println(v.get(i));
	}
	}


}


