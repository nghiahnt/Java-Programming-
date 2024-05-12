package Basics_Algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class ManipulateData_Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		numbers.add(4);
		numbers.add(5);
		numbers.add(1);
		numbers.add(3);

		System.out.println("Unsorted arraylist: " + numbers);
		
		// Using reverse() method
		Collections.reverse(numbers);
		System.out.println("Reversed arraylist: " + numbers);
		
		// Using swap to swaps position of two element in a colllection
		Collections.swap(numbers, 0, 1);
		System.out.println("Using swap: " + numbers);
		
		// Using AddAll 
		ArrayList<Integer> newNumbers = new ArrayList<Integer>();
		newNumbers.addAll(numbers);
		System.out.println("Using allAll to newNumbers: " + newNumbers);
		
		// Using fill
		Collections.fill(numbers, 0);
		System.out.println("Using fill() method: " + numbers);
		
		// Using copy
		Collections.copy(newNumbers, numbers);
		System.out.println("Using copy method to copy to newNumbers: " + newNumbers);
 	}

}
