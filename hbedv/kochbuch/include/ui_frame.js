/**
 *  frame JavaScript;
 *  -Diese JavaScriptframebasisfunktionen stehen allen Jspseiten zur Verfügung;
 *  -Der Umfang wird klein und kompakt gehalten;
 *  -Alle JavaScriptfunktionen sind "localefaehig".
 *
 */


//*framefunktionen**************************************************************

/**
 * Setze Eingabefocus auf erstes Control.
 *
 *@param  formIn ... Htmlform;
 */
function uIFrameInit(formIn)
{
  if (formIn.length > 0) {
    for (i=0;i<formIn.length;i++) {
    if (formIn.elements[i].type != null)
      if ((formIn.elements[i].type=="text")     ||
          (formIn.elements[i].type=="textarea") ||
          (formIn.elements[i].type.toString().charAt(0)=="s")) {
          if (formIn.elements[i].disabled == false) {
            formIn.elements[i].focus();
            break;
          }
      }
    }
  }
  if (typeof uIFrameInitCallback == 'function') {
    uIFrameInitCallback(formIn);
  }
  
}

function uIFrameDone(form) 
{
  if (typeof uIFrameDoneCallback == 'function') {
    if(!uIFrameDoneCallback(form))
      return;
  }
}

/**
 *  Ruft der frame beim Speichern auf. Um in der eigenen Seite noch reagieren
 *  zu koennen, wird uIFrameSpeichereCallback aufgerufen.
 *  Je nach Rueckgabewert von uIFrameSpeichereCallback
 *  true: submittet Seite; Bsp.: Alle Eingaben sind OK
 *  false: bleibt im Browser; Bsp. Eingaben sind falsch.
 *
 *@param  formIn ... Htmlform;
 */
function uIFrameSpeichere(formIn)
{
  if (typeof uIFrameSpeichereCallback == 'function') {
    if(!uIFrameSpeichereCallback(formIn))
      return;
  }

  //will der Uiframeuser noch was machen?
  //naechste Zeile nicht loeschen
  //formIn.subcmd.value= <%=Alice.SUB_CMD_SPEICHERE%>;
  formIn.subcmd.value= "speichere";
  formIn.submit();
}


/**
 *  Ruft der frame beim Loeschen auf. Um in der eigenen Seite noch reagieren
 *  zu koennen, wird uIFrameSpeichereCallback aufgerufen.
 *  Je nach Rueckgabewert von uIFrameSpeichereCallback
 *  true: submittet Seite; Bsp.: Alle Eingaben sind OK
 *  false: bleibt im Browser; Bsp. Eingaben sind falsch.
 *
 *@param  formIn ... Htmlform;
 */
function uIFrameLoesche(formIn)
{
  if (typeof uIFrameLoescheCallback == 'function') {
    if(!uIFrameLoescheCallback(formIn))
      return;
  }

  //will der Uiframeuser noch was machen?
  //naechste Zeile nicht loeschen
  //formIn.subcmd.value= <MM:BeginLock translatorClass="MM_ASPSCRIPT" type="script" depFiles="" orig="%3C%25=Alice.SUB_CMD_LOESCHE%25%3E" ><MM_ASPSCRIPT><MM:EndLock>;
  formIn.subcmd.value= "loesche";
  formIn.submit();
}


/**
 *  Ruft der frame beim "Tabreiten" auf. Um in der eigenen Seite noch reagieren
 *  zu koennen, wird uIFrameSpeichereCallback aufgerufen.
 *  Je nach Rueckgabewert von uIFrameSpeichereCallback
 *  true: submittet Seite; Bsp.: Alle Eingaben sind OK
 *  false: bleibt im Browser; Bsp. Eingaben sind falsch.
 *
 *@param  formIn ... Htmlform
 *@param  idReiterIn
 */
function uIFrameReite(formIn, idReiterIn)
{
  //precondition
  if (idReiterIn == null)
    alert("**X: idReiterIn == null ");

  // ist die uIFrameReiteCallback(formIn, idReiterIn) nicht vorhanden, dann nehmen
  // wir an, dass keine Prüfung benötigt wird !!!!
  if (typeof uIFrameReiteCallback == 'function') {
    if(!uIFrameReiteCallback(formIn, idReiterIn))
      return;
  }

  //naechste Zeile nicht loeschen
  //formIn.subcmd.value= <MM:BeginLock translatorClass="MM_ASPSCRIPT" type="script" depFiles="" orig="%3C%25=Alice.SUB_CMD_REITE%25%3E" ><MM_ASPSCRIPT><MM:EndLock>;
  formIn.subcmd.value= "reiten";
  formIn.reiter.value= idReiterIn;
  formIn.submit();
}


