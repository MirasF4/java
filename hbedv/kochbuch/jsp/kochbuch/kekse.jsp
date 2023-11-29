<%@ include file="import.jsp" %>

<% 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	KochbuchKekseManager manager = client.getKochbuchKekseManager();
%>


<%@ include file="header.jsp" %>

<%@ include file="rezept.jsp" %>

<%@ include file="footer.jsp" %>
