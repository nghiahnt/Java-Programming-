package IO_Stream_Practices;

import java.io.*;

public class CopyFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("./src/IO_Stream_Practices/CopyFile.java");
			fos = new FileOutputStream("./src/IO_Stream_Practices/Destinate_CopyFile.java");
			
			int data;
			data = fis.read();
			
			while (data != -1) {
				fos.write(data);
				data = fis.read();
			}
			
			fos.flush();
			System.out.print("Copy file successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
