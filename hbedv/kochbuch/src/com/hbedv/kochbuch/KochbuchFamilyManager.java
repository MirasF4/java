/*
 * Created on 07.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.kochbuch;

import java.sql.SQLException;

import com.hbedv.db.ConnectionWrapper;
import com.hbedv.db.DB;
import com.hbedv.db.kochbuch.DBKochbuch;
import com.hbedv.frame.Aspect;

/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class KochbuchFamilyManager extends KochbuchManager {

    /**
     * @param clientNew
     */
    public KochbuchFamilyManager(ClientKochbuch clientNew) {
        super(clientNew);
    }
    
    
	public DB getDB() throws SQLException {
	    return new DBKochbuch();
	}

    /* (non-Javadoc)
     * @see com.hbedv.frame.Manager#existsValues(com.hbedv.db.ConnectionWrapper, java.lang.Object, com.hbedv.frame.Aspect)
     */
    public boolean existsValues(ConnectionWrapper connection, Object bez, Aspect aspects) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    
  
    
}
