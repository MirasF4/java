/******************************************************************************
 *  basis JavaScript;
 *
 *  - diese basis js wird ins 'oberste' jsp includiert
 *    und steht somit allen anderen zur verfügung
 *
 *  - Der Umfang wird klein und sehr kompakt gehalten
 *    Sprachausgaben sind nicht vorgesehen!
 *
 *  - Alle JavaScriptfunktionen sind "localefaehig".
 *
 * ****************************************************************************
 *
 *@Source      $Source: D:/cvs_src/java/hbedv/kochbuch/include/basic.js,v $
 *@Revision    $Revision: 1.1.1.1 $
 *@Change      Last Change: $Author: hubert $; $Date: 2006/02/25 12:27:28 $
 *@author      fuc
 *@created     27.11.2003
 ******************************************************************************
 *
 * Methoden:
 *
 *  String  function ba_rTrim(String cParm)
 *  String  function ba_lTrim(String cParm)
 *  String  function ba_allTrim(String cParm)
 *
 *  boolean function ba_isInt(int value)
 *  boolean function ba_isFloat(float value)
 *  float   function ba_round(float value, int kommastellen)
 *
 *  void    function ba_help(chapter)
 *  void    function ba_helper(origCmd, subcmd, source, target)
 *  void    function ba_helperElem()
 *
 *  void    function ba_cursor_up_down(form,feld,minzahl,maxzahl,Zeichenkette)
 *
 *
 *************************************************************************/

// Sting Funktionen *****************************************************
/**
 *  Blank entfernen von rechts.
 *
 *  @param    String
 *  @return   String
 **/
function ba_rTrim(cParm)
{
 var n = cParm.length;
 while(cParm.substr(n-1,1) == " ")
 {
  cParm = cParm.substring(0,n-1);
  n--;
 }
 return cParm;
}

/**
 *  Blank-entfernen von links
 *
 *  @param    String
 *  @return   String
 **/
function ba_lTrim(cParm)
{
 var n = cParm.length;
 while(cParm.substring(0,1) == " ")
 {
  cParm = cParm.substring(1,n);
  n--;
 }
 return cParm;
}


/**
 *  Blank entfernen, beidseitig
 *  beidseitig
 *
 *  @param    String
 *  @return   String
 **/
function ba_allTrim(cParm)
{
 return  ba_lTrim(ba_rTrim(cParm));
}


// Zahlen ****************************************************************
/**
 * ba_isInt
 * Pruefung auf integer
 *
 * @param  value (String)
 * @return boolean isInt
 **/
function ba_isInt(value)
{
 if(isNaN(value) == true)
   return false;

 if( String(value).indexOf(".") != -1)
   return false;

 return true;
}


/**
 * Pruefung auf float
 *
 * @param value String
 * @param boolean
 **/
function ba_isFloat(value)
{
 if(isNaN(value) == true) // keine Zahl!
 {
  // Auf Zahl prüfen !!

  // Keine Zahl !!! Dann prüfen wir auf deutsche Schreibweise.
  // ACHTUNG Wert im Feld wird NICHT verändert !!!!
  n1 = value.lastIndexOf(",");
  n2 = value.lastIndexOf(".");

  // Ist Positition des Kommas grösser als Punkt, dann
  // sollte es ein Kommabeistrich sein
  if (n1 > n2)
  {
    nL = value.length;
    ii = 0;
    Erg = "";

    // Ergebnis String zusammenbauen
    // ohne Leerzeichen und ohne Tausender Punkt Trennzeichen !!!
    while (ii < nL)
    {
      // Leerzeichen entfernen
      if (value.substr(ii,1) != " ")
      {
        // Tausender Punkt(e) entfernen
        if (value.substr(ii,1) != '.')
        {
          // Beistrich Komma durch Punkt Komma ersetzen
          if (value.substr(ii,1) == ',')
          {
            if (ii == n1)
              Erg = Erg + ".";
          }
          else
          {
            // sonst Ziffer zum String addieren
            Erg = Erg + value.substr(ii,1);
          }
        }
      }
      ii++;
    }

    // Ergebnis prüfen !!!!
    if (isNaN(Erg) == true )
      return false; // keine Zahl
    return true;
  }
  else
  {
    // Else vom: if (n1 > n2)  // ist keine Zahl!
    return false;
  }
 }

return true;
}


