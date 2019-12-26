package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Problem1B {

	private static void writeUsingFiles(String data) {
        try {
            Files.write(Paths.get("C:\\Users\\User\\eclipse-workspace\\lab4\\src\\grades.txt"), data.getBytes(),StandardOpenOption.APPEND);
       } catch (IOException e) {
            e.printStackTrace();
        }
    } 
	 

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader;
			reader = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspace\\lab4\\src\\scores.txt"));
        String line;
     
        List<Integer> lt = new ArrayList<Integer>();
        while ((line = reader.readLine()) != null) {
        
        	String k="";
        	int i =0;
        	while(i!=3) {
        		if(line.charAt(line.length()-3+i)!=' ') {
        			k +=  line.charAt(line.length()-3+i);
        		}
        		i++;
        	}
        	int l = Integer.parseInt(k);
        	lt.add(l);   	
        }
        reader.close();
        
        int best=0;
        int min = 100000;
        int average =0;
        for (int i=0;i<lt.size();i++) { 
        	
        	if(lt.get(i)>best)
        		best=lt.get(i);
        	else if(min>lt.get(i))
        		min=lt.get(i);
        	average=(average+lt.get(i))/2;
        	}
        
        String data= "\n"+"Average - "+average +"\n"+ "Maximum - "+best+"\n"+"Minimum - "+min;
       
        writeUsingFiles(data);
	}

}
