package TCP_packet_practices.Exchange_Time;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws IOException {
		try (// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(3000)) {
			System.out.println("Server is running...");

			while (true) {
				Socket socket = server.accept();

				// Set response for clien
				DataOutputStream res = new DataOutputStream(socket.getOutputStream());
				String time = new Date().toString();
				res.writeUTF(time);
				socket.close();
			}
		}
	}

}
