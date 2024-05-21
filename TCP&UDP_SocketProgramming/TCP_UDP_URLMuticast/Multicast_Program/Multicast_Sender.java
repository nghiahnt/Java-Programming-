package TCP_UDP_URLMuticast.Multicast_Program;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;

public class Multicast_Sender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String multicastAddress = args[0];
		int socketPort = Integer.parseInt(args[1]);
		String message = args[2];
		int receiverPort = Integer.parseInt(args[3]);

		try {
			// Create multicast socket
			MulticastSocket socket = new MulticastSocket(socketPort);

			// Join the multicast group
			// Connect to client multicast
			InetAddress address = InetAddress.getByName(multicastAddress);
			SocketAddress socketAddress = new InetSocketAddress(address, receiverPort);
			socket.joinGroup(socketAddress, null);

			// Send a message as bytes
			byte[] messageBytes = message.getBytes();
			socket.send(new DatagramPacket(messageBytes, messageBytes.length, socketAddress));

			System.out.println(
					"Sent message: " + message + " to multicast address: " + multicastAddress + " on port: " + receiverPort);

			// Leave the multicast group (optional)
			socket.leaveGroup(socketAddress, null);

			// Close the socket
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
