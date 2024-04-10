
// Java Program to Read XML Using DOM Parser 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document; 
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node; 
import java.io.File;
import java.io.IOException;

public class ReadXMLFileDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		// Specify the file path as a File object 
		String path = "D:\\OneDrive - vq21j\\Java_Programming_Advanced\\Labs\\Midterm_K22\\src\\student.xml";
        File xmlFile = new File(path); 
  
        // Create a DocumentBuilder 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
        DocumentBuilder builder = factory.newDocumentBuilder(); 
  
        // Parse the XML file 
        Document document = builder.parse(xmlFile); 
  
        // Access elements by tag name 
        NodeList nodeList = document.getElementsByTagName("Student"); 
        for (int i = 0; i < nodeList.getLength(); i++) { 
            Node node = nodeList.item(i); 
            System.out.println("Element Content: " + node.getTextContent()); 
        }
	}

}
