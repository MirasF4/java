/**
 *  addons JavaScript;
 *  -Diese JavaScriptframebasisfunktionen stehen allen Jspseiten zur Verfügung;
 *  -Der Umfang wird klein und kompakt gehalten;
 *  -Alle JavaScriptfunktionen sind "localefaehig".
 *
 */


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
  cText = cText.substring(1,n);
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
 *  Pruefung auf Inhalt
 **/
function isempty(cFeld)
{

  var cTemp = alltrim(cFeld.value);

  if (cTemp.length > 0) {
    return true;
  }
  else {
   alert("Eingabe erforderlich !");
   cFeld.focus();
   return false;
  }
}


/**
 *  Pruefung auf integer
 **/
function isint(cFeld,cPositiv,cUebernull)
{
 var nPos = 0;
 var lReturn = true;
 var nWert = cFeld.value;

 if (cPositiv == null)
   cPositiv = 'N';

 if (cUebernull == null)
   cUebernull = 'N';


 if(isNaN(nWert) == true) {
   alert(nWert + " ist keine Zahl !");
   cFeld.focus();
   return false;
 }
 else {
   nPos = nWert.indexOf(".");
   if(nPos != -1) {
     alert(nWert + " ist keine ganze Zahl !");
     cFeld.focus();
     return false;
   }
 }

 if (cPositiv == "J") {
   if (nWert < 0) {
     alert("Wert muss positiv sein");
     cFeld.focus();
     return false;
   }
 }

 if (cUebernull == "J") {
   if (nWert < 1) {
     alert("Wert muss groessser 0 sein");
     cFeld.focus();
     return false;
   }
 }

 return true;
}

 /**
 *  verglvb
 *
 *  compare von-bis Werte
 *  verwendung:
 *   - kampagnen, werbemittel
 **/
 function verglvb(cFeld1,cFeld2)
 {
   var vonWert = new Number(cFeld1.value);
   var bisWert = new Number(cFeld2.value);

   if (bisWert < vonWert) {
    alert("Bis-Wert ist kleiner Von-Wert !");
    cFeld2.focus();
    return false;
   }
   else
     return true;
 }


/**
 * Pruefung auf float
 **/
function isfloat(Feld)
{
  nWert = Feld.value;
  // Auf Zahl prüfen !!
  if(isNaN(nWert) == true)
  {
    // Keine Zahl !!! Dann prüfen wir auf deutsche Schreibweise.
    // ACHTUNG Wert im Feld wird NICHT verändert !!!!
    n1 = nWert.lastIndexOf(",");
    n2 = nWert.lastIndexOf(".");

    // Ist Positition des Kommas grösser als Punkt, dann
    // sollte es ein Kommabeistrich sein
    if (n1 > n2)
    {
      nL = nWert.length;
      ii = 0;
      Erg = "";

      // Ergebnis String zusammenbauen
      // ohne Leerzeichen und ohne Tausender Punkt Trennzeichen !!!
      while (ii < nL)
      {
        // Leerzeichen entfernen
        if (nWert.substr(ii,1) != " ")
        {
          // Tausender Punkt(e) entfernen
          if (nWert.substr(ii,1) != '.')
          {
            // Beistrich Komma durch Punkt Komma ersetzen
            if (nWert.substr(ii,1) == ',')
            {
              if (ii == n1)
                Erg = Erg + ".";
            }
            else
            {
              // sonst Ziffer zum String addieren
              Erg = Erg + nWert.substr(ii,1);
            }
          }
        }
        ii++;
      }
      // Ergebnis prüfen !!!!
      if (isNaN(Erg) == true )
      {
        alert(nWert + " ist keine Zahl !");
        Feld.focus();
        return false;
      }
      else
        return true;
    }
    else
    {
      // Else vom: if (n1 > n2)
      alert(nWert + " ist keine Zahl !");
      Feld.focus();
      return false;
    }
  }
  else
    return true;
}


/**
 *  Pruefung auf nicht leeres FORM.Eingabefeld
 *  verwendung:
 *   passwortchange
 *  @param
 *  @return boolean
 **/
