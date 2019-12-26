package lab2;

import java.util.Scanner;

class Data{
	double largest;
	double average;
	int data;
	
	Data(){
		data=0;
	}
	int counter=0;
	void add(int data){
		average+=data;
		counter++;
	
		this.data = data;	
		if(data>largest)
				largest=data;
		
	}
	
	double averag() {
		average = average/counter;
		return average; 
	}
	
	double larges() {
		return largest;
	}
	
}

public class Analyzer {
	public static void main(String[] args) {
		Data newdata = new Data();
		System.out.print("Enter number(Q to quit):");
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()==true) {
			
		System.out.print("Enter number(Q to quit):");
		if(scan.hasNextInt()==true) 
		{
		int ch =scan.nextInt();
		newdata.add(ch);
		}
		else {
			String s = scan.next();
			if(s.contentEquals("Q"))
				break;
		}
									}
		

		System.out.println("average is = " + newdata.averag());
		System.out.println("largest is = " + newdata.larges());
		
		scan.close();
	
		
	}
}
