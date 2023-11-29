package com.hbedv.frame;


/**
 *  Diese Klasse wird zur Infomationsweitergabe verwendet. Sie haelt eine Information
 *  und/oder eine Exception. Desweiteren verwaltet sie eine confirmed Variable, die
 *  sich um die Bestaetigung der Information kümmert. <BR>
 *  confirmed=true ... Information wurde abgeholt. <BR>
 *  confirmed=false ... Information wurde noch nicht abgeholt .
 *
 *      $
 */
public class Informant {
  //Information
  private String information = "";

  private Informant detail = null;

  //Information bestaetigt?
  private boolean confirmed = false;
  private boolean popup = false;


  /**
   *  Wenn nicht confirmed, dann return information und setze confirmed=true;<BR>
   *  sonst: ""
   *
   *@return    The andRespectConfirmInformation value
   */
  public synchronized String getAndRespectConfirmInformation() {
    if (!this.confirmed) {
      this.confirmed = true;
      return information;
    }
    else {
      return "";
    }
  }

  /**
   *  Retourniere confirmed.
   *
   *@return    The confirmed value
   */
  public synchronized boolean isConfirmed() {
    return this.confirmed;
  }


  /**
   *  Setze ein neue Information, unter Beachtung von comfirmed (=true).
   *
   *@param  newInformation  The new information value
   */
  public synchronized void setAndRespectInformation(String newInformation) {
    this.confirmed = false;
    this.popup = false;
    information = newInformation;
  }

  public synchronized void setAndRespectInformation(String newInformation, boolean newPopup) {
    this.confirmed = false;
    this.popup = newPopup;
    information = newInformation;
  }


  public synchronized void setAndRespectInformation(String newInformation, String newDetailInformation) {
    this.confirmed = false;
    this.popup = false;
    information = newInformation;

    if (newDetailInformation != null && newDetailInformation.length() > 0) {
      detail = new Informant();
      detail.confirmed = false;
      detail.information = newDetailInformation;
    }
  }


  public synchronized Informant getDetail() {
    return detail;
  }

  /**
   *  Setze confirmed.
   *
   *@param  confirmed  The new confirmed value
   */
  public void setConfirmed(boolean confirmed) {
    this.confirmed = confirmed;
  }

  /**
   *  Gets the information attribute of the Informant object
   *
   *@return    The information value
   */
  public synchronized boolean hasUIInformation() {
    return (this.information != null && !this.information.equals("") && !this.confirmed);
  }

  /**  Sets the reset attribute of the Informant object */
  public synchronized void resetAndRespectConfirm() {
    if (this.confirmed) {
      this.confirmed = false;
      information = "";
    }
  }
  public boolean isPopup() {
    return popup;
  }
}