/**
 *  Ruft der frame beim "Specialcommand" auf. Um in der eigenen Seite noch reagieren
 *  zu koennen, wird uIFrameSpeichereCallback aufgerufen.
 *  Je nach Rueckgabewert von uIFrameSpeichereCallback
 *  true: submittet Seite; Bsp.: Alle Eingaben sind OK
 *  false: bleibt im Browser; Bsp. Eingaben sind falsch.
 *
 *@param  formIn ... Htmlform
 *@param  subCmdIn ... Subcommand
 */
function specialCommand(formIn, subCmdIn)
{
  if (typeof uIFrameSpecialCallback == 'function') {
    if(!uIFrameSpecialCallback(formIn))
      return;
  }

  formIn.subcmd.value= subCmdIn;
  //naechste Zeile nicht loeschen
  //formIn.subcmd.value= <MM:BeginLock translatorClass="MM_ASPSCRIPT" type="script" depFiles="" orig="%3C%25=Alice.SUB_CMD_SORTIERE%25%3E" ><MM_ASPSCRIPT><MM:EndLock>;
  formIn.submit();
}


/**
 *  Ruft der frame beim Sortieren auf.
 *
 *@param  formIn ... Htmlform
 */
function sortiere(formIn)
{
  formIn.cmd.value= uIFrameForm.cmd.value;
  //naechste Zeile nicht loeschen
  //formIn.subcmd.value= <MM:BeginLock translatorClass="MM_ASPSCRIPT" type="script" depFiles="" orig="%3C%25=Alice.SUB_CMD_SORTIERE%25%3E" ><MM_ASPSCRIPT><MM:EndLock>;
  formIn.subcmd.value= "sortiere";
  formIn.submit();
}




/**
 * Zeige Wartedialog;
 */
function bitteWarten() {
  var elmDiv = document.createElement('div');
  var elmBody = document.getElementsByTagName('body')[0];

  elmDiv.id = 'waitDialog';
  elmDiv.className = 'layer';
  elmDiv.style.position = 'absolute';
  elmDiv.style.left = '50%';
  elmDiv.style.width = '250px';
  elmDiv.style.marginLeft = '-125px';
  elmDiv.style.top = '50%';
  elmDiv.style.height = '50px';
  elmDiv.style.marginTop = '-25px';
  elmDiv.style.zIndex = '100';
/**  elmDiv.innerHTML = '<font size="2"><table><tr>Please wait</tr><tr><td><img src="images/progress.gif" width="100" height="20"/></td><td >  Information are processed...</td></tr></table></font>';**/
  elmDiv.innerHTML = '<font size="2"><table><tr>Bitte warten</tr><tr><td><img src="images/progress.gif" width="100" height="20"/></td><td >  Ihre Daten werden verarbeitet...</td></tr></table></font>';


  elmBody.appendChild(elmDiv);
}


/**
 * -Zeige Wartedialog;
 * -idItem wird während des Wartnes invisible gesetzt;
 * -specialCommandIn wird via specialCommand(uIFrameForm, specialCommandIn)
 *  ausgeführt.
 *
 *@param  idItem ... Htmlid des Controls das invisible wird.
 *@param  specialCommandIn
 */
function showWaitDialog(idItem, specialCommandIn)
{
  bitteWarten();
  idItem.style.visibility='hidden';
  specialCommand(uIFrameForm, specialCommandIn);
}




//* printing friendly **********************************************************
//!!drucken: hier befinden sich zentriert die allgemeinen (frame) Druckroutinen.


var printWindow;


/**
 *
 * @return
 */
function walk(dd){
  openWindow(dd);

  for (i = 0; i < dd.form.childNodes.length; i++) {
    walkover(dd.form.childNodes[i], 1, dd.border);
  }

  closeWindow();

  printWindow.print();
}


/**
 *
 * @return
 */
function expandDiv(elem, depth) {
  if (!elem)
    return;

  if (elem.tagName == "DIV") {
    if (elem.style.display == "none") {
      elem.style.display = "inline";
    }
  }
  else if (elem.tagName == "A") {
    if (elem.innerHTML.substr(0,1) == "+") {
      elem.removeNode(true);
    }
    else {
      elem.removeNode(false);
    }
  }

  var tmp = elem.firstChild;
  while (tmp) {
    expandDiv(tmp, depth+1);
    tmp = tmp.nextSibling;
    expandDiv(tmp, depth);
  }
}


