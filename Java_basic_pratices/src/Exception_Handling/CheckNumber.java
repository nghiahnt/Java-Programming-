package Exception_Handling;

// User enter the string 
// System check the string weather that string is number string?

import java.util.Scanner;

class UnsignedIntegerException extends Exception {
	public UnsignedIntegerException(String str) {
		super(str);
	}
}

public class CheckNumber {
	
	public static void checkNumber(String str) throws UnsignedIntegerException {
		String numReg = "^\\d+$";
		Boolean b = str.matches(numReg);
		
		if(b) {
			System.out.println("Hop le");
		} else
			throw new UnsignedIntegerException("Khong hop le");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhap chuoi so nguyen duong: ");
			String num = sc.nextLine();
			
			checkNumber(num);
		} catch (UnsignedIntegerException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
