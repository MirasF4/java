/*
 * Created on 24.07.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.livejournal;

import javax.servlet.http.HttpServletRequest;

import com.hbedv.frame.BodyCommand;



/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FertigCommand extends BodyCommand {
	
	public FertigCommand(String newNext) {
		super(newNext);
	}

	protected void setManager() {
		super.manager = ((ClientLiveJournal) client).getFertigManager();
		((ClientLiveJournal) client).setFertigManagerAsManagerNeu();
	}
	
	
	protected synchronized void init(HttpServletRequest request)
	throws Exception {
		super.init(request);
		FertigManager pM = (FertigManager) manager;
		pM.setCmd(LiveJournal.CMD_FERTIG);
		String jsp = ((ClientLiveJournal) client).getUriJSPLiveJournal("finished.jsp");
		super.setJspNext(jsp);
	}
	

}
