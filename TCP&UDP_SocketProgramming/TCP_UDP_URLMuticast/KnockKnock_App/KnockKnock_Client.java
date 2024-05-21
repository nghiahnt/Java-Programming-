package TCP_UDP_URLMuticast.KnockKnock_App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class KnockKnock_Client {
	private Socket kkSocket;

	private PrintWriter out;
	private BufferedReader in, stdIn;
	
	private String fromServer, fromUser;

	private void kkClient() {
		try {
			kkSocket = new Socket("localhost", 4444);

			out = new PrintWriter(kkSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
		} catch (UnknownHostException e) {
			// TODO: handle exception
			System.err.println("Don't know about host: taranis.");
			System.exit(1);
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("Couldn't get I/O for the connection to: taranis.");
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnockKnock_Client obj = new KnockKnock_Client();
		obj.kkClient();
		
		obj.stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while ((obj.fromServer = obj.in.readLine()) != null) {
				System.out.println("Server: " + obj.fromServer);
				if (obj.fromServer.equals("Bye."))
					break;
				
				obj.fromUser = obj.stdIn.readLine();
				if (obj.fromUser != null) {
					System.out.println("Client: " + obj.fromUser);
					obj.out.println(obj.fromUser);
				}
			}
			
//			while (true) {
//				obj.fromUser = obj.stdIn.readLine();
//				if (obj.fromUser != null) {
//					System.out.println("Client: " + obj.fromUser);
//					obj.out.println(obj.fromUser);
//				}				
//			}
			
//			obj.out.close();
//			obj.in.close();
//			obj.stdIn.close();
//			obj.kkSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
