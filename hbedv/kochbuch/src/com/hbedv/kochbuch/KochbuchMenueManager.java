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
import com.hbedv.db.kochbuch.KochbuchBean;
import com.hbedv.frame.AliceSortMap;
import com.hbedv.frame.AliceSortOrder;
import com.hbedv.frame.Aspect;
import com.hbedv.frame.Client;
import com.hbedv.frame.MenueManager;

/**
 * @author hubert
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class KochbuchMenueManager extends MenueManager {

    
    private AliceSortMap asmMenue = null;
    
    public void setAsmMenue (AliceSortMap asm) {
        asmMenue = asm;
    }
    
    public AliceSortMap getAsmMenue () {
        return asmMenue;
    }
    
    /**
     * @param clientNew
     */
    public KochbuchMenueManager(Client clientNew) {
        super(clientNew);

        ConnectionWrapper connection = null;
        KochbuchBean kb = new KochbuchBean();
        try {
            connection = getDB().getConnection();
	    
	        AliceSortMap asm = kb.readMenues(connection);
	         
	        int[] sortOrder = {KochbuchBean.AsmMenue.KEY_SORT};
	        AliceSortOrder aso = asm.createAliceSortOrderContainer(sortOrder);
	        asm.sortListAsc(aso);
	        	        
	        connection.close();
	        setAsmMenue(asm);
	    }
	    catch (SQLException e) {
            e.printStackTrace();
        }
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
