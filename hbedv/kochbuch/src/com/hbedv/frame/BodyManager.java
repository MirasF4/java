
package com.hbedv.frame;

import com.hbedv.db.DB;

import java.sql.SQLException;


public abstract class BodyManager extends Manager {
    
    private boolean initialized = false;
    
    public BodyManager(Client clientNew) {
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
