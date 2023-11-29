
<%@ include file="import.jsp" %>

<% 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	KochbuchHauptspeisenManager manager = client.getKochbuchHauptspeisenManager();
%>

<%@ include file="header.jsp" %>

<%@ include file="rezept.jsp" %>


<%@ include file="footer.jsp" %>
