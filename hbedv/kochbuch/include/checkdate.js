/****************************************************************************
 *  checkdate JavaScript;
 *  -Diese JavaScriptframebasisfunktionen stehen allen Jspseiten zur Verfügung;
 *  -Der Umfang wird klein und kompakt gehalten;
 *  -Alle JavaScriptfunktionen sind "localefaehig".
 *
 ****************************************************************************/


  /**
 *
 * <b>formatiert
 * <ul>
 *  <li>String xxxx</li>
 *  <li>x.xxx,xx</li>
 *  <li>xxxx.x</li>
 *  <li>xxxx,x</li>
 * </ul>
 * in Zahl
 * </b>
 * @param Kosten
 * @return Number
 */
function FormatStringToNumber(Kosten){
var sKosten = Kosten.value;
var cTemp="";
var sTemp="";
var strichNichtDa = sKosten.indexOf(",");
var punktNichtDa = sKosten.indexOf(".");

for(i = 0; i < sKosten.length; i++)
 {
    cTemp = sKosten.charAt(i);

    if (strichNichtDa == -1 && punktNichtDa == -1){
      if(cTemp >= "0" && cTemp <= "9")
      {
        sTemp = sTemp+cTemp;
      }
    }
   else if (strichNichtDa != -1 && punktNichtDa == -1){
      if(cTemp >= "0" && cTemp <= "9" || cTemp == ",")
      {
        if(cTemp == ",")
          sTemp = sTemp+".";
        else
          sTemp = sTemp+cTemp;
      }
   }
   else if (strichNichtDa == -1 && punktNichtDa != -1){
      if(cTemp >= "0" && cTemp <= "9" || cTemp == ".")
      {
        sTemp = sTemp+cTemp;
      }
   }
   else if (strichNichtDa != -1 && punktNichtDa != -1){
      if(cTemp >= "0" && cTemp <= "9" || cTemp == ",")
      {
        if(cTemp == ",")
          sTemp = sTemp+".";
        else
          sTemp = sTemp+cTemp;
      }
   }
 }
 return(Number(sTemp));
}


// Sting Funktionen //
/**
 *  altbekanntes Blank-wegschmeissen
 *  von rechts.
 *  @param
 *  @return
 **/
function trim(cParm)
{
 var cText = cParm;
 var n = cText.length;
 while(cText.substr(n-1,1) == " ")
 {
  cText = cText.substring(0,n-1);
  n--;
 }
 return cText;
}

/**
 *  altbekanntes Blank-wegschmeissen
 *  von links
 *  @param
 *  @return
 **/
function ltrim(cParm)
{
 var cText = cParm;
 var n = cText.length;
 while(cText.substring(0,1) == " ")
 {
  cText = cText.substring(1,n-1);
  n--;
 }
 return cText;
}

/**
 *  altbekanntes Blank-wegschmeissen
 *  beidseitig
 *  @param
 *  @return
 **/
function alltrim(cParm)
{
 var cText = cParm;
 cText = trim(cText);
 cText = ltrim(cText);
 return cText;
}

/**
 * überprüft auf gültige positive Zahl und für Prozent ob zwischen 0 und 100%
 **/
function checkProzent(cProzent)
{
  var cTemp = "";
  var nPMin = 0;
  var nPMax = 100;
  var nProz = 0;

  var cTProz = cProzent.value;


  for(i = 0; i < cTProz.length; i++){
    cTemp = cTProz.charAt(i);

    if(cTemp < "0" || cTemp > "9"){
      alert("Ungültiges Format für Prozentangabe nur positive ganze Zahlen");
      cProzent.select();
      return;
    }
  }

  nProz = Number(cTProz);

  if (nPMin > nProz || nPMax < nProz){
    alert("Lösungsgrad muß zwischen 0 und 100 Prozent liegen.");
    cProzent.select();
    return;
  }
  else
    return true;
}


/**
 * überprüft auf gültige positive Zahl und ob Min < Max
 **/
