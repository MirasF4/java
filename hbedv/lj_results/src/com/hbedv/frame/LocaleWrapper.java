package com.hbedv.frame;


import java.util.*;

/**
 *  Diese Klasse haelt die Locales:
 *  <ol>
 *    <li> Currencies (Geld), Date (Datum, Nummern) und </li>
 *    <li> Resourcebundletexte </li>
 *  </ol>
 *  !!lo:
 */
public class LocaleWrapper {
  private Locale localeForLabels = null;
  private Locale localeForDate = null;


  /**
   *  Hole das Locale fuer Currencies.
   *
   *@return    The localeForLabels value
   */
  public Locale getLocaleForLabels() {
    return this.localeForLabels;
  }


  /**
   *  Hole das Locale fuer das Daten(Datum) und Nummern.
   *
   *@return    The localeForNumber value
   */
  public Locale getLocaleForDate() {
    return this.localeForDate;
  }



  /**
   *  Setze alle Locales auf localeNew.
   *
   *@param  localeNew  The new allLocales value
   */
  public void setAllLocales(Locale localeNew) {
    localeForLabels = localeNew;
    localeForDate = localeNew;
  }



  /**
   *  Setze das Locale fuer Daten und Nummern.
   *
   *@param  localeForDateNew  The new localeForDate value
   */
  public void setLocaleForDate(Locale localeForDateNew) {
    this.localeForDate = localeForDateNew;
  }


  /**
   *  Setze das Locale fuer Labels (Resourcebundel).
   *
   *@param  localeForLabels  The new localeForLabels value
   */
  public void setLocaleForLabels(Locale localeForLabelsNew) {
    this.localeForLabels = localeForLabelsNew;
  }
}
