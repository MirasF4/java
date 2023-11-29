package com.hbedv.frame;


import java.util.*;

/**
 *  Diese Hilfsklasse haelt eine Container.
 *
 *      $
 */
@SuppressWarnings("unchecked")
public class AliceSortMapContainer {
  private List listSort = new ArrayList();
  private List listSortKeys = new ArrayList();
  private int valueMax = Util.UNDEFINED_INT;
  private int keyMax = Util.UNDEFINED_INT;


  /**
   *  Constructor for the AliceSortMapContainer object
   *
   *@param  newKeys    Description of Parameter
   *@param  newValues  Description of Parameter
   */
  public AliceSortMapContainer(int newKeys, int newValues) {
    int insgesamt = 0;
    valueMax = newValues;
    keyMax = newKeys;
    insgesamt = valueMax + keyMax;

    for (int list = 0; list < insgesamt; list++)
      listSort.add(null);

    for (int list = 0; list < keyMax; list++)
      listSortKeys.add(null);

  }


  /**
   *  Hole die keys und den value.
   *
   *@return    The listOfKeys value
   */
  public List getKeysAndValue() {
    return listSort;
  }


  /**
   *  Gets the listSortKeys attribute of the AliceSortMapContainer object
   *
   *@return    The listSortKeys value
   */
  public List getListSortKeys() {
    return listSortKeys;
  }


  /**
   *  Setze den value an der Stelle xKey.
   *
   *@param  xKey           The new key value
   *@param  valueToSet     The new key value
   */
  public void setKey(int xKey, Object valueToSet) {

    if (xKey < 0 || xKey > keyMax)
      throw new IndexOutOfBoundsException("Index: " + xKey + " out of Bounds (" + keyMax + ")");

    ((ArrayList) listSort).set(xKey, valueToSet);
    ((ArrayList) listSortKeys).set(xKey, valueToSet);
  }

  
  public Object getKey(int xKey) {
      return ((ArrayList) listSortKeys).get(xKey);
  }
  
  
  public Object getValue(int xValue) {
      return ((ArrayList) listSort).get(keyMax + xValue);
  }
  

  /**
   *  Setze den value.
   *
   *@param  value          The new value value
   *@param  xValue         The new value value
   */
  public void setValue(int xValue, Object value) {

    if (xValue < 0 || xValue > valueMax)
      throw new IndexOutOfBoundsException("Index: " + xValue + " out of Bounds (" + valueMax + ")");

    ((ArrayList) listSort).set(keyMax + xValue, value);
  }


  /**
   *  Description of the Method
   *
   *@return    Description of the Returned Value
   */
  public String toString() {
    String ret = "";
    int nKeys = keyMax;//  listSort.size() - 1;
    /*    if (valueMax > 0) {
      nKeys = nKeys + valueMax;
    }*/
    for (int list = 0; list < nKeys /* listSort.size() - 1*/; list++)
      ret += "\tkey" + list + ": " + (listSort.get(list) + "; ");

    if (valueMax > 0)
      for (int list = nKeys; list < nKeys + valueMax; list++)
        ret += "\t\tvalue" + (list - nKeys) + ": " + listSort.get(list);

    return ret;
  }
}
