package TCP_UDP_URLMuticast.Multicast_Program;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;

public class Multicast_Receiver {
	// Client port
	private static final int MULTICAST_PORT = 6789;

	// Server 
	private static final String MULTICASTGROUP = "230.0.0.1";
	private static final Integer serverPort = 4444;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Create socket multicast
			@SuppressWarnings("resource")
			MulticastSocket multicastSocket = new MulticastSocket(MULTICAST_PORT);

			// Join the multicast group
			// Connect to server multicast
			InetAddress address = InetAddress.getByName(MULTICASTGROUP);
			SocketAddress socketAddress = new InetSocketAddress(address, serverPort);
			multicastSocket.joinGroup(socketAddress, null);

			// Receive message
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

			while (true) {
				try {
					multicastSocket.receive(packet);
					String receivedMessage = new String(packet.getData(), 0, packet.getLength());
					System.out.println("Received message: " + receivedMessage + " from address: "
							+ packet.getAddress().getHostAddress() + " on port: " + packet.getPort());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					break;
				}
			}
			
//			// Leave group
//			multicastSocket.leaveGroup(socketAddress, null);
//			
//			// Close the socket
//			multicastSocket.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
