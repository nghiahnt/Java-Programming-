package Basics_Algorithms;

import java.util.Scanner;

public class ConvertToBinary {
	
	@SuppressWarnings("unused")
	public static String convert(int number) {
		StringBuilder binary = new StringBuilder();
		if (number == 0) {
			return "0";
		}
		while (number > 0) {
			int bit = number % 2;
			binary.insert(0, bit);
			 number /= 2;
		}
		return binary.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number to convert: ");
		int number = input.nextInt();
		System.out.println("The number after convert is: " + convert(number));
	}

}
