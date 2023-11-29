package com.hbedv.db;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import com.hbedv.frame.AliceSortMap;
import com.hbedv.frame.Aspect;
import com.hbedv.frame.Money;

/**
 *  <Description of the Class>
 *
 *@Source      $Source: D:/cvs_src/java/hbedv/livejournal/WEB-INF/src/com/hbedv/db/Repository.java,v $
 *@Revision    $Revision: 1.1.1.1 $
 *@Change      Last Change: $Author: hubert $; $Date: 2006/02/25 12:28:42 $
 *@created     orn; 12. April 2002
 */
@SuppressWarnings("unchecked")
public abstract class Repository {

// definiert für Datenbankzugriffe Aspect
  /**  Description of the Field */
  public final static Integer QUICK = new Integer(1);
  /**  Description of the Field */
  public final static Integer DETAIL = new Integer(2);

  /**  Description of the Field */
  public final static char DB_JA = 'J';
  /**  Description of the Field */
  public final static char DB_NEIN = 'N';
  /**
   *@todo    orn static raus
   */
  protected static ResourceBundle sQLResource = null;

  //static Category logger = Category.getInstance(Repository.class.getName());

  /**
   *  HELPER - Methoden für die Verbinder-Tabellen-Sortmaps (lesen & schreiben) Das
   *  SEL - Statement für das PreparedStatement muss folgenden SELECT-Struktur aufweisen:
   *  SELECT details.id, details.bez, details.hasId FROM details, outer verbinder
   *  where details.id = verbinder.detailid and verbinder.key = ? Struktur der Alice-Sortmap
   *  wie folgt: sortMap.key(0) : ID des Master - Objects (sollte durchgehend gleich
   *  sein) sortMap.key(1) : ID's der Details sortMap.key(2) : Bezeichnung der Details
   *  sortMap.key(3) : Boolean, ob gesetzt oder nicht (wenn true gibts eintrag in
   *  detail-Tabelle) sortMap.value(1) : Boolean, ob nach einlesen geändert wurde
   *  ( z.Zt. nicht unterstützt)
   */

  private final static int COLUMN_MASTERID = 0;
  protected MessageFormat messageFormater = null;
  protected DBDefault defaultDatabase = null;
  private boolean fromDB = false;


  /**
   *  Constructor for the Repository object
   *
   *@exception  MissingResourceException  Description of Exception
   */
  public Repository()
    throws MissingResourceException {
    /**
     *@todo    orn rausnehmen
     */
    messageFormater = new MessageFormat("");
    sQLResource = ResourceBundle.getBundle("com.hbedv.db.SQLResource");
  }


  /**
   *  Description of the Method
   *
   *@param  swi  Description of Parameter
   *@return      Description of the Returned Value
   */
  public static String convert2AliceDBJA_NEIN(Boolean swi) {
    return swi.booleanValue() ? DB_JA + "" : DB_NEIN + "";
  }


  /**
   *@param  resultSet         Description of Parameter
   *@param  columneName       Description of Parameter
   *@return                   wenn wasNull: ""; sonst den Wert ohne blanks, hinten
   *      und vorne!
   *@exception  SQLException  Description of Exception
   */
  public static String formatStringFromDB(ResultSet resultSet, String columneName)
    throws SQLException {

    String columneValue = resultSet.getString(columneName);
    return resultSet.wasNull() ? "" : columneValue.trim();
  }


  /**
   *@param  resultSet         Description of Parameter
   *@param  columneName       Description of Parameter
   *@return                   wenn "J": true; sonst false
   *@exception  SQLException  Description of Exception
   */
  public static boolean formatStringFromDB2Boolean(ResultSet resultSet, String columneName)
    throws SQLException {
    return (formatStringFromDB(resultSet, columneName).equals(DB_JA + ""));
  }


