/*
 * Created on 07.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.kochbuch;

import javax.servlet.http.HttpServletRequest;

import com.hbedv.frame.util.DateAndTime;


/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class KochbuchFamilyCommand extends KochbuchCommand {

    /**
     * @param newNext
     */
    
    public KochbuchFamilyCommand(String newNext) {
        super(newNext);
        // TODO Auto-generated constructor stub
    }

    protected void setManager() {
		super.manager = ((ClientKochbuch) client).getKochbuchFamilyManager();
		((ClientKochbuch) client).setKochbuchFamilyManagerAsManagerNeu();
	}
   
    protected synchronized void init(HttpServletRequest request)
	throws Exception {
		super.init(request);
		ClientKochbuch cl = ((ClientKochbuch) client);
		String jsp = cl.getUriJSPKochbuch("family.jsp");
		super.setJspNext(jsp);
	}
    
}
