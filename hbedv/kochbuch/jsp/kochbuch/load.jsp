<%@ include file="import.jsp" %>

<%
  ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
  
%>

<%@ include file="header.jsp" %>

<input type="hidden" name="m_id" value="<%=client.getLoadMenId()%>">
<input type="hidden" name="r_id" value="<%=client.getLoadRezId()%>">

<script type="text/javascript" language="javascript">
 	BodyForm.cmd.value = "<%=client.getLoadCommand()%>";
 	BodyForm.subcmd.value = "<%=client.getLoadSubCommand()%>";
 	BodyForm.submit();
</script>

<%@ include file="footer.jsp" %>

