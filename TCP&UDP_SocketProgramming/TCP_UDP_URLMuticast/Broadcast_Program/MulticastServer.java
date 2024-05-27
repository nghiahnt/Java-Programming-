package TCP_UDP_URLMuticast.Broadcast_Program;

import java.io.IOException;

public class MulticastServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new MulticastServerThread().start();
	}

}