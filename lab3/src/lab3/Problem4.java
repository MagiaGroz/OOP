package lab3;

abstract class Piece{
	abstract boolean isLegalMove(Position a, Position b);
}

class Position{
	char x;
	int y;
	Position(char x, int y){
		this.x=x;
		this.y=y;
	}
		
}

class Rock extends Piece{

	@Override
	boolean isLegalMove(Position a, Position b) {
		if(a.x==b.x ||a.y==b.y)
		return true;
		return false;
	}	
}
class King extends Piece{
	@Override
	boolean isLegalMove(Position a, Position b) {
		
		
		if(Math.abs((int)a.x-(int)b.x)>1 || Math.abs(a.y-b.y)>1)
			return false;
		
		return true;
	}

	
}
class Pawn extends Piece{
	@Override
	boolean isLegalMove(Position a, Position b) {
		
		
		if(a.x==a.y && b.y+1==a.y)
			return true;
		
		return false;
	}
}

class Elephant extends Piece{
	@Override
	boolean isLegalMove(Position a, Position b) {
		
		
		if(Math.abs(b.x-a.x)==Math.abs(b.y-a.y))
			return true;
		
		return false;
	}
}
public class Problem4 {

	public static void main(String[] args) {
		Position a = new Position('a',2);
		Position b = new Position('c',4);
		Position c = new Position('h',7);
		Elephant e = new Elephant();
		System.out.println(e.isLegalMove(a,b));
		Pawn p = new Pawn();
		System.out.println(p.isLegalMove(c,b));
		Rock r = new Rock();
		System.out.println(r.isLegalMove(a,c));
		King k = new King();
		System.out.println(k.isLegalMove(b,a));

	}

}
