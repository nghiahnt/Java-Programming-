package TCP_UDP_URLMuticast.URL;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class ExaminesURLContent {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String domain = "http://viettuts.vn/eclipse/phim-tat-hay-dung-trong-eclipse";
		int i;
		
		try {
			URI uri = new URI(domain);
			URL url = uri.toURL();
			
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection connection = (HttpURLConnection) urlConnection;
			connection.setRequestMethod("GET");
			
			System.out.println("Date: " + new Date(connection.getDate()));
			System.out.println("Content-type: " + connection.getContentType());
			System.out.println("Expires: " + connection.getExpiration());
			System.out.println("Last modified: " + connection.getLastModified());
			
			int length = connection.getContentLength();
			System.out.println("Content-Length: " + length);
			
			if (length > 0) {
				System.out.println("Content");
				
				InputStream input = connection.getInputStream();
				int a = length;
				
				while (((i = input.read()) != -1) && (--a>0)) {
					System.out.print((char) i);
				}
				
				input.close();
			} else {
				System.out.println("Content is not available");
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
