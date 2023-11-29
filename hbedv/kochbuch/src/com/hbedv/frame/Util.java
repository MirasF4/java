package com.hbedv.frame;


import java.io.*;
import java.text.*;
import java.util.*;

/**
 *  Diverse Utilitymethoden, die den Fuxprogrammieraltag versuessen. <br>
 *  Alle Member und Methoden sind vollkommen unabhängig, d.h. erfordern keinen Include
 *  wie z.B. com.poi.*!
 *
 */
public class Util {
  public final static String MARK_ERROR = "**E: ";
  public final static String CRLF = "\r\n";
  public final static String CRLF_in_ALERT = "\\r\\n";

  public final static String UNDEFINED_STRING = "undefined";
  public final static int UNDEFINED_INT = -9999;

  public final static String HTML_EURO = "&euro;";
  public final static String HTML_QUOT = "&quot;";
  public final static String HTML_CRLF = "<br>";
  public final static String HTML_NBSP = "&nbsp;";
  public final static String HTML_LT = "&lt;";
  public final static String HTML_GT = "&gt;";
  public final static String HTML_AMP = "&amp;";

  public final static String CHECKBOX_SELECTED = "ON";

  private static String dateFormat = "dd.MM.yyyy";


  /**  Constructor for the Util object */
  private Util() { }


  public static int getIntFromStr(String sd) {
      return getIntegerFromStr(sd).intValue();
  }
  
  public static Integer getIntegerFromStr(String sd) {
      Integer result;
      if (sd == null) sd = "";
	  sd = sd.trim();
	  if (sd == "") sd = "0";
	  try {
	      result = new Integer(sd);
	  }
	  catch (NumberFormatException ex) {
	      result = new Integer(0);
	  }
	  return result;
  }

  
  public static boolean getBooleanFromStr(String sd)
  {
    if (sd == null) sd = "N";
    sd = sd.trim();
    return (sd.equalsIgnoreCase("Y") || sd.equalsIgnoreCase("Yes") || 
            sd.equalsIgnoreCase("J") || sd.equalsIgnoreCase("Ja") || 
            sd.equals("ON"));
  }
  
 
  public static boolean isCheckBoxChecked(String checkBoxValue) {
    return (checkBoxValue == null) ?
      false : checkBoxValue.equals(Util.CHECKBOX_SELECTED);
  }


  public static Float getFloatFromString(String sValue) {
    if (sValue != null) {
      return new Float(sValue.replace(',', '.'));
    }
    else {
      return null;
    }
  }

  public static String getZeroStrInt (String zahlStr) {
      String result = "0";
      if (zahlStr != null) {
          result = zahlStr.trim();
          result = result.replaceAll(" ","");
          try {
              new Integer(zahlStr);
          }
          catch (NumberFormatException ex) {
              result = "0";
          }
      }
      return result;
  }

  public static String getZeroStrDouble (String zahlStr) {
      String result = "0.0";
      if (zahlStr != null) {
          result = zahlStr.trim();
          result = result.replaceAll(" ","");
          NumberFormat f = getDecimalFormat(zahlStr);
          //Number myNumber;
          //boolean fehler = false;
          try {
            ((DecimalFormat) f).parse(result);
          }
          catch (ParseException pe) {
              result = "0.0";
          }
      }
      return result;
  }

  
  public static String getSimpleDateFormat() {
    return dateFormat;
  }

  public static String encode(String s) throws UnsupportedEncodingException {
    if (s == null) {
      return "";
    }
    return java.net.URLEncoder.encode(s, "UTF-8");
  }

