package com.readwritexml.setonpojo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ReadingUnknowStructorOfXML {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, VerifyError {

		/**
		 * We can pass the class name of the XML parser
		 * to the SAXParserFactory.newInstance().
		 */
		//SAXParserFactory saxDoc = SAXParserFactory.newInstance("com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl", null);
		SAXParserFactory saxDoc = SAXParserFactory.newInstance();
		SAXParser saxParser = saxDoc.newSAXParser();
		DefaultHandler handler = new DefaultHandler() {
			String tmpElementName = null;
			String tmpElementValue = null;
			Map<String,String> tmpAtrb=null;
			@SuppressWarnings("unchecked")
			@Override
			public void startElement(String uri, String localName, String qName, 
					Attributes attributes) throws SAXException {
				tmpElementValue = "";
				tmpElementName = qName;
				tmpAtrb=new HashMap();
				//System.out.println("Start Element :" + qName);
				/**
				 * Store attributes in HashMap
				 */
				for (int i=0; i<attributes.getLength(); i++) {
					String aname = attributes.getLocalName(i);
					String value = attributes.getValue(i);
					tmpAtrb.put(aname, value);
				}
			}
			@Override
			public void endElement(String uri, String localName, String qName) 
					throws SAXException {
				if(tmpElementName.equals(qName)){
					System.out.println("Element Name :"+tmpElementName);
					/**
					 * Retrive attributes from HashMap
					 */                    for (Map.Entry<String, String> entrySet : tmpAtrb.entrySet()) {
						 System.out.println("Attribute Name :"+ entrySet.getKey() + "Attribute Value :"+ entrySet.getValue());
					 }
					 System.out.println("Element Value :"+tmpElementValue);
				}
			}
			@Override
			public void characters(char ch[], int start, int length) throws SAXException {
				tmpElementValue = new String(ch, start, length) ;
			}
		};
		/**
		 * Below two line used if we use SAX 2.0
		 * Then last line not needed.
		 */
		//saxParser.setContentHandler(handler);
		//saxParser.parse(new InputSource("c:/file.xml"));
		System.out.println("****************product contents key values:*********************\n");
		saxParser.parse(new File(System.getProperty("user.home")+"/file/product.xml"), handler);
		System.out.println("****************complex contents key values:*********************\n");
		saxParser.parse(new File(System.getProperty("user.home")+"/file/complex.xml"), handler);
		System.out.println("****************nestedroot contents key values:******************\n");
		saxParser.parse(new File(System.getProperty("user.home")+"/file/nestedroot.xml"), handler);

	}
}