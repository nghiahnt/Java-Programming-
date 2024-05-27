package TCP_UDP_URLMuticast.Broadcast_Program;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;

public class MulticastClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MulticastSocket socket = new MulticastSocket(4446);
		
		InetAddress address = InetAddress.getByName("230.0.0.1");
		SocketAddress group = new InetSocketAddress(address, 4446);
		
		socket.joinGroup(group, null);
		
		DatagramPacket packet;
		
		// Get a quotes
		for (int i=0; i<5; i++) {
			byte[] buf = new byte[256];
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			
			String received = new String(packet.getData());
			System.out.println("Quote of the moment: " + received);
		}
		
		socket.leaveGroup(group, null);
		socket.close();
	}

}
