package com.hbedv.frame;


import com.hbedv.db.*;
import java.sql.SQLException;

/**
 *  Manager; kuemmert sich um die Businesslogic;
 *
 */
public abstract class Manager {
  protected Client client = null;

  //*miniframe
  protected AliceSortMap idBezis = null;//miniframe
  protected String command = null;//miniframe
  private Object idCur = null;//miniframe
  private String bezCur = null;//miniframe
  private boolean editSchluessel = false;//miniframe
  private Object key = null;//schluessel

  private String filename = null;

  /* deprecated orn: setvalues!; keine flags; oje */
  private boolean neu = false;

  /**
   *  Hier wird der current Item zB. eine Person, in voller Pracht unter Beruecksichtigung
   *  von Aspect gemerkt.
   */
  private Object itemPrachtCur = null;

  private java.sql.Timestamp lastChangeTimestamp = null;
  private Integer lastChangeId = null;

  //true ... Item wird geinserted; false ... Item wird upgedated
  private boolean newItem = false;


  /**
   *  Constructor for the Manager object.
   *
   *@param  newClient  Description of Parameter
   */
  public Manager(Client newClient) {
    client = newClient;
  }


  /**
   *  Gets the idCur attribute of the Manager object.
   *
   *@return                The idCur value.
   *@exception  Exception
   */
  public Object getIdCur() throws Exception{
    return idCur;
  }


  /**
   *  Gets the cmd attribute of the Manager object.
   *
   *@return    The cmd value.
   */
  public String getCmd() {
    return command;
  }


  /**
   *  Gets the bezCur attribute of the Manager object.
   *
   *@return    The bezCur value.
   */
  public String getBezCur() {
    return bezCur;
  }


  /**
   *  Gets the key attribute of the Manager object.
   *
   *@return                The key value.
   *@exception  Exception  Description of Exception
   */
  public Object getKey()
    throws Exception {
    return key;
  }


  /**
   *  Gets the filename attribute of the Manager object.
   *
   *@return    The filename value.
   */
  public String getFilename() {
    return filename;
  }


  /**
   *  Gets the dB attribute of the Manager object
   *
   *@return                The dB value
   * @throws SQLException TODO
   */
  public abstract DB getDB()
    throws SQLException;


  /**
   *  Gets the idBezis attribute of the Manager object
   *
   *@return    The idBezis value
   */
  public AliceSortMap getIdBezis() {
    return idBezis;
  }


  /**
   *  Gets the neu attribute of the Manager object
   *
   *@return        The neu value
  */
  public boolean isNeu() {
    return neu;
  }


  /**
   *  Hole den current Item.
   *
   *@return                The itemPrachtCur value
   *@exception  Exception  Description of Exception
   */
  public Object getCurItem() {
    return itemPrachtCur;
  }


  /**
   *  Gets the lastChangeTimestamp attribute of the Manager object
   *
   *@return    The lastChangeTimestamp value
   */
  public java.sql.Timestamp getLastChangeTimestamp() {
    return lastChangeTimestamp;
  }


  /**
   *  Gets the lastChangeId attribute of the Manager object
   *
   *@return    The lastChangeId value
   */
  public Integer getLastChangeId() {
    return lastChangeId;
  }


  /**
   *  Gets the newItem attribute of the Manager object
   *
   *@return    The newItem value
   */
  public boolean isNewItem() {
    return newItem;
  }


  /**
   *  Setze idCur.
   *
   *@param  newIdCur  The new idCur value.
   */
  public void setIdCur(Object newIdCur) {
    idCur = newIdCur;
  }


  /**
   *  Setze den Ersten der AliceSortMap als den Aktuellen.
   *
   *@exception  Exception
   *@Exception             idBezis == null.
   */
  public void setFirst() {
    if (idBezis == null) {
      return;
    }
    else if (idBezis.getValues(0).isEmpty()) {
      return;
    }
    else {
      setIdCur(idBezis.getValues(0).get(0));
    }
    setBezCur(idBezis.getKeys(0).get(0).toString());
  }


