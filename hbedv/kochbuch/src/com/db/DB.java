package com.hbedv.db;

import javax.naming.*;
import javax.sql.DataSource;

import java.sql.*;
/**
 *  $Source: D:/cvs_src/java/hbedv/kochbuch/WEB-INF/src/com/hbedv/db/DB.java,v $
 *
 *@Source      $Source: D:/cvs_src/java/hbedv/kochbuch/WEB-INF/src/com/hbedv/db/DB.java,v $
 *@Revision    $Revision: 1.1.1.1 $
 *@Change      Last Change: $Author: hubert $; $Date: 2006/02/25 12:28:42 $
 *@author      ORN; created: 2001/01/01 Last Change: $Author: hubert $; $Date: 2006/02/25 12:28:42 $
 *@created     kla; 1. Oktober 2002
 *@short       abstract Klasse welche für alle benutzten DBs die Methoden vorgibt;
 *      $Revision: 1.1.1.1 $
 */
public abstract class DB {
  protected InitialContext context = null;
  protected DataSource dataSource = null;
  protected String repositoryName = null;
  /**
   *  Gets the connection attribute of the DB object
   *
   *@return                The connection value
   *@exception  Exception  Description of Exception
   */
  public synchronized ConnectionWrapper getConnection()
    throws RepositoryException{
    ConnectionWrapper cw = null;
    try {
      cw = new ConnectionWrapper(getDataSource());
    }
    catch (SQLException e) {
      throw new RepositoryException(RepositoryException.CONNECTION_REFUSED);
    }
    return cw;
  }
  /**  Description of the Method */
  public synchronized void finalize() {
    try {
      if (context != null) {
        context = null;
      }
      if (dataSource != null) {
        dataSource = null;
      }
    }
    catch (Exception e) {
      //MsgLogger.instance().printlnExceptionLog(e);
    }
  }
  /**
   *  Hole die DataSource die via JRun verwaltet werden.
   *
   *@return                The dataSource value
   *@exception  Exception  Description of Exception
   */
  public synchronized DataSource getDataSource() { 
  
      return null;
  };
  
}



/************************************************************************************/
/* Das vorliegende JAVA-Programm realisiert einen einfachen UPDATE-Zugriff auf eine */
/* relationale Datenbank (MS-Access 7.0).                                           */
/*                                                                                  */
/* Das Programm muss in der folgenden Form aufgerufen werden:                       */
/*                                                                                  */
/* java accjdbc2 [Kennwort] [Kundennummer] [Vorname] [Nachname]                     */
/*                                                                                  */
/* Erstellt: 30.10.1997                                                             */
/* Copyright 1997 by Jens Hartwig                                                   */
/************************************************************************************/

/**
// Notwendige Klassen importieren
import java.sql.*;

// Klassendefinition
class accjdbc2 {

    static int      lv_retval = 0;      // Rueckgabewert des Update-Statements
    static String   update_str;         // Term fuer das Update-Statement

    public static void  main(String args[]) {

        // Programminformationen ausgeben:
        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("* Programm:       accjdbc2                                  *");
        System.out.println("* Zweck:          UPDATE-Zugriff auf MS-Access-Datenbank    *");
        System.out.println("* Version:        1.0                                       *");
        System.out.println("* Erstellt am:    30.10.1997                                *");
        System.out.println("* Copyright by:   Jens Hartwig, 1997                        *");
        System.out.println("*************************************************************");
        System.out.println();

        // Pruefen, ob genug Parameter eingegeben wurden
        if(args.length != 4) {
            System.out.println("=============================================================================");
            System.out.println("ERROR: Aufrufsyntax nicht korrekt.");
            System.out.println("INFO:  Aufrufsyntax: java accjdbc2 [Kennwort] [Kundennummer] [Vorname] [Nachname]");
            System.out.println("=============================================================================");
            System.exit(-1);
        }

        try {

            // 1. JDBC-Treiber laden
            Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");

            // 2. Datenbank-URL spezifizieren
            String db_url = "jdbc:odbc:jdbc_test";

            // 3. Connect zur Datenbank ausführen (Kennwort muss beim Programmaufruf uebergeben werden)
            Connection my_con = DriverManager.getConnection(db_url, "java", args[0]);
            System.out.println("=========================================================");
            System.out.println("INFO: Verbindung zur Datenbank erfolgreich durchgefuehrt.");
            System.out.println("---------------------------------------------------------");

            // 4. Statement erzeugen
            Statement my_stmt = my_con.createStatement();

            // 5. Updateterm als String festlegen
            update_str = "UPDATE t_kunden SET name = '" + args[3] + "', vorname = '" + args[2] + "' WHERE kdnr = " + args[1];

            // 6. Update ausfuehren
            lv_retval = my_stmt.executeUpdate(update_str);
            if(lv_retval > 0) {
                System.out.println(lv_retval + " Saetze in der Datenbank geaendert.");
                System.out.println("---------------------------------------------------------");
            }
            else {
                System.out.println("Es konnte kein Satz geaendert werden.");
                System.out.println("---------------------------------------------------------");
            }

            // 8. Connect zur Datenbank beenden
            my_con.close();
            System.out.println("INFO: Verbindung zur Datenbank geschlossen.");
            System.out.println("=========================================================");
            System.out.println();
        }
        // Ggf. aufgetretene Exceptions abfangen
        catch(SQLException my_sqlex) {
            System.out.println("**************************************************************************");
            System.out.println("ERROR: Datenbankfehler: " + my_sqlex.getMessage());
            System.out.println("--------------------------------------------------------------------------");
            my_sqlex.printStackTrace();
            System.out.println("**************************************************************************");
        }
        catch(Exception my_ex) {
            System.out.println("**************************************************************************");
            System.out.println("ERROR: Sonstiger Fehler: " + my_ex.getMessage());
            System.out.println("--------------------------------------------------------------------------");
            my_ex.printStackTrace();
            System.out.println("**************************************************************************");
        }
    }
}

**/