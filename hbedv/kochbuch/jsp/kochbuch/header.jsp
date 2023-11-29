
<html>
<% 
if (client.isMobileVersion()) {
	%>
	<link rel="stylesheet" href="<%=client.getUriCssGlobal("kochbuch_mobil.css")%>" type="text/css">
	<%
}
else {
	%>
	<link rel="stylesheet" href="<%=client.getUriCssGlobal("kochbuch.css")%>" type="text/css">
	<%
}
%>
<head>
<title>Kochbuch</title>

</head>

<script type="text/javascript" language="javascript">



isIE="IE"; 
isFireFox="FireFox";
isEdge="Edge";
isOpera="Opera";
isChrome="Chrome";
isSafari="Safari";
isUnknown="Unknown";


function checkBrowserName(name)
{
	var agent = navigator.userAgent.toLowerCase();
	if (agent.indexOf(name.toLowerCase())>-1) {
		return true;
	}
	return false;
}


function getBrowserName() {
	var ret=isUnknown;

	if(checkBrowserName('edge'))
	{
		ret=isEdge;
	} 
	else if(checkBrowserName('like gecko') || checkBrowserName('msi')) {
		ret = isIE;
	}
	else if(checkBrowserName('opera')) {
		ret = isOpera;
	}
	else if(checkBrowserName('chrome'))
	{
		ret=isChrome;
	}
	else if(checkBrowserName('safari'))
	{
		ret=isSafari;
	}
	else if(checkBrowserName('firefox'))
	{
		ret=isFireFox;
	} 
	return ret;
}
	
function ResizeApp() {

	var outerWidth = window.outerWidth;  
	var outerHeight = window.outerHeight;

	bsWidth = document.getElementById('bs_width');
	if (bsWidth != null) {
		
		bsWidth.value = outerWidth;

		bsHeight = document.getElementById('bs_height');
		if (bsHeight != null) {
			bsHeight.value = outerHeight; 
		}
		
		objTxt1 = document.getElementById('text_width');
		if (objTxt1 != null) {
			objTxt1.value = document.getElementById('bs_width').value;
		}
		
		objTxt2 = document.getElementById('text_height');
		if (objTxt2 != null) {
			objTxt2.value = document.getElementById('bs_height').value;
		}
	}

	if (typeof ResizeWindow === "function") {
		ResizeWindow(outerWidth,outerHeight);
	}
}

window.addEventListener('resize', ResizeApp);
</script


<BODY BGCOLOR=#ECE3BE LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

<form name="BodyForm" method="post" action="<%=TheApp.encodeURL(client.getUriForm(), response)%>" target="body">

<input type="hidden" id="bs_width" name="bs_width" value="0">
<input type="hidden" id="bs_height" name="bs_height" value="0">

<input type="hidden" id="text_width" name="text_width" >
<input type="hidden" id="text_height" name="text_height">

<input type="hidden" name="cmd" value="">
<input type="hidden" name="subcmd" value="">

