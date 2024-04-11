package IO_Stream_Practices;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {

	public static void writeFile(String path) {
		// Use buffer - intermediate stream use to write full of string into file
		DataOutputStream bf = null;

		// Write data
//		FileOutputStream fos = null; // The first way to write file

		String msg = "Programming with I.O Stream in Java 3rd";

//		try {
//			fos = new FileOutputStream(path);
//			for (int i=0; i<msg.length(); i++) {
//				fos.write((int)msg.charAt(i));
//			}
//			fos.flush(); // Push data in buffered to file
//		} catch (IOException e) {
//			// TODO: handle exception
//			System.out.println("IOException error");
//		} finally {
//			try {
//				System.out.print("Successfully");
//				fos.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//				System.out.println("IOException error");
//			}
//		} // The first way to write file

		try {
			// Concat FileOutputStream into DataOutputStream
			bf = new DataOutputStream(new FileOutputStream(path));
			bf.writeChars(msg);
			bf.flush();
			System.out.print("Successfully");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("IOException error");
		} finally {
			try {
				bf.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("IOException error");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeFile(
				"D:\\OneDrive - vq21j\\Java_Programming_Advanced\\Labs\\I.O Stream Programming\\src\\IO_Stream_Practices\\Data");
	}

}
