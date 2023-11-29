<%@ page errorPage="errorpage.jsp" %>
<%@ page import="com.hbedv.frame.*" %>

<%
	Client client= (Client)session.getAttribute(session.getId());
	if(client == null) throw new Exception("client == null");
	String banner = "banner.jpg";
	String height = "140px";
	if (client.getBsHeight().intValue() < 864) {
		height = "50px";
		banner = "banner2.jpg";
	}
%>

<HTML>
<HEAD>
<TITLE>Banner</TITLE>
</HEAD>

<BODY BGCOLOR=#ECE3BE LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 background="<%=client.getUriImageGlobal(banner)%>">


<%--
<table width="100%">
<tr>
<td align="right">
<IMG SRC="<%=client.getUriImageGlobal(banner)%>"  
style="border:0;position:relative;top-2px;width:<%=client.getBsWidth().intValue()%>px;height:<%=height%>px;" ALT="">
</td>
</tr>
</table>
--%>

</BODY>
</HTML>