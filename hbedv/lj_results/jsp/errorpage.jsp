<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="pre_adjustments.jsp" %>
<%@ page isErrorPage="true" %>

<%
  //com.hbedv.frame.Client client= (com.hbedv.frame.Client)request.getAttribute("com.hbedv.client");
  java.io.StringWriter sw = new java.io.StringWriter();
  java.io.PrintWriter pw = new java.io.PrintWriter(sw);
  exception.printStackTrace (pw);
  String emsg = com.hbedv.frame.Util.convertChars(sw.getBuffer().toString());
%>
<html>
<head>

<title>HBEDV Fehlerseite</title>
<link rel="STYLESHEET" type="text/css" href="css/hbedv.css">
  <style type="text/css">
    /* Styles für Body */
    body 		{ background-color:#FFFFFF; padding-top:0px; padding-left:0px; padding-right:0px; }
    #balken1	{ position:absolute; left:0px; top:0px; z-index:1; }
    #LoginMaske	{ position:absolute; left:296px; top:193px; z-index:1; }
    A         { color: #000000; text-decoration:underline;}
    A:Hover		{ color: #000000; text-decoration:underline;}
    A:Active	{ color: #000000; text-decoration:underline;}
  </style>
</head>

<body>
<center>
<table width='80%' bgcolor="#FEFEFE"><tr bgcolor="#EC2700">
<td colspan='2' align="right" width="100%" style="border: solid 1px #333A48;" valign="top">
<center><font color="#FEFEFE" size="+1">HBEDV konnte Ihre Anfrage leider nicht verarbeiten</font></center>
</td></Tr>
<tr>
  <td colspan='2' bgcolor="#D4D9DE" style="border:1px solid #333A48; padding-left:19px;" class="LoginText" height="49" align="center">
<font size="2">
Bitte wenden Sie Sich an Miras ;-) <BR>
</font>
</td>
</tr>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
<td valign="top" width="10%" bgcolor="#708090"><font color="#FEFEFE" size="2">Problem:</font></td>
<td bgcolor="#D4D9DE"><font color="#000000" size="3"><%=exception.getMessage()%></font></td>
</tr>
<tr>
<td valign="top" width="10%" bgcolor="#708090"><font color="#FEFEFE" size="2">Session:</font></td>
<td bgcolor="#D4D9DE"><font color="#000000" size="3"><%=request.getSession().getId()%></font></td>
</tr>
<tr>
<td valign="top" width="10%" bgcolor="#708090"><font color="#FEFEFE" size="2">Uhrzeit:</font></td>
<td bgcolor="#D4D9DE"><font color="#000000" size="3"><%=new java.sql.Timestamp(System.currentTimeMillis())%></font></td>
</tr>
<tr>
<td valign="top" width="10%" bgcolor="#708090"><font color="#FEFEFE" size="2">Trace:</font></td>
<td bgcolor="#D4D9DE"><font color="#000000" size="3"><%=emsg%></font></td>
</tr>
</table>
</center>
</body>
</html>