function checkTeilMinMax(cMin,cMax)
{
  var cTemp = "";
  var nTMin = 0;
  var nTMax = 0;

  var cTMin = cMin.value;
  var cTMax = cMax.value;

  for(i = 0; i < cTMin.length; i++){
    cTemp = cTMin.charAt(i);

    if(cTemp < "0" || cTemp > "9"){
      alert("Ungültiges Format für Teilnehmer Min. nur positive ganze Zahlen");
      cMin.select();
      return false;
    }
  }

  for(i = 0; i < cTMax.length; i++){
    cTemp = cTMax.charAt(i);

    if(cTemp < "0" || cTemp > "9"){
      alert("Ungültiges Format für Teilnehmer Max. nur positive ganze Zahlen");
      cMax.select();
      return false;
    }
  }

  nTMin = Number(cTMin);
  nTMax = Number(cTMax);

  if (nTMin > nTMax){
    alert("Teilnehmeranzahl min. muss größer oder gleich sein als Teilnehmeranzahl max.");
    cMax.select();
    return false;
  }
  else
    return true;
}


/**
 * erlaubt Eingabe von halben Tagen mit , getrennt cFeld kann sein z.B 1,5 oder 1
 **/
function checkdauer(cFeld,cErford)
{
   var lRet   = true;
   var cTag = "";
   var cStunde = "0";
   var cTemp  = "";
   var nTag   = 0;
   var nStunde = 0;
   var nBinde = 0;
   var i      = 0;
   var cTrenn = ",";

   var cDauer = cFeld.value;

   if (alltrim(cDauer).length == 0 && cErford == "N")
     return true;


   for(i = 0; i < cDauer.length; i++)
   {
      cTemp = cDauer.charAt(i);

      if(cTemp != cTrenn && (cTemp < "0" || cTemp > "9"))
         lRet = false;
   }
   if(lRet == true)
   {
      cTemp  = cDauer;
      nBinde = cDauer.indexOf(cTrenn);
      if(nBinde == -1){
          cTag  = cDauer;
      }
      else
      {
         cTag   = cTemp.substring(0,nBinde);
         cStunde  = cTemp.substring(nBinde+1,cTemp.length);
      }
      if(isNaN(cTag) == false && isNaN(cStunde) == false && cDauer.length > 0  && lRet == true )
      {
         nTag = Number(cTag);
         if(cStunde=="5" || cStunde=="0")
           nStunde = Number(cStunde);
         else
          lRet = false;
      }
      else
         lRet = false;
   }
   if(lRet == false) {
      alert("Das Dauer Format ist ungültig es sind nur 1/2 Tage zulässig, Eingabe im Format z.B. 1,5 Tage");
      cFeld.select();
   }
   else
    cFeld.value = cTag+","+cStunde;

   return lRet;
}


/**
 * @todo orn; mit xnm checken
 * */
function formatdauer(f)
{
  var msg = "Die Eingabe muss positive sein; die kleinste Einheit sind halbe Tage! z.B. 1,5 oder 4 oder 4.5.";
  f= f.replace(",",".");
  if(parseFloat(f, 10) != f)
    alert("**F0: " + msg);
  else if(f < 0)
    alert("**F1: " + msg);
  else if((f % 0.5) != 0)
    alert("**F2: " + msg);
  else
    return f;
}


/**
 * erlaubt tt.mm.jjjj und ttmmjjjj; bei ttmmjjjj werden "." eingefuegt
 **/
