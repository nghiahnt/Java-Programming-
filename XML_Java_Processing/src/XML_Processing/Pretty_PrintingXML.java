package XML_Processing;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

// Create a method to convert ulgy, raw xml string to a pretty-formatted string

public class Pretty_PrintingXML {
	public static String prettyPrintByTransformer(String xmlString, int indent, boolean ignoreDeclaration) {
		Writer out = new StringWriter();
		try {
			InputSource src = new InputSource(new StringReader(xmlString));
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", indent);

			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			transformer.transform(new DOMSource(document), new StreamResult(out));

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error occurs when pretty-printing xml:\n" + xmlString, e);
		}
		return out.toString();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		InputStream inputStream = XmlPrettyPrinter.class.getResourceAsStream("");
	}

}