	//Formatiert nach locale wenn Client übergeben wird
  public static String formatDoubleToStringNK(double fZahl, int mini, int maxi,Client client, boolean notNull) {
      String result = null;
      Double dZahl = new Double(fZahl);
      if (dZahl != null) {
          NumberFormat f = NumberFormat.getCurrencyInstance();
          //getCurrencyInstance(client.getLocalCur().getLocaleForDate());
          DecimalFormatSymbols dfs = ((DecimalFormat) f).getDecimalFormatSymbols();
          dfs.setCurrencySymbol("");
          ((DecimalFormat) f).setDecimalSeparatorAlwaysShown(true);
          ((DecimalFormat) f).setMaximumFractionDigits(maxi);
          ((DecimalFormat) f).setMinimumFractionDigits(mini);
          ((DecimalFormat) f).setDecimalFormatSymbols(dfs);
          result = (f.format(dZahl)).trim();
      }
      else {
          if (notNull) {
              result = "";
          }
      }
      return result;
  }


  public static String formatDoubleToStringNK(double fZahl, int mini, int maxi,Client client) {
      return formatDoubleToStringNK(fZahl,mini,maxi,client,false);
  }

  public static String formatDoubleToStringNK(Double fZahl, int mini, int maxi,Client client) {
      String result = null;
      if (fZahl != null) {
          result = formatDoubleToStringNK(fZahl.doubleValue(),mini,maxi,client,false);
      }
      return result;
  }

	public static String formatDoubleToStringNK(Double fZahl, int mini, int maxi,Client client, boolean notNull) {
		String result = null;
		if (notNull) result = "";
		if (fZahl != null) {
			result = formatDoubleToStringNK(fZahl.doubleValue(),mini,maxi,client,notNull);
		}
		return result;
	}

	public static String formatFloatToStringNK(float fZahl, int mini, int maxi,Client client) {
	  return formatDoubleToStringNK((new Double(fZahl)).doubleValue(), mini, maxi,client);
	}

	public static String formatFloatToStringNK(Float fZahl, int mini, int maxi,Client client) {
		String result = null;
		if (fZahl != null) {
			result = formatDoubleToStringNK(fZahl.doubleValue(), mini, maxi,client); 
		}
	  return result;
	}

	public static String formatFloatToStringNK(float fZahl, int mini, int maxi,Client client, boolean notNull) {
	  return formatDoubleToStringNK((new Double(fZahl)).doubleValue(), mini, maxi,client,notNull);
	}

	public static String formatFloatToStringNK(Float fZahl, int mini, int maxi,Client client, boolean notNull) {
	    String result = null;
		if (notNull) result = "";
		if (fZahl != null) {
			result = formatDoubleToStringNK(fZahl.doubleValue(), mini, maxi,client,notNull);
		} 
		return result; 
	}

	
  public static String formatStackTrace(Exception e) {
    StringWriter stringError = new StringWriter();
    PrintWriter printError = new PrintWriter(stringError);
    e.printStackTrace(printError);
    return stringError.toString();
  }


  public static String convertChars(Object s) {
    return convertChars((String) s);
  }


  /**
   *  Konveriert alle Zeichen die groesser 128 sind in entsprechende HTMLSchreibweise
   *  und ", &, <, >
   *
   *@param  s  Description of Parameter
   *@return    Description of the Returned Value
   */

  public static String convertCharsCRLF(String s) {
    char[] str = s.toCharArray();
    boolean nonbsp = false;
    StringBuffer buf = new StringBuffer(str.length);
    String prefix = "&#";
    for (int i = 0; i < str.length; i++) {
      if (str[i] < 128) {
        switch (str[i]) {
          case 32:
            if (nonbsp) {
              buf.append(HTML_NBSP);
              nonbsp = false;
              break;
            }
            else {
              buf.append(str[i]);
              break;
            }
          case '"':
            buf.append(HTML_QUOT);
            break;
          case Money.EURO_AS_CHAR:
            buf.append(HTML_EURO);
            break;
          case '&':
            buf.append(HTML_AMP);
            break;
          case '<':
            buf.append(HTML_LT);
            break;
          case '>':
            buf.append(HTML_GT);
            break;
          case 13:// isses ein Windows CR/LF ??
            if ((i + 1) < str.length && str[i + 1] == 10) {// stehts nicht an letzter stelle und ist zeichen danach ein lf
              buf.append(HTML_CRLF);
              nonbsp = true;
            }
            break;
          case 10:// isses ein Unix LF ??
            if (i == 0 || str[i - 1] != 13) {// stehts an erster stelle oder ist zeichen davor KEIN cr
              buf.append(HTML_CRLF);
              nonbsp = true;
            }
            break;
          default:
            buf.append(str[i]);
        }
      }
      else {
        buf.append(prefix + (int) str[i] + ";");
      }
    }
    return buf.toString();
  }


