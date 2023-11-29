<!DOCTYPE html>

<html>
<head>

<%@ page errorPage="errorpage.jsp" %>
<%@ page import="com.hbedv.frame.*" %>

<%
	Client client= (Client)session.getAttribute(session.getId());
	if(client == null) throw new Exception("client == null");
	boolean mobileVersion = client.isMobileVersion();
	String subcmd = request.getParameter("subcmd");
	String idMenueNotValid = "&amp;" + TheApp.ID_MENUE + "=" + TheApp.ID_MENUE_NOT_VALID;
	String bodyFrameSrc = TheApp.encodeURL(client.getUriForm() + "?cmd="+TheApp.CMD_BODY,response) + idMenueNotValid;
	String menuFrameSrc = TheApp.encodeURL(client.getUriForm() + "?cmd="+TheApp.CMD_MENUE,response);
	String bannerFrameSrc = TheApp.encodeURL(client.getUriForm() + "?cmd="+TheApp.CMD_BANNER,response);
	String familyFrameSrc = TheApp.encodeURL(client.getUriForm() + "?cmd="+TheApp.CMD_FAMILY,response);
	
	/*
	Integer bsHeigth = client.getBsHeight();
	Integer bsWidth = client.getBsWidth();
	*/

	Integer bsWidth = new Integer(0);
	Integer bsHeigth = new Integer(0);
	int w = 0;
	int h = 0;
	if (mobileVersion) {
		bsWidth = new Integer(800);
		bsHeigth = new Integer(480);
		w = 800;
		h = 480;
	}
	else {
		bsWidth = new Integer(1152);
		bsHeigth = new Integer(864);
		w = 1152;
		h = 864;
	}
	client.setBsHeight(bsHeigth);
	client.setBsWidth(bsWidth);
		
	boolean kleinerBS = false;
	
%>


<link rel="STYLESHEET" type="text/css" href="css/kochbuch.css">
<link rel="SHORTCUT ICON" href="images/favicon.ico">
<link rel="ICON" href="images/favicon.ico" type="image/x-icon">

<META NAME="Title" CONTENT="Ullis Kochbuch">
<META NAME="Author" CONTENT="Hubert Beham">
<META NAME="Publisher" CONTENT="Hubert Beham">
<META NAME="Copyright" CONTENT="Ulrike, Michaela und Hubert Beham">
<META NAME="Revisit" CONTENT="After 10 days">
<META NAME="Keywords" CONTENT="kochen,Kochbuch,braten,backen,essen,Rezept,Zutaten,Kuchen,Kekse,Vorspeisen,Nachspeise,Desert,Hauptspeise,Gericht,Küche,Dinner,speisen,Speise,Menü,Ernährung,Ulrike Beham,Salat,Zubereitung,grillen,Griller,Fleisch,Gemüse,Brot,Obst,Torte,Ei,Tomate,Mehl,Zucker,Schokolade,schmackhaft,Kochrezept">
<META NAME="Description" CONTENT="Eine Sammlung von Ullis Kochrezepten für alle die es interessiert">
<META NAME="Abstract" CONTENT="Ullis-Kochbuch">
<META NAME="page-topic" CONTENT="Kochbuch">
<META NAME="audience" CONTENT=" Alle ">
<META NAME="Robots" CONTENT="INDEX,FOLLOW">
<META NAME="Language" CONTENT="Deutsch">
<META NAME="Content-language" content="DE">
<META NAME="pragma" content="no-cache">
<META NAME="Page-type" content="Private Homepage">




<title>Ullis Kochbuch</title>


<!-- JavaScript main -->
<script type="text/javascript" language="javascript">

// window.opener.ok = true;


if(top.frames.length > 0) {
  top.location.href= self.location.href;
}

<%
	if (mobileVersion) {
	%>
		var width  = 800;
		var height = 480;
	<%
	}
	else {
	%>
		var width  = 1152;
		var height = 864;
	<%
	}
	%>
width = window.outerWidth;  
height = window.outerHeight;

if (width > <%=w%>)
  width = <%=w%>;

if (height > <%=h%>)
  height = <%=h%>;

window.resizeTo(width, height);


if (top.toolbar && top.toolbar.visible == true) {
	top.toolbar.visible = false;
}

bsWidth = document.getElementById('bs_width');
if (bsWidth != null) {
	bsWidth.value = width;
}

bsHeight = document.getElementById('bs_height');
if (bsHeight != null) {
	bsHeight.value = height; 
}

</script>

<meta name="pragma" content="no-cache">

</head>
<%
if (mobileVersion) {
%>
<frameset rows="*" cols="*" frameborder="0" border="0" framespacing="1">
	<frameset rows="*" cols="120,*" framespacing="0" frameborder="YES" border="0">
		<frameset rows="*" cols="*" framespacing="0" frameborder="yes" border="0">
    		<frame src="<%=menuFrameSrc%>" name="<%=TheApp.CMD_MENUE%>" noresize scrolling="no"> </frame>
		</frameset>    	    
		<frame src="<%=bodyFrameSrc%>" name="<%=TheApp.CMD_BODY%>" noresize scrolling="no"> </frame>
  	</frameset>
</frameset>
<%
}
else {
%>
<frameset rows="140,*" cols="*" frameborder="0" border="0" framespacing="1">
	<frame src="<%=bannerFrameSrc%>"  frameborder="0" noresize name="<%=TheApp.CMD_BANNER%>" scrolling="no"> </frame>
	<frameset rows="*" cols="170,*" framespacing="0" frameborder="YES" border="0">
		<frameset rows="*" cols="*" framespacing="0" frameborder="yes" border="0">
    		<frame src="<%=menuFrameSrc%>" name="<%=TheApp.CMD_MENUE%>" noresize scrolling="no"> </frame>
		</frameset>    	    
		<frame src="<%=bodyFrameSrc%>" name="<%=TheApp.CMD_BODY%>" noresize scrolling="no"> </frame>
  	</frameset>
</frameset>
<%
}
%>




<noframes>
<body>

</body>
</noframes>
</html>




















