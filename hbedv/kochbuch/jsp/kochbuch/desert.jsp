<%@ include file="import.jsp" %>

<% 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	KochbuchDesertManager manager = client.getKochbuchDesertManager();
%>

<%@ include file="header.jsp" %>

<%@ include file="rezept.jsp" %>

<%@ include file="footer.jsp" %>
