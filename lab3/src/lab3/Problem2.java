package lab3;

abstract class Shape{
	
	abstract double volume();
	abstract double surfaceArea();
	abstract double diameter();
}

class Cylinder extends Shape{
	int h;
	int r;
	Cylinder(int h, int r){
		this.h=h;
		this.r=r;
	}
	double volume() {
		double vol = 3.14*r*r*h;
		return vol;
	}
	double surfaceArea() {
		double area=2*3.14*r*(r+h);
		return area;
	}
	double diameter() {
		double d=Math.sqrt((4*volume())/(h*3.14));
		return d;
	}
	
}
class Sphere extends Shape{
    int h;
	int r;
	Sphere(int h, int r){
		this.h=h;
		this.r=r;
	}
	double volume() {
		double vol = (4/3)*3.14*r*r*r;
		return vol;
	}
	double surfaceArea() {
		double area=4*3.14*r*r;
		return area;
	}
	double diameter() {
		double d=2*r;
		return d;
	}
}

class Cube extends Shape{
	int a;
	Cube(int a){
		this.a=a;
		
	}
	double volume() {
		double vol = a*a*a;
		return vol;
	}
	double surfaceArea() {
		double area=6*a*a;
		return area;
	}
	double diameter() {
		double d=Math.sqrt(3)*a;
		return d;
	}
}
public class Problem2 {

	public static void main(String[] args) {
		Cylinder c = new Cylinder(4,8);
		Cylinder k;
		Cube c2 = new Cube(5);
		Sphere c3 = new Sphere(7,8);
		System.out.println("Surface Area of cylinder = " + c.surfaceArea());
		System.out.println("Surface Area of cube = " + c2.surfaceArea());
		System.out.println("Surface Area of sphere = " + c3.surfaceArea());
		System.out.println("Volume of cylinder = " + c.volume());
		System.out.println("Volume of cube = " + c2.volume());
		System.out.println("Volume of sphere = " + c3.volume());

	}

}
