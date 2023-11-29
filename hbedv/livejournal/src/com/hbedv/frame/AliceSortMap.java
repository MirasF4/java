package com.hbedv.frame;


import java.util.*;

/**
 *  <Description of the Class>
 *
 *      $
 */
@SuppressWarnings("unchecked")
public class AliceSortMap {
  private int keysMax = Util.UNDEFINED_INT;
  //reale Anzahl von Schlüsseln
  private int valuesMax = Util.UNDEFINED_INT;
  //reale Anzahl von Werten
  private List listSort = null;
  private ArrayList listsToSortTemp = null;
  private final int ASC = 0;
  private final int DESC = 1;
  private int maxEntries = Util.UNDEFINED_INT;


  /**
   *  Constructor for the AliceSortMap object
   *
   *@param  newKeys        Maximale Anzahl von Schluesseln
   *@param  newValues      Maximale Anzahl von Werten
   */
  public AliceSortMap(int newKeys, int newValues) {
    // preconditon
    if (newKeys < 1 || newValues < 0)
      throw new IndexOutOfBoundsException("newKeys < 1 || newValues < 0");

    keysMax = newKeys;
    valuesMax = newValues;
    maxEntries = 0;
    listSort = new ArrayList();
    for (int xListSort = 0; xListSort < keysMax + valuesMax; xListSort++)
      listSort.add(new ArrayList());

  }


  /**
   *  Hole einen leeren Sortcontainer. Braucht man um beliebige Sortierreihenfolgen
   *  einzustellen.
   *
   *@return    Sortcontainer.
   */
  public AliceSortMapContainer getEmptyAliceSortMapContainer() {
    return new AliceSortMapContainer(keysMax, valuesMax);
  }


  /**
   *  Hole die Kopie eines bestimmten Container.
   *
   *@param  xEntry  Idxeintrag
   *@return         Kopie des aliceSortMapContainer
   */
  public AliceSortMapContainer getAliceSortMapContainer(int xEntry) {
    //precondition
    if (xEntry < 0 || xEntry > ((ArrayList) (listSort.get(0))).size())
      throw new IndexOutOfBoundsException("xEntry: " + Integer.toString(xEntry) + " ; xEntry < 0 || xEntry > keysMax + valuesMax - 1");
    AliceSortMapContainer aliceSortMapContainer = new AliceSortMapContainer(keysMax, valuesMax);

    for (int xAliceSortMapContainer = 0; xAliceSortMapContainer < keysMax; xAliceSortMapContainer++)
      aliceSortMapContainer.setKey(xAliceSortMapContainer, ((ArrayList) listSort.get(xAliceSortMapContainer)).get(xEntry));

    for (int xAliceSortMapContainer = 0; xAliceSortMapContainer < valuesMax; xAliceSortMapContainer++)
      aliceSortMapContainer.setValue(xAliceSortMapContainer, ((ArrayList) listSort.get(xAliceSortMapContainer + keysMax)).get(xEntry));

    return aliceSortMapContainer;
  }


  /**
   *  Hole eine bestimmte keyspalte. Der 0te ist die 1te key-ArrayList
   *
   *@param  xKey  Position des zu holenden Keys (der 0te ist der 1te)
   *@return       ArrayList of key values
   */
  public ArrayList getKeys(int xKey) {
    //precondition
    if (xKey < 0 || xKey > keysMax - 1)
      throw new IndexOutOfBoundsException("getKeys: xKey < 0 || xKey > keysMax-1");
    return (ArrayList) listSort.get(xKey);
  }


  /**
   *  Holt eine bestimmte valuespalte. Der 0te ist die 1te Value-Arraylist
   *
   *@param  xValue  Position des zu holenden Values (der 0te ist der 1te)
   *@return         ArrayList of values
   */
  public ArrayList getValues(int xValue) {
    //precondition
    if (xValue < 0 || xValue > valuesMax - 1)
      throw new IndexOutOfBoundsException("getValues: xValue < 0 || xValue > valuesMax - 1");
    return (ArrayList) listSort.get(keysMax + xValue);
  }


  /**
   *  Gibt die anzahl der vorhanden Eintraege zurück
   *
   *@return    int Anzahl Eintrage
   */
  public int getSize() {
    return maxEntries;
  }


  /**
   *  Anzahl Schluessel sind in der AliceSortMap
   *
   *@return    int Anzahl Keys
   */
  public int getMaxKeys() {
    return keysMax;
  }


