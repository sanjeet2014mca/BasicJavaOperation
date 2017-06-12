package com.readwritexml.setonpojo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JavaReadingWritingXml {
	public static void main(String s[]) throws JAXBException, FileNotFoundException{
		//Read XML file set on Pojo 
		try {
			JAXBContext jc = JAXBContext.newInstance(Product.class);
			Unmarshaller u = jc.createUnmarshaller();
			File f = new File(System.getProperty("user.home")+"/file/product.xml");
			Product product = (Product) u.unmarshal(f);
			System.out.println(product.getCode());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		//Create Java to XML  
		try {
			JAXBContext context = JAXBContext.newInstance(Product.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Product object = new Product();
			object.setCode("WI1");
			object.setName("Widget Number One");
			object.setPrice(BigDecimal.valueOf(300.00));
			System.out.println("Marshling on console:");
			m.marshal(object, System.out);
			System.out.println("Marshling in file:");
			m.marshal(object,new FileOutputStream(System.getProperty("user.home")+"/file/javaproduct.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}