  /**
   *  Description of the Method
   *
   *@param  map            Description of Parameter
   *@return                Description of the Returned Value
   *@exception  Exception  Description of Exception
   */
  @SuppressWarnings("unchecked")
  public static ArrayList convertASMtoArrayList(AliceSortMap map)
    throws Exception {
    ArrayList list = new ArrayList();
    int i;
    int b;
    list.clear();
    for (i = 0; i < map.getKeys(0).size(); i++) {
      for (b = 0; b < map.getMaxKeys(); b++) {
        list.add(Util.nvl(map.getKeys(b).get(i), ""));
      }
    }
    return list;
  }

	public static Integer nvlInteger (Integer zahl, int value) {
		if (zahl == null) zahl = new Integer(value);
		return zahl;
	}

	public static Integer nvlInteger (Integer zahl, Integer value) {
		if (value == null) value = new Integer(0);
		return nvlInteger (zahl, value.intValue());
	}

	public static int nvlIntegerToInt (Integer zahl, int value) {
		return nvlInteger (zahl, value).intValue();
	}

	public static int nvlIntegerToInt (Integer zahl, Integer value) {
		return nvlInteger (zahl, value).intValue();
	}


  public static String convertChars(String s) {
    char[] str = s.toCharArray();
    StringBuffer buf = new StringBuffer(str.length);
    String prefix = "&#";
    for (int i = 0; i < str.length; i++) {
      if (str[i] < 128) {
        switch (str[i]) {
          case '"':
            buf.append(HTML_QUOT);
            break;
          case '&':
            buf.append(HTML_AMP);
            break;
          case '<':
            buf.append(HTML_LT);
            break;
          case '>':
            buf.append(HTML_GT);
            break;
          default:
            buf.append(str[i]);
        }
      }
      else {
        buf.append(prefix + (int) str[i] + ";");
      }
      /*
       *  endif
       */
    }
    /*
     *  endfor
     */
    return buf.toString();
  }



  /**
   *  Verhindert, dass nicht null auf HTML-Seiten angezeigt wird, sowie Umwandlung
   *  von Strings in HTML-konforme Zeichen
   *
   *@param  toConvert       zu konvertierender String
   *@param  ersatzWennNull  Ersatzzeichen wenn toConvert=null
   *@return                 konvertierter String
   */
  public static Object nvlConvert(Object toConvert, Object ersatzWennNull) {

    if (toConvert == null && ersatzWennNull == null) {
      throw new NullPointerException("toConvert == null && ersatzWennNull == null");
    }
    if (ersatzWennNull == null) {
      ersatzWennNull = "";
    }
    return convertCharsCRLF(nvl(toConvert, ersatzWennNull).toString());
  }


  public static Object nvl(Object original, Object ersatzWennNull) {
    if (original == null) {
      if (ersatzWennNull instanceof String) {
        return ((String) ersatzWennNull).trim();
      }
      else {
        return ersatzWennNull;
      }
    }
    else {
      if (original instanceof String) {
        return ((String) original).trim();
      }
      else {
        return original;
      }
    }
  }



  public static synchronized String informationToDisplay(Client client) {
    String toDisplay = "";
    if (client.getInformant().hasUIInformation()) {
      toDisplay = "<script>alert('" + client.getInformant().getAndRespectConfirmInformation() + "');</script>";
    }

    return toDisplay;
  }


