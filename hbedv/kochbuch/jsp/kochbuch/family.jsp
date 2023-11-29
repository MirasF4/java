<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="../errorpage.jsp" %>
<%@ page import="com.hbedv.kochbuch.*" %>
<%@ page import="com.hbedv.frame.*" %>
<%@ page import="com.hbedv.db.kochbuch.KochbuchBean" %>

<%
	ClientKochbuch client= (ClientKochbuch)session.getAttribute(session.getId());
	if(client == null) throw new Exception("client == null");
	String progStr = "Programm:";
	if (client.getBsHeight().intValue() < 864) {
		progStr = "Progr.:";
	}
%>

<html>
<link rel="stylesheet" href="<%=client.getUriCssGlobal("kochbuch.css")%>" type="text/css">
<head>
<title>Kochbuch</title>

</head>

<BODY BGCOLOR=#ECE3BE LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>
<form name="BodyForm" method="post" action="<%=TheApp.encodeURL(client.getUriForm(), response)%>" target="body">

<input type="hidden" name="cmd" value="">
<input type="hidden" name="subcmd" value="">


<table width="100%">
	<tr>
		<td>
			<table>
				<tr>
					<td style="font-size:10pt;text-align:center;line-height:14px;"><b>(c) HB EDV Service</b></td>
				</tr>
				<tr>
					<td style="font-size:10pt;text-align:center;line-height:14px;">
						Idee: Ulrike Beham
					</td>
				</tr>
				<tr>
					<td style="font-size:10pt;text-align:center;line-height:14px;">
						Design: Michaela Beham
					</td>
				</tr>
				<tr>
					<td style="font-size:10pt;text-align:center;line-height:14px;">
						<%=progStr%> <a href="mailto:hubert@hubert.beham@solimp.at">Hubert Beham</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>


</div>
</form>
</BODY>
</HTML>

