import java.util.Scanner;
public class task2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		box(name.length());
		System.out.println("|"+name+"|");
		box(name.length());
	}
	
public static void box(int size) {
		System.out.print("+");
		for(int i=0;i<size;i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}
}