  /**
   *  Stringmanipulation. <br>
   *  Description of the Method
   *
   *@param  sValue         "xxxhdl={hdl}&yyyymarke={marke}&sssfabrikat={fabrikat}"
   *@param  tofind         {"{hdl}", "{marke}", "{fabrikat}", "{magic1}", "{time_ms}"}
   *@param  replacement    {"hdl", "marke", "fabrikat", "magic1", "time_ms"}
   *@return                "xxxhdl=hdl&yyyymarke=marke&sssfabrikat=fabrikat"
   *@exception  Exception  Description of Exception
   */
  public static String tokenReplace(String sValue, String[] tofind, String[] replacement)
    throws Exception {
    StringBuffer sbValue = new StringBuffer(sValue);
    int start = 0;
    int end = 0;
    int sbLen = sbValue.length();
    boolean found = false;
    for (int xToken = 0; xToken < tofind.length; xToken++) {
      do {
        start = sbValue.toString().indexOf(tofind[xToken]);
        if (found = (start > 0)) {
          end = start + tofind[xToken].length();
          sbValue.replace(start, end, replacement[xToken]);
        }
      } while (found && start < sbLen);
    }
    return sbValue.toString();
  }


  /**
   *  Description of the Method
   *
   *@param  sToCount  Description of Parameter
   *@return           Description of the Returned Value
   */
  public static int asciiSum(String sToCount) {

    String tmpStr = new String(sToCount);
    int x = 0;

    if (tmpStr != null && tmpStr.length() > 0) {
      for (int i = 0; i < tmpStr.length(); i++) {
        x += tmpStr.charAt(i);
      }
    }

    return x;
  }


  /**
   *  Stringmanipulation. <br>
   *  Adds a feature to the UniqueTokenAtEnd attribute of the KlientBean object
   *
   *@param  value  The feature to be added to the UniqueTokenAtEnd attribute
   *@return        Description of the Returned Value
   *@return        Description of the Returned Value
   */
  public static synchronized String addUniqueTokenAtEnd(String value) {
    return value + "_" + System.currentTimeMillis();
  }



  public static double round(float f, int stellen)
    throws Exception {
    return Util.round((double) f, stellen);
  }


  public static int round2Int(double f)
    throws Exception {
    int i = (int) round(f, 0);
    return i;
  }


  public static double round(double f, int stellen)
    throws Exception {
    if (stellen < 0 || stellen > 5) {
      throw new Exception("stellen < 0 || stellen > 5");
    }
    double fac[] = {1, 10, 100, 1000, 10000};
    return (Math.round(f * fac[stellen])) / fac[stellen];
  }

  
  public static DecimalFormat getDecimalFormat(String strZahl) {
      NumberFormat f = NumberFormat.getInstance();
      DecimalFormatSymbols dfs = new DecimalFormatSymbols();
      if (strZahl.lastIndexOf(".") != -1 && strZahl.lastIndexOf(",") == -1) {
          dfs.setDecimalSeparator('.');
      }
      else {
          dfs.setDecimalSeparator(',');
          dfs.setGroupingSeparator('.');
      }
      ((DecimalFormat) f).setDecimalSeparatorAlwaysShown(true);
      ((DecimalFormat) f).setDecimalFormatSymbols(dfs);
      return (DecimalFormat) f;
  }
  

  public static double parseString2Double(String strZahl) {
    if (strZahl.length() != 0 && strZahl != null) {
      NumberFormat f = getDecimalFormat(strZahl);
      Number myNumber;
      try {
        myNumber = ((DecimalFormat) f).parse(strZahl);
      }
      catch (ParseException pe) {
        return 0.0d;
      }
      double dZahl = myNumber.doubleValue();
      return (dZahl);
    }
    else {
      return 0.0d;
    }
  }
  

  public static String encodeUnicode (String s)
  {
     StringBuffer buf = new StringBuffer ();
     int cnt = s.length ();
     for (int i=0; i < cnt; i++)
     {
         buf.append ((int)(s.charAt (i)));
         buf.append ('+');
     }
     return buf.toString ();
  }
}
