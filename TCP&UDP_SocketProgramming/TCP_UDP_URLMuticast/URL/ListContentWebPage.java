package TCP_UDP_URLMuticast.URL;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class ListContentWebPage {
	
	public static void readURL(URL url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			InputStream inputStream = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			reader.close();
		} else {
			System.err.println("Error: " + connection.getResponseCode());
		}
	}
	
	public static void readHeaderInfor(URL url, int i) throws IOException {
		int iValue = i;
		
		URLConnection urlConnection = url.openConnection();
		String field = urlConnection.getHeaderField(iValue);
		String fieldKey = urlConnection.getHeaderFieldKey(iValue);
		
		while (field != null) {
			System.out.println("Header " + iValue + ": " + fieldKey + " = " + field);
			iValue++;
			field = urlConnection.getHeaderField(iValue);
			fieldKey = urlConnection.getHeaderFieldKey(iValue);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		int i = 1;
		
		try {
			URI uri = new URI(args[0]);
			URL url = uri.toURL();
			
//			readURL(url);
			readHeaderInfor(url, i);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
