package Console_Programming;

import java.util.Scanner;
import java.io.*;

public class File_Explorer {
	public static int countFile = 0;
	
	private static void printDirectory(File dir, String value) {
		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				System.out.println("|--" + file.getName());
//				System.out.println("|--" + file.getName());
				printDirectory(file, value);
			} else {
				String fileName = file.getName();
				if (fileName.indexOf(value) != -1) {
					countFile++;
					System.out.println("|   |--" + file.getName());
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input your folder: ");
		String path = input.nextLine();
//		System.out.println(folderName);
		
		System.out.println("Enter file name: ");
		String searchValue = input.nextLine();
//		System.out.println(searchValue);
		
		printDirectory(new File(path), searchValue);
		System.out.println("The total file findout is: " + countFile);
	}

}
