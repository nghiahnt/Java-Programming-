package IO_Stream_Practices;

import java.io.*;
import java.io.IOException;

public class CountCharFile {

	public static int count(String path, char ch) {
		int result = 0;
		// Read input stream
		FileInputStream fis = null; // Read file by byte
		try {
			fis = new FileInputStream(path);
			int data;
			data = fis.read();
			while (data != -1) {
				if (data == ch)
					result++;
				data = fis.read();
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("IOException Error1");
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO: handle exception
				System.out.println("IOException Error2");
			}
		}

		return result;
	}

	public CountCharFile(String path) {
		File f = new File(path);

		String fileNames[] = f.list();

		for (String file : fileNames) {
			System.out.println(file);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The total of i characters: " + count("./src/IO_Stream_Practices/CountCharFile.java", 'i'));
//		new CountCharFile("./src/IO_Stream_Practices");
	}

}
