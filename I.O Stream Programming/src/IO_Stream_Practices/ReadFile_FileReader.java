package IO_Stream_Practices;

import java.io.*;

public class ReadFile_FileReader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("./src/IO_Stream_Practices/ReadFile_FileReader.java");
		// Using buffer to read line
		BufferedReader br = new BufferedReader(fr);
		String s;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}
		fr.close();
	}

}
