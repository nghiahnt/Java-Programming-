package IO_Stream_Practices;

// Show content file to the screen
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
	public static void readFile(String path) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(path);
			int data;
			data = fis.read(); // read byte data
			
			while (data != -1) {
				System.out.print((char)data);
				data = fis.read();
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("IO Exception Error");
		} 
		finally {
			try {
				fis.close();
			} catch (IOException e2) {
				// TODO: handle exception
				System.out.println("IO Exception Error");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFile("./src/IO_Stream_Practices/ReadFile.java");
	}

}
