/*
 * Created on 07.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.kochbuch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbedv.db.kochbuch.KochbuchBean;


/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class KochbuchDesertCommand extends KochbuchCommand {

    /**
     * @param newNext
     */
    public KochbuchDesertCommand(String newNext) {
        super(newNext);
        // TODO Auto-generated constructor stub
    }
    
    protected void setManager() {
		super.manager = ((ClientKochbuch) client).getKochbuchDesertManager();
		((ClientKochbuch) client).setKochbuchDesertManagerAsManagerNeu();
	}

	protected synchronized void init(HttpServletRequest request)
	throws Exception {
		super.init(request);
		KochbuchDesertManager pM = (KochbuchDesertManager) manager;
		pM.setCmd(Kochbuch.CMD_DESERTS);
		pM.readRezeptList(KochbuchBean.MENUE_DESERTS);
		String jsp = ((ClientKochbuch) client).getUriJSPKochbuch("desert.jsp");
		super.setJspNext(jsp);
	}
	
	protected void specialCommand(HttpServletRequest request,HttpServletResponse response)
	throws Exception { 
	    super.specialCommand(request,response);
	    super.navigate(request, "desert.jsp");
	}

}
