package sis1;
import java.util.ArrayList;
import java.util.Scanner;

import lab2.Student;

class Course{
	String name;
	String description;
	int credits;
	String prerequisite;
	Course(String name, String description, int credits, String prerequisite){
		this.name = name;
		this.description = description;
		this.credits = credits;
		this.prerequisite = prerequisite;
	}
	
	public String toString() {
		String s = name+" " + description + " number of credits = "+ credits + " prerequisits = "+prerequisite;
		return s;
	}
}

class GradeBook{
	Course crs;
	ArrayList<Student> ar;
	
	GradeBook(Course crs, ArrayList<Student> ar){
		this.crs = crs;
		this.ar = ar;
	}
	String displayMessage() {
		String s = "Welcome to the grade book for CS101 Object-oriented Programming and Design!  " +"\n" +"Please, input grades for students: ";
	return s;
	}
	
	public String toString() {
		String s = crs.toString() +"\n"+ ar.toString();
		return s;
	}
	void displayGradeReport(ArrayList<Integer> grad) {
		int best =-1;
		int lowest=101;		
		
		for(int i=0;i<grad.size();i++) {
			int loc = grad.get(i);
			if(best<loc)
				best = loc;
			if(lowest>loc)
				lowest= loc;	
		}
		
		determineClassAverage(grad);
		System.out.println("Lowest grade is " +lowest+" "+ ar.get(grad.indexOf(lowest) )  );
		System.out.println("Highest grade is " +best+" "+ ar.get(grad.indexOf(best) )  );
		
	}
	
	void determineClassAverage(ArrayList<Integer> grad) {
		double av = 0;
		for(int i=0;i<grad.size();i++) {
			av+=grad.get(i)	;	
		}
		av=av/grad.size();
		System.out.println("Class average is " +av+" ."  );

	}
	
	
	
	public void outputBarChart(ArrayList<Integer> grad) {
		
		String[] bar = new String[20];
		
		int lim =10;
		
		for(int i=0;i<grad.size();i++) {
			int g = grad.get(i);
			for(int j=1;j<12;j++) {
				
				if(lim*j-11 < g&&g<lim*j) {
					if(bar[j]!=null) {
						bar[j]+="*";
					}
					else
					bar[j]="*";
				}
				
			}
			
		}
		
		for(int j=1;j<12;j++) {
			if(bar[j]==null)
				bar[j]="";
			if(lim*j==110) 
				System.out.println((lim*j-10)+": "+bar[j] );
			
			else
			System.out.println((lim*j-10)+"-"+(lim*j-1)+": "+bar[j] );
		}
		
	}
}

public class GradeBookTest {

	public static void main(String[] args) {
	
		Course crs = new Course("Object-oriented Programming and Design",
								"Major subject for Software Engineer",
								3,"PP1, PP2");

		Student s1 = new Student("Student A",1);
		Student s2= new Student("Student B",2);
		Student s3= new Student("Student C",3);
		Student s4= new Student("Student D",4);
		Student s5= new Student("Student E",5);
		
		ArrayList<Student> ar = new ArrayList<Student>();
		ar.add(s1);
		ar.add(s2);
		ar.add(s3);
		ar.add(s4);
		ar.add(s5);
		
		ArrayList<Integer> grad = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		GradeBook gb = new GradeBook(crs , ar);	
		System.out.println(gb.displayMessage());
		
		int i=1;
	while(i!=6) {
		if(i==1)
		System.out.print(s1.name + " : ");
		if(i==2)
			System.out.print(s2.name+ " : ");
		if(i==3)
			System.out.print(s3.name+ " : ");
		if(i==4)
			System.out.print(s4.name+ " : ");	
		if(i==5)
			System.out.print(s5.name+ " : ");	
		int g = scan.nextInt();
		grad.add(g);
		i++;
	}
	scan.close();
	gb.displayGradeReport(grad);
	gb.outputBarChart(grad);
	
	}

}
