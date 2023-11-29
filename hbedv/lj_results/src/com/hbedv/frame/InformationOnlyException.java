package com.hbedv.frame;


/**
 *  Diese Klasse kuemmert sich um Informationen die im Framework, Subsystem herumgereicht
 *  werden. So kann zB. ein Entwickler in einem Subsystem die Anwendereingabe pruefen,
 *  entdeckt hierbei einen Fehler und wirft einfach einen InformationOnlyException
 *  mit einer passenden Fehlermeldung. Grundsaetzlich dient diese Klasse fuer den
 *  automatische Transport einer Meldung zum UI.
 *
 *      $
 */
@SuppressWarnings("serial")
public class InformationOnlyException extends Exception {

  //Jspseite mit der es weiter geht.
  private String jspNext = null;


  /**
   *  Constructor for the InformationOnlyException object
   *
   *@param  msg      Description of Parameter
   *@param  nextjsp  Description of Parameter
   */
  public InformationOnlyException(String msg, String nextjsp) {
    super(msg);
    this.jspNext = nextjsp;
  }


  /**
   *  Gets the jspNext attribute of the InformationOnlyException object
   *
   *@return    The jspNext value
   */
  public String getNext() {
    return jspNext;
  }


  /**
   *  Sets the jspNext attribute of the InformationOnlyException object
   *
   *@param  jspNext  The new jspNext value
   */
  public void setNext(String jspNext) {
    this.jspNext = jspNext;
  }
}
