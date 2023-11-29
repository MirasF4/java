/*
 * Created on 16.02.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hbedv.frame.util;


import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*; 

/**
 * @author sem2
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class XML {

	public static String XMLDocument2XMLString(Document doc) {
		String value = null;
		
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty("omit-xml-declaration", "yes");
	
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
	
			DOMSource source = new DOMSource(doc);
			
			transformer.transform(source, result);
			value = sw.getBuffer().toString();
		} catch (TransformerException te) {
			// und was mache ich hier
		}
		return value;
	}



}
