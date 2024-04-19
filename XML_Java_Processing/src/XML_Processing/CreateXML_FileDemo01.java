package XML_Processing;

// Write XML file in java
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML_FileDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Create DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Create a new document
			Document document = builder.newDocument();
			
			// Create root element
			Element root = document.createElement("library");
			document.appendChild(root);
			
			// Create book elements and add text content
			Element book1 = document.createElement("Program1");
			book1.appendChild(document.createTextNode("Java Programming"));
			Element book2 = document.createElement("Program2");
			book2.appendChild(document.createTextNode("Python Programming"));
			Element book3 = document.createElement("Program3");
			book3.appendChild(document.createTextNode("Javascript"));
			
			root.appendChild(book1);
			root.appendChild(book2);
			root.appendChild(book3);
			
			// Write to XML file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			
			// Configure transformer
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			// Specify your local file path
			StreamResult result = new StreamResult("D:\\OneDrive - vq21j\\Java_Programming_Advanced\\Labs\\XML_Java_Processing\\src\\XML_Processing\\outputDemo01.xml");
			transformer.transform(source, result);
			
			System.out.println("XML file created successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
