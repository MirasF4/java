<%@ include file="import.jsp" %>

<% 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	boolean mobileVersion = client.isMobileVersion();
	KochbuchBodyManager manager = client.getKochbuchBodyManager();
%>

<%@ include file="header.jsp" %>

<script type="text/JavaScript">
function nothingToDo(f) {
	f.logo.style.cursor = "default";
}
</script>
<table width="100%">
	<tr>
		<td align="center">
			<table width="95%" border="0">
				<%
				if (mobileVersion) {
				%>
					<tr>
						<td width="100%" align="center" valign="middle" height="550px">
							<a href="javascript:nothingToDo(BodyForm)" >
								<IMG SRC="<%=client.getUriImageGlobal("body.jpg")%>" name="logo" disabled="true" border="0" WIDTH="450px" HEIGHT="300px" ALT="" style="cursor:default;position:absolute;top:30px;left:90px;">
							</a>
						</td>
					</tr>
					<%
				}
				else {
				%>
					<tr>
						<td width="100%" align="center" valign="middle" height="550px">
							<a href="javascript:nothingToDo(BodyForm)" >
								<IMG SRC="<%=client.getUriImageGlobal("body.jpg")%>" name="logo" disabled="true" border="0" WIDTH="600px" HEIGHT="400px" ALT="" style="cursor:default;">
							</a>
						</td>
					</tr>
				<%
				}
				%>
			</table>
		</td>
	</tr>
</table>

<%@ include file="footer.jsp" %>