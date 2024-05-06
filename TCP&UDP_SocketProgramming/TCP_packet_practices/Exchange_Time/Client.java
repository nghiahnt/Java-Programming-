package TCP_packet_practices.Exchange_Time;

import java.io.DataInputStream;
import java.net.Socket;

import javax.swing.JFrame;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Socket socket = new Socket("localhost", 3000)) {
			// Get response
			DataInputStream res = new DataInputStream(socket.getInputStream());
			while(res != null) {
				String time = res.readUTF();
				System.out.println(time);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

class ElectronicClock extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ElectronicClock() {
		
	}
	
	
}