  /**
   *  Setze das Command (Alice.) mit der die .jsp callbacked.
   *
   *@param  newCommand  Der neue CMD-Wert.
   */
  public void setCmd(String newCommand) {
    command = newCommand;
  }


  /**
   *  Sets the bezCur attribute of the Manager object.
   *
   *@param  newBezCur  The new bezCur value.
   */
  public void setBezCur(String newBezCur) {
    bezCur = newBezCur;
  }


  /**
   *  Sets the editSchluessel attribute of the Manager object.
   *
   *@param  newEditSchluessel  The new editSchluessel value.
   */
  public void setEditSchluessel(boolean newEditSchluessel) {
    editSchluessel = newEditSchluessel;
  }


  /**
   *  Sets the key attribute of the Manager object.
   *
   *@param  newKey  The new key value.
   */
  public void setKey(Object newKey) {
    key = newKey;
  }


  /**
   *  Sets the filename attribute of the Manager object.
   *
   *@param  newFilename  The new filename value.
   */
  public void setFilename(String newFilename) {
    filename = newFilename;
  }


  /**
   *  Sets the idBezis attribute of the Manager object
   *
   *@param  newIdBezis  The new idBezis value
   */
  public void setIdBezis(AliceSortMap newIdBezis) {
    this.idBezis = newIdBezis;
  }


  /**
   *  Sets the neu attribute of the Manager object
   *
   *@param  newNeu  The new neu value
   */
  public void setNeu(boolean newNeu) {
    this.neu = newNeu;
  }


  /**
   *  Setze den current Item.
   *
   *@param  newCurItem     The new curItem value
   *@exception  Exception  Description of Exception
   */
  public void setCurItem(Object newCurItem) {
    this.itemPrachtCur = newCurItem;
  }


  /**
   *  Sets the lastChangeTimestamp attribute of the Manager object
   *
   *@param  newLastChangeTimestamp  The new lastChangeTimestamp value
   */
  public void setLastChangeTimestamp(java.sql.Timestamp newLastChangeTimestamp) {
    this.lastChangeTimestamp = newLastChangeTimestamp;
  }


  /**
   *  Sets the lastChangeId attribute of the Manager object
   *
   *@param  newLastChangeId  The new lastChangeId value
   */
  public void setLastChangeId(Integer newLastChangeId) {
    this.lastChangeId = newLastChangeId;
  }


  /**
   *  Sets the newItem attribute of the Manager object
   *
   *@param  newItem  The new newItem value
   */
  public void setNewItem(boolean newItem) {
    this.newItem = newItem;
  }


  /**
   *  Description of the Method
   *
   *@param  connection     Description of Parameter
   *@param  bez            Description of Parameter
   *@param  aspects        Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception @deprecated: orn use existsValues(ConnectionWrapper
   *      connection, Aspect aspects)
   */
  public abstract boolean existsValues(ConnectionWrapper connection, Object bez, Aspect aspects)
    throws Exception;


  /**
   *  Description of the Method
   *
   *@param  connection     Description of Parameter
   *@param  aspects        Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  public boolean existsValues(ConnectionWrapper connection, Aspect aspects)
    throws Exception {
    return false;
  }


  /**
   *  Lies eine Liste von Items (z.B. Personen, Menuepunkte, ...) ein. Diese Routine
   *  kuemmert sich selbst um die connection, d.h. wenn du nur von einer DB liest,
   *  dann überschreiben readListValues und getDB. Braucht das Lesen mehr als eine
   *  DB so überschreibe die Methode.
   *
   *@param  aspects        Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  public synchronized AliceSortMap readList(Aspect aspects)
    throws Exception {
    //precondition
    DB db = null;
    ConnectionWrapper connection = null;
    db = getDB();
    connection = db.getConnection();
    try {
      connection.setAutoCommit(false);
      setIdBezis(readListValues(connection, aspects));
    }
    finally {
      connection.close();
    }
    return idBezis;
  }


  /**
   *  Description of the Method
   *
   *@param  aspect         Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  public boolean exists(Aspect aspect)
    throws Exception {
    //precondition
    boolean exist = false;
    ConnectionWrapper connection = getDB().getConnection();
    try {
      exist = existsValues(connection, aspect);
    }
    finally {
      connection.close();
    }
    return exist;
  }


  /**
   *  Existiert bez in der db? Dann muß Methode überschrieben werden.
   *
   *@param  bez            bez.
   *@return                Description of the Returned Value
   *@exception  Exception  @deprecated: orn use exists(Aspect aspects)
   */
  public boolean exists(Object bez)
    throws Exception {
    //precondition
    boolean exist = false;
    ConnectionWrapper connection = getDB().getConnection();
    try {
      exist = existsValues(connection, bez, null);
    }
    finally {
      connection.close();
    }
    return exist;
  }


