<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page errorPage="../errorpage.jsp" %>
<%@ page import="com.hbedv.frame.*" %>
<%@ page import="com.hbedv.lj_results.*" %>

<%
	ClientLjResults client=(ClientLjResults)session.getAttribute(session.getId());
%>

<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<TITLE>Load End</TITLE>

</HEAD>


<BODY onLoad="javascript:loadFertig()">
<form name="BodyForm" method="post" action="<%=TheApp.encodeURL(client.getUriForm(), response)%>">
<input type="hidden" name="cmd" value="">
<input type="hidden" name="subcmd" value="">
<input type="hidden" name="target" value="">


<script type="text/javascript" language="javascript">
function loadFertig() {
	document.BodyForm.cmd.value = "<%=LjResults.CMD_FERTIG%>";
	document.BodyForm.subcmd.value = "<%=TheApp.SUB_CMD_INIT%>";
	document.BodyForm.submit("");
}  
</script>
</form>
</BODY>