/**
 *
 * @return
 */
function walkover(elem, depth, border){
  if (!elem)
    return;

  if (elem.tagName == "TABLE") {
  	if (border != "N") {
    	printWindow.document.write("<table class='BorderGrid'>");
	} else {
		printWindow.document.write("<table border='0'>");
	}

    oClone = elem.cloneNode(true);
    expandDiv(oClone, depth);
    printWindow.document.write(oClone.innerHTML);

    printWindow.document.write("</table>");
  }
}

function openWindow(dd) {
  printWindow = window.open("","","toolbar=no,location=no,"+
                "directories=no,status=yes,menubar=no,scrollbars=yes,resizable=yes,"+
                "copyhistory=no");

  printWindow.document.write("<HTML><HEAD><TITLE>DruckFenster</TITLE>");
  printWindow.document.write('<link rel="stylesheet" href=' + dd.style + ' type="text/css">');
  printWindow.document.write("</head>");
  

  if (dd.head1 != null)
    printWindow.document.write("<font class='h1'>" +dd.head1+ "</font>");

  if (dd.head2 != null && dd.head2 != "") {
    printWindow.document.write("<font class='h2'>"+dd.head2+"</font>");
  }
}




function closeWindow() {
  printWindow.document.write('</body></html>');
  printWindow.document.close();
}


/**
 * Diese Klasse beihaltet die walkdaten.
 *
 *@param  formIn ... Htmlform
 *@param  idReiterIn
 */
function DruckData(formIO, head1IO, head2IO, pBorder)
{
  var form= new Object();
  var head1= new String("");
  var head2= new String("");
  var style= new String(""); 
  var border = new String("");

  this.form= formIO;
  this.head1= head1IO;
  this.head2= head2IO;
  this.style="";
  if (pBorder == null) {
  	this.border="J";
  }
  else {
  	this.border = pBorder;
  }
}


/**
 *  Ruft der frame beim Drucken auf. Um in der eigenen Seite noch reagieren
 *  zu koennen, wird uIFrameSpeichereCallback aufgerufen.
 *  Je nach Rueckgabewert von uIFrameSpeichereCallback
 *  true: submittet Seite; Bsp.: Alle Eingaben sind OK
 *  false: bleibt im Browser; Bsp. Eingaben sind falsch.
 *
 *@param  formIn ... Htmlform
 *@param  idReiterIn
 */
function uIFrame_Drucken(sStyle)
{
  //precondition
  if (typeof uIFrameDruckenCallback != 'function')
    alert("no uIFrameDruckenCallback!");

  var dd = uIFrameDruckenCallback();
  //assert
  if (dd.form == null)
    alert("dd.form == null");
  if (dd.head1 == null)
    alert("head1 == null");
  if (dd.head2 == null)
    alert("head2 == null");
  dd.style = sStyle;
  if (dd.style == null)
    alert("style == null");

  walk(dd);
}


/**
 * periodenWahl
 *
 * verwendung:  für MIS
 * @autor       xbe
 */
function periodenWahl(nPeriodeId)
{
  if (nPeriodeId == 0)
  {
    var nId = window.showModalDialog("?cmd=periodenwahl&id_menue=-8888");
    if (nId == null) nId = 0;
    parent.frames.helper.location = "/mis/mis?cmd=periodenwahl&subcmd=detail&id_item=" + nId;
  }
}

/**
 * openHilfe
 *
 * verwendung:  für MIS
 * @autor       xbe
 */
function openHilfe(url)
{
  sem = window.open("","","toolbar=yes,location=no,"+
  "directories=no,status=yes,menubar=yes,scrollbars=yes,resizable=yes,"+
  "copyhistory=no");
  sem.resizeTo(1024,700);
  sem.document.write("<HTML><HEAD><TITLE>Hilfe</TITLE></HEAD><BODY>");
  sem.location.href=url;
}

/**
 * openInfo
 *
 * verwendung:  für MIS
 * @autor       xbe
 */
function openInfo(url)
{
  sem = window.open("","","toolbar=no,location=no,"+
                    "directories=no,status=yes,menubar=no,scrollbars=yes,resizable=yes,"+
                    "copyhistory=no");
  sem.resizeTo(500,500);
  sem.document.write("<HTML><HEAD><TITLE>PR-Info</TITLE></HEAD><BODY>");
  sem.location.href=url;
}
