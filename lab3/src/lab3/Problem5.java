package lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Problem5 {

	public static void main(String[] args) throws IOException {
		Vector<Person5> v = new Vector<Person5>();
		System.out.println("Print add , info or end ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			String origin = reader.readLine();
		if(origin.contentEquals("add")) {
			System.out.println("For adding Person print 1 for Student 2 for Employee 3");
			String nam = reader.readLine();
			if(nam.contentEquals("1")) {
				Person5 p = new Person5();
				System.out.println("Name: ");
				String name = reader.readLine();
				p.name=name;
				System.out.println("Address: ");
				String address = reader.readLine();
				p.address=address;
				v.add(p);
			}
			else if(nam.contentEquals("2")) {
				Student s = new Student();
				System.out.println("Name: ");
				String name = reader.readLine();
				s.name=name;
				System.out.println("Address: ");
				String address = reader.readLine();
				s.address=address;
				System.out.println("Program: ");
				String program = reader.readLine();
				s.program=program;
				System.out.println("fee: ");
				String fee = reader.readLine();
				s.fee=Double.parseDouble(fee);
				System.out.println("Year of study: ");
				int year = reader.read();
				s.year=year-48;
				v.add(s);
			}
			else if(nam.contentEquals("3")) {
				Staff s = new Staff();
				System.out.println("Name: ");
				String name = reader.readLine();
				s.name=name;
				System.out.println("Address: ");
				String address = reader.readLine();
				s.address=address;
				System.out.println("School: ");
				String school = reader.readLine();
				s.school=school;
				System.out.println("Pay: ");
				String pay = reader.readLine();
				s.pay=Double.parseDouble(pay);
				v.add(s);
				
			}
			
			
		}
		else if(origin.contentEquals("info")) {
			for(int j=0;j<v.size();j++) {
				System.out.println(v.get(j).toString());
			}
		}
		else if(origin.contentEquals("end")) {
			break;
		}
		
		
		}

	}

}
