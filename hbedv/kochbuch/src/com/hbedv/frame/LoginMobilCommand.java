/*
 * Created on 24.07.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.frame;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LoginMobilCommand extends Command {

	/**
	 * @param newNext
	 */
	public LoginMobilCommand(String newNext) {
		super(newNext);
	}

	/* (non-Javadoc)
	 * @see com.hbedv.frame.Command#setManager()
	 */
	protected void setManager() {
		super.manager = client.getLoginMobilManager();
		client.setLoginMobilManagerAsManagerNeu();
	}

	protected synchronized void init(HttpServletRequest request)
	throws Exception {
		super.init(request);
		//LoginMobilManager pM = (LoginMobilManager) manager;
		client.setMobileVersion(true);
		super.setJspNext("template.jsp");
		
	}
}