function isnotempty(EFormElement)
{
  if (notempty( EFormElement ))
    return true;
  // else
     alert("Eingabe erforderlich !");
     EFormElement.focus();
     return false;
}


/**
 *
 * @return boolean
 */
function notempty(EFormElement)
{
  var cFormFeld = "";
  cFormFeld = EFormElement.value;
  cFormFeld = alltrim(cFormFeld);

  if (cFormFeld.length > 0)
    return true;

  return false;
}


/**
 * für werbemittel, kampagnen
 * @return
 */
function checkLengthArea(feld, lines, column)
{
  var aText = new Array();
  aText = feld.value.split('\r\n');

  if (aText.length > lines) {
    feld.value = feld.value.substring(0, feld.value.lastIndexOf('\r\n'));
    return;
  }

  var pos = 0;
  for (i = 0; i < aText.length; i++) {
    pos += aText[i].length;
    if (aText[i].length > column) {

      aText[i] = aText[i].substring(0,column);
      feld.value = aText.join('\r\n');

      if (feld.createTextRange) {
        var r = feld.createTextRange();
        r.collapse();
        r.moveStart('character', pos);
        r.select();
      }
      return;
    }
  }
}



/**
 *
 * verwendung:  für MIS
 * @autor       xbe
 * @return
 */
function notZero(feld)
{
  var nZahl = toNumber(feld);

  if (nZahl != 0)
    return true;

  alert("Mussfeld - bitte Wert eingeben! Bei einem mit einem * gekennzeichneten Feld muss ein Wert eingegeben werden.");
  feld.focus();
  return false;
}

/**
 *
 * verwendung:  für MIS
 * @autor       xbe
 * @return
 */
function notZeroSumme(nZahl,feld)
{
  if (nZahl != 0)
    return true;
  alert("Mussfelder - bitte Wert eingeben! Bei einer mit einem * gekennzeichneten Zeile muss mindestens ein Wert eingegeben werden.");
  feld.focus();
  return false;
}


/**
 *  Prufe feld2Check auf: intMin <= feld2Check <= intMax.
 *  Erzeugt im Fehlerfall ein alert.
 *
 *@param   feld2Check
 *@param   intMin
 *@param   intMax
 *@return  true: wenn ganze Zahl und intMin <= feld2Check <= intMax gilt;
 *         false: sonst
 */
function checkInteger(feld2Check, intMin, intMax)
{
  int2CheckI = feld2Check.value;
  if(int2CheckI.length > 0 && alltrim(int2CheckI).length == 0) {
    alert(getText("UngueltigeZeichen"));
    feld2Check.focus();
    feld2Check.select();
    return false;
  }
  else if (isNaN(int2CheckI)) {
   //--not a number :-(
    alert(getText("UngueltigeZeichen"));
    feld2Check.focus();
    feld2Check.select();
    return false;
  }
  else if (!(intMin == 0 && intMax == 0)) {
    var wertInt = parseInt(int2CheckI);
    if (wertInt < intMin || wertInt > intMax) {
      alert(getText("UngueltigerWertebereich"));
      feld2Check.focus();
      feld2Check.select();
      return false;
    }
    else {
      if ( ! checkGanzeZahl(wertInt) )
      //--not a integer
      {
        feld2Check.focus();
        feld2Check.select();
        return false;
      }
    }
  }
  feld2Check.value= alltrim(feld2Check.value);
  return true;
}

/**
 *  Pruefe auf ganze Zahl.
 *  Erzeugt im Fehlerfall ein Mehr*alert.
 *
 *@param  zahlI   zu pruefende Zahl.
 *@return         true: wenn ganze Zahl; false: sonst
 */
function checkGanzeZahl(zahlI) {
  var valid = "0123456789";
  var temp;

  for (var i=0; i<zahlI.length; i++) {
    temp = "" + zahlI.substring(i, i+1);
    if (valid.indexOf(temp) == "-1")
    {
      alert(getText("UngueltigeZeichen"));
      return false;
    }
  }
  return true;
}


/**
 *
 * verwendung:  für MIS
 * @autor       xbe
 * @return
 */
