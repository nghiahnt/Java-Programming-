package StudentManagement_Full;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ModifyXML_StudentManagement extends JFrame implements ActionListener {
	// This class used to store the data from mysql database into .xml file
	// Display the data from .xml file to the screen, and make it can modify

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private Vector<Object> vTitle;
//	private Vector<Object> vData;
	
	// IO task
	private String filePath = "D:\\OneDrive - vq21j\\Java_Programming_Advanced\\Labs\\JDBC_Programming\\src\\StudentManagement_Full\\StudentXMLDataFile.xml";

	// Show the data from XML file to the screen
	ModifyXML_StudentManagement(String title) throws SAXException, IOException {
		super(title);
		
		try {
			File file = new File(filePath);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(file);
			
			// Call update from 
			// Get data from xml and give it to Form to display
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Get data from data and store to the database
	public static void createXMLFile(Vector<Vector<Object>> vData, Vector<Object> vTitle) {
		System.out.println("Creating a students XML file...");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Create a new doc
			Document document = builder.newDocument();

			// Create element
			Element root = document.createElement("students");
			document.appendChild(root);

			// Read XML
			// Create student content and inside content
			for (int i=0; i<vData.size(); i++) {
				Element std = document.createElement("student"); // a vector

				for (int j=0; j<vTitle.size(); j++) {
					Element tags = document.createElement((String) vTitle.get(j));
//						tags.appendChild(document.createTextNode((String) data));
					tags.appendChild(document.createTextNode((String) vData.get(i).get(j)));
					std.appendChild(tags);
				}

				root.appendChild(std);
			}

			// Write to XML File
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);

			// Configure transformer
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			// Specify the local path
			StreamResult result = new StreamResult(
					"D:\\OneDrive - vq21j\\Java_Programming_Advanced\\Labs\\JDBC_Programming\\src\\StudentManagement_Full\\StudentXMLDataFile.xml");
			transformer.transform(source, result);
			System.out.println("XML file created successfully!");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
