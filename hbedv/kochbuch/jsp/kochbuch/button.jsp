<script language="JavaScript" type="text/JavaScript">
	function first(f) {
		f.target = "<%=TheApp.CMD_BODY%>";
		f.cmd.value = "<%=manager.getCmd()%>";
		f.subcmd.value = "<%=Kochbuch.SUB_CMD_FIRST%>";
		f.submit("");
	}

	function last(f) {
		f.target = "<%=TheApp.CMD_BODY%>";
		f.cmd.value = "<%=manager.getCmd()%>";
		f.subcmd.value = "<%=Kochbuch.SUB_CMD_LAST%>";
		f.submit("");
	}

	function back(f) {
		f.target = "<%=TheApp.CMD_BODY%>";
		f.cmd.value = "<%=manager.getCmd()%>";
		f.subcmd.value = "<%=Kochbuch.SUB_CMD_BACK%>";
		f.submit("");
	}

	function next(f) {
		f.target = "<%=TheApp.CMD_BODY%>";
		f.cmd.value = "<%=manager.getCmd()%>";
		f.subcmd.value = "<%=Kochbuch.SUB_CMD_NEXT%>";
		f.submit("");
	}

	function print(f) {
		f.cmd.value="<%=manager.getCmd()%>";
    	f.target = "PrintRezept";
    	win = window.open("",f.target,"toolbar=yes,location=no,"+
  			"directories=no,status=yes,menubar=yes,scrollbars=yes,resizable=yes,"+
  			"copyhistory=no");
		win.moveTo(0,0);
  		win.resizeTo(1140,820);
  	
  		f.cmd.value="<%=manager.getCmd()%>";
  		f.subcmd.value="<%=Kochbuch.SUB_CMD_PRINT_REZEPT%>";
  		f.submit("");
  			
	}
</script>

<%
if (client.isMobileVersion()) {
	%>
	<table align="center">
		<tr>
			<td width="70px" height="34px" align="center" style="position:relative;top:-6px;">
				<%
				if (row > 1) { %>
					<a href="javascript:first(BodyForm)">
						<img src="<%=client.getUriImageGlobal("bbutton_first.gif")%>" style="border:0;" alt="Erstes Rezept" width="32" height="32">
					</a>
				<% } else { %>
					<img src="<%=client.getUriImageGlobal("bbutton_first_disabled.gif")%>" style="border:0;" alt="" width="32" height="32">
				<% } %>
			</td>
			<td width="70px" align="center" style="position:relative;top:-6px;">
				<%
				if (row > 1) { %>
					<a href="javascript:back(BodyForm)">
						<img src="<%=client.getUriImageGlobal("bbutton_back.gif")%>" style="border:0;" alt="Zur&uuml;ck" width="32" height="32">
					</a>
				<% } else { %>
					<img src="<%=client.getUriImageGlobal("bbutton_back_disabled.gif")%>" style="border:0;" alt="" width="32" height="32">
				<% } %>
			</td>
			<td width="70px" align="center" style="position:relative;top:-6px;">
				<%
				if (row < size) { %>
					<a href="javascript:next(BodyForm)">
						<img src="<%=client.getUriImageGlobal("bbutton_prior.gif")%>" style="border:0;" alt="Vor" width="32" height="32">
					</a>
				<% } else { %>
					<img src="<%=client.getUriImageGlobal("bbutton_prior_disabled.gif")%>" style="border:0;" alt="" width="32" height="32">
				<% } %>
			</td>
			<td width="70px" align="center" style="position:relative;top:-6px;">
				<%
				if (row < size) { %>
					<a href="javascript:last(BodyForm)">
						<img src="<%=client.getUriImageGlobal("bbutton_last.gif")%>" style="border:0;" alt="Letztes Rezept" width="32" height="32">
					</a>
				<% } else { %>
					<img src="<%=client.getUriImageGlobal("bbutton_last_disabled.gif")%>" style="border:0;" alt="" width="32" height="32">
				<% } %>
			</td>
			<td>
				<p>&nbsp;</p>		
			<td>
			<td width="70px" align="center" style="position:relative;top:-6px;">
				<%
				if (size > 0) { %>
					<a href="javascript:print(BodyForm)">
						<img src="<%=client.getUriImageGlobal("bbutton_print.gif")%>" style="border:0;" alt="Drucken" width="32" height="32">
						<!-- <img src="<%=client.getUriImageGlobal("bbutton_print_disabled.gif")%>" style="border:0;" alt="" width="32" height="32"> -->
					</a>
				<% } else { %>
					<img src="<%=client.getUriImageGlobal("bbutton_print_disabled.gif")%>" style="border:0;" alt="" width="32" height="32">
				<% } %>
			</td>
			
		</tr>
	</table>
	<%
}
else {
	%>
	<table align="center">
		<tr>
			<td width="70px" height="70px" align="center">
				<%
				if (row > 1) { %>
					<a href="javascript:first(BodyForm)">
						<img src="<%=client.getUriImageGlobal("bbutton_first.gif")%>" style="border:0;" alt="Erstes Rezept">
					</a>
				<% } else { %>
					<img src="<%=client.getUriImageGlobal("bbutton_first_disabled.gif")%>" style="border:0;" alt="">
				<% } %>
			</td>
			<td width="70px" height="70px" align="center">
				<%
				if (row > 1) { %>
					<a href="javascript:back(BodyForm)">
						<img src="<%=client.getUriImageGlobal("bbutton_back.gif")%>" style="border:0;" alt="Zur&uuml;ck">
					</a>
				<% } else { %>
					<img src="<%=client.getUriImageGlobal("bbutton_back_disabled.gif")%>" style="border:0;" alt="">
				<% } %>
			</td>
			<td width="70px" height="70px" align="center">
				<%
				if (row < size) { %>
					<a href="javascript:next(BodyForm)">
						<img src="<%=client.getUriImageGlobal("bbutton_prior.gif")%>" style="border:0;" alt="Vor">
					</a>
				<% } else { %>
					<img src="<%=client.getUriImageGlobal("bbutton_prior_disabled.gif")%>" style="border:0;" alt="">
				<% } %>
			</td>
			<td width="70px" height="70px" align="center">
				<%
				if (row < size) { %>
					<a href="javascript:last(BodyForm)">
						<img src="<%=client.getUriImageGlobal("bbutton_last.gif")%>" style="border:0;" alt="Letztes Rezept">
					</a>
				<% } else { %>
					<img src="<%=client.getUriImageGlobal("bbutton_last_disabled.gif")%>" style="border:0;" alt="">
				<% } %>
			</td>
			<td>
				<p>&nbsp;</p>		
			<td>
			<td width="70px" height="70px" align="center">
				<%
				if (size > 0) { %>
					<a href="javascript:print(BodyForm)">
						<img src="<%=client.getUriImageGlobal("bbutton_print.gif")%>" style="border:0;" alt="Drucken">
					</a>
				<% } else { %>
					<img src="<%=client.getUriImageGlobal("bbutton_print_disabled.gif")%>" style="border:0;" alt="">
				<% } %>
			</td>
			
		</tr>
	</table>
	<%
}
%>