function checkdate(cFeld,cErford)
{
   var lRet   = true;
   var cTag   = "";
   var cMonat = "";
   var cJahr  = "";
   var nJahr2 = 0;
   var cTemp  = "";
   var nTag   = 0;
   var nMonat = 0;
   var nJahr  = 0;
   var nBinde = 0;
   var i      = 0;
   var cTrenn = ".";

   var cDatum = cFeld.value;

   if ((alltrim(cDatum).length == 0) && (cErford == "N")) {
     return true;
   }

   for(i = 0; i < cDatum.length; i++)
   {
      cTemp = cDatum.charAt(i);
      if(cTemp != cTrenn && (cTemp < "0" || cTemp > "9"))
      {
         lRet = false;
      }
   }
   if(lRet == true)
   {
      cTemp  = cDatum;
      nBinde = cDatum.indexOf(cTrenn);
      if(nBinde == -1)
      {
         cTag   = cDatum.substring(0,2);
         cMonat = cDatum.substring(2,4);
         if(cDatum.length == 8)
         {
            cJahr  = cDatum.substring(4,8);
         }
         else
         {
            lRet = false;
         }
      }
      else
      {
         cTag   = cTemp.substring(0,nBinde);
         cTemp  = cTemp.substring(nBinde+1,cTemp.length);
         nBinde = cTemp.indexOf(cTrenn);
         cMonat = cTemp.substring(0,nBinde);
         cTemp  = cTemp.substring(nBinde+1,cTemp.length);
         cJahr  = cTemp;

         if(cJahr.length != 4)
         {
            lRet = false;
         }
      }

      if(isNaN(cTag) == false && isNaN(cMonat) == false && isNaN(cJahr) == false && cDatum.length > 0 && lRet == true)
      {
         nTag = Number(cTag);
         nMonat = Number(cMonat-1);
         nJahr = Number(cJahr);
         dDatum = new Date(nJahr,nMonat,nTag);
         dDatum.setFullYear(nJahr);
         nJahr2 = dDatum.getFullYear();
         if(nJahr2 != nJahr || dDatum.getMonth() != nMonat || dDatum.getDate() != nTag)
         {
            lRet = false;
         }
         else
         {
            lRet = true;
         }
      }
        else
      {
        lRet = false;
      }
   }
   if(lRet == false) {
      alert("Ungültiges Datum! Geben Sie das Datum im Format (ttmmjjjj) oder (tt.mm.jjjj) ein!");
      cFeld.select();
   }
   else {
    cFeld.value = cTag+"."+cMonat+"."+cJahr
   }
   return lRet;
}


/**
 *  erlaubt hh:mm und hhmm; bei hhmm wird ":" eingefuegt
 **/
function checktime(cFeld,cErford)
{
   var lRet   = true;
   var cStunde   = "";
   var cMinute = "";
   var cTemp  = "";
   var nStunde   = 0;
   var nMinute = 0;
   var nBinde = 0;
   var i      = 0;
   var cTrenn = ":";

   var cTime = cFeld.value;

   if (alltrim(cTime).length == 0 && cErford == "N") {
     return true;
   }

   for(i = 0; i < cTime.length; i++)
   {
      cTemp = cTime.charAt(i);
      if(cTemp != cTrenn && (cTemp < "0" || cTemp > "9"))
      {
         lRet = false;
      }
   }
   if(lRet == true)
   {
      cTemp  = cTime;
      nBinde = cTime.indexOf(cTrenn);
      if(nBinde == -1)
      {
         cStunde = cTime.substring(0,2);
         cMinute = cTime.substring(2,4);
      }
      else
      {
        if(cTemp.length<5)
          lRet = false;
        else{
         cStunde = cTemp.substring(0,nBinde);
         cMinute = cTemp.substring(nBinde+1,cTemp.length);
        }
      }
      if(isNaN(cStunde) == false && isNaN(cMinute) == false && cTime.length > 3 && lRet == true)
      {
         nStunde = Number(cStunde);
         nMinute = Number(cMinute);
         dDatum = new Date(2000,1,1,nStunde,nMinute);
         if(dDatum.getMinutes() != nMinute || dDatum.getHours() != nStunde)
         {
            lRet = false;
         }
         else
         {
            lRet = true;
         }
      }
        else
      {
        lRet = false;
      }
   }
   if(lRet == false) {
      alert("Ungültiges Zeitformat! Geben Sie das Datum im Format HH:MM oder HHMM ein!");
      cFeld.select();
   }
   else {
    cFeld.value = cStunde+":"+cMinute
   }
   return lRet;
}

