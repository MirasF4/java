/*
 * Created on 24.07.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
	Last change: PIG 27.11.2007 16:33:56
 */
package com.hbedv.lj_results;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbedv.frame.BodyCommand;



/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LjResultsCommand extends BodyCommand {
	
	public LjResultsCommand(String newNext) {
		super(newNext);
	}

	protected void setManager() {
		super.manager = ((ClientLjResults) client).getLjResultsManager();
		((ClientLjResults) client).setLjResultsManagerAsManagerNeu();
	}
	
	
	protected synchronized void init(HttpServletRequest request)
	throws Exception {
		super.init(request);
		LjResultsManager pM = (LjResultsManager) manager;
		pM.setCmd(LjResults.CMD_PAGE);
		String jsp = ((ClientLjResults) client).getUriJSPLiveJournal("page1.jsp");
		pM.setPage(1);
		super.setJspNext(jsp);
	}

	protected void readJspPage(HttpServletRequest request) {
	}
	
	protected void specialCommand(HttpServletRequest request,HttpServletResponse response)
	throws Exception {
		super.specialCommand(request,response);
	    LjResultsManager eM = (LjResultsManager) manager;
		String subcmd = request.getParameter("subcmd");
		if (subcmd.equals(LjResults.SUB_CMD_BACK)) {
			readJspPage(request);
			int pg = eM.getPage();
			if (pg > 1) {
				eM.setPage(pg-1);
				String jsp = ((ClientLjResults) client).getUriJSPLiveJournal("page" + eM.getPage() + ".jsp");
				super.setJspNext(jsp);
			}
		}
		else if (subcmd.equals(LjResults.SUB_CMD_NEXT)) {
			readJspPage(request);
			int pg = eM.getPage();
			if (pg < 3) {
				eM.setPage(pg+1);
				String jsp = ((ClientLjResults) client).getUriJSPLiveJournal("page" + eM.getPage() + ".jsp");
				super.setJspNext(jsp);
			}
		}
	}
	
	protected void navigate(HttpServletRequest request, String jsp) {
		String subcmd = request.getParameter("subcmd");
		if (subcmd.equals(LjResults.SUB_CMD_NEXT) || subcmd.equals(LjResults.SUB_CMD_BACK) || 
			subcmd.equals(LjResults.SUB_CMD_FIRST) || subcmd.equals(LjResults.SUB_CMD_LAST)) {
			
	    	jsp = ((ClientLjResults) client).getUriJSPLiveJournal(jsp);
	        super.setJspNext(jsp);

		}
	}

}
