package multiThread_Daily_Exercises;

import java.util.Scanner;

class inputNumber extends Thread {
	float a;
	float b;
	Scanner sc = new Scanner(System.in);
	
	public void run() {
		System.out.println("Enter the length of the rectangle: ");
		a = sc.nextFloat();
		System.out.println("Enter the width of the rectangle: ");
		b = sc.nextFloat();
	}
}

class acreage extends Thread {
	float a, b;
	float result;
	
	public acreage(float lenght, float width) {
		this.a = lenght;
		this.b = width;
	}
	
	public void run() {
		result = a * b;
	}
	
	public float getResult() {
		return result;
	}
}

class primeter extends Thread {
	float a, b;
	float result;
	
	public primeter(float lenght, float width) {
		this.a = lenght;
		this.b = width;
	}
	
	public void run() {
		result = (a+b)/2;
	}
	
	public float getResult() {
		return result;
	}
}

public class ThreeThread_SolveRectangle {
	
	// Create three threads
	inputNumber thread1 = new inputNumber();
	acreage thread2;
	primeter thread3;
	
	public ThreeThread_SolveRectangle() {
		thread1.start();
		try {
			thread1.join();
			float length = thread1.a;
			float width = thread1.b;
			
			thread2 = new acreage(length, width);
	        thread3 = new primeter(length, width);
	        
	        thread2.start();
	        thread3.start();

	        // Wait for thread2 and thread3 to finish (optional)
	        thread2.join();
	        thread3.join();
	        
	        System.out.println("The acreage of the rectangle is: " + thread2.getResult());
	        System.out.println("The perimeter of the rectangle is: " + thread3.getResult());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreeThread_SolveRectangle();
	}

}
