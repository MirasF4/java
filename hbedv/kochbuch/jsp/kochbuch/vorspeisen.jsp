<%@ include file="import.jsp" %>

<% 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	KochbuchVorspeisenManager manager = client.getKochbuchVorspeisenManager();
%>

<%@ include file="header.jsp" %>

<%@ include file="rezept.jsp" %>

<%@ include file="footer.jsp" %>
