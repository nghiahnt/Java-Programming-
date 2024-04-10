package XML_Processing;

import java.io.File;
import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SAX_Usage_Instruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xmlResource = "";
		int index = 0;
		
		// XML files
		String[] file = {"item.xml", "chessboard.xml", "contents.xml"};
		
		try {
			// Get the path name
			xmlResource = "file:\\" + new File(file[index]).getAbsolutePath();
			System.out.println(xmlResource);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		System.out.println("Processing the file: " + xmlResource + "\n");
		
		// Create content handler
//		ContentHandler contentHandler = new MyContentHandler();
	}

}

class MyContentHandler implements org.xml.sax.ContentHandler {
	String data = "";
	private Locator locator; // Store the event locator

	// Set the locator
	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		this.locator = locator;
		System.out.println("The locator set");
		
	}

	// Start processing
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Processing started");
	}

	// Stop processing
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Processing stopped");
	}

	// Start namespace mapping
	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Prefix " + prefix + " mapped to " + uri);
	}

	// Stop namespace mapping
	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Finished mapping the prefix " + prefix);
	}

	// Beginning of an element
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Startt of the element " + localName);
		if (!uri.equals("")) {
			System.out.println(" The name of the element " + uri + " [" + qName + "]");
		} else {
			System.out.println("No namespace found!");
			
		}
		
		for (int i=0; i<atts.getLength(); i++) {
			System.out.println("  Attribute: " + atts.getLocalName(i) +"=" + atts.getValue(i));
			// Element's data
			System.out.println("Element's data " + localName + ":" + data);
		}
	}

	// End of the element
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("end of the element: " + localName + "\n");
	}

	// element's data
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		data = new String(ch, start, length);
	}

	// Skip white spaces
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String s = new String(ch, start, length);
        System.out.println("skipped whitespaces: [" + s + "]");
	}

	// A processing instruction encountered
	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("PI: the goal PI:" + target + " Data: " + data);
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Skipped entities " + name);
	}
	
}

class MyErrorHandler implements ErrorHandler {

	// Warning: something is wrong
	@Override
	public void warning(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(
	             "*Parse warning*\n" +
	             "  Line:     "  + exception.getLineNumber() + "\n" +
	             "  URI:     "   + exception.getSystemId()   + "\n" +
	             "  Message:   " + exception.getMessage());        
	        throw new SAXException("Warning");
	}

	// non-fatal error; parsing continues
	@Override
	public void error(SAXParseException e) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(
		      	   "**Parsing Error**\n" +
		           "  Line:     "  + e.getLineNumber() + "\n" +
		           "  URI:     "   + e.getSystemId()   + "\n" +
		           "  Message:   " + e.getMessage());
		        throw new SAXException("Non-fatal error");
	}

	// fatal error - parsing stops
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(
	            "**Parsing Fatal Error**\n" +
	            "  Line:     "   + e.getLineNumber() + "\n" +
	            "  URI:     "   + e.getSystemId()   + "\n" +
	            "  Message:   " + e.getMessage());        
	        throw new SAXException("Fatal error"); 
	}
	
}
