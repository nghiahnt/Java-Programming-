package TCP_UDP_URLMuticast.Standalone_App;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Standalone_Client {
	public static final int PORT = 3002;

	private Socket clientSocket;
	private DataOutputStream sender;
	private DataInputStream receiver;
	
	@SuppressWarnings("unused")
	private void initSocket(String domain, int PORT) throws UnknownHostException, IOException {
		clientSocket = new Socket(domain, PORT);
		sender = new DataOutputStream(clientSocket.getOutputStream());
		receiver = new DataInputStream(clientSocket.getInputStream());
	}
	
	@SuppressWarnings("unused")
	private void initSocket() throws UnknownHostException, IOException {
		clientSocket = new Socket("localhost", PORT);
		sender = new DataOutputStream(clientSocket.getOutputStream());
		receiver = new DataInputStream(clientSocket.getInputStream());
	}

	private void go(String arg) {
		try {
			sender.writeUTF(arg);
			sender.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void go() {
		try {
			sender.writeUTF("0");
			sender.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Standalone_Client obj = new Standalone_Client();
			
			if (args.length == 0 || args.length == 1) {
				System.err.println("Please check your input!");
				obj.initSocket();
				obj.go();
			} else {
				// Init socket
				obj.initSocket(args[0], PORT);				
				// Send data
				obj.go(args[1]);
			}
			
			// Get response
			System.out.println("Server: " + obj.receiver.readUTF());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
