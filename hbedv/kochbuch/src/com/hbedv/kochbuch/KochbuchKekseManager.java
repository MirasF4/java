/*
 * Created on 07.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.hbedv.kochbuch;

import com.hbedv.db.ConnectionWrapper;
import com.hbedv.frame.Aspect;

/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class KochbuchKekseManager extends KochbuchManager {

    /**
     * @param clientNew
     */
    public KochbuchKekseManager(ClientKochbuch clientNew) {
        super(clientNew);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see com.hbedv.frame.Manager#existsValues(com.hbedv.db.ConnectionWrapper, java.lang.Object, com.hbedv.frame.Aspect)
     */
    public boolean existsValues(ConnectionWrapper connection, Object bez, Aspect aspects) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

}
