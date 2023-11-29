package com.hbedv.frame.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  Diverse Utilitymethoden zur <b>Datums und Zeitmanipulation.</b> <br>
 *  Alle Member und Methoden sind vollkommen unabhängig, d.h. erfordern keinen Include
 *  wie z.B. com.poi.*! $
 */
public class DateAndTime {

  /**  Constructor for the DateAndTime object */
  private DateAndTime() { }


  /**
   *  Gets the sQLDateFromYMD attribute of the DateAndTime class
   *
   *@param  year                Description of Parameter
   *@param  month               Description of Parameter
   *@param  date                Description of Parameter
   *@return                     The sQLDateFromYMD value
   *@exception  ParseException  Description of Exception
   */
  public static java.sql.Date getSQLDateFromYMDWithException(int year, int month, int date)
  throws Exception {
    java.sql.Date back = null;
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.set(year, month - 1, date);

    back = new java.sql.Date(calendar.getTime().getTime());

    int testYear = calendar.get(Calendar.YEAR);
    int testMonth = calendar.get(Calendar.MONTH) + 1;
    int testDate = calendar.get(Calendar.DATE);

    if (year != testYear || month != testMonth || date != testDate) {
      throw new Exception("Ungueltiger Datumswert!");
    }
    return back;
  }


  public static java.sql.Date getSQLDateFromYMD(int year, int month, int date)
	{
		java.sql.Date back = null;
		try {
			back = getSQLDateFromYMDWithException(year, month, date);
		}
		catch (Exception e) {
			//nix tun !!!
		}
	  return back;
	}


