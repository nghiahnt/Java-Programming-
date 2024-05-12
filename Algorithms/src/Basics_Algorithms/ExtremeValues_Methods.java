package Basics_Algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class ExtremeValues_Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		numbers.add(4);
		numbers.add(5);
		numbers.add(1);
		numbers.add(3);

		System.out.println("Unsorted arraylist: " + numbers);
		
		// Using min()
		int min = Collections.min(numbers);
		System.out.println("Minimum element is: " + min);
		
		// Using max()
		int max = Collections.max(numbers);
		System.out.println("Maximum element is: " + max);
	}

}