/**
 * Addiert Tage zu einem Datum
 **/
function dayadd(dDate,nTage)
{
  return new Date(dDate.getTime() + (nTage*24*60*60*1000));
}


/**
 *
 * @return
 */
function datstring(dDate)
{
  var nTag = 0;
  var nMonat = 0;
  var nJahr = 0;
  var nMulti = 1;
  var cTag = "";
  var cMonat = "";
  var cJahr = "";
  var cDatum = "";

  nTag = dDate.getDate();
  nMonat = dDate.getMonth() + 1;
  nJahr = dDate.getYear();

  if (nJahr < 100) nJahr = 1900 + nJahr;
  cTag = "" + nTag;
  cMonat = "" + nMonat;
  cJahr = "" + nJahr;
  if (cTag.length < 2) cTag = "0" + cTag;
  if (cMonat.length < 2) cMonat = "0" + cMonat;


  var cFormat = getLocalFormatPatternDate();
  var cTest  	= new Array();
  var nIndex = 0;
  var cTemp  = "";


  for(i = 0; i < cFormat.length; i++) {
    cTemp = cFormat.charAt(i);
    if(cTemp < "A" || cTemp > "z") {
      cTest[nIndex] = cTemp;
      nIndex++;
    }
    cTrenn = cTest[0];
  }

  var nPosTag = cFormat.indexOf("d");
  var nPosMonat = cFormat.indexOf("M");
  var nPosJahr = cFormat.indexOf("y");

    //--Defaultwert :  DD.MM.YYYY
    cDatum = cTag + cTrenn + cMonat + cTrenn + cJahr;
  if(nPosJahr < nPosMonat && nPosMonat < nPosTag) {
    cDatum = cJahr + cTrenn + cMonat + cTrenn + cTag ;
  }
  if(nPosMonat < nPosTag && nPosTag < nPosJahr) {
    cDatum = cMonat + cTrenn + cTag + cTrenn + cJahr;
  }
  return cDatum
}


/**
 * Diese Funktion zerlegt je nach Locale den Eingangsparameter und gibt ein
 * Array zurück mit folgenden Werten:
 * [0] Tag
 * [1] Monat
 * [2] Jahr
 * [3] Trennzeichen
 */
function getDayMonthYear(datum) {

  var cFormat = getLocalFormatPatternDate();
  var cTest  	= new Array();
  var nIndex = 0;
  var cTemp  = "";
  var retArray = new Array();

  for(i = 0; i < cFormat.length; i++) {
    cTemp = cFormat.charAt(i);
    if(cTemp < "A" || cTemp > "z") {
      cTest[nIndex] = cTemp;
      nIndex++;
    }
    cTrenn = cTest[0];
  }

  var nPosTag = cFormat.indexOf("d");
  var nPosMonat = cFormat.indexOf("M");
  var nPosJahr = cFormat.indexOf("y");
  var einzel = datum.split(cTrenn);
    //--Defaultwert :  DD.MM.YYYY
  retArray[0] = einzel[0];
  retArray[1] = einzel[1];
  retArray[2] = einzel[2];

  if(nPosJahr < nPosMonat && nPosMonat < nPosTag) {
    retArray[0] = einzel[2];
    retArray[1] = einzel[1];
    retArray[2] = einzel[0];
  }
  if(nPosMonat < nPosTag && nPosTag < nPosJahr) {
    retArray[0] = einzel[1];
    retArray[1] = einzel[0];
    retArray[2] = einzel[2];
  }
  retArray[3] = cTrenn;
  return retArray;
}

/**
 *
 * @return
 */
