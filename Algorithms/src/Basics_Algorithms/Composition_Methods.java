package Basics_Algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class Composition_Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(2);
		numbers.add(3);

		System.out.println("Unsorted arraylist: " + numbers);
		
		// Using frequency method to count the appear of itself
		int count = Collections.frequency(numbers, 3);
		System.out.println("The count of 3 is: " + count);
		
		ArrayList<Integer> newValues = new ArrayList<Integer>();
		newValues.add(1);
		newValues.add(6);
		System.out.println("Arraylist 2 is: " + newValues);
		
		// Using disjoint method, disjoint method used to check if 2 collections contain some 
		// common element. Return true if don't have
		boolean value = Collections.disjoint(numbers, newValues);
		System.out.println("Two list are disjoint: " + value);
	}

}
