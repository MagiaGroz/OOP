import java.util.Scanner;
public class task4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		double dis =b*b - 4*a*c;
		if(dis<0) {
			System.out.println("ERROR D IS NEGATIVE");
			
		}
		else if(dis==0) {
			System.out.println(-b/(2*a));
		}
		else {
			System.out.println("x1="+( (-b+Math.sqrt(dis) )/(2*a)));
			System.out.println("x2="+( (-b-Math.sqrt(dis) )/(2*a)));
		}
		
	}
	

}