function datumedit(EcDatfeld)
{
  var nCode = window.event.keyCode;
  var cTaste = ""; //String.fromCharCode(nCode);
  var cDatum = EcDatfeld.value;
  var cTag = "";
  var cMonat = "";
  var cJahr = "";
  var nTag = 0;
  var nMonat = 0;
  var nJahr = 0;
  var nDiv = 0;
  var dDate = new Date();

  if (nCode == 107) {cTaste = "+";}       // + auf der normalen Tastatur

  if (nCode == 109) {cTaste = "-";}       // - auf der normalen Tastatur

  if (nCode == 187) {cTaste = "+";}       // + auf dem Zahlenblock

  if (nCode == 189) {cTaste = "-";}       // - auf dem Zahlenblock

  if (nCode == 38) {cTaste = "+";}        // Cursor nach oben

  if (nCode == 40) {cTaste = "-";}        // Cursor nach unten

  if (nCode == 36) {cTaste = "POS1";}     // Pos1 = 1 Monat vor

  if (nCode == 35) {cTaste = "END";}      // End = 1 Monat zurück

  if (nCode == 33) {cTaste = "PAGEUP";}   // Pagedown = 1 Jahr vor

  if (nCode == 34) {cTaste = "PAGEDOWN";} // Pageup = 1 Jahr zurück

  if (nCode == 72) {cTaste = "H";}        // Heute

  if (nCode == 68) {cTaste = "D";}        // Heute

  if (nCode == 77) {cTaste = "M";}        // Morgen

  if (nCode == 71) {cTaste = "G";}        // Gestern

  //if (nCode == 33) {cTaste = "PAGEUP";}   // Pagedown = 1 Jahr vor Noch einmal !!! Wenns nur oben steht funkt es nicht! Keine Ahnung warum???

  var array =   getDayMonthYear(EcDatfeld.value);
  var cFormat = getLocalFormatPatternDate();
  var datumLaenge = cFormat.length;
  cTag   = array[0];
  cMonat = array[1];
  cJahr  = array[2];


  if (cTaste == "H" || cTaste == "D" )
  {
    dDate = new Date();
    EcDatfeld.value = datstring(dDate);
  }

  if (cTaste == "M")
  {
    dDate = new Date();
    dDate = dayadd(dDate,1);
    EcDatfeld.value = datstring(dDate);
  }

  if (cTaste == "G")
  {
    dDate = new Date();
    dDate = dayadd(dDate,-1);
    EcDatfeld.value = datstring(dDate);
  }

  cDatum = EcDatfeld.value;
  if (cTaste == "POS1" || cTaste == "END")
  {
    if (cDatum.length < datumLaenge)
    {
      dDate = new Date();
      EcDatfeld.value = datstring(dDate);
    }
    else
    {
      if(isNaN(cTag)==false && isNaN(cMonat)==false && isNaN(cJahr)==false)
      {
        nTag   = Number(cTag);
        nMonat = Number(cMonat)-1;
        nJahr  = Number(cJahr);
        if (cTaste == "POS1")
        {
          nMonat++;
          if (nMonat > 12)
          {
            nMonat = 1;
            nJahr++;
          }
        }
        else
        {
          nMonat--;
          if (nMonat < 1)
          {
            nMonat = 12;
            nJahr--;
          }
        }
        if (nMonat == 2 && nTag > 28 ) nTag = 28;
        if (nMonat == 4 || nMonat == 6 || nMonat == 9 || nMonat == 11)
        {
          if (nTag > 30) nTag = 30;
        }
        cTag = "" + nTag;
        if (cTag.length == 1)  cTag = "0" + cTag;
        cMonat = "" + nMonat;
        cJahr = "" + nJahr;
        if (cMonat.length == 1) cMonat = "0" + cMonat;
        dDate = new Date(cJahr,cMonat,cTag);
        EcDatfeld.value = datstring(dDate);
      }
      else
      {
        dDate = new Date();
        EcDatfeld.value = datstring(dDate);
      }
    }
  }

  if (cTaste == "PAGEUP" || cTaste == "PAGEDOWN")
  {
    if (cDatum.length < datumLaenge)
    {
      dDate = new Date();
      EcDatfeld.value = datstring(dDate);
    }
    else
    {
      if(isNaN(cTag)==false && isNaN(cMonat)==false && isNaN(cJahr)==false)
      {
        nTag   = Number(cTag);
        nMonat = Number(cMonat)-1;
        nJahr  = Number(cJahr);

        if(nJahr > 72 && nJahr <  100) {
            nJahr = nJahr+1900;
          }

        if (cTaste == "PAGEUP") {
          nJahr++;
        }
        else
          nJahr--;
        if (nMonat == 2 && nTag > 28) nTag = 28;
        cTag = "" + nTag;
        if (cTag.length == 1) cTag = "0" + cTag;
        cMonat = "" + nMonat;
        cJahr = "" + nJahr;
        if (cMonat.length == 1) cMonat = "0" + cMonat;
        dDate = new Date(cJahr,cMonat,cTag);
        EcDatfeld.value = datstring(dDate);
      }
      else
      {
        dDate = new Date();
        EcDatfeld.value = datstring(dDate);
      }
    }
  }

  if (cTaste == "+" || cTaste == "-")
  {
    // Da geht er rein wenn die Länge der Eingabe kleiner 10 ist !!!
    if (cDatum.length < datumLaenge)
    {
      dDate = new Date();
      EcDatfeld.value = datstring(dDate);
    }
    else
    {
      if(isNaN(cTag)==false && isNaN(cMonat)==false && isNaN(cJahr)==false)
      {
        if (cTaste == "+")
          nMulti = 1;
        else
          nMulti = -1;
        nTag   = Number(cTag);
        nMonat = Number(cMonat)-1;
        nJahr  = Number(cJahr);
        dDate = new Date(nJahr,nMonat,nTag);
        dDate = dayadd(dDate,nMulti);
        EcDatfeld.value = datstring(dDate);
      }
      else
      {
        dDate = new Date();
        EcDatfeld.value = datstring(dDate);
      }
    }
  }
  }