function toNumber(feld)
{
	var nRet = 0;
  	var cDummy = feld.value;

  	cDummy = cDummy.replace(",",".");
  	nRet = Number(cDummy);

  	nRet = nRet * 100;
  	nRet = Math.round(nRet);
  	nRet = nRet / 100;
  	feld.value = nRet;
  	feld.value = feld.value.replace(".",",");

  	return nRet;
}

function toNumberDec(feld)
{
	var nRet = 0;
	var cDummy = feld.value;
	cDummy = cDummy.replace(" ","");
	
	while (cDummy.lastIndexOf(".") > -1) {
		cDummy = cDummy.replace(".","");
	}
  	cDummy = cDummy.replace(",",".");
	nRet = Number(cDummy);


	nRet = nRet * 100;
	nRet = Math.round(nRet);
	nRet = nRet / 100;
	feld.value = nRet;
	feld.value = feld.value.replace(".",",");
	var cFeld = feld.value;
	var len = cFeld.lastIndexOf(",");
	var nachKomma = "";
	if (len < 0) {
		len = cFeld.lastIndexOf("");
	}
	else {
		nachKomma = cFeld.substr(len + 1,3);
		cFeld = cFeld.substr(0,len);
	}
	if (len > -1) {
	 	
 		var fertig = false;
	 	var z = len;
 		var x = -1;
	 	var cErg = "";
 		while (z > -1) {
 			var ch = cFeld.substr(z,1);
	 		if (ch != "-"){
 				x++;	
 			}
	 		cErg = ch + cErg;
 			if (x > 2 && ((z > 0 && nRet >= 0) || (z > 1 && nRet < 0))) {
 				x = 0;
 				cErg = "." + cErg;
	 		}
 			z--;
	 	}	
	 	if (nachKomma != "") {
 			cErg = cErg + "," + nachKomma;
 		}
 		else {
 			cErg = cErg + ",00";
 		}
	 	feld.value = cErg;
	}
 	
	return nRet;
}


/**
 *
 * verwendung:  für MIS
 * @autor       xbe
 **/
function toFieldDec(feld,nZahl)
{
  nZahl = nZahl * 100;
  nZahl = Math.round(nZahl);
  nZahl = nZahl / 100;
  var cDummy = String(nZahl);
  cDummy = cDummy.replace(".",",");
  feld.value  = cDummy;
}


/**
 *
 *
 * verwendung:  für MIS
 * @autor       xbe
 */
function toFieldInt(feld,nZahl)
{
  var cDummy = String(nZahl);
  //feld.value  = cDummy;
  //feld.value = Math.round(feld.value);
  feld.value = Math.round(cDummy);
}


/***************************************************************************
 * hilfe
 ***************************************************************************/

/**
 *
 */
function help(chapter)
{
  winHelp= window.open("/public_html/help.html"+"#"+chapter,"Hilfe",'width=700,height=600,resizable=1,scrollbars=1');
  winHelp.focus();
}

/**
 *
 */
/*function helper(origCmd, subcmd, source, target) {
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
*/

/**
 * Parameterabfrage so gelöst um ein leeres Fabrikat zu verhindern
 * Es gibt diesen Aufruf mit 4 und mit 5 Parameter (any question: ask WOI)
 */
 
function helper() {
	origCmd = arguments[0] || "";	
	subcmd  = arguments[1] || "";	
	source  = arguments[2] || "";	
	target  = arguments[3] || "";	
	fab     = arguments[4] || "";	
	land    = arguments[5] || "";

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
             
      if (fab != "")       
      	url += '&fabrikat=' + fab;
      
       if (land != "")       
      	url += '&land=' + land;	

      top.frames.helper.location.href = url;
    }
    else {
      target.value = "";
    }
  }
  else {
  	if (fab != "") {
	  top.frames.helper.location.href = '?cmd=helper&subcmd=' + subcmd + '&source=&value=&target=';
	} 
  	else {
	  top.frames.helper.location.href = '?cmd=helper&fabrikat=' +fab+'&subcmd=' + subcmd + '&source=&value=&target=';
	}  
  }
}

/**
 *
 * @return
 */
function helperElem() {
  this.id = arguments[0] || "0";
  this.value = arguments[1] || "";
}


/**
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
 */
function cursor_up_down(form,feld,minzahl,maxzahl,Zeichenkette)
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
