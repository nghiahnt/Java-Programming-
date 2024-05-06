package TCP_packet_practices.SimpleChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_SimpleChat {

	public static void main(String[] args) throws UnknownHostException, IOException {
		try (// TODO Auto-generated method stub
				Socket socket = new Socket("localhost", 3001)) {
			// Set req and res
			DataOutputStream sender = new DataOutputStream(socket.getOutputStream());
			DataInputStream receiver = new DataInputStream(socket.getInputStream());

			try (Scanner input = new Scanner(System.in)) {
				while (true) {
					System.out.println("Client: ");
					String data = input.nextLine();
					sender.writeUTF(data);
					sender.flush();

					// Get data
					String res = receiver.readUTF();
					System.out.println("Server: " + res);

					input.reset();
				}
			}
		}
	}

}
