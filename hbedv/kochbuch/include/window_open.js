/**
 *  window_open JavaScript;
 *  -Diese JavaScriptframebasisfunktionen stehen allen Jspseiten zur Verfügung;
 *  -Der Umfang wird klein und kompakt gehalten;
 *  -Alle JavaScriptfunktionen sind "localefaehig".
 *
 */


/**
 *
 */
function windowBild(bild) {

  var was = "";

  was = bild.substr(bild.length-4,4);

  sem = window.open("","","toolbar=no,location=no,"+
                "directories=no,status=yes,menubar=no,scrollbars=yes,resizable=yes,"+
                "copyhistory=no");

  sem.document.write("<HTML><HEAD><TITLE>Infoanzeige</TITLE></HEAD><BODY>");

  var resize = false;

  switch(was)
  {
  case ".mp3":
    sem.document.write('<embed src="'+bild+'">');
    sem.document.write('</BODY></HTML>');
    sem.document.close();
    break;
  case ".avi":
    sem.document.write('<embed src="'+bild+'">');
    sem.document.write('</BODY></HTML>');
    sem.document.close();
    break;
  case ".mpg":
    sem.document.write('<embed src="'+bild+'">');
    sem.document.write('</BODY></HTML>');
    sem.document.close();
    break;
  case "mpeg":
    sem.document.write('<embed src="'+bild+'">');
    sem.document.write('</BODY></HTML>');
    sem.document.close();
    break;
  case ".pdf":
    sem.document.write('</BODY></HTML>');
    sem.document.close();
    sem.location.href=bild;
    break;
  default:
//    sem.document.write('<img src="'+bild+'">');
    sem.document.write('</BODY></HTML>');
    sem.document.close();
    sem.location.href=bild;
    resize = true;
  }

  if (resize)
    resizeWindow();

}


/**
 *
 */
function resizeWindow() {
  x = screen.width;
  y = screen.height;

  if (document.images) {
    if (sem.document.images.length == 1) {
      if (sem.document.images[0].width+50 < screen.width)
        x = sem.document.images[0].width+50;
      if (sem.document.images[0].height+85 < screen.height)
        y = sem.document.images[0].height+85;


      if (document.layers)
        sem.resizeTo(x,y);
      else if (document.all)
        sem.resizeTo(x,y);
    }
    else
      setTimeout('resizeWindow()',1000);
  }
}

/**
 *
 */
function windowFzgInfo(link) {
  window.showModalDialog(link, "",'dialogWidth:720px; dialogHeight:450px; Scroll: auto; ');
}

