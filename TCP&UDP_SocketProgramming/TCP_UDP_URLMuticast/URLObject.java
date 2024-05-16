package TCP_UDP_URLMuticast;

import java.net.URI;
import java.net.URISyntaxException;

public class URLObject {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please provide a URL as a command line argument");
			return;
		}

		// Example urlString  = http://example.com/path/to/file.txt
		String urlString = args[0];

		try {
			URI u = new URI(urlString);
			System.out.println("Name of the file is: " + u.getPath());
			System.out.println("Host Name is: " + u.getHost());
			System.out.println("Port number is: " + u.getPort());
			System.out.println("Protocol type is: " + u.getScheme());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			URL u = new URL(urlString);
//			System.out.println("Name of the file is: " + u.getFile());
//			System.out.println("Host Name is: " + u.getHost());
//			System.out.println("Port number is: " + u.getPort());
//			System.out.println("Protocol type is: " + u.getProtocol());
//		} catch (MalformedURLException e) {
//			System.out.println(e);
//		}

	}
}