  /**
   *  Insert den current Item. Diese Routine kuemmert sich selbst um die connection,
   *  d.h. wenn du nur in eine DB schreibst, dann überschreibe insertValues und getDB.
   *  Braucht das Insert mehr als eine DB so überschreibe die Methode.
   *
   *@param  aspects        Description of Parameter
   *@exception  Exception
   *@Exception
   */
  public void insert(Aspect aspects)
    throws Exception {
    ConnectionWrapper connection = getDB().getConnection();
    try {
      connection.setAutoCommit(false);
      insertValues(connection, aspects);
      connection.commit();
      //neu; nach insert jetzt immer true
     	((com.hbedv.db.IRepository) this.getCurItem()).setFromDB(true);
      		
    }
    catch (java.sql.SQLException re) {
      connection.rollback();
      throw re;
    }
    finally {
      connection.close();
    }

  }


  /**
   *@exception  Exception  @deprecated; orn: durch delete(c) ersetzt delete the curId.
   *@Exception
   */
  public void delete()
    throws Exception {
    throw new Exception("Not implemented yet!");
  }


  /**
   *  Loesche je nach Aspect DBEintraege.
   *
   *@param  aspects        Description of Parameter
   *@exception  Exception  Description of Exception
   */
  public void delete(Aspect aspects)
    throws Exception {
    ConnectionWrapper connection = getDB().getConnection();
    try {
      connection.setAutoCommit(false);
      deleteValues(connection, aspects);
      connection.commit();
    }
    catch (Exception e) {
      connection.rollback();
      throw e;
    }
    finally {
      connection.close();
    }
  }



  /**
   *  Update den current Item. Diese Routine kuemmert sich selbst um die connection,
   *  d.h. wenn du nur in eine DB schreibst, dann überschreibe updateValues und getDB.
   *  Braucht das Update mehr als eine DB so überschreibe die Methode.
   *
   *@param  aspects        Description of Parameter
   *@exception  Exception
   *@Exception
   */
  public void update(Aspect aspects)
    throws Exception {
    ConnectionWrapper connection = getDB().getConnection();
    try {
      connection.setAutoCommit(false);
      updateValues(connection, aspects);
      connection.commit();
    }
    catch (Exception e) {
      connection.rollback();
      throw e;
    }
    finally {
      connection.close();
    }
  }


  /**
   *  Schluesselfelder editierbar.
   *
   *@return    Ob Schluesselfeld editierbar ist.
   */
  public boolean editSchluessel() {
    return editSchluessel;
  }


  /**
   *  Ueberschreibe diese Methode um deinen Manager zu initialisieren; wird nur 1x
   *  aufgerufen.
   *
   *@exception  Exception  Description of Exception
   */
  public void init() throws Exception {
    newItem = false;
  }



  /**
   *  Bereite die nächste Item(button)ebene auf; idCur ist der aktuelle!
   *
   *@exception  java.lang.Exception  Description of Exception
   */
  public synchronized void refreshItemList()
    throws java.lang.Exception {
    ConnectionWrapper connection = getDB().getConnection();
    try {
      connection.setAutoCommit(false);
      setIdBezis(refreshItemListValue(connection, new Aspect(Repository.QUICK)));
    }
    finally {
      connection.close();
    }
  }


