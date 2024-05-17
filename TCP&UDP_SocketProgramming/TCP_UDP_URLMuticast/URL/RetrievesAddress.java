package TCP_UDP_URLMuticast.URL;

import java.net.InetAddress;

public class RetrievesAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		try {
			// Get localhost IP
			InetAddress i = InetAddress.getLocalHost();
			System.out.println("The localhost is: " + i);
			
			// Get local name
			InetAddress nullHost = InetAddress.getByName(null);
			System.out.println("The Null host is: " + nullHost.getHostAddress());
			
			InetAddress webHost = InetAddress.getByName("www.facebook.com");
			System.out.println("The facebook address is: " + webHost);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