  /**
   *  Anzahl Values in der AliceSortMap
   *
   *@return    int Anzahl Values
   */
  public int getMaxValues() {
    return valuesMax;
  }


  /**
   *  Gets the empty attribute of the AliceSortMap object
   *
   *@return    The empty value
   */
  public boolean isEmpty() {
    return (maxEntries == 0);
  }


  /**
   *  Setzt in xRow, xColumne value.
   *
   *@param  xRow      Zeile die zu verändern ist
   *@param  xColumne  Spalte die zu verändern ist
   *@param  value     Wert
   */
  public void setValue(int xRow, int xColumne, Object value) {
    //precondition
    if (xRow < 0 || xRow > getSize() - 1)
      throw new IndexOutOfBoundsException("xRow < 0 || xRow > getSize() - 1");
    if (xColumne < 0 || xColumne > getMaxValues() - 1)
      throw new IndexOutOfBoundsException("xColumne < 0 || xColumne > getMaxValues() - 1");
    getValues(xColumne).set(xRow, value);
  }


  /**
   *  Setzt in xRow, xColumne neuen Keys.
   *
   *@param  xRow      Zeile die zu verändern ist
   *@param  xColumne  Key.Spalte die zu verändern ist
   *@param  key       Wert
   */

  public void setKey(int xRow, int xColumne, Object key) {
    //precondition
    if (xRow < 0 || xRow > getSize() - 1)
      throw new IndexOutOfBoundsException("xRow :" + xRow + " size: " + getSize());
    if (xColumne < 0 || xColumne > getMaxKeys() - 1)
      throw new IndexOutOfBoundsException("xColumne < 0 || xColumne > getMaxKeys() - 1");
    getKeys(xColumne).set(xRow, key);
  }


  /**
   *  Fügt an die AliceSortMap eine neue Value-Spalte an und füllt diese mit den
   *  Daten aus der ArrayList toAdd Es muss nach einem AddValueList unbedingt ein
   *  neuer Container geholt werden, ansonsten stimmt die Anzahl der Felder nicht
   *  mehr.
   *
   *@param  toAdd  The feature to be added to the Value attribute
   */

  public void addValue(ArrayList toAdd) {

    if (toAdd == null)
      throw new NullPointerException("toAdd == null");

    if (toAdd.size() != maxEntries)
      throw new IndexOutOfBoundsException("toAdd..size() (=" + toAdd.size() + ") != maxEntries (=" + maxEntries + ")");

    valuesMax += 1;
    listSort.add(toAdd);

  }


  /**
   *  Erzeuge und fuelle einen Sortiercontainer mit einer Sortierreihenfolge.
   *
   *@param  sortOrders  Sortierreihenfolge
   *@return             SortOrderContainer
   */
  public AliceSortOrder createAliceSortOrderContainer(int[] sortOrders) {
    // precondition
    if (sortOrders.length < 1 || sortOrders.length > keysMax)
      throw new IndexOutOfBoundsException("sortOrders.length < 1 || sortOrders.length > keysMax");
    for (int i = 0; i < sortOrders.length; i++)
      if (sortOrders[i] < 0 || sortOrders[i] > keysMax - 1)
        throw new IndexOutOfBoundsException("sortOrders[i] < 0 || sortOrders[i] > keysMax -1");

    AliceSortOrder a = new AliceSortOrder(keysMax, sortOrders);
    return a;
  }


  /**
   *  Loescht die Zeile Row in der AliceSortMap.
   *
   *@param  row  Zeile.
   */
  public void delete(int row) {

    if (listSort.isEmpty())
      throw new IndexOutOfBoundsException("listSort.isEmpty()");

    if (row < 0 || row > maxEntries - 1)
      throw new IndexOutOfBoundsException("row < 0 || row > maxEntries-1");

    for (int i = 0; i < listSort.size(); i++)
      ((ArrayList) listSort.get(i)).remove(row);

    maxEntries--;
  }


  /**
   *  Loescht mehrere Zeilen Row in der AliceSortMap.
   *
   *@param  toDel  ArrayList mit Integer
   */
  public void delete(ArrayList toDel) {

    if (listSort.isEmpty())
      throw new IndexOutOfBoundsException("listSort.isEmpty()");

    if (toDel != null && !toDel.isEmpty())
      for (int cnt = toDel.size() - 1; cnt >= 0; cnt--) {
        Integer welcher = (Integer) toDel.get(cnt);
        delete(welcher.intValue());
      }

  }


