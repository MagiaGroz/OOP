import java.util.Scanner;
public class task6 {
	static boolean isPal(String name) {
		boolean IsPal=true;
		
		for(int i=0;i<name.length()/2;i++) 
			if(name.charAt(i)!=name.charAt(name.length()-1-i)) {
				return false;
			}
		 
			
			return true;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();

	
	if(isPal(name)) {
		System.out.println("YES");
	}
	else {
		System.out.println("NO");
	}
	}
	

}