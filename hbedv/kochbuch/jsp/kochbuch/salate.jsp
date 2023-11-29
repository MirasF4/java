<%@ include file="import.jsp" %>

<% 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	KochbuchSalateManager manager = client.getKochbuchSalateManager();
%>

<%@ include file="header.jsp" %>

<%@ include file="rezept.jsp" %>

<%@ include file="footer.jsp" %>
