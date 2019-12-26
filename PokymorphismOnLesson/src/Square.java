
public class Square extends Shape  {

	Square(int space, Color color) {
		super(space,color);
		
	}
void draw() {
	super.move();
	
	if(color == Color.BLACK) {
		System.out.println("[]");
	}
	
	else {
		System.err.println("[]");
	}
}


	
}
