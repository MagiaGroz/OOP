
abstract class Shape  {
 int space;
Color color;


public Shape(int space, Color color)
{
	this.space = space;
	this.color = color;
	
	
}

abstract void draw();

final void move() {
	for(int i=0;i<space;i++) {
		System.out.print(" ");
	}
	
};
}


