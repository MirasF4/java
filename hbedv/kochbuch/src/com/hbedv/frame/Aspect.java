package com.hbedv.frame;


import java.util.*;

/**
 *  <Description of the Class>
 *
 */
@SuppressWarnings("unchecked")
public class Aspect {

  private java.util.ArrayList aspects = null;


  /**  Constructor for the Aspect object */
  public Aspect() { }


  /**
   *  Constructor for the Aspect object
   *
   *@param  aspect  Description of Parameter
   */
  public Aspect(int aspect) {
    aspects = new ArrayList();
    aspects.add(new Integer(aspect));
  }


  /**
   *  Constructor for the Aspect object
   *
   *@param  newAspects  Description of Parameter
   */
  public Aspect(java.util.ArrayList newAspects) {
    aspects = newAspects;
  }


  /**
   *  Constructor for the Aspect object
   *
   *@param  value  Description of Parameter
   */
  public Aspect(Integer value) {
    aspects = new java.util.ArrayList();
    aspects.add(value);
  }


  /**
   *  Constructor for the Aspect object
   *
   *@param  value  Description of Parameter
   */
  public Aspect(String value) {
    aspects = new java.util.ArrayList();
    aspects.add(value);
  }


  /**
   *  Gets the aspects attribute of the Aspect object
   *
   *@return    The aspects value
   */
  public java.util.ArrayList getAspects() {
    return aspects;
  }


  /**
   *  Sets the aspects attribute of the Aspect object
   *
   *@param  newAspects  The new aspects value
   */
  public void setAspects(java.util.ArrayList newAspects) {
    aspects = newAspects;
  }


  /**
   *  Adds a feature to the Aspect attribute of the Aspect object
   *
   *@param  value  The feature to be added to the Aspect attribute
   */
  public void addAspect(Integer value) {
    if (aspects == null) {
      aspects = new java.util.ArrayList();
    }
    aspects.add(value);
  }
}
