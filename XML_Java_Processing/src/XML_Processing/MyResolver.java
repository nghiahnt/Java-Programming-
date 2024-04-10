package XML_Processing;

import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class MyResolver implements EntityResolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Main function purpose is allow use local data replace for online content when parser XLM 

	@Override
	public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
		// TODO Auto-generated method stub
		if (systemId.equals("http://www.myhost.com/today")) {
			FileReader reader = new FileReader("data.txt");
			return new InputSource(reader);
		} 
		else return null;
	}
}
