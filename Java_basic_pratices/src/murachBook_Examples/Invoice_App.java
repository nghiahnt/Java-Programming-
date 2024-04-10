package murachBook_Examples;

import java.util.Scanner;

public class Invoice_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Invoice Total Calculator\n");
		
		try (Scanner sc = new Scanner(System.in)) {
			// Perform invoice calculations 
			String choice = "Y";
			// Perform compare between two string ignore case considerations
			while (choice.equalsIgnoreCase("Y")) {
				// Get invoice subTotal
				System.out.println("Enter sub-total: ");
				double subTotal = sc.nextDouble();
				
				// Calculate discount and total
				double discountPercent = 0.0;
				if (subTotal >= 200) {
					discountPercent = .2;
				}
				else if (subTotal >= 100)
					discountPercent = .1;
				else 
					discountPercent = 0.0;
				
				double discountAmount = subTotal * discountPercent;
				double total = subTotal - discountAmount;
				
				// Display
				String message = "Discount percent: " + discountPercent + "\n"
						+ "Discount Amount: " + discountAmount + "\n"
						+ "Invoice Total: " + total + "\n";
				System.out.println(message);
				
				// See if user wants to continue
				System.out.print("Continue? (y/n): ");
				choice = sc.next();
				System.out.println();
			}
		}
	}

}
