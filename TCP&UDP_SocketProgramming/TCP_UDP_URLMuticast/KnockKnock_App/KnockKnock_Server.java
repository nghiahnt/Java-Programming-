package TCP_UDP_URLMuticast.KnockKnock_App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class KnockKnock_Server {
	private ServerSocket serverSocket;
	private Socket server;

	// Handle req, res
	private PrintWriter out;
	private BufferedReader in;
	private String inputLine, outputLine;

	@SuppressWarnings("unused")
	private void start() {
		try {
			serverSocket = new ServerSocket(4444);
			System.out.println("Server is running");

			server = serverSocket.accept();

			// Config request
			out = new PrintWriter(server.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		KnockKnock_Server obj = new KnockKnock_Server();

		obj.start();

		KnockKnock_Protocol kkp = new KnockKnock_Protocol();
		
		obj.outputLine = kkp.processInput(null);
		obj.out.println(obj.outputLine);
		
		try {
			while ((obj.inputLine = obj.in.readLine()) != null) {
				obj.outputLine = kkp.processInput(obj.inputLine);
				System.out.println("Response data: " + obj.outputLine);
				obj.out.println(obj.outputLine);
				
				if (obj.outputLine.equals("Bye.")) {
					break;
				}
				
//				obj.out.close();
//				obj.in.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		obj.serverSocket.close();
		obj.server.close();
	}

}
