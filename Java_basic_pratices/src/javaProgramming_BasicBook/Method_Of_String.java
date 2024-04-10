package javaProgramming_BasicBook;

public class Method_Of_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Write a Java program is very easily";
		
		//Count the quantity of a
		// Method charAt
		int count = 0;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == 'a') count ++;
		}
		System.out.println("Quantity of a is: " + count);
		
		// Check string if has "java"
		// Method indexOf
		int index = s.indexOf("Java");
		if (index >= 0) System.out.println("It has appear at " + index);
		else System.out.print("Null");
		
		// Check the string has start with "write"
		if (s.startsWith("Write") == true) System.out.print("Yes");
		else System.out.print("No");
		
		// EndWidth method
		if (s.endsWith("easily") == true) System.out.print("Yes");
		else System.out.print("No");
	}

}
