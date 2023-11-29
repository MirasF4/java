/*
 * Created on 20.10.2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.hbedv.frame;

import com.hbedv.db.DB;

import java.sql.SQLException;


public abstract class MenueManager extends Manager {
    
    private boolean initialized = false;
    
    public MenueManager(Client clientNew) {
        super(clientNew);
    }


	public DB getDB() throws SQLException {
	    return null;
	}

	public boolean isInitialized() {
	    return initialized;
	}
	
	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}
  
}
