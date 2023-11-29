/*
 * Created on 24.07.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.frame;

import java.sql.SQLException;

import com.hbedv.db.ConnectionWrapper;
import com.hbedv.db.DB;

/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LoginAllManager extends Manager {

	/**
	 * @param newClient
	 */
	public LoginAllManager(Client newClient) {
		super(newClient);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.hbedv.frame.Manager#getDB()
	 */
	public DB getDB() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hbedv.frame.Manager#existsValues(com.hbedv.db.ConnectionWrapper, java.lang.Object, com.hbedv.frame.Aspect)
	 */
	public boolean existsValues(ConnectionWrapper connection, Object bez,
			Aspect aspects) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
