/*
 * Created on 07.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.kochbuch;

import javax.servlet.http.HttpServletRequest;

import com.hbedv.frame.MenueCommand;

/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class KochbuchMenueCommand extends MenueCommand {

    /**
     * @param newNext
     */
    
    public KochbuchMenueCommand(String newNext) {
        super(newNext);
        // TODO Auto-generated constructor stub
    }

    protected void setManager() {
		super.manager = ((ClientKochbuch) client).getKochbuchMenueManager();
		((ClientKochbuch) client).setKochbuchMenueManagerAsManagerNeu();
	}
   
    protected synchronized void init(HttpServletRequest request)
	throws Exception {
		super.init(request);
		//KochbuchMenueManager pM = (KochbuchMenueManager) manager;
		String jsp = ((ClientKochbuch) client).getUriJSPKochbuch("menue.jsp");
		super.setJspNext(jsp);
	}
    
}
