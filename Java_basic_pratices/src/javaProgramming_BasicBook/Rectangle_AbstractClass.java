package javaProgramming_BasicBook;

public class Rectangle_AbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] vec = {
				new Circle(3), new Rectangle(4, 5), new Circle(4), new Circle(8)
		};
		
		for (Shape s : vec) {
			System.out.println(s);
		}
	}

}

abstract class Shape {
	public abstract double area();
	
	// toString method is called automatically by JVM - Override function
	// Used to display the objects in array (convert object to string)
	public String toString() {
		return "Dien tich la " + area();
	}
}

class Rectangle extends Shape {
	private double width, height;
	
	public Rectangle(double wVal, double hVal) {
		width = wVal;
		height = hVal;
	}
	
	public double area() {
		return width*height;
	}
}

class Circle extends Shape {
	private double radius;
	
	public Circle(double cVal) {
		radius = cVal;
	}
	
	public double area() {
		return Math.PI * radius * radius;
	}
}
