package com.hbedv.db;

//import org.apache.log4j.*;

import java.sql.*;
import javax.sql.*;

/**
 *  <p>
 *
 *  Title: </p> <p>
 *
 *  Description: </p> <p>
 *
 *  Copyright: Copyright (c) 2001</p> <p>
 *
 *  Company: poi.fux</p>
 *
 *@Source      $Source: D:/cvs_src/java/hbedv/lj_results/WEB-INF/src/com/hbedv/db/ConnectionWrapper.java,v $
 *@Revision    $Revision: 1.1.1.1 $
 *@Change      Last Change: $Author: hubert $; $Date: 2006/02/25 12:28:42 $
 *@author      unascribed
 *@created     orn; 10. Oktober 2002
 *@version     1.0
	Last change: PIG 27.11.2007 16:33:55
 */

public class ConnectionWrapper {
  private Connection connection = null;

  //static Category LOG = Category.getInstance(ConnectionWrapper.class.getName());

  /**
   *  Constructor for the Connection object
   *
   *@param  newDataSource  Description of Parameter
   */
  public ConnectionWrapper(DataSource newDataSource) throws SQLException{
    connection = newDataSource.getConnection();
  }



  /**  Constructor for the ConnectionWrapper object */
  //private ConnectionWrapper() { }



  /**
   *  Gets the metaData attribute of the ConnectionWrapper object
   *
   *@return                The metaData value
   *@exception  Exception  Description of Exception
   */
  public DatabaseMetaData getMetaData()
    throws SQLException {
    return connection.getMetaData();
  }


  /**
   *  Sets the autoCommit attribute of the ConnectionWrapper object
   *
   *@param  autocommit     The new autoCommit value
   *@exception  Exception  Description of Exception
   */
  public void setAutoCommit(boolean autocommit)
    throws SQLException {
    connection.setAutoCommit(autocommit);
  }


  /**
   *  Description of the Method
   *
   *@exception  Exception  Description of Exception
   */
  public void commit()
    throws SQLException {
    connection.commit();
  }


  /**
   *  Description of the Method
   *
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  public Statement createStatement()
    throws SQLException {
    return connection.createStatement();
  }


  /**
   *  Description of the Method
   *
   *@exception  Exception  Description of Exception
   */
  public void rollback()
    throws SQLException {
    connection.rollback();
  }


  /**
   *  Description of the Method
   *
   *@param  sql            Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  public PreparedStatement prepareStatement(String sql)
    throws SQLException {
    //long start = System.currentTimeMillis();
    PreparedStatement tmp = connection.prepareStatement(sql);
    return tmp;
  }


  /**
   *  Description of the Method
   *
   *@param  sql            Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  public PreparedStatement prepareCall(String sql)
    throws SQLException {
    return connection.prepareCall(sql);
  }


  /**
   *  Description of the Method
   *
   *@exception  Exception  Description of Exception
   */
  public synchronized void close()
    throws SQLException {
    if (connection != null) {
      connection.close();
      connection = null;
    }
  }

  public Connection getConnection() {

    return this.connection;

  }


}

