<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="../errorpage.jsp" %>
<%@ page import="com.hbedv.kochbuch.*" %>
<%@ page import="com.hbedv.frame.*" %>

<%
  ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
  
%>

<html>
<link rel="stylesheet" href="<%=client.getUriCssGlobal("kochbuch.css")%>" type="text/css">
<head>
<title>Kochbuch</title>

</head>

<BODY BGCOLOR=#ECE3BE LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>
<form name="BodyForm" method="post" action="<%=TheApp.encodeURL(client.getUriForm(), response)%>" target="body">
<br>
<br>
<table>
<tr>
<td>
<p><font size="4"><%=client.getMessage()%></font></p>
</td>
</tr>

<%
	java.sql.SQLException sqlErr = client.getSqlErr();
	if (sqlErr != null) { 
	 	java.io.StringWriter sw = new java.io.StringWriter();
  		java.io.PrintWriter pw = new java.io.PrintWriter(sw);
		sqlErr.printStackTrace(pw);
		String emsg = com.hbedv.frame.Util.convertChars(sw.getBuffer().toString());
		client.setSqlErr(null); %>
<tr>
<td>
	<%=emsg%>
</td>
</tr>
<% } %>

</table>


</form>
</BODY>
</HTML>


