package javaProgramming_BasicBook;

import java.util.Arrays;

public class Sort_AreaRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double randomWidth = 0, randomHeight = 0;
		Rectangle01[] vec = new Rectangle01[10];
		
		for (int i=0; i<vec.length; i++) {
			// Create random number
			randomWidth = 100 * Math.random();
			randomHeight = 100 * Math.random();
			
			vec[i] = new Rectangle01(randomWidth, randomHeight);
		}
		
		// Sort by area
		Arrays.sort(vec);
		
		// Display result
		for (int i=0; i<vec.length; i++) {
			System.out.println("Dien tich HCN " + i + " = " + Math.round(vec[i].area()));
		}
	}

}

abstract class Shape01 {
	abstract double area();
	public String toString() {
		return "area = " + area();
	}
}

class Rectangle01 extends Shape01 implements Comparable<Rectangle01> {
	double width;
	double height;
	
	public Rectangle01(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double area() {
		return width * height;
	}
	
	@Override
	public int compareTo(Rectangle01 other) {
		return Double.compare(this.area(), other.area());
	}
}