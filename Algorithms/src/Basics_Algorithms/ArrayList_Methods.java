package Basics_Algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(4);
		numbers.add(5);
		numbers.add(1);
		numbers.add(3);
		
		System.out.println("Unsorted arraylist: " + numbers);
		
		// Using sort method
		Collections.sort(numbers);
		System.out.println("Sorted arraylist: " + numbers);
		
		// Using stuffle to destroy order present
		Collections.shuffle(numbers);
		System.out.println("Arraylist using shuffle " + numbers);
	}

}
