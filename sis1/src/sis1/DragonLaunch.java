package sis1;

import java.util.Scanner; 
import java.util.Vector; 


class Person{
	enum Gender {BOY , GIRL}	
	Gender gen;
	char ch;
	Person(char ch){
		this.ch = ch;
	}
	
	
}
public class DragonLaunch {
	Vector<Person> vec = new Vector<Person>();
		void kidnap(Person p) {
		vec.add(p);

	}
	
	boolean willDragonEatOrNot() {
		for(int i=0;i<vec.size();i++) {
			if(vec.get(i).ch=='B' && vec.get(i+1).ch=='G' ) {
				vec.remove(i);
				vec.remove(i);
				i=-1;
			}
			if(vec.size()==0||vec.size()==1) {
				break;
			}
		}
		if(vec.size()==0)
			return false;
		else 
			return true;
		 
			
	
	}
	public static void main(String[] args)  {
		
		String s = "BGBG";
		Person p1 = new Person(s.charAt(0));
		Person p2 = new Person(s.charAt(1));
		Person p3 = new Person(s.charAt(2));
		Person p4 = new Person(s.charAt(3));
		DragonLaunch dr1 = new DragonLaunch();
		dr1.kidnap(p1);
		dr1.kidnap(p2);
		dr1.kidnap(p3);
		dr1.kidnap(p4);
		System.out.println(dr1.willDragonEatOrNot());
 
	}

}
