package TCP_packet_practices.SimpleChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_SimpleChat {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try (ServerSocket server = new ServerSocket(3001)) {
			System.out.println("Starting...");
			
			// Create req and res methods
			Socket socket = server.accept();
			DataInputStream req = new DataInputStream(socket.getInputStream());
			DataOutputStream res = new DataOutputStream(socket.getOutputStream());
			
			try (Scanner input = new Scanner(System.in)) {
				while (true) {
					String reqData = req.readUTF();
					System.out.println("Client: " + reqData);
					
					System.out.println("Server: ");
					String resData = input.nextLine();
					res.writeUTF(resData);
					res.flush();
					
					input.reset();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
