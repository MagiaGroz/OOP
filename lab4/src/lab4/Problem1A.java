package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map.Entry;

public class Problem1A {

	private static void writeUsingFiles(String data) {
        try {
            Files.write(Paths.get("C:\\Users\\User\\eclipse-workspace\\lab4\\src\\grades.txt"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader;
			reader = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspace\\lab4\\src\\scores.txt"));
        String line;
     
        HashMap<String, Integer> mp = new HashMap<>();
        while ((line = reader.readLine()) != null) {
        
        	String k="";
        	String ka = "";
        	int i =0;
        	
        	while(i!=3) {
        		if(line.charAt(line.length()-3+i)!=' ') {
        			k +=  line.charAt(line.length()-3+i);
        		}
        		i++;
        	}
        	 i=0;
        	while(line.charAt(i)>64 || line.charAt(i)==32) {
        		ka+=line.charAt(i);
        		i++;
        	}
        	int l = Integer.parseInt(k);
        	mp.put(ka,l);
        	
        	
        }
        reader.close();
        int best=0;
        for (Entry<String, Integer> entry: mp.entrySet()) { 
        	Integer value = entry.getValue(); 
        	if(value>best)
        		best=value;
        	}
        
        String data="";
        for (Entry<String, Integer> entry: mp.entrySet()) { 
        	String key = entry.getKey();
        	Integer value = entry.getValue(); 
        	if(value>=best-10) {
        		data+=key+"- \"A\" "+"\n";
        	}
        	else if(value>=best-20) {
        		data+=key+"- \"B\" "+"\n";
        	}
        	else if(value>=best-30) {
        		data+=key+"- \"C\" "+"\n";
        	}
        	else if(value>=best-40) {
        		data+=key+"- \"D\" "+"\n";
        	}
        	else {
        		data+=key+"- \"F\" "+"\n";
        	}
        	
        	}
        writeUsingFiles(data);
	}

}