/**
 *  Pruefe feld2Check gegen Webappmehr*locale.
 *  Liefert bei Flascheingaben Fehlermeldung.
 *  !!datecheck: 6 die Javascriptdatecheckfunktion
 *
 *@param  feld2Check
 *@return             true: ist gueltiges Mehr*datum;
 *                    false: sonst
 */
function ui_frameDatumCheck(feld2Check, cErford) {
  var lRet   = true;
  var lRetTrenn = true;
  var eingangTag   = "";
  var eingangMonat = "";
  var eingangJahr  = "";
  var nJahr2 = 0;
  var nTag   = 0;
  var nMonat = 0;
  var nJahr  = 0;
  var nBinde = 0;
  var i      = 0;
  var cTrenn = ".";
  var cTrennFalsch = null;
  var cTest  	= new Array();
  var nPosTag  = 0;
  var nPosMonat= 0;
  var nPosJahr = 0;
  var cDatumrichtig = "";
  var nIndex = 0;
  var cTemp  = "";
  var cDatum = feld2Check.value;
  var cFormat = getLocalFormatPatternDate();

 if ((alltrim(cDatum).length == 0 || cDatum == "") && cErford == "N")
     return true;
 else {
  for(i = 0; i < cFormat.length; i++) {
    cTemp = cFormat.charAt(i);
    if(cTemp < "A" || cTemp > "z") {
      cTest[nIndex] = cTemp;
      nIndex++;
    }
    cTrenn = cTest[0];
  }
  for(i=0; i<cTest.length; i++ ) {
    if(cTest[i] != cTest[0]) {
      lRet	= false;
    }
  }
  for(i = 0; i < cDatum.length; i++) {
    cTemp = cDatum.charAt(i);
    if(cTemp != cTrenn && (cTemp < "0" || cTemp > "9")) {
      cTrennFalsch = cTemp;
    }
  }
  cDatumrichtig = cDatum.replace(cTrennFalsch,cTrenn);
  cDatumrichtig = cDatumrichtig.replace(cTrennFalsch,cTrenn);
  feld2Check.value = cDatumrichtig;

  if(alltrim(cDatumrichtig).length == 0 ) {
    lRet = false;
  }
  nPosTag = cFormat.indexOf("d");
  nPosMonat = cFormat.indexOf("M");
  nPosJahr = cFormat.indexOf("y");
  var einzel = cDatumrichtig.split(cTrenn);
  var kurzJahr = false;

  //--Defaultwert :  DD.MM.YYYY
  eingangTag = einzel[0];
  eingangMonat = einzel[1];
  eingangJahr = einzel[2];

  if(nPosJahr < nPosMonat && nPosMonat < nPosTag) {
    eingangTag = einzel[2];
    eingangMonat = einzel[1];
    eingangJahr = einzel[0];
  }
  if(nPosMonat < nPosTag && nPosTag < nPosJahr) {
    eingangTag = einzel[1];
    eingangMonat = einzel[0];
    eingangJahr = einzel[2];
  }
  if(isNaN(eingangTag) == false && isNaN(eingangMonat) == false && isNaN(eingangJahr) == false && cDatumrichtig.length > 0 && lRet == true) {
    nTag = Number(eingangTag);
    nMonat = Number(eingangMonat-1);
    nJahr = Number(eingangJahr);
    dDatum = new Date(nJahr,nMonat,nTag);
    dDatum.setFullYear(nJahr);
    nJahr2 = dDatum.getFullYear();
    if (nJahr < 1000) {
     lRet = false;
    } else {
 	  if(nJahr2 != nJahr || dDatum.getMonth() != nMonat || dDatum.getDate() != nTag) {
    	lRet = false;
	  }
 	  else {
	  	lRet = true;
      }
    }
  }
  else {
    lRet = false;
  }
  if(lRet == false) {
      alert(getText("UngueltigDatum"));
      //window.event.cancleBubble = true; //Commented KAL löste einen JScriptFehler
      feld2Check.focus();
      feld2Check.select();
  }
  if(lRet == true) //alert("Sie haben das Datum richtig eingegeben!");
  return lRet;
} //else
}


