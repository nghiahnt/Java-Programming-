package javaProgramming_BasicBook;

public class Point2D {
	private float x, y;
	
	// Default define function
	public Point2D() {
		this.x = 0;
		this.y = 0;
	}
	
	// Function to initialize two attributes
	public Point2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(float dx, float dy) {
		x += dx;
		y += dy;
	}
	
	public void display() {
		System.out.println("("+x+","+y+")");
	}
	
	// Argument is an object
	public double distance(Point2D A) {
		System.out.print(this.x +";"+ this.y +"\n");
		return Math.sqrt(Math.pow(this.x - A.x, 2) + Math.pow(this.y - A.y, 2));
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point2D A, B;
		A = new Point2D(3, 4);
		B = new Point2D(6, 7);
		
		System.out.print("A co toa do la: "); A.display();
		System.out.print("B co toa do la: "); B.display();
		
		// Move
		A.move(4, 2);
		System.out.print("Toa do moi cua A la: "); A.display();
		
		double distanceAB = A.distance(B);
		System.out.println("Khoang cach tu A den B la: " + distanceAB);
	}

}
