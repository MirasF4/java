/*
 * Created on 13.01.2005
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.hbedv.db;

/**
 * @author woi
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public interface IRepository {
	boolean fromDB  = false;
	
	public boolean isFromDB();

	public void setFromDB(boolean b);

}
