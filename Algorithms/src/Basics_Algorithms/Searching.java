package Basics_Algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class Searching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		numbers.add(4);
		numbers.add(5);
		numbers.add(1);
		numbers.add(3);

		System.out.println("Unsorted arraylist: " + numbers);
		
		// Using binary search
		int pos = Collections.binarySearch(numbers, 3);
		System.out.println("The position of 3 is " + pos);
	}

}
