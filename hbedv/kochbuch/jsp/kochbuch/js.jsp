<script type="text/javascript" src="<%=client.getUriJSGlobal("eventhandler.js")%>"></script>
<script type="text/javascript" src="<%=client.getUriJSGlobal("basic.js")%>"></script>

<script language="JavaScript" type="text/JavaScript">

//setDefaultButton("saveButton");

<%
if (client.getMessage() != null && !client.getMessage().equals("")) { %>
	alert("<%=client.getMessage()%>");
	<%
	client.setMessage("");
	}
%>

function zurueckZurAuswahl(f) {
	f.cmd.value="<%=TheApp.CMD_SEARCH%>";
	f.subcmd.value="<%=TheApp.SUB_CMD_INIT%>";
	f.submit();
}

function saveRezept(f) {
	var rez = f.rezeptname.value;
	rez = ba_allTrim(rez);
	if (rez == "") {
		alert("Rezeptname darf nicht leer sein!");
		f.rezeptname.focus();
	}
	else if (f.m_id.value == 0) {
		alert("<%=auswahlErr%>");
		f.selectMenues.focus();
	}
	else {
		f.cmd.value="<%=TheApp.CMD_SEARCH%>";
		f.subcmd.value="<%=Kochbuch.SUB_CMD_SAVE%>";
		f.submit();
	}
}


function changeMenue(f,wert) {
	f.m_id.value = wert;
}


function picDelete(f) {
	var lOk = confirm("Bild entfernen ?");
	if (lOk) {
		f.cmd.value="<%=TheApp.CMD_SEARCH%>";
		f.subcmd.value="<%=Kochbuch.SUB_CMD_DELETE_PIC%>";
		f.submit();
	} 
}

function picUpload(f) {
	win2 = 	window.open("","","toolbar=no,location=no,"+
  	 		"directories=no,status=yes,menubar=no,scrollbars=no,resizable=no,"+
  			"copyhistory=no");
	win2.resizeTo(700,300);
	win2.location.href="<%=client.getAppRootUrl()%>/jsp/upload.jsp";
	
}


function insertCode(aTag, eTag, nameForm, nameTArea) {
  var input = document.forms[nameForm].elements[nameTArea];
  input.focus();
  /* für Internet Explorer */
  if(typeof document.selection != 'undefined') {
    /* Einfügen des Formatierungscodes */
    var range = document.selection.createRange();
    var insText = range.text;
    range.text = aTag + insText + eTag;
    /* Anpassen der Cursorposition */
    range = document.selection.createRange();
    if (insText.length == 0) {
      range.move('character', -eTag.length);
    } else {
      range.moveStart('character', aTag.length + insText.length + eTag.length);      
    }
    range.select();
  }
  /* für neuere auf Gecko basierende Browser */
  else if(typeof input.selectionStart != 'undefined')
  {
    /* Einfügen des Formatierungscodes */
    var start = input.selectionStart;
    var end = input.selectionEnd;
    var insText = input.value.substring(start, end);
    input.value = input.value.substr(0, start) + aTag + insText + eTag + input.value.substr(end);
    /* Anpassen der Cursorposition */
    var pos;
    if (insText.length == 0) {
      pos = start + aTag.length;
    } else {
      pos = start + aTag.length + insText.length + eTag.length;
    }
    input.selectionStart = pos;
    input.selectionEnd = pos;
  }
  /* für die übrigen Browser */
  else
  {
    /* Abfrage der Einfügeposition */
    var pos;
    var re = new RegExp('^[0-9]{0,3}$');
    while(!re.test(pos)) {
      pos = prompt("Einfügen an Position (0.." + input.value.length + "):", "0");
    }
    if(pos > input.value.length) {
      pos = input.value.length;
    }
    /* Einfügen des Formatierungscodes */
    var insText = prompt("Bitte geben Sie den zu formatierenden Text ein:");
    input.value = input.value.substr(0, pos) + aTag + insText + eTag + input.value.substr(pos);
  }
}

</script>
