<%@ include file="import.jsp" %>

<% 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	KochbuchBackwarenManager manager = client.getKochbuchBackwarenManager();
%>

<%@ include file="header.jsp" %>

<%@ include file="rezept.jsp" %>

<%@ include file="footer.jsp" %>
