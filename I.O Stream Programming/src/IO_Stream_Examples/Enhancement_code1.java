package IO_Stream_Examples;

import java.io.*;

public class Enhancement_code1 {

	public static void main(String[] args) {
        String path = "D:\\OneDrive - vq21j\\Java_Programming_Advanced\\Labs\\I.O Stream Programming";
        printDirectory(new File(path));
    }

    private static void printDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                System.out.println("<Dir> " + file.getName());
                printDirectory(file); // Đệ quy
            } else {
                System.out.println("  " + file.getName());
            }
        }
    }

}
