package IO_Stream_Practices;

import java.io.*;

public class ReadDir {
	
	public ReadDir(String path) {
		File f = new File(path);
		
		String[] filenames = f.list();
		
		for (int i=0; i<filenames.length; i++) {
			System.out.println(filenames[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReadDir("./");
	}

}