/**
 * runden
 *
 * anmerkung: nicht mit Number ...
 * denn da gibts probleme beim Konvertieren.
 *
 * verwendung:  für MIS
 * @autor       xbe
 * @param       string;
 * @param       int   anzahl kommastellen;
 * @return      string;
 */
function ba_round(value, kommastellen)
{
  value = ""+value;
  fValue = value.replace(",",".");

  for (komma = 0; komma < kommastellen; komma ++)
    fValue = fValue * 10;

  fValue = Math.round(fValue);

  for ( komma = 0; komma < kommastellen; komma ++)
    fValue = fValue / 10;

  value = "" + fValue;  // wieder in String konvertieren!
  value = value.replace(".",",");

  return value;
}



/***************************************************************************
 * hilfe
 ***************************************************************************/

/**
 *
 */
function ba_help(chapter)
{
  winHelp= window.open("/public_html/help.html"+"#"+chapter,"Hilfe",'width=700,height=600,resizable=1,scrollbars=1');
  winHelp.focus();
}

/**
 *
 */
function ba_helper(origCmd, subcmd, source, target)
{
  if (source != "") {
    sName = source.name;
    sValue = source.value;

    if (target == null)
      target = source;

    tName = target.name;

    if (sValue != "") {
      url = '?cmd=helper';
      url += '&origCmd=' + origCmd + '&subcmd=' + subcmd + '&source=' + sName +
             '&value=' + sValue + '&target=' + tName;

      top.frames.helper.location.href = url;
    }
    else {
      target.value = "";
    }
  }
  else {
    top.frames.helper.location.href = '?cmd=helper&subcmd=' + subcmd + '&source=&value=&target=';
  }
}


/**
 *
 * @return
 */
function ba_helperElem()
{
  this.id = arguments[0] || "0";
  this.value = arguments[1] || "";
}



/*******************************************************************************
 //
 // Navigation mit Cursortasten zwischen den Eingabefeldern
 // =======================================================
 //
 // Voraussetzung: Feldnamen = Zeichenkette + fortaufende Zahlen
 // Zahlenreiehe darf nicht unterbrochen sein
 // Bsp.: Felder k100 bis k115
 // <!-- Bsp. Aufruf: <input type="text" name="k100" value="" onKeyDown="javascript:cursor_up_down(uIFrameForm,this,100,115)" >  -->
 *
 * verwendung:  für MIS
 * @autor       xbe
 *****************************************************************************/
function ba_cursor_up_down(form,feld,minzahl,maxzahl,Zeichenkette)
{

  var nCode = window.event.keyCode;
  var cTaste = String.fromCharCode(nCode);
  var cFeldName = "";
  var nFeld = 0;

  if (nCode == 38) cTaste = "+";        // Cursor nach oben
  if (nCode == 40) cTaste = "-";        // Cursor nach unten

  if (cTaste == "-" || cTaste == "+")
  {
    cFeldName = feld.name;
    cFeldName = cFeldName.substr(Zeichenkette.length,4);
    cFeldName = trim(cFeldName);
    nFeld = parseInt(cFeldName);
    if (cTaste == "-")
    {
      nFeld++;
      if (nFeld > maxzahl) nFeld = minzahl;
    }
    else
    {
      nFeld--;
      if (nFeld < minzahl) nFeld = maxzahl;
    }
    cFeldName = Zeichenkette + nFeld.toString();
    eval(form.name + "." + cFeldName + ".focus();");
    //eval(form.name + "." + cFeldName + ".select();");
    //form.a2.select();
    //form.a2.select();
  }
}
