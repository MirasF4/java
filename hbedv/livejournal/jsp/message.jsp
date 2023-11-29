<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="../errorpage.jsp" %>
<%@ page import="com.hbedv.livejournal.*" %>
<%@ page import="com.hbedv.frame.*" %>

<%
ClientLiveJournal client= (ClientLiveJournal)request.getAttribute("com.hbedv.client");
  
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="<%=client.getUriCssGlobal("livejournal.css")%>" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>LiveJournal</title>

</head>

<BODY BGCOLOR=#ECE3BE LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>
<form name="BodyForm" method="post" action="<%=TheApp.encodeURL(client.getUriForm(), response)%>">
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


