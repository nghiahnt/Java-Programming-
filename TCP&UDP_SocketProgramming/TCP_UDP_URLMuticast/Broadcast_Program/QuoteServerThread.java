package TCP_UDP_URLMuticast.Broadcast_Program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;

public class QuoteServerThread extends Thread {
	// Initialize
	protected DatagramSocket socket = null;
	protected BufferedReader input = null;
	protected boolean moreQuotes = true;
//	private int TTL = 128;
	
	public QuoteServerThread() throws IOException {
		this("QuoteServerThread");
	}

	public QuoteServerThread(String name) throws IOException {
		// TODO Auto-generated constructor stub
		super(name);

		socket = new DatagramSocket(4445);

		try {
			String path = "./TCP_UDP_URLMuticast/Broadcast_Program/";
			FileReader file = new FileReader(path + "Quotes.txt");
			input = new BufferedReader(file);
			System.out.println("Server is running...");
			// Show file
//			File directory = new File("./TCP_UDP_URLMuticast/Broadcast_Program");
//			File[] files = directory.listFiles();
//			for (File file : files) {
//				System.out.println(file.getName());
//			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Could not open the quote file");
			moreQuotes = false;
		}
	}

	protected String getNextQuote() {
		String returnValue = null;

		try {
			if ((returnValue = input.readLine()) == null) {
				input.close();
				moreQuotes = false;
				returnValue = "No more quotes. Good bye!!";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("IOException occurred in server");
		}

		return returnValue;
	}
}