  /**
   *  Bereite die nächste Item(kastl)ebene auf; idCur ist der aktuelle!
   *
   *@exception  java.lang.Exception  Description of Exception
   */
  public synchronized void refreshTableList()
    throws java.lang.Exception {
    ConnectionWrapper connection = getDB().getConnection();
    try {
      connection.setAutoCommit(false);
      setIdBezis(refreshTableListValue(connection, new Aspect(Repository.QUICK)));
    }
    finally {
      connection.close();
    }
  }


  /**
   *  Bereite den nächsten Item auf; idCur ist der aktuelle!
   *
   *@exception  java.lang.Exception  Description of Exception
   */
  public synchronized void refreshItem()
    throws java.lang.Exception {
    //precondition
    ConnectionWrapper connection = getDB().getConnection();
    try {
      connection.setAutoCommit(false);
      setCurItem(readItemValue(connection, new Aspect(Repository.DETAIL)));
    }
    finally {
      connection.close();
    }
  }


  /**
   *  Ueberschreibe diese Methode um eine Liste von Items (z.B. Personen, Menuepunkte,
   *  ...) einzulesen.
   *
   *@param  connection     Description of Parameter
   *@param  aspects        Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   *@deprecated            use: refreshItemListValue or refreshTableList
   */
  protected synchronized AliceSortMap readListValues(ConnectionWrapper connection, Aspect aspects)
    throws Exception {

    if (connection == null)
      throw new NullPointerException("connection == null");

    return null;
  }


  /**
   *  Ueberschreibe diese Methode um deine aktuell gesetzten Werte deines one/current
   *  Items upzudaten.
   *
   *@param  connection     Description of Parameter
   *@param  aspects        Description of Parameter
   *@exception  Exception  Description of Exception
   */
  protected void updateValues(ConnectionWrapper connection, Aspect aspects)
    throws Exception {

    if (connection == null)
      throw new NullPointerException("connection == null");
  }


  /**
   *  Ueberschreibe diese Methode um deine aktuell gesetzten Werte deines one/current
   *  Items zu inserten.
   *
   *@param  connection     Description of Parameter
   *@param  aspects        Description of Parameter
   *@exception  Exception  Description of Exception
   */
  protected void insertValues(ConnectionWrapper connection, Aspect aspects)
    throws Exception {
    if (connection == null)
      throw new NullPointerException("connection == null");
  }


  /**
   *  Ueberschreibe diese Methode um deinen one/current Items zu loeschen.
   *
   *@param  connection     Description of Parameter
   *@param  aspects        Description of Parameter
   *@exception  Exception  Description of Exception
   */
  protected void deleteValues(ConnectionWrapper connection, Aspect aspects)
    throws Exception {
    if (connection == null)
      throw new NullPointerException("connection == null");
  }


  /**
   *  Ueberschreibe diese Methode um eine Liste von Items (z.B. Personen, Menuepunkte,
   *  ...) fuer die Kastl-/Tabellendarstellung einzulesen.
   *
   *@param  connection     Description of Parameter
   *@param  aspects        Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  protected AliceSortMap refreshTableListValue(ConnectionWrapper connection, Aspect aspects)
    throws Exception {
    if (connection == null)
      throw new NullPointerException("connection == null");
    return null;
  }


  /**
   *  Ueberschreibe diese Methode um eine Liste von Items (z.B. Personen, Menuepunkte,
   *  ...) fuer die Buttondarstellung einzulesen.
   *
   *@param  connection     Description of Parameter
   *@param  aspects        Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  protected AliceSortMap refreshItemListValue(ConnectionWrapper connection, Aspect aspects)
    throws Exception {
    if (connection == null)
      throw new NullPointerException("connection == null");

    return null;
  }


  /**
   *  Ueberschreibe diese Methode um einen Item (z.B. Person, Menuepunkt, ...) einzulesen.
   *
   *@param  connection     Description of Parameter
   *@param  aspects        Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  protected synchronized Object readItemValue(ConnectionWrapper connection, Aspect aspects)
    throws Exception {

    if (connection == null)
      throw new NullPointerException("connection == null");

    return null;
  }

}
