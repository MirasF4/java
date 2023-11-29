/*
 * Created on 16.10.2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.hbedv.frame;

import java.util.*;
/**
 * @author woi
 *
 * Kann im Zusammenspiel mit RedirectRequestFacade die Parameter von einem request ersetzen
 * 
 */
@SuppressWarnings("unchecked")
public class RequestStateKeeper {
	private Map parameter = null;

	public RequestStateKeeper() {
		parameter = new HashMap();
	}

	/**
	 * Liefert den Value zu dem Key 
	 */
	public String getParameter(String key) {
		Object test = parameter.get(key);
		
		if (test == null)
			return null;
		if (test instanceof String)
			return ((String) test);
		else if (test instanceof String[])
		{
			String values[] = (String[]) test;
		
			String str = new String();
			for (int i = 0; i < values.length; i++) {
				if (values[i] != null)
					str += values[i];
			}
			return str;
		}
		else 		
			return "";
	}
	
	public String[] getParameterValues(String key) {
		return (String[]) parameter.get(key);
	}	
	
	
	/**
	 * Liefert die Parameter Map
	 */
	public Map getParameterMap() {
		return parameter;
	}

	/**
	 * Liefert die Parameter Namen als Enumeration
	 */
	public Enumeration getParameterNames() {
		Set keySet = parameter.keySet();
		Iterator i = keySet.iterator();
		Vector vec = new Vector();
		
		while (i.hasNext()) {
			String key = (String) i.next();
			vec.add(key);
		}
		return vec.elements();
	}
	
	/**
	 * Setzt die Parameter-Map mit der aktuellen Map
	 */
	public void setParameter(Map map) {
		parameter = map;
	}

	/**
	 * Fügt einen Key mit seinem Value zu dem Paramter hinzu
	 */
	public void addParameter(String key, String value) {
		parameter.put(key, value);
	}

	/**
	 * Fügt eine Map zu den Paramter hinzu
	 */
	public void addParameter(Map map) {
		parameter.putAll(map);
	}
}