  /**
   *  Description of the Method
   *
   *@param  dBJN           Description of Parameter
   *@return                Description of the Returned Value
   */
  public static Boolean convertAliceDBJA_NEIN2Boolean(String dBJN) {
    if (dBJN == null)
      return null;
    else if (dBJN.equals(DB_JA + ""))
      return new Boolean(true);
    else if (dBJN.equals(DB_NEIN + ""))
      return new Boolean(false);
    else
      throw new NoSuchElementException("? :-( J/N" + dBJN);
  }


  
//Helper========================================================================
  /**
   *  Hole von dieser ConnectionWrapper, nach einem insert (tabelle hat serial) den
   *  von der DB vergebenen Serialwert.
   *
   *@param  connection        Description of Parameter
   *@param  sequenceName      Description of Parameter
   *@return                   The lastSerial value
   *@exception  SQLException  Description of Exception
   */
  public synchronized int getLastSerial(ConnectionWrapper connection, Object sequenceName)
    throws SQLException {

    ResultSet rs = null;
    int serialValue = 0;
    Statement stmt = connection.createStatement();
    try {
      stmt.executeQuery("SELECT " + sequenceName + ".currval AS seqValue FROM dual ");
      rs = stmt.getResultSet();
      if (rs.next())
        serialValue = rs.getInt(1);

    }
    finally {
      stmt.close();
    }
    return serialValue;
  }


  /**
   *  Ist der Eintrag (dein abgeleitetes Bean) aus der DB.
   *
   *@return    The fromDB value
   */
  public boolean isFromDB() {
    return fromDB;
  }


  /**
   *  Gets the integer attribute of the Repository object
   *
   *@param  rs                Description of Parameter
   *@param  spaltenName       Description of Parameter
   *@return                   The integer value
   *@exception  SQLException  Description of Exception
   */
  public synchronized Integer getInteger(ResultSet rs, String spaltenName)
    throws SQLException {
    int x = rs.getInt(spaltenName);
    return (rs.wasNull() ? null : new Integer(x));
  }


  /**
   *  Gets the float attribute of the Repository object
   *
   *@param  rs                Description of Parameter
   *@param  spaltenName       Description of Parameter
   *@return                   The float value
   *@exception  SQLException  Description of Exception
   */
  public synchronized Float getFloat(ResultSet rs, String spaltenName)
    throws SQLException {
    float x = rs.getFloat(spaltenName);
    return (rs.wasNull() ? null : new Float(x));
  }


  /**
   *  Gets the double attribute of the Repository object
   *
   *@param  rs                Description of Parameter
   *@param  spaltenName       Description of Parameter
   *@return                   The double value
   *@exception  SQLException  Description of Exception
   */
  public synchronized Double getDouble(ResultSet rs, String spaltenName)
    throws SQLException {
    double x = rs.getDouble(spaltenName);
    return (rs.wasNull() ? null : new Double(x));
  }


  /**
   *  Gets the boolean attribute of the Repository object
   *
   *@param  rs                Description of Parameter
   *@param  spaltenName       Description of Parameter
   *@return                   The boolean value
   *@exception  SQLException  Description of Exception
   */
  public synchronized Boolean getBoolean(ResultSet rs, String spaltenName)
    throws SQLException {
    String str = rs.getString(spaltenName);
    return (rs.wasNull() ? null : new Boolean(str));
  }


  /**
   *  Gets the boolean attribute of the Repository object
   *
   *@param  rs                Description of Parameter
   *@param  spaltenName       Description of Parameter
   *@return                   The boolean value
   *@exception  SQLException  Description of Exception
   */
  public synchronized Boolean getBooleanJN(ResultSet rs, String spaltenName)
    throws SQLException {
    String str = rs.getString(spaltenName);
    return (rs.wasNull() ? null : new Boolean(str.equals(Repository.DB_JA + "")));
  }


  /**
   *  Gets the date attribute of the Repository object
   *
   *@param  rs                Description of Parameter
   *@param  spaltenName       Description of Parameter
   *@return                   The date value
   *@exception  SQLException  Description of Exception
   */
  public synchronized java.sql.Date getDate(ResultSet rs, String spaltenName)
    throws SQLException {
    java.sql.Date x = rs.getDate(spaltenName);
    return (rs.wasNull() ? null : x);
  }


