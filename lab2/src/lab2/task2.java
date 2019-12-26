package lab2;

class StarTriangle{
	 int width;
	

	
	StarTriangle(int width){
		this.width = width;
	}

	public String toString() {
		String s ="";
	for(int i=0;i<width;i++) {
		for(int j=0;j<width;j++) {
			
		if(i>=j)
	s+="[*]";
			}
		s+="\n";
		}
	return s;	
		
	}
}
public class task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StarTriangle st = new StarTriangle(3);
		System.out.println( st.toString() );
	}

}
