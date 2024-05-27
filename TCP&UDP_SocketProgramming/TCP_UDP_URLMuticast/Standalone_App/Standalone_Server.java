package TCP_UDP_URLMuticast.Standalone_App;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Standalone_Server {
	public static final int PORT = 3002;
	private Socket socket;
	private DataInputStream req;
	private DataOutputStream res;

	private void start() {
		boolean status = true;

		while (status) {
			try (ServerSocket serverSocket = new ServerSocket(PORT)) {
				System.out.println("Server is running...");

				// Create socket
				socket = serverSocket.accept();

				// Initialize input, output stream
				req = new DataInputStream(socket.getInputStream());
				res = new DataOutputStream(socket.getOutputStream());

				// Listen req
				while (status) {
					String reqData = req.readUTF();
					System.out.println("Client data: " + reqData);
					// Convert
					String resData = resValue(reqData);

					// Response
					System.out.println("Response data: " + resData);
					res.writeUTF(resData);
					res.flush();
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				status = true;
				e.printStackTrace();
			} finally {
				System.out.println(status ? "Server continue running..." : "Server stopped!");
			}
		}
	}

	private String resValue(String number) {
		switch (number) {
		case "1":
			return "ONE";
		case "2":
			return "two";
		case "3":
			return "three";
		default:
			System.out.println(number);
			return "unknown";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			new Standalone_Server().start();
//			System.out.println(new Standalone_Server().resValue("1"));

			Standalone_Server server = new Standalone_Server();
			server.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
