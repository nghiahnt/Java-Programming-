package XML_Processing;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// Read XML file in java

public class ReadXML_FileDemo01 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		
		//Specify the path of the file 
		File xmlFile = new File("D:\\OneDrive - vq21j\\Java_Programming_Advanced\\Labs\\XML_Java_Processing\\src\\XML_Processing\\outputDemo01.xml");
		
		//Create a DocumentBuilder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		// Parse the XML file
		Document document = builder.parse(xmlFile);
		
		// Access elements by tag name
		NodeList nodeList = document.getElementsByTagName("library");
		for (int i=0; i<nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			System.out.println("Element Content: " + node.getTextContent());
		}
	}

}
