package IO_Stream_Practices;

import java.io.FileWriter;

public class WriteFile2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String mgs = "Programming with I.O Stream in Java - version 2";
		FileWriter f = new FileWriter("./src/IO_Stream_Practices/Data.txt");
		
		f.write(mgs);
		f.flush();
		f.close();
	}

}
