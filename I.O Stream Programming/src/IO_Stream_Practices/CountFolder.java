package IO_Stream_Practices;

import java.io.File;

public class CountFolder {
	
	public static int count(String path) {
		int result = 0;
		File f = new File(path);
		String[] filenames = f.list();
		
		for (int i=0; i<filenames.length; i++) {
			File fi = new File(path+"\\"+filenames[i]);
			
			if (fi.isFile()) result++;
			// If next path is folder then call count function with argument is current path
			else result += count(fi.getAbsolutePath());
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count("./"));
	}

}
