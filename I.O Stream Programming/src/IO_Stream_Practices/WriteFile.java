package IO_Stream_Practices;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
	
	public static void writeFile(String path) {
		// Write data 
		FileOutputStream fos = null;
		
		String msg = "Programming with I.O Stream in Java 3rd";
		
		try {
			fos = new FileOutputStream(path);
			for (int i=0; i<msg.length(); i++) {
				fos.write((int)msg.charAt(i));
			}
			fos.flush();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("IOException error");
		} finally {
			try {
				System.out.print("Successfully");
				fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("IOException error");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeFile("D:\\OneDrive - vq21j\\Java_Programming_Advanced\\Labs\\I.O Stream Programming\\src\\IO_Stream_Practices\\Data");
	}

}
 