  /**
   *  Gets the character attribute of the Repository object
   *
   *@param  rs                Description of Parameter
   *@param  spaltenName       Description of Parameter
   *@return                   The character value
   *@exception  SQLException  Description of Exception
   */
  public synchronized Character getCharacter(ResultSet rs, String spaltenName)
    throws SQLException {

    String x = rs.getString(spaltenName);
    return (rs.wasNull() ? null : new Character(x.charAt(0)));
  }


  /**
   *  Gets the char attribute of the Repository object
   *
   *@param  rs                Description of Parameter
   *@param  spaltenName       Description of Parameter
   *@return                   The char value
   *@exception  SQLException  Description of Exception
   */
  public synchronized char getChar(ResultSet rs, String spaltenName)
    throws SQLException {

    String x = rs.getString(spaltenName);
    return (rs.wasNull() ? ' ' : x.charAt(0));
  }


  /**
   *  Gets the string attribute of the Repository object
   *
   *@param  rs                Description of Parameter
   *@param  spaltenName       Description of Parameter
   *@return                   The string value
   *@exception  SQLException  Description of Exception
   */
  public synchronized String getString(ResultSet rs, String spaltenName)
    throws SQLException {

    String x = rs.getString(spaltenName);
    return (rs.wasNull() ? null : x);
  }


  /**
   *  Gets the stringTrimed attribute of the Repository object
   *
   *@param  rs                Description of Parameter
   *@param  spaltenName       Description of Parameter
   *@return                   The stringTrimed value
   *@exception  SQLException  Description of Exception
   */
  public synchronized String getStringTrimed(ResultSet rs, String spaltenName)
    throws SQLException {

    String x = rs.getString(spaltenName);
    return (rs.wasNull() ? null : x.trim());
  }


  /**
   *  Sets the fromDB attribute of the Repository object
   *
   *@param  fromDB  The new fromDB value
   */
  public void setFromDB(boolean fromDB) {
    this.fromDB = fromDB;
  }


  /**
   *  Description of the Method
   *
   *@param  connection        Description of Parameter
   *@param  aspects           Description of Parameter
   *@exception  SQLException  Description of Exception
   */
  public void write(ConnectionWrapper connection, Aspect aspects)
    throws SQLException {
    throw new UnsupportedOperationException("Not implemented yet!");
  }


  /**
   *  Inserte je nach Aspect "auf der ConnectionWrapper" deinen Eintrag (dein abgeleitetes
   *  Bean) in die DB.
   *
   *@param  connection        Description of Parameter
   *@param  aspects           Description of Parameter
   *@exception  SQLException  Description of Exception
   */
  public void insert(ConnectionWrapper connection, Aspect aspects)
    throws SQLException {
    throw new UnsupportedOperationException("Not implemented yet!");
  }


  /**
   *  Delete je nach Aspect "auf der ConnectionWrapper" Eintraege in der DB.
   *
   *@param  connection        Description of Parameter
   *@param  aspects           Description of Parameter
   *@exception  SQLException  Description of Exception
   */
  public void delete(ConnectionWrapper connection, Aspect aspects)
    throws SQLException {
    throw new UnsupportedOperationException("Not implemented yet!");
  }


  /**
   *  Update je nach Aspect "auf der ConnectionWrapper" deinen Eintrag (dein abgeleitetes
   *  Bean) in die DB.
   *
   *@param  connection        Description of Parameter
   *@param  aspects           Description of Parameter
   *@exception  SQLException  Description of Exception
   */
  public void update(ConnectionWrapper connection, Aspect aspects)
    throws SQLException {
    throw new UnsupportedOperationException("Not implemented yet!");
  }


