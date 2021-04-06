package TPDOMSAX;

import java.util.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class SAXLocalNameCount extends DefaultHandler {
	private Hashtable<String, Integer> tags;
	public void startDocument() throws SAXException {
		tags = new Hashtable<String, Integer>();
	}
	public void endDocument() throws SAXException {
		Enumeration<String> e = tags.keys();
		while(e.hasMoreElements()) {
			String tag = (String) e.nextElement();
			int count = ((Integer) tags.get(tag)).intValue();
			System.out.println("Element \"" + tag + "\" se produit " + count + " fois");
		}
	}
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		String key = localName;
		Object value = tags.get(key);
		if(value == null) {
			tags.put(key, 1);
		} else {
			int count = (Integer) value + 1;
			tags.put(key, count);
		}
	}
}
