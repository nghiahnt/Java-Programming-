package javaProgramming_BasicBook;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		int i;
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter N: ");
			N = sc.nextInt();
		}
		// Find the prime number
		for (i=2; i<=Math.round(Math.sqrt(N)); i++) {
			if (N%i == 0) {
			System.out.println("N khong phai la so nguyen to " + i);
			break;
			}
			else System.out.println("N la so nguyen to");
		}
	}

}