  /**
   *  Read je nach Aspect "auf der ConnectionWrapper" aus der DB.
   *
   *@param  connection        Description of Parameter
   *@param  aspects           Description of Parameter
   *@exception  SQLException  Description of Exception
   */
  public abstract void read(ConnectionWrapper connection, Aspect aspects)
    throws SQLException;


  /**
   *  Exists je nach Aspect "auf der ConnectionWrapper" in der DB der Eintrag (dein
   *  abgeleitetes Bean).
   *
   *@param  connection        Description of Parameter
   *@param  aspects           Description of Parameter
   *@return                   Description of the Returned Value
   *@exception  SQLException  Description of Exception
   */
  public boolean exists(ConnectionWrapper connection, Aspect aspects)
    throws SQLException {
    throw new UnsupportedOperationException("Not implemented yet!");
  }


  /**
   *  Sets the selectionMapKey attribute of the Repository object
   *
   *@param  selectionMap   The new selectionMapKey value
   *@param  key            The new selectionMapKey value
   */
  protected synchronized void setSelectionMapKey(AliceSortMap selectionMap, Object key) {

    if (selectionMap == null)
      throw new NullPointerException("selectionMap == null");
    if (key == null)
      throw new NullPointerException("key == null");

    for (int i = 0; i < selectionMap.getSize(); i++)
      selectionMap.getKeys(COLUMN_MASTERID).set(i, key);

  }


  /**
   *  Description of the Method
   *
   *@param  rs                Description of Parameter
   *@param  aspects           Description of Parameter
   *@exception  SQLException  Description of Exception
   */
  protected abstract void fillMe(final ResultSet rs, final Aspect aspects)
    throws SQLException;


  /**
   *@param  prepareStatement         Description of Parameter
   *@exception  SQLException         Description of Exception
   */
  protected synchronized void executeUpdate(PreparedStatement prepareStatement)
    throws SQLException {
    //int recordsChanged = Util.UNDEFINED_INT;
    try {
    	prepareStatement.executeUpdate();
    }
    catch (SQLException se) {
        throw se;
    }
  }


  /**
   *  Description of the Method
   *
   *@param  prepareStatement         Description of Parameter
   *@return                          Description of the Returned Value
   *@exception  SQLException         Description of Exception
   *@exception  RepositoryException  Description of Exception
   */
  protected synchronized ResultSet executeQuery(PreparedStatement prepareStatement)
    throws SQLException {
    ResultSet resultSet = null;
    try {
      resultSet = prepareStatement.executeQuery();
    }
    catch (SQLException se) {
        throw se;
    }
    return resultSet;
  }


//Helper========================================================================
  /**
   *  Description of the Method
   *
   *@param  connection        Description of Parameter
   *@param  SQL               Description of Parameter
   *@return                   Description of the Returned Value
   *@exception  SQLException  Description of Exception
   */
  protected synchronized int max(ConnectionWrapper connection, String SQL)
    throws SQLException {
    if (defaultDatabase == null)
      throw new NullPointerException("defaultDatabase==null");
    if (sQLResource == null)
      throw new NullPointerException("sQLResource==null");

    PreparedStatement prepareStatement = null;
    ResultSet resultset = null;
    try {
      prepareStatement = connection.prepareStatement(sQLResource.getString(SQL));
      prepareStatement.executeQuery();
      resultset = prepareStatement.getResultSet();
      resultset.next();
      return resultset.getInt(1);
    }
    finally {
      prepareStatement.close();
    }
  }


