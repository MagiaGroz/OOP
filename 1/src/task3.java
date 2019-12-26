import java.util.Scanner;
public class task3 {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int grade = scan.nextInt();
		if(grade>94) {
			System.out.println("A");
		}
		
		else if(grade>89) {
			System.out.println("-A");
		}
	
		else if(grade>84) {
			System.out.println("B+");
		}
	
		else if(grade>79) {
			System.out.println("B");
		}
		else if(grade>74) {
			System.out.println("-B");
		}
		else if(grade>69) {
			System.out.println("c+");
		}
		else if(grade>64) {
			System.out.println("C");
		}
		else if(grade>59) {
			System.out.println("-C");
		}
		else if(grade>55) {
			System.out.println("D");
		}
		else if(grade>=50) {
			System.out.println("D-");
		}
	
	}
	


}
