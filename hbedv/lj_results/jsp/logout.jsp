<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page errorPage="errorpage.jsp" %>
<%@ page import="com.hbedv.frame.*"%>


<%! String authenticateMsg= Util.UNDEFINED_STRING;%>
<%
  Client client= (Client)request.getAttribute("com.hbedv.client");

  if(client != null) {
		session.invalidate();
  }
%>
<%
synchronized (client) {
synchronized (authenticateMsg) {
%>


<HTML>
<HEAD>

<script type="text/javascript" language="javascript">
function closeIt() {
  //Fenster schließen, Parent wegen Frame !!
  parent.window.close();
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<TITLE>Logout</TITLE>

<%=Util.informationToDisplay(client)%>
<script type="text/javascript" language="javascript">
  window.close();
</script>
</HEAD>
<BODY onLoad="closeIt()";>
</BODY>
</HTML>

<%
}}
%>
