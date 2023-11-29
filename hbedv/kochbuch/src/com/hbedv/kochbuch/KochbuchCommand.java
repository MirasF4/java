/*
 * Created on 24.07.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.kochbuch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbedv.db.kochbuch.KochbuchBean;
import com.hbedv.frame.AliceSortMap;
import com.hbedv.frame.AliceSortMapContainer;
import com.hbedv.frame.BodyCommand;
import com.hbedv.frame.Util;


/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class KochbuchCommand extends BodyCommand {

	
	public KochbuchCommand(String newNext) {
		super(newNext);
	}

	protected void setManager() {
		
	}
	
	protected synchronized void writeLog(HttpServletRequest request)
	throws Exception {

		AliceSortMap asm = KochbuchBean.AsmLog.getEmptyASM();
		AliceSortMapContainer asmc = asm.getEmptyAliceSortMapContainer();
		
		String localUrl = (String) Util.nvl(request.getLocalAddr(),"NULL");
		Integer localPort = new Integer(request.getLocalPort());
		String remoteAddr = (String) Util.nvl(request.getRemoteAddr(),"NULL");
		String remoteHost = (String) Util.nvl(request.getRemoteHost(),"NULL");
		Integer remotePort = new Integer(request.getRemotePort());
		String sessionId = (String) Util.nvl(request.getRequestedSessionId(),"NULL");
		String requestURI = (String) Util.nvl(request.getRequestURI(),"NULL");
		String requestUrl = (String) Util.nvl(request.getRequestURL().toString(),"NULL");
		String servername = (String) Util.nvl(request.getServerName(),"NULL");
		String cmd = (String) Util.nvl(request.getParameter("cmd"),"NULL");
		String subcmd = (String) Util.nvl(request.getParameter("subcmd"),"NULL");
		String user = (String) Util.nvl(((ClientKochbuch) client).getUserName(),"NULL");
		if (user.equals("")) user = "NULL";

		asmc.setKey(KochbuchBean.AsmLog.KEY_LOCAL_ADDR,localUrl);
		asmc.setKey(KochbuchBean.AsmLog.KEY_LOCAL_PORT,localPort);
		asmc.setKey(KochbuchBean.AsmLog.KEY_REMOTE_ADDR,remoteAddr);
		asmc.setKey(KochbuchBean.AsmLog.KEY_REMOTE_HOST,remoteHost);
		asmc.setKey(KochbuchBean.AsmLog.KEY_REMOTE_PORT,remotePort);
		asmc.setKey(KochbuchBean.AsmLog.KEY_SESSION_ID,sessionId);
		asmc.setKey(KochbuchBean.AsmLog.KEY_REQUEST_URI,requestURI);
		asmc.setKey(KochbuchBean.AsmLog.KEY_REQUEST_URL,requestUrl);
		asmc.setKey(KochbuchBean.AsmLog.KEY_SERVERNAME,servername);
		asmc.setKey(KochbuchBean.AsmLog.KEY_CMD,cmd);
		asmc.setKey(KochbuchBean.AsmLog.KEY_SUBCMD,subcmd);
		asmc.setKey(KochbuchBean.AsmLog.KEY_USER,user);
		asm.add(asmc);
				
		KochbuchManager eM = (KochbuchManager) manager;
		eM.writeLog(asm);
	}
	
	protected synchronized void init(HttpServletRequest request)
	throws Exception {
		super.init(request);
		this.writeLog(request);
	}
	
	protected void specialCommand(HttpServletRequest request,HttpServletResponse response)
	throws Exception { 
	    super.specialCommand(request,response);
	    this.writeLog(request);
	    KochbuchManager eM = (KochbuchManager) manager;
		String subcmd = request.getParameter("subcmd");
		if (subcmd.equals(Kochbuch.SUB_CMD_BACK)) {
		    eM.computeAsmRow(-1);
		    eM.readRezept(eM.getAsmRow());
		}
		else if (subcmd.equals(Kochbuch.SUB_CMD_NEXT)) {
		    eM.computeAsmRow(1);
		    eM.readRezept(eM.getAsmRow());
		}
		else if (subcmd.equals(Kochbuch.SUB_CMD_FIRST)) {
		    eM.setAsmRow(0);
		    eM.readRezept(eM.getAsmRow());
		}
		else if (subcmd.equals(Kochbuch.SUB_CMD_LAST)) {
		    eM.setAsmRow(eM.getAsmRezeptListe().getSize()-1);
		    eM.readRezept(eM.getAsmRow());
		}
		else if (subcmd.equals(Kochbuch.SUB_CMD_PRINT_REZEPT)) {
		    String jsp = ((ClientKochbuch) client).getUriJSPKochbuch("print_rezept.jsp");
			super.setJspNext(jsp);
		}
	}
	
	protected void navigate(HttpServletRequest request, String jsp) {
		String subcmd = request.getParameter("subcmd");
		if (subcmd.equals(Kochbuch.SUB_CMD_NEXT) || subcmd.equals(Kochbuch.SUB_CMD_BACK) || 
			subcmd.equals(Kochbuch.SUB_CMD_FIRST) || subcmd.equals(Kochbuch.SUB_CMD_LAST)) {
			
	    	jsp = ((ClientKochbuch) client).getUriJSPKochbuch(jsp);
	        super.setJspNext(jsp);

		}
	}
	
}
