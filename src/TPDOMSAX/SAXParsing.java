package TPDOMSAX;

import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class SAXParsing {

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		SAXParser parser;
		try {
			parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			reader.setContentHandler(new SAXLocalNameCount());
			reader.parse("documents/dvd.xml");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
