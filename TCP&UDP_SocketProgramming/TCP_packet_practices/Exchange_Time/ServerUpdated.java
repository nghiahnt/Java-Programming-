package TCP_packet_practices.Exchange_Time;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerUpdated {
	static int count = 1;
	
	public static void main(String[] args) throws IOException {
		try (// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(3000)) {
			System.out.println("Server is running...");
			
			while(true) {
				Socket clientSocket = server.accept();
				System.out.println("Start response time " + count++);
				Thread clientThread = new Thread(new ClientHanler(clientSocket));
				clientThread.start();
			}
		}
	}

}

class ClientHanler implements Runnable {
	Socket clientSocket;
	
	DataOutputStream res;
	
	public ClientHanler(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			res = new DataOutputStream(clientSocket.getOutputStream());
			
			// Loop
			while(true) {
				String time = new Date().toString();
				res.writeUTF(time);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
