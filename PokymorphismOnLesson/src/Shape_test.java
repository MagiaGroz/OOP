import java.util.Vector;

public class Shape_test {

	public static void main(String[] args) {
		
		Vector<Shape> v = new Vector<Shape>();
		v.add( new Circle(1,Color.BLACK));
		v.add(new Square(2,Color.BLACK));
		v.add( new Circle(3,Color.RED));
		v.add( new Square(4,Color.RED));
		for(int i=0;i<4;i++) {
			if(v.get(i) instanceof Circle) {
				Circle l = (Circle)v.get(i);
			System.out.println(l.r);
				l.draw();
			}
			else if(v.get(i) instanceof Square) {
				Square k = (Square)v.get(i);
				k.draw();
			}
		}
	

		
		
	}

}
