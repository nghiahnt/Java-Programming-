package javaProgramming_BasicBook;

import java.util.Scanner;

public class CommonDivisor {
	
	// Define function 
	public static int comDiv(int a, int b) {
		return (b==0)?a:comDiv(b, a%b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		int b;
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter A: ");
			a = sc.nextInt();
			System.out.print("Enter B: ");
			b = sc.nextInt();
		}
		
		System.out.println("Comdiv of " + a + " and " + b + " is: " + comDiv(a, b));		
	}

}
