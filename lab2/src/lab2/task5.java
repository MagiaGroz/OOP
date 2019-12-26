package lab2;

class Animals {
	int eyes;
	
	 enum Move{
		 FLY, WALK // animal can walk or fly
	 }
	 
	static final int head = 1; //all animals have 1 head and we sholdn't change it
	 {
		eyes=2; //initialization block
	}
	private int foots;		//read only
	private String name;  //read only
	 
	 
	 Animals(int foots, String name){  //constructor
		 this.foots = foots;
		 this.name = name;
	 }
	 
	public int getFoots() {     	//for read only variable
		return foots;
	}
	
	public String getName() {	    //for read only variable
		return name;
	}
	
	 
	 public String getInfo() {
		 String s = "This animal " + name +" have " +foots+" foots and number of his"+" eyes = "+eyes +"\n" + "head = " +head;
		 return s;
	 }
	
	

	public String getinfo(int a) {
		String g = "You have " + a+" "+name+" animals";
		 return g;
	}

	 
	 
}

public class task5 {

	public static void main(String[] args) {
		Animals dog = new Animals(4,"Layka");
		System.out.println(dog.getInfo());
		System.out.println( dog.getinfo(12) );
		
		Animals tarantul = new Animals(8,"ZhgiDom");
		System.out.println("Foots of " +tarantul.getName()+" equal to "+tarantul.getFoots());
	

	}

}
