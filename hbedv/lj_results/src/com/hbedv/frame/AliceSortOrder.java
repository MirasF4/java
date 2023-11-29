package com.hbedv.frame;


import java.util.*;

/**
 *  Diese Hilfsklasse haelt einen Sortiercontainer.
 *
 *      $
 */
@SuppressWarnings("unchecked")
public class AliceSortOrder {

  private ArrayList sortOrder = null;


  /**
   *  Constructor for the AliceSortOrder object
   *
   *@param  keysMax     # keys.
   *@param  sortOrders  Keyreihenfolge nach der sortiert werden soll.
   */
  public AliceSortOrder(int keysMax, int sortOrders[]) {
    //precondition
    if (sortOrders == null) {
      throw new NullPointerException("sortOrders == null");
    }
    sortOrder = new ArrayList();
    for (int i = 0; i < sortOrders.length; i++)
      sortOrder.add(new Integer(sortOrders[i]));

  }


  /**
   *  Constructor for the AliceSortOrder object
   *
   *@param  keysMax     # keys.
   *@param  sortOrders  Keyreihenfolge nach der sortiert werden soll.
   */
  public AliceSortOrder(int keysMax, ArrayList sortOrders) {
    //precondition
    if (sortOrders == null) {
      throw new NullPointerException("sortOrders == null");
    }
    sortOrder = sortOrders;
  }


  /**
   *  Gets the sortOrder attribute of the AliceSortOrder object
   *
   *@return    The sortOrder value
   */
  public java.util.ArrayList getSortOrder() {
    return sortOrder;
  }


  /**
   *  AliceSortOrder to String.
   *
   *@return    the String.
   */
  public String toString() {
    String ret = "";
    for (int list = 0; list < sortOrder.size(); list++)
      ret += "key" + (sortOrder.get(list) + "; ");

    return ret;
  }
}
