/*
 * Created on 07.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.kochbuch;

import javax.servlet.http.HttpServletRequest;


/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class KochbuchBannerCommand extends KochbuchCommand {

    /**
     * @param newNext
     */
    
    public KochbuchBannerCommand(String newNext) {
        super(newNext);
        // TODO Auto-generated constructor stub
    }

    protected void setManager() {
		super.manager = ((ClientKochbuch) client).getKochbuchBannerManager();
		((ClientKochbuch) client).setKochbuchBannerManagerAsManagerNeu();
	}
   
    protected synchronized void init(HttpServletRequest request)
	throws Exception {
		super.init(request);
		String jsp = ((ClientKochbuch) client).getUriJSPKochbuch("banner.jsp");
		super.setJspNext(jsp);
	}
    
}
