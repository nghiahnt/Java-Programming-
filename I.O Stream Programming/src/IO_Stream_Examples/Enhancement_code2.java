package IO_Stream_Examples;

import java.io.*;

public class Enhancement_code2 {

	// Write a method to count all files in the folder (including all subfolder)

	public static int countFile(String path) {
		int count=0;
		File f = new File(path);

		String[] names = f.list();

		for (int i=0; i<names.length; i++) {
			File fi = new File(path+"\\"+names[i]);

			if (fi.isDirectory()) count+=countFile(fi.getAbsolutePath());
			else count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(Enhancement_code2.countFile("D:\\\\OneDrive - vq21j\\\\Java_Programming_Advanced\\\\Labs\\\\I.O Stream Programming"));

	}

}
