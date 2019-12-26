package problem4;


public class Chocolate implements Comparable<Chocolate> {
	double weight;
	String name;
	Chocolate(double weight, String name){
		this.weight=weight;
		this.name=name;
	}
	
	public String toString() {
		return "weight: "+weight+"name: "+name;
	}

	@Override
	public int compareTo(Chocolate o) {
//		if(weight>o.weight)
//			return 1;
//		if(weight==o.weight)
//			return 0;
//		else 
//			return -1;
		
		return (int)(weight-o.weight);
	}
	
}
