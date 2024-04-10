package Exception_Handling;

import java.util.Scanner;

public class EmailCheck {
	public static void check(String str) throws EmailAddressException {
		// Bieu thuc chinh quy so khop dia chi email
		String emailreg = "^[\\w-]+@([\\w- ]+\\.)+[\\w-]+$";
		// So khop dia chi email
		Boolean b = str.matches(emailreg);
		
		if(b == false) throw new EmailAddressException("Dia chi email khong hop le");
		System.out.println("Email hop le");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhap email: ");
			
			String email = sc.nextLine();
			check(email);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}

class EmailAddressException extends Exception {
	EmailAddressException(String str) {
		// Call initial function 
		super(str);
	}
}