  public static long getTimeInMs(String dateTime,Locale locale, String timePattern)
		throws ParseException {

		if (dateTime == null) {
		  throw new NullPointerException("dateTime == null");
		}

		//DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		if (timePattern == null || timePattern.trim().equalsIgnoreCase("")) {
			timePattern = getTimepattern(locale).trim();
		}
		String sDateFormat = getDatepattern(locale).trim() + " " + timePattern;
		//String sDateFormat = getDatepattern(locale).trim() + " HH:mm";
		DateFormat dateFormat = new SimpleDateFormat(sDateFormat);
		java.util.Date ud = dateFormat.parse(dateTime);
		return ud.getTime();
	  }



  /**
   *  Datemanipulation. <br>
   *  Hole das zugehoerige Alicedatepattern zu locale.<BR>
   *  !!datecheck: 9
   *
   *@param  locale  Locale
   *@return         The datepattern value
   */
  public static String getDatepattern(Locale locale) {

    if (locale == null) {
      throw new NullPointerException("locale == null");
    }
    Locale.setDefault(locale);
    SimpleDateFormat sDF = new SimpleDateFormat();
    String sDFP = sDF.toPattern();
    StringBuffer sbDFP = new StringBuffer(sDFP);
    int xEnd = sDFP.indexOf(" ");
    String sRet = sbDFP.substring(0, xEnd);
    /*  XBE
        Wir brauchen immer eine 4 stellige Jahreszahl
        weil wir einen Datumsbereich von 1900 bis 2099
        abdecken müssen!
        Daher unten stehende Erweiterung!
    */
    // Umwandeln in 4 stellige Jahreszahl
    int iFind = sRet.toLowerCase().indexOf("yyyy");
    if (iFind < 0) {
      iFind = sRet.toLowerCase().indexOf("yy");
      if (iFind > -1) {
        String sTemp1 = sRet.substring(0, iFind);
        String sTemp2 = sRet.substring(iFind);
        sRet = sTemp1 + "yy" + sTemp2;
      }
    }
    return sRet;
  }



  /**
   *  Gets the datepatternExample attribute of the DateAndTime class
   *
   *@param  locale  Description of Parameter
   *@return         The datepatternExample value
   */
  public static String getDatepatternExample(Locale locale) {

    if (locale == null) {
      throw new NullPointerException("locale == null");
    }
    Double timestamp = new Double("1004000000000");
    java.sql.Date datum = new java.sql.Date(timestamp.longValue());
    return DateAndTime.formatDate(datum, locale);
  }

  public static int getDatepatternLength(Locale locale) {
  	
  	return getDatepatternExample(locale).length();
  }

  /**
   *  Datemanipulation. <br>
   *  Hole das zugehoerige Alicetimepattern zu locale.<BR>
   *  !!datecheck: 8
   *
   *@param  locale         Locale
   *@return                The timepattern value
   *@exception  Exception  Description of Exception
   */
  public static String getTimepattern(Locale locale){
    //precondition
    if (locale == null) {
      throw new NullPointerException("locale == null");
    }
    Locale.setDefault(locale);
    SimpleDateFormat sDF = new SimpleDateFormat();
    String sDFP = sDF.toPattern();
    StringBuffer sbDFP = new StringBuffer(sDFP);
    int xEnd = sDFP.indexOf(" ");
    return sbDFP.substring(xEnd + 1, sDFP.length());
  }


  /**
   *  Gets the monthAsString attribute of the Util class
   *
   *@param  datum          Description of Parameter
   *@param  locale         Description of Parameter
   *@return                The monthAsString value
   *@exception  Exception  Description of Exception
   */
  public static String getMonthAsString(Date datum, Locale locale)
    throws Exception {
    //precondition
    if (datum == null) {
      throw new Exception("datum == null");
    }

    if (locale == null) {
      throw new Exception("locale == null");
    }

    String monat = "";
    // ab 3xM gibt der DateFormater einen String als Rückgabeparameter zurück
    // bei 3xM wird z.B. Nov für November zurückgegeben
    // ab 4xM wird die lange Bezeichnung des Monats zurückgegeben
    DateFormat df = new SimpleDateFormat("MMMM", locale);
    monat = df.format(datum);

    return monat;
  }


  /**
   *  Datemanipulation. <br>
   *  Rechnet zu einem bestimmten Datum x Tage hinzu
   *
   *@param  inDatum  Das Datum, zu dem hinzugezählt werden soll
   *@param  anzTage  Anzahl Tage, die hunzugezählt werden sollen. Werte < 0 um Tage
   *      abzuziehen
   *@return          das neue Datum
   */
  public static synchronized java.sql.Date addDays(java.sql.Date inDatum, int anzTage) {
    long anzZeit = 86400000 * ((long) anzTage);
    long alteZeit = inDatum.getTime();
    return new java.sql.Date(alteZeit + anzZeit);
  }

  public static synchronized java.sql.Date addDays(java.sql.Date inDatum, Integer anzTage) {
  	
  	if (anzTage == null) // nichts tun (ungeöffnet zurück, wie alte Jungfrau)
  	  return inDatum;  
  	else
	  	return addDays(inDatum,anzTage.intValue());
	}

	public static synchronized java.sql.Date addYears(java.sql.Date inDatum, Integer anzJahre) {
		if (anzJahre == null) { // nichts tun 
		  return inDatum;  
		}
		else {
			return addYears(inDatum, anzJahre.intValue());
		}
	}

	public static synchronized java.sql.Date addYears(java.sql.Date inDatum, int anzJahre) {
		int tag = getDay(inDatum).intValue();
		int monat = getMonth(inDatum).intValue();
		int jahr = getYear(inDatum).intValue();
		jahr = jahr + anzJahre;
				
		java.sql.Date result = getSQLDateFromYMD(jahr, monat, tag);
				
		return result;
  }


	/**
	 *  Datemanipulation. <br>
	 *  Rechnet die Differenz von 2 Datumswerten in Tagen aus
	 *
	 *@param  vonDatum 
	 *@param  bisDatum
	 *      
	 *@return Differenz in Tagen (Integer)
	 */
	public static synchronized Integer diffDatesInDays(java.sql.Date vonDatum, java.sql.Date bisDatum) {
			
		long diff = bisDatum.getTime() - vonDatum.getTime(); 
		long erg1 = diff/86400000;
		int erg2 = (int)erg1;  
		Integer result = new Integer(erg2);
		return result; 
	}

	public static synchronized Integer diffDatesInSeconds(java.sql.Date vonDatum, java.sql.Date bisDatum) {
			
			long diff = bisDatum.getTime() - vonDatum.getTime(); 
			long erg1 = diff/1000;
			int erg2 = (int)erg1;  
			Integer result = new Integer(erg2);
			return result; 
		}


	public static synchronized java.sql.Date now() {
		return new java.sql.Date(System.currentTimeMillis());	
	}

  /**
   *  Description of the Method <BR>
   *  !!datecheck: 7
   *
   *@param  sd                  Description of Parameter
   *@param  locale              Description of Parameter
   *@return                     Description of the Returned Value
   *@exception  Exception       Description of Exception
   *@exception  ParseException  Description of Exception
   */
  public static java.sql.Date parseDateRespectEmpty(String sd, Locale locale)
    throws Exception, ParseException {
    if (sd == null || sd.equals("")) {
      return null;
    }

    DateFormat sdf = new SimpleDateFormat(DateAndTime.getDatepattern(locale));
    java.util.Date ud = sdf.parse(sd);
    return new java.sql.Date(ud.getTime());
  }


  /**
   *  Datemanipulation. <br>
   *  Formatiere date entsprechend dem locale. Ist date = null wird "" zurueckgegeben.
   *  !!datecheck: 12
   *
   *@param  date
   *@param  locale
   *@return         formatiertes date; oder ""
   */
  public static String formatDate(java.sql.Date date, Locale locale) {
    if (date == null) {
		return null;
    }
    if (locale == null) locale = Locale.GERMAN;
    DateFormat f = new SimpleDateFormat(DateAndTime.getDatepattern(locale));
    return f.format(date);
  }



  /**
   *  Description of the Method
   *
   *@param  locale  Description of Parameter
   *@param  tmstmp  Description of Parameter
   *@return         Description of the Returned Value
   */
  public static String formatDate(java.sql.Timestamp tmstmp, Locale locale) {
    if (tmstmp == null) {
		  return null;
    }
    DateFormat f = new SimpleDateFormat(DateAndTime.getDatepattern(locale));
    return f.format(tmstmp);
  }


  /**
   *  Datemanipulation. <br>
   *  Description of the Method
   *
   *@param  date    Description of Parameter
   *@param  locale  Description of Parameter
   *@return         Description of the Returned Value
   */
  public static String formatUtilDate(java.util.Date date, Locale locale) {
    if (date == null) {
			return null;
    }
    DateFormat f = new SimpleDateFormat(DateAndTime.getDatepattern(locale));
    return f.format(date);
  }


  /**
   *  Datemanipulation. <br>
   *  Description of the Method
   *
   *@param  d  Description of Parameter
   *@return    Description of the Returned Value
   */
  public static String formatTimeHHmm(java.sql.Timestamp d) {
    if (d == null) {
			return null;
    }
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    return dateFormat.format(d);
  }
	
  
	public static String getZeitStempelSek() {
  		String zeit = DateAndTime.formatTimeHHmmss(new java.sql.Timestamp(System.currentTimeMillis()));
  		java.sql.Date dat = new java.sql.Date(System.currentTimeMillis());
  		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  		String datum = df.format(dat);
  		return datum + " " + zeit;
  	}

  
  /**
	 *  Datemanipulation. <br>
	 *  Description of the Method
	 *
	 *@param  d  Description of Parameter
	 *@return    Description of the Returned Value
	 */
	public static String formatTimeHHmmss(java.sql.Timestamp d) {
	  if (d == null) {
			  return null;
	  }
	  DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	  return dateFormat.format(d);
	}

  /**
   * Liefert das Jahr an Hand des Timestamps zurück
	 * @param d
	 * @return
	 */
	public static Integer getYear(java.sql.Timestamp d) {
		java.sql.Date d2 = new java.sql.Date(d.getTime());
  	return getYear(d2);
  }

	/**
	 * Liefert das Jahr an Hand des Dates zurück
	 * @param d
	 * @return
	 */
  public static Integer getYear(java.sql.Date d) throws NumberFormatException {
	  DateFormat f = new java.text.SimpleDateFormat("yyyy-mm-dd");
	  String datum = f.format(d);
	  String jahrStr = datum.substring(0,4);
		Integer jahr = new Integer(jahrStr);
		
	  return jahr;
	}


	/**
	 * Liefert das Monat an Hand des Timestamps zurück
	 * @param d
	 * @return
	 */
	public static Integer getMonth(java.sql.Timestamp d) {
		java.sql.Date d2 = new java.sql.Date(d.getTime());
		return getMonth(d2);
  }
  
	/**
	 * Liefert das Monat an Hand des Dates zurück
	 * @param d
	 * @return
	 */
	public static Integer getMonth(java.sql.Date d) throws NumberFormatException {
		
		DateFormat f = new java.text.SimpleDateFormat("yyyy-MM-dd");
	  String datum = f.format(d);
	  String monatStr = datum.substring(5,7);
		Integer monat = new Integer(monatStr);
		
	  return monat;
	 }


	/**
	 * Liefert den Tag an Hand des Timestamps zurück
	 * @param d
	 * @return
	 */
	public static Integer getDay(java.sql.Timestamp d) {
		java.sql.Date d2 = new java.sql.Date(d.getTime());
		return getDay(d2);
  }
  
	/**
	 * Liefert den Tag an Hand des Dates zurück
	 * @param d
	 * @return
	 */
	public static Integer getDay(java.sql.Date d) throws NumberFormatException {
		
		DateFormat f = new java.text.SimpleDateFormat("yyyy-MM-dd");
	  String datum = f.format(d);
	  String tagStr = datum.substring(8,10);
		Integer tag = new Integer(tagStr);
		
	  return tag;
	 }
	
	/**
	 * Prüft ob der Tag1 gleich dem Tag2 ist
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static boolean day1EqualsDay2(java.sql.Date day1, java.sql.Date day2) {
		boolean equal = false;
		
		if (diffDatesInDays(day1, day2).intValue() == 0 &&
				getDay(day1).equals(getDay(day2)))
			equal = true;
					
		return equal;
	}

	/**
	 * Prüft ob der Tag1 nach dem Tag2 liegt
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static boolean day1AfterDay2(java.sql.Date day1, java.sql.Date day2) {
		boolean greater = false;
		
		if (day2 == null)
			return false;
		
		if (diffDatesInDays(day1, day2).intValue() > 0 &&
				(getDay(day1).intValue() >  getDay(day2).intValue() ||
				getMonth(day1).intValue() > getMonth(day2).intValue() ||
				getYear(day1).intValue() > getYear(day2).intValue()))
			greater = true;
					
		return greater;
	}



	/**
	 * Prüft ob der Tag1 vor dem Tag2 liegt
	 * @param day1
	 * @return
	 */
	public static boolean day1BeforeDay2(java.sql.Date day1, java.sql.Date day2) {
		boolean greater = false;

		if (day1.after(day2) &&
				(getDay(day1).intValue() >  getDay(day2).intValue() ||
				getMonth(day1).intValue() > getMonth(day2).intValue() ||
				getYear(day1).intValue() > getYear(day2).intValue()))
			greater = true;
					
		return greater;
	}

	/**
	 * Prüft ob der Tag vor dem aktuellen Tag liegt
	 * @param day1
	 * @return
	 */
	public static boolean day1BeforeToday(java.sql.Date day1) {
		return day1BeforeDay2(day1, DateAndTime.now());
	}
	
	/**
	 * Prüft ob der Tag nach dem aktuellen Tag liegt
	 * @param day1
	 * @return
	 */
	public static boolean day1AfterToday(java.sql.Date day1) {
		return day1AfterDay2(day1, DateAndTime.now());
	}

	/**
	 * Prüft ob der Tag nach dem aktuellen Tag liegt
	 * @param day1
	 * @return
	 */
	public static boolean day1EqualsToday(java.sql.Date day1) {
		return day1EqualsDay2(day1, DateAndTime.now());
	}
	

	public static java.sql.Date trunc(java.sql.Date date) {
		
		return getSQLDateFromYMD(getYear(date).intValue(), getMonth(date).intValue(), getDay(date).intValue());
			
	}
	
	
	/**
	 * Compares two Dates without the Time
	 * 
   * @param Date 1 to compare
   * @param Date 2 to compare
   * @return true or false
   */
  public static boolean compareDates(java.sql.Date date1, java.sql.Date date2) {
		boolean equals = false;
		java.sql.Date date1ToComp = null;
		java.sql.Date date2ToComp = null;
		if (date1 != null && date2 != null) {
			date1ToComp = DateAndTime.truncDate(date1);
			date2ToComp = DateAndTime.truncDate(date2);
			if (date1ToComp != null && date2ToComp != null)
				equals = date1ToComp.equals(date2ToComp);
		}
		return equals;
	}
	
	/**
	 * Truncates (Clears the Time fields) a java.sql.Date
	 * 
   * @param Date to truncate
   * @return truncated Date
   */
  public static java.sql.Date truncDate(java.sql.Date dateToTrunc) {
		java.sql.Date returnDate = null;
		if (dateToTrunc != null) {
			Calendar cal1 = new GregorianCalendar();
			cal1.clear();
			cal1.setTime(new java.sql.Date(dateToTrunc.getTime()));
			cal1.clear(Calendar.HOUR);
			cal1.clear(Calendar.MILLISECOND);
			cal1.clear(Calendar.MINUTE);
			cal1.clear(Calendar.SECOND);
			returnDate = new java.sql.Date(cal1.getTime().getTime());
		}
		return returnDate;
	}

}