  /**
   *  Sucht alle Vorkommen der Werte aus keysToDel in "spalte" und löscht diese Einträge.
   *
   *@param  spalte     Description of Parameter
   *@param  keysToDel  Description of Parameter
   */
  public void delete(int spalte, ArrayList keysToDel) {

    ArrayList toDel = new ArrayList();

    if (listSort.isEmpty())
      throw new IndexOutOfBoundsException("listSort.isEmpty()");

    if (keysToDel != null && !keysToDel.isEmpty())
      for (int x = 0; x < this.getSize(); x++)
        for (int y = 0; y < keysToDel.size(); y++)
          if (this.getKeys(spalte).get(x) != null && this.getKeys(spalte).get(x).equals(keysToDel.get(y)))
            toDel.add(new Integer(x));



    if (toDel != null && toDel.size() > 0)
      this.delete(toDel);

  }



  /**
   *  Fuege einen Container hinzu. Achtung: ist der Container bereits vorhanden (alle
   *  keys sind gleich) wird der Container auch hinzugefuegt.
   *
   *@param  aliceSortMapContainer
   */
  public void add(AliceSortMapContainer aliceSortMapContainer) {
    // precondition
    if (aliceSortMapContainer == null)
      throw new NullPointerException("aliceSortMapContainer == null");

    for (int xAliceSortMapContainer = 0;
      xAliceSortMapContainer < aliceSortMapContainer.getKeysAndValue().size();
      xAliceSortMapContainer++)
      ((ArrayList) (listSort.get(xAliceSortMapContainer))).add(aliceSortMapContainer.getKeysAndValue().get(xAliceSortMapContainer));

    maxEntries++;
  }


  /**
   *  Fuegt Einträge von einer AliceSortMap hinzu. Achtung: ist ein Container bereits
   *  vorhanden (alle keys sind gleich) wird der Container auch hinzugefuegt. (doppelte
   *  Einträge !!)
   *
   *@param  asmFrom  Description of Parameter
   */

  public void append(AliceSortMap asmFrom) {
    // precondition
    if (asmFrom == null)
      throw new NullPointerException("aliceSortMapContainer == null");

    for (int i = 0; i < asmFrom.getSize(); i++)
      this.add(asmFrom.getAliceSortMapContainer(i));

  }


  /**  Description of the Method  */
  public void removeDoubleKeys() {

    this.sortListAsc();

    int i = 0;
    while (i + 1 < this.getSize()) {
      AliceSortMapContainer container = this.getAliceSortMapContainer(i);
      if (container.getListSortKeys().equals(this.getAliceSortMapContainer(i + 1).getListSortKeys()))
        this.delete(i);

      else
        i++;

    }
  }



  /**
   *  Alles Wichtige to String.
   *
   *@return    the String.
   */
  public String toString() {
    String ret = "";
    try {
      int nEntries = ((ArrayList) (listSort.get(0))).size();
      AliceSortMapContainer asc = null;
      for (int xEntry = 0; xEntry < nEntries; xEntry++) {
        asc = this.getAliceSortMapContainer(xEntry);
        ret += asc.toString() + "\n";
      }
    }
    catch (Exception ex) {
      ret = ":-(";
    }
    return ret;
  }


  /**
   *  Sortiere entsprechend dem Sortiercontainer aufsteigend. Bei Boolean kommen
   *  true-Werte zuerst
   *
   *@param  keyOrders  Reihenfolge von Keys, nach denen sortiert werden soll
   */
  public void sortListAsc(AliceSortOrder keyOrders) {

    //precondition
    if (keyOrders == null)
      throw new NullPointerException("keyOrders == null ");
    if (keyOrders.getSortOrder().size() > keysMax)
      throw new IndexOutOfBoundsException("keyOrders.getSortOrder().size() > keysMax");

    sortList(keyOrders, ASC);
  }


  /**
   *  Sortiere entsprechend dem Sortiercontainer aufsteigend. Bei Boolean kommen
   *  true-Werte zuerst
   */
  public void sortListAsc() {

    //precondition
    if (keysMax <= 0)
      throw new IndexOutOfBoundsException("keysMax <= 0");
    ArrayList sort = new ArrayList();
    for (int i = 0; i < this.getMaxKeys(); i++)
      sort.add(new Integer(i));

    AliceSortOrder a = new AliceSortOrder(keysMax, sort);
    this.sortListAsc(a);
  }


