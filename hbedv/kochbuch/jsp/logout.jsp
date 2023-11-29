<%@ page errorPage="errorpage.jsp" %>
<%@ page import="com.hbedv.frame.*"%>


<%! String authenticateMsg= Util.UNDEFINED_STRING;%>
<%
  Client client= (Client)request.getAttribute("com.hbedv.client");

  if(client != null) {
    //MsgLogger.instance().printlnHintLog(session.getId() + " Kochbuch; logged out.");
    session.invalidate();
  }
%>
<%
synchronized (client) {
synchronized (authenticateMsg) {
%>

<script type="text/javascript" language="javascript">
function closeIt() {
  //Fenster schlieﬂen, Parent wegen Frame !!
  parent.window.close();
}
</script>
<HTML>
<HEAD>
<TITLE>Logout</TITLE>

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
