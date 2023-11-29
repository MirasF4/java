<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page errorPage="errorpage.jsp" %>

<%@ page import="com.hbedv.frame.*"%>

<%--
--%>

<%! String authenticateMsg= Util.UNDEFINED_STRING;%>
<%
  Client client= (Client)request.getAttribute("com.hbedv.client");
%>


<script type="text/javascript" language="javascript">

</script>
<HTML>
<HEAD>
<TITLE>Reload</TITLE>
</HEAD>

<BODY>
<script type="text/javascript" language="javascript">
  parent.frames.body.location.reload();
</script>
</BODY>