  /**
   *  Sortiere entsprechend dem Sortiercontainer absteigend. Bei Boolean kommen false-Werte
   *  zuerst
   *
   *@param  keyOrders
   */
  public void sortListDesc(AliceSortOrder keyOrders) {
    //precondition
    if (keyOrders == null)
      throw new NullPointerException("keyOrders == null");
    if (keyOrders.getSortOrder().size() > keysMax)
      throw new IndexOutOfBoundsException("keyOrders.getSortOrder().size() > keysMax");

    sortList(keyOrders, DESC);
  }


  /**
   *  Sucht die ensprechende Zeile zu einer bestimmten Wert in einer KeySpalte.
   *
   *@param  xKey      KeySpalte, die durchsucht werden soll.
   *@param  toSearch  Description of Parameter
   *@return           Zeilennummer.
   */
  public int indexOfKey(int xKey, Object toSearch) {

    // precondition
    if (listSort.isEmpty())
      throw new IndexOutOfBoundsException("listSort.isEmpty()");
    if (xKey < 0 || xKey > keysMax)
      throw new IndexOutOfBoundsException("xKey < 0 || xKey > keysMax");
    if (toSearch == null)
      throw new NullPointerException("toSearch == null");

    int row = ((ArrayList) listSort.get(xKey)).indexOf(toSearch);
    return row;
  }


  /**
   *  In einer AliceSortMap kann nach einem bestimmten Satz mit beliebigen Key-Anzahl
   *  gesucht werden. Von 1 bis keysMax.
   *
   *@param  nKeys      ArrayList mit den Keys
   *@param  nToSearch  ArrayList mit den zu suchenden Objekten
   *@return            Position des ersten gefundenen Satzes
   */
  public int indexOfKeys(ArrayList nKeys, ArrayList nToSearch) {

    if (listSort.isEmpty())
      throw new IndexOutOfBoundsException("listSort.isEmpty()");

    if (nKeys == null)
      throw new NullPointerException("nKeys == null");
    if (nKeys.size() < 1 || nKeys.size() > keysMax)
      throw new IndexOutOfBoundsException("nKeys.size() < 1 || nKeys.size() > keysMax");

    if (nKeys.size() != nToSearch.size())
      throw new IndexOutOfBoundsException("nKeys.size() != nToSearch.size()");

    int nResult = -1;

    if (nKeys.size() == 1)
      nResult = indexOfKey(((Integer) nKeys.get(0)).intValue(), nToSearch.get(0));

    else {
      int wieViele = nKeys.size();
      boolean lTreffer = true;

      for (int i = 0; i < this.getSize(); i++) {
        lTreffer = true;


        for (int j = 0; j < wieViele; j++) {
          int keyPos = ((Number)nKeys.get(j)).intValue();
          if ( (this.getKeys(keyPos).get(i) == null) || (!this.getKeys(keyPos).get(i).equals(nToSearch.get(j)))) {
            lTreffer = false;
            break;
          }
        }
        if (lTreffer) {
          nResult = i;
          break;
        }
      }
    }

//    int row = ((ArrayList) listSort.get(xKey)).indexOf(toSearch);
    return nResult;
  }


  /**
   *  Sucht die ensprechende Zeile zu einer bestimmten Wert in einer ValueSpalte.
   *
   *@param  xValue  ValueSpalte, die durchsucht werden soll.
   *@param  o       Wonach soll gesucht werden.
   *@return         Zeile in der Wert steht.
   */
  public int indexOfValue(int xValue, Object o) {
    int row;
    // precondition
    if (listSort.isEmpty())
      throw new NullPointerException("listSort.isEmpty()");
    if (xValue < 0 || xValue > valuesMax)
      throw new IndexOutOfBoundsException("xValue < 0 || xValue > valuesMax");
    if (o == null)
      throw new NullPointerException("o == null");

    row = ((ArrayList) listSort.get(xValue + keysMax)).indexOf(o);

    return row;
  }


  /**
   *  Liefert ein Kopie einer ALiceSortMap zurück (als Object)
   *
   *@return    Object von ALiceSortMap
   */
  public Object clone() {
    AliceSortMap asmRet = null;

    try {
      asmRet = new AliceSortMap(this.getMaxKeys(), this.getMaxValues());
      asmRet.append(this);
    }
    catch (Exception e) {
      //MsgLogger.instance().printlnHintLog("AliceSortMap: clone failed " + e.getMessage());
    }
    return asmRet;
  }