  /**
   *  Description of the Method
   *
   *@param  connection        Description of Parameter
   *@param  SQL               Description of Parameter
   *@param  o                 Description of Parameter
   *@return                   Description of the Returned Value
   *@exception  SQLException  Description of Exception
   */
  protected synchronized boolean exists(ConnectionWrapper connection, String SQL, Object o)
    throws SQLException {
    if (sQLResource == null)
      throw new NullPointerException("sQLResource==null");

    PreparedStatement prepareStatement = null;
    ResultSet resultset = null;
    try {
      prepareStatement = connection.prepareStatement(SQL);
      if (o instanceof String)
        prepareStatement.setString(1, (String) o);

      else if (o instanceof Integer)
        prepareStatement.setObject(1, o);

      else
        throw new NoSuchElementException("unbekannter Typ: " + o.getClass());

      prepareStatement.executeQuery();
      resultset = prepareStatement.getResultSet();
      return resultset.next();
    }
    finally {
      prepareStatement.close();
    }
  }

//  synchronized protected void delete(String sQLResourceFileToken, Object key, ConnectionWrapper connection)
  /**
   *  Description of the Method
   *
   *@param  connection        Description of Parameter
   *@param  sQL               Description of Parameter
   *@param  key               Description of Parameter
   *@exception  SQLException  Description of Exception
   */
  protected synchronized void delete(ConnectionWrapper connection, String sQL, Object key)
    throws SQLException {
    if (sQLResource == null)
      throw new NullPointerException("sQLResource==null");
    if (key == null)
      throw new NullPointerException("key==null");
    if (sQL == null)
      throw new NullPointerException("sQLResourceFileToken==null");

    PreparedStatement prepareStatement = null;
    try {
      prepareStatement = connection.prepareStatement(sQL);
      String str = "";
      if (key.getClass().isInstance(str))
        prepareStatement.setString(1, (String) key);

      else
        prepareStatement.setObject(1, key);

      executeUpdate(prepareStatement);
    }
    finally {
      prepareStatement.close();
    }
  }


  /**
   *  Description of the Method
   *
   *@param  connection        Description of Parameter
   *@param  sQL               Description of Parameter
   *@param  values            Description of Parameter
   *@exception  SQLException  Description of Exception
   */
  protected synchronized void insert(ConnectionWrapper connection, String sQL, ArrayList values)
    throws SQLException {
    updateInsertDelete(connection, sQL, values);
  }


  /**
   *  Description of the Method
   *
   *@param  connection        Description of Parameter
   *@param  sQL               Description of Parameter
   *@param  values            Description of Parameter
   *@exception  SQLException  Description of Exception
   */
  protected synchronized void update(ConnectionWrapper connection, String sQL, ArrayList values)
    throws SQLException {
    updateInsertDelete(connection, sQL, values);
  }


  /**
   *  Description of the Method
   *
   *@param  connection        Description of Parameter
   *@param  sQL               Description of Parameter
   *@param  values            Description of Parameter
   *@exception  SQLException  Description of Exception
   */
  protected synchronized void delete(ConnectionWrapper connection, String sQL, ArrayList values)
    throws SQLException {
    updateInsertDelete(connection, sQL, values);
  }