/**
 * vergleich datum
 *
 * Diese Funktion wandelt die zwei Eingangsparameter in DATEN um und vergleicht auf: cFeld1 < cFeld2
 * Wenn diese Bedingung nicht eintrifft, wird eine Fehlermeldung ausgegeben, diese ist Mehrsprachenfähig.
 **/
function verglvbdate(cFeld1,cFeld2, outputErrorMsg) {

	var lOk = true;
	if (typeof outputErrorMsg == "undefined") {
    	outputErrorMsg = true;
  	}

	var vonWert = cFeld1.value;
	var bisWert = cFeld2.value;

	if (alltrim(vonWert).length == 0) {
    	return true;
	}

	var arrayFeld1 = getDayMonthYear(vonWert);
	var vonTag   = arrayFeld1[0];
	var vonMonat = arrayFeld1[1];
	var vonJahr  = arrayFeld1[2];

	var arrayFeld2 = getDayMonthYear(bisWert);
	var bisTag   = arrayFeld2[0];
	var bisMonat = arrayFeld2[1];
	var bisJahr  = arrayFeld2[2];

	if(vonJahr < 70) vonJahr = 20 + vonJahr;
	if(bisJahr < 70) bisJahr = 20 + bisJahr;

	vonDate = new Date(Date.UTC(vonJahr, vonMonat-1, vonTag));
	bisDate = new Date(Date.UTC(bisJahr, bisMonat-1, bisTag));

	if (bisDate < vonDate) {
  		if (outputErrorMsg == true) {
  			alert(getText("VonBisDatum"));
	  	}
	  	if (outputErrorMsg) {
			cFeld2.focus();
		}
		lOk = false;
	}
	else {
		lOk = true;
	}
	return lOk;
}



