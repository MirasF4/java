package com.hbedv.db.lj_results;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hbedv.db.ConnectionWrapper;
import com.hbedv.db.DB;
import com.hbedv.db.RepositoryException;

/**
 *  <Description of the Class>
 *
 *@Source      $Source: D:/cvs_src/java/hbedv/lj_results/WEB-INF/src/com/hbedv/db/lj_results/DBlj_results.java,v $
 *@Revision    $Revision: 1.1.1.1 $
 *@Change      Last Change: $Author: hubert $; $Date: 2006/02/25 12:28:43 $
 *@created     mac; 05. Juli 2002
	Last change: PIG 27.11.2007 16:33:56
 */
public class DBLiveJournal extends DB {

    //private java.sql.Statement statement = null;
    //final static String REPOSITORY_DEFAULT = "java:comp/env/jdbc/REPOSITORY_ALICE";

    public DBLiveJournal() {
        //repositoryName = DBlj_results.REPOSITORY_lj_results;
    }


    public synchronized DataSource getDataSource() {
        if (dataSource == null) {
            try {
                context = new InitialContext();
                dataSource = new DataSource() {
                    public Connection getConnection() throws SQLException {
                        try {
                            // TODO Auto-generated method stub
                            Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
                        }
                        catch (ClassNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        String db_url = "jdbc:odbc:LiveJournal";
                        Connection my_con = DriverManager.getConnection(db_url);
                        return my_con;
                    }
                    
                    public Connection getConnection(String username, String password)
                    throws SQLException {
                        // TODO Auto-generated method stub
                        return null;
                    }
                    
                    public PrintWriter getLogWriter() throws SQLException {
                        // TODO Auto-generated method stub
                        return null;
                    }
                    
                    public void setLogWriter(PrintWriter out) throws SQLException {
                        // TODO Auto-generated method stub
                    }
                    
                    public void setLoginTimeout(int seconds) throws SQLException {
                        // TODO Auto-generated method stub
                    }
                    
                    public int getLoginTimeout() throws SQLException {
                        // TODO Auto-generated method stub
                        return 0;
                    }

					@Override
					public boolean isWrapperFor(Class<?> arg0)
							throws SQLException {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public <T> T unwrap(Class<T> arg0) throws SQLException {
						// TODO Auto-generated method stub
						return null;
					}
                };
            }
            catch (NamingException nEx) {
                nEx.printStackTrace();
            }
        }
        return dataSource;
    }
 
  

    public synchronized ConnectionWrapper getConnection() throws RepositoryException {
        ConnectionWrapper cw = null;
        try {
            cw = new ConnectionWrapper(getDataSource());
        }
        catch (SQLException e) {
            throw new RepositoryException(RepositoryException.CONNECTION_REFUSED);
        }
        return cw;
    }
}
