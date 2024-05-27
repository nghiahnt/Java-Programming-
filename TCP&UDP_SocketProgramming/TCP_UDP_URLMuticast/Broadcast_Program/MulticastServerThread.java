package TCP_UDP_URLMuticast.Broadcast_Program;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;

public class MulticastServerThread extends QuoteServerThread {
	// Initialize
	private long FIVE_SECONDS = 5000;

	// Create methods
	public MulticastServerThread() throws IOException {
		super("MulticastServerThread");
	}

	public void run() {
		// Get attributes from QuoteServerThread
		while (moreQuotes) {
			try {
				byte[] buf = new byte[256];

				// Contruct quote
				String dString = null;

				if (input == null) {
					dString = new Date().toString();
				} else
					dString = getNextQuote();

				buf = dString.getBytes();

				InetAddress address = InetAddress.getByName("230.0.0.1");
//				SocketAddress group = new InetSocketAddress(address);
				DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4446);

				socket.send(packet);

				// Sleep for a while
				try {
					sleep((long) (Math.random() * FIVE_SECONDS));
				} catch (Exception e) {
					// TODO: handle exception
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				moreQuotes = false;
			}
		}

		socket.close();
	}
}
