package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ParseXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		ParseXML xmlParser = new ParseXML();
		try {
			xmlParser.parse("test.xml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void parse(String file) throws ParserConfigurationException, SAXException, IOException {
		
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new File(file));
		
		doc.getDocumentElement().normalize();
		
	}

}
