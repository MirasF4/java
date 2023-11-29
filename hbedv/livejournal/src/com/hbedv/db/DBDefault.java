package com.hbedv.db;

/**
 *  <Description of the Class>
 *
 *@Source      $Source: D:/cvs_src/java/hbedv/livejournal/WEB-INF/src/com/hbedv/db/DBDefault.java,v $
 *@Revision    $Revision: 1.1.1.1 $
 *@Change      Last Change: $Author: hubert $; $Date: 2006/02/25 12:28:42 $
 *@created     mac; 05. Juli 2002
 */
public class DBDefault extends DB {

  //private java.sql.Statement statement = null;
  //final static String REPOSITORY_DEFAULT = "java:comp/env/jdbc/REPOSITORY_ALICE";
  
  //final static String REPOSITORY_DEFAULT = "sun.jdbc.odbc.JdbcOdbcDriver";
  final static String REPOSITORY_DEFAULT = "";
  /**
   *  Constructor for the DBAlice object
   *
   *@exception  RepositoryException  Description of Exception
   */
  public DBDefault() {
    repositoryName = DBDefault.REPOSITORY_DEFAULT;
  }


  /**
   *  Gets the connection attribute of the DBAlice object
   *
   *@return                          The connection value
   *@exception  java.lang.Exception  Description of Exception
   */
  public synchronized ConnectionWrapper getConnection() throws RepositoryException {
    return null;
  }
}
