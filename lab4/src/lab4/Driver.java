package lab4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Driver implements Serializable{

	private static final long serialVersionUID = -1370760535308341490L;

	private static void writeUsingFiles(String data) {  // ������ � ����
        try {
            Files.write(Paths.get("C:\\Users\\User\\eclipse-workspace\\lab4\\src\\admin.txt"), data.getBytes(),StandardOpenOption.APPEND); //Append ������������� ������
       } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	static int hash(String a) {
		return a.charAt(0)+a.length();  // ������� ��� �������� , ���������� ����� ������� ������� ����� � ����� �����
	}
	
	@SuppressWarnings("deprecation") // ���������� ��������� ����������
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Date date = new Date(); // ������ ������ ����
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // ������ ��� ������ � �������	
		
		List<Course> crs = new ArrayList<Course>(); // ���� ������ ������� ����� ��������� ������������
		
		main:while(true) { 
			
		System.out.println("Choose user or admin mode");
			
		String consol= reader.readLine();
		if(consol.contentEquals("admin")) {
			
			BufferedReader readerofadmintxt = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspace\\lab4\\src\\admin.txt"));
        String line;  // ������� ����� ����� ��� ���������� ������ � ������ � �����
        
        System.out.println("Enter your username:");
        
        if((line = readerofadmintxt.readLine()) != null) {
        	String[] username= line.split(" "); // ���������� ����� ����� ��� ��������� ����� �� �����
        	
        	if(username[1].contains(reader.readLine())) { // ���� ��������� ������� ����� ����� ������ � ����� ���� ������
        		
        		System.out.println("Enter your password:");
    			
    			line = readerofadmintxt.readLine();
    		
    			String[] password = line.split(" ");
    			int hashPassword = hash(reader.readLine() ); //�������� ������ ������� ���� ������������
    		
    			if(!password[1].contains( String.valueOf(hashPassword))) {  // ���� ������ � ����� �� ����� ������ ���������� ������������� ����� ���� � ������
    				System.out.println("Invalid password, try again");
            		continue main; //����������� � ��������� main
    			}
        	}
        	else {
        		System.out.println("Invalid username, try again");
        		continue main; // ����������� � ��������� main
        	}
        	
        }
        	readerofadmintxt.close(); //��������� ����� ������� ������ ����� � ������
			
			writeUsingFiles(date.toGMTString()+" admin logged in to a system"+"\r\n");
			//continue main;
			boolean OneMore = true;
			while(OneMore) {
			System.out.println("Enter title of new course"); //�������� ��������� � ������� ������ �����
			String title = reader.readLine();
			System.out.println("Enter isbn of textbook of new course");
			int isbn = Integer.parseInt(reader.readLine());
			System.out.println("Enter title of textbook of new course");
			String titlebook = reader.readLine();
			System.out.println("Enter author of textbook of new course");
			String author = reader.readLine();
			System.out.println("Enter first name of instructor of new course");
			String fname = reader.readLine();
			System.out.println("Enter last name of instructor of new course");
			String lname = reader.readLine();
			System.out.println("Enter department of instructor of new course");
			String department = reader.readLine();
			System.out.println("Enter email of instructor of new course");
			String email = reader.readLine();
			crs.add(new Course(title,isbn,titlebook,author,fname,lname,department,email));
			
			writeUsingFiles(date.toGMTString()+" admin added new course " + "\""+title+"\""+"\r\n"); 
			// ��������� ������� ���� � ���������� � ���� �����.���
			writeUsingFiles(date.toGMTString()+" admin added new textbook " + "\""+titlebook+"\""+"\r\n");
			writeUsingFiles(date.toGMTString()+" admin added new instructor" + "\""+fname+lname+"\""+"\r\n");
			
			System.out.println("New course added! Do you want add one more?");
			String IsMore = reader.readLine();
			if(IsMore.contains("no")) {
				OneMore=false;
				reader.close();
			}
			}
			
			FileOutputStream outputStream = new FileOutputStream("C:\\Users\\User\\eclipse-workspace\\lab4\\src\\save.ser");
		       ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

		       objectOutputStream.writeObject(crs); //������������ ����� ������ � ����
		       objectOutputStream.flush(); // ������� ������ ����� ���������
		       objectOutputStream.close(); //�������� ������
		      
		       writeUsingFiles(date.toGMTString()+" Lists of courses serialized by admin" +"\r\n"); // ��������� ���������� ��� ���� �������� � ���� �����.���
		       break main; // ��������� ���������
		}
		else {
			List<Course> curs= new ArrayList<>();
	         
	        try
	        { //�������� ��������������
	            FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\lab4\\src\\save.ser");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	          
	            curs = (ArrayList<Course>)ois.readObject(); // typecasting ������� � Arraylist
	           
	            ois.close(); //��������� ������
	           
	            fis.close();
	            writeUsingFiles(date.toGMTString()+" Lists of courses deserialized by admin" +"\r\n"); 
	            System.out.println("Do you want see List of courses or see information about one of courses");
	            if(reader.readLine().contains("List")) { //������� ����� ���� ������ � �����
	            	for(int i=0;i<curs.size();i++) {
	            		System.out.println((i+1)+") "+curs.get(i).getCourseTitle());
	            	}
	            	System.out.println("Do you want see more information about any of these courses?");
	            	if(reader.readLine().contains("yes")) {
	            		System.out.println("Which course?");
		            	int k = Integer.parseInt(reader.readLine());
		            	System.out.println(curs.get(k-1).toString()); //������� ��� ���������� �� ����� �����
		            	
	            	}
	            }
	            else if(reader.readLine().contains("information")) {
	            	System.out.println("Which course?");
	            	int k = Integer.parseInt(reader.readLine());
	            	System.out.println(curs.get(k-1).toString()); //������� ��� ���������� �� ����� �����
	            	
	            }
	            
	        } 
	        catch (IOException ioe) // ����� ��������� ������ �����
	        {
	            ioe.printStackTrace();
	           
	        } 
	        catch (ClassNotFoundException c)  // ����� ��������� ������ � ������ �������
	        {
	            System.out.println("Class not found");
	            c.printStackTrace();
	        }
	        reader.close();  //�������� ������ 
        	break main;
			
		}

	}
	}
}