  /**
   *  Description of the Method
   *
   *@param  prepareStatement  Description of Parameter
   *@param  values            Description of Parameter
   *@return                   Description of the Returned Value
   *@exception  SQLException  Description of Exception
   */
  protected synchronized ResultSet read(PreparedStatement prepareStatement,
                                        ArrayList values)
    throws SQLException {
    //precondition
    if (prepareStatement == null)
      throw new NullPointerException("prepeardStatement == null");

    if (values != null && values.size() > 0)
      for (int xWorker = 0; xWorker < values.size(); xWorker++)
        if (values.get(xWorker) != null) {
          if (values.get(xWorker) instanceof String)
            prepareStatement.setString(xWorker + 1, (String) values.get(xWorker));

          else if (values.get(xWorker) instanceof Money)
            prepareStatement.setDouble(xWorker + 1, ((Money) values.get(xWorker)).getMoney().doubleValue());

          else if (values.get(xWorker) instanceof Integer)
            prepareStatement.setInt(xWorker + 1, ((Integer) values.get(xWorker)).intValue());

//          else if (values.get(xWorker) instanceof Duration)
//            prepareStatement.setInt(xWorker + 1, ((Duration) values.get(xWorker)).getValue());

          else if (values.get(xWorker) instanceof Boolean)
            prepareStatement.setString(xWorker + 1, ((Boolean) values.get(xWorker)).booleanValue() == true ? DB_JA + "" : DB_NEIN + "");

          else if (values.get(xWorker) instanceof Character)
            prepareStatement.setString(xWorker + 1, ((Character) values.get(xWorker)).toString());

          else if (values.get(xWorker) instanceof java.sql.Date)
            prepareStatement.setDate(xWorker + 1, (java.sql.Date) values.get(xWorker));

          else if (values.get(xWorker) instanceof java.sql.Timestamp)
            prepareStatement.setTimestamp(xWorker + 1, (java.sql.Timestamp) values.get(xWorker));

          else if (values.get(xWorker) instanceof java.sql.Time)
            prepareStatement.setTime(xWorker + 1, (java.sql.Time) values.get(xWorker));

          else
            prepareStatement.setObject(xWorker + 1, values.get(xWorker));

        }//for
        else// java.sql.Types.VARCHAR: weil der in DB bei allen Datentypen geinserted werden kann
          // (so was wie 'automatisches cast')
          prepareStatement.setNull(xWorker + 1, java.sql.Types.VARCHAR);

          // for (int xWorker = 0; xWorker < values.size(); xWorker++)
    // if (values != null && values.size() > 0)
    //long start = System.currentTimeMillis();
    ResultSet tmp = executeQuery(prepareStatement);
  

    return tmp;
  }



  /**
   *  Description of the Method
   *
   *@param  connection        Description of Parameter
   *@param  sQL               Description of Parameter
   *@param  values            Description of Parameter
   *@exception  SQLException  Description of Exception
   */
  private synchronized void updateInsertDelete(ConnectionWrapper connection,
                                               String sQL, ArrayList values)
    throws SQLException {
    if (sQL == null)
      throw new NullPointerException("sQLResource==null");
    if (connection == null)
      throw new NullPointerException("connection==null");

    PreparedStatement prepareStatement = connection.prepareStatement(sQL);
    try {
      if (values != null)
        for (int xWorker = 0; xWorker < values.size(); xWorker++)
          if (values.get(xWorker) != null) {
            if (values.get(xWorker) instanceof String)
              prepareStatement.setString(xWorker + 1, (String) values.get(xWorker));

            else if (values.get(xWorker) instanceof Money)
              prepareStatement.setDouble(xWorker + 1, ((Money) values.get(xWorker)).getMoney().doubleValue());//Moneyxxx

//            else if (values.get(xWorker) instanceof Duration)
//              prepareStatement.setInt(xWorker + 1, ((Duration) values.get(xWorker)).getValue());

            else if (values.get(xWorker) instanceof Boolean)
              prepareStatement.setString(xWorker + 1, ((Boolean) values.get(xWorker)).booleanValue() == true ? DB_JA + "" : DB_NEIN + "");

            else if (values.get(xWorker) instanceof Character)
              prepareStatement.setString(xWorker + 1, ((Character) values.get(xWorker)).toString());

            else if (values.get(xWorker) instanceof java.sql.Date)
              prepareStatement.setDate(xWorker + 1, (java.sql.Date) values.get(xWorker));

            else if (values.get(xWorker) instanceof java.sql.Timestamp)
              prepareStatement.setTimestamp(xWorker + 1, (java.sql.Timestamp) values.get(xWorker));

            else if (values.get(xWorker) instanceof java.sql.Time)
              prepareStatement.setTime(xWorker + 1, (java.sql.Time) values.get(xWorker));

            else
              prepareStatement.setObject(xWorker + 1, values.get(xWorker));

          }
          else
            prepareStatement.setNull(xWorker + 1, java.sql.Types.VARCHAR);


      executeUpdate(prepareStatement);
    }
    catch (SQLException se) {
      //MsgLogger.instance().printlnHintLog("Werteliste: " + values.toString());
      throw se;
    }
    finally {
      prepareStatement.close();
    }
  }
}
