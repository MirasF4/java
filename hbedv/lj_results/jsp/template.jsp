<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">

<%@ page errorPage="errorpage.jsp" %>
<%@ page import="com.hbedv.frame.*" %>


<%
	Client client= (Client)session.getAttribute(session.getId());
	if(client == null) throw new Exception("client == null");
	String idMenueNotValid = "&amp;" + TheApp.ID_MENUE + "=" + TheApp.ID_MENUE_NOT_VALID;	
	String bodyFrameSrc = TheApp.encodeURL(client.getUriForm() + "?cmd="+TheApp.CMD_START,response) + idMenueNotValid;
%>


<html>
<head>

<link rel="STYLESHEET" type="text/css" href="css/lj_results.css">
<link rel="SHORTCUT ICON" href="images/umfrage.ico">
<link rel="ICON" href="images/umfrage.ico" type="image/x-icon">

<meta http-equiv="refresh" content="0; URL=<%=bodyFrameSrc%>">

<META NAME="Title" CONTENT="Umfrage LJ Results">
<META NAME="Author" CONTENT="Michaela Beham">
<META NAME="Publisher" CONTENT="Hubert Beham">
<META NAME="Copyright" CONTENT="Michaela und Hubert Beham">
<META NAME="Revisit" CONTENT="After 10 days">
<META NAME="Keywords" CONTENT="LJ Results, Umfrage">
<META NAME="Description" CONTENT="Umgrage für die Diplomarbeit von Michaela Beham">
<META NAME="Abstract" CONTENT="LJ Results">
<META NAME="page-topic" CONTENT="LJ Results">
<META NAME="audience" CONTENT=" Alle ">
<META NAME="Robots" CONTENT="INDEX,FOLLOW">
<META NAME="Language" CONTENT="Deutsch">
<META NAME="Content-language" content="DE">
<META NAME="pragma" content="no-cache">
<META NAME="Page-type" content="Private Homepage">

<META HTTP-EQUIV="pragma" content="no-cache">
<META HTTP-EQUIV="expires" content="0">
<META HTTP-EQUIV="Content-Type" content="text/html; charset=iso-8859-1">
<META HTTP-EQUIV="Content-Script-Type" content="text/javascript">
<META HTTP-EQUIV="Content-Style-Type" content="text/css">


<title>LJ Results</title>


<!-- JavaScript main -->

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="pragma" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>

</body>
</html>




