  /**
   *  Helper.
   *
   *@param  keyOrders  Description of Parameter
   *@param  ascDesc    Description of Parameter
   */
  private void sortList(AliceSortOrder keyOrders, int ascDesc) {

    //precondition
    if (keyOrders == null)
      throw new NullPointerException("keyOrders == null");
    if (keyOrders.getSortOrder().size() > keysMax)
      throw new IndexOutOfBoundsException("keyOrders.getSortOrder().size() > keysMax");

    List listOfKeysTemp = null;

    for (int xSortOrder = keyOrders.getSortOrder().size(); xSortOrder > 0; xSortOrder--) {
      int xKey = ((Integer) keyOrders.getSortOrder().get(xSortOrder - 1)).intValue();

      if (xKey < 0 || xKey > keysMax - 1)
        throw new IndexOutOfBoundsException("xKey < 0 || xKey > keysMax-1");
      listOfKeysTemp = new ArrayList((ArrayList) listSort.get(xKey));
      this.sort(listOfKeysTemp, ascDesc);
    }
  }


  /**
   *  Helper.
   *
   *@param  iL  Description of Parameter
   *@param  iR  Description of Parameter
   */
  private void assign(int iL, int iR) {
    listsToSortTemp.set(iL, listsToSortTemp.get(iR));
    for (int xKey = 0; xKey < listSort.size(); xKey++)
      ((ArrayList) listSort.get(xKey)).set(
        iL, ((ArrayList) listSort.get(xKey)).get(iR));

  }


  /**
   *  Helper.
   *
   *@param  iL                     Description of Parameter
   *@param  aliceSortMapContainer  Description of Parameter
   *@param  o                      Description of Parameter
   */
  private void assign(int iL, AliceSortMapContainer aliceSortMapContainer, Object o) {
    listsToSortTemp.set(iL, o);
    for (int xKey = 0; xKey < listSort.size(); xKey++)
      ((ArrayList) listSort.get(xKey)).set(
        iL, aliceSortMapContainer.getKeysAndValue().get(xKey));

  }


  /**
   *  Helper.
   *
   *@param  o1       Description of Parameter
   *@param  o2       Description of Parameter
   *@param  ascDesc  Description of Parameter
   *@return          Description of the Returned Value
   */
  private boolean vgl(Object o1, int ascDesc, Object o2) {

    boolean ret = false;
    if (o1 == null)
      ret = true;

    else if (o2 == null)
      ret = false;

    else if (o1 instanceof java.lang.String)
      ret = (((String) o1).compareTo((String) o2) > 0);

    else if (o1 instanceof java.lang.Integer)
      ret = (((Integer) o1).compareTo((Integer) o2) > 0);

    else if (o1 instanceof java.lang.Long)
      ret = (((Long) o1).compareTo((Long) o2) > 0);

    else if (o1 instanceof java.math.BigDecimal)
      ret = (((java.math.BigDecimal) o1).compareTo((java.math.BigDecimal) o2) > 0);

    else if (o1 instanceof java.lang.Float)
      ret = (((Float) o1).compareTo((Float) o2) > 0);

    else if (o1 instanceof java.lang.Boolean && o2 instanceof java.lang.Boolean)
      ret = ((Boolean) o2).booleanValue();

    else if (o1 instanceof java.lang.Character && o2 instanceof java.lang.Character)
      ret = (((Character) o1).compareTo((Character) o2) > 0);

    else if (o1 instanceof java.sql.Date && o2 instanceof java.sql.Date)
      ret = (((Date) o1).compareTo((Date) o2) > 0);

    else
      throw new UnsupportedOperationException("Datentyp nicht unterstuetzt: " + o1.getClass());

    return ascDesc == DESC ? !ret : ret;
  }


  /**
   *  Helper.
   *
   *@param  newListsToSortTemp  Description of Parameter
   *@param  ascDesc             Description of Parameter
   */
  private void sort(List newListsToSortTemp, int ascDesc) {
  	
    listsToSortTemp = (ArrayList) newListsToSortTemp;
    for (int xKey = 0; xKey < listsToSortTemp.size() - 1; xKey++)
      if (vgl(listsToSortTemp.get(xKey), ascDesc, listsToSortTemp.get(xKey + 1))) {
        AliceSortMapContainer ascHelp = getAliceSortMapContainer(xKey + 1);
        Object oHelp = listsToSortTemp.get(xKey + 1);
        int j = xKey;
        while (j > -1 && vgl(listsToSortTemp.get(j), ascDesc, oHelp)) {
          assign(j + 1, j);
          j--;
        }
        assign(j + 1, ascHelp, oHelp);
      }

  }

}
