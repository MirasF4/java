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
public class KochbuchBackwarenCommand extends KochbuchCommand {

    /**
     * @param newNext
     */
    public KochbuchBackwarenCommand(String newNext) {
        super(newNext);
        // TODO Auto-generated constructor stub
    }
    
    protected void setManager() {
		super.manager = ((ClientKochbuch) client).getKochbuchBackwarenManager();
		((ClientKochbuch) client).setKochbuchBackwarenManagerAsManagerNeu();
	}

	protected synchronized void init(HttpServletRequest request)
	throws Exception {
		super.init(request);
		KochbuchBackwarenManager pM = (KochbuchBackwarenManager) manager;
		pM.setCmd(Kochbuch.CMD_BACKWAREN);
		pM.readRezeptList(KochbuchBean.MENUE_BACKWAREN);
		String jsp = ((ClientKochbuch) client).getUriJSPKochbuch("backwaren.jsp");
		super.setJspNext(jsp);
	}
	
	protected void specialCommand(HttpServletRequest request,HttpServletResponse response)
	throws Exception { 
	    super.specialCommand(request,response);
	    super.navigate(request, "backwaren.jsp");
	}

}
