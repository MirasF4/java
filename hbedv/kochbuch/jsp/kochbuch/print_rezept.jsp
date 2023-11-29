
<%@ include file="import.jsp" %>

<% 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	KochbuchManager manager = (KochbuchManager) client.getManager();
%>

<html>
<link rel="stylesheet" href="<%=client.getUriCssGlobal("print_kochbuch.css")%>" type="text/css">
<head>
<title>Kochbuch</title>

<script language="JavaScript" type="text/JavaScript">
onload = function() {
	window.print();
}

function resizeApp() {
	/*
	var pic1 = document.getElementById('pic1');
	var pKom = document.getElementById('pKom');
	var rect = pKom.getBoundingClientRect();
	var e = rect.top;
	pic1.position = "absolute";
	pic1.top = e;
	*/
}

</script>

</head>

<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>
<form name="BodyFormPrint" method="post" action="<%=TheApp.encodeURL(client.getUriForm(), response)%>" target="PrintRezept">

<table width="100%">
	<tr>
		<td align="center">
			<table width="90%" border="0">
				<tr>
					<td width="90px">&nbsp;</td>
					<td width="100%" height="60px" align="left" colspan="3">
						<table width="100%" border="0">
						<tr>
						<td>
						<em>
							<strong>
								<font size="6" face="Sylfaen" style="position:relative;top:+8px;">
									<%=manager.getRezeptName()%> 
								</font>
							</strong>
						</em>
						</td>
						<td align="right">
						<font size="4" face="Sylfaen" style="position:relative;top:+8px;">
							(<%=manager.getMenueBez()%>)&nbsp;
						</font>
						</td>
						</tr>
						</table>
					</td>
					</td>
					
				</tr>
				<tr>
					<td width="90px">&nbsp;</td>
					<td>
						<p style="border-width:0px;padding:2px;background-color:silver;height:28px;width:450px;position:relative;top:-2px;text-align:left;">
							<font size="5" face="Sylfaen" style="position:relative;top:+2px;">
								<strong>
									&nbsp;Zutaten
								</strong>
							</font>
						</p>
					</td>
					<td>
						<p style="border-width:0px;padding:2px;background-color:silver;height:28px;width:440px;position:relative;top:-2px;text-align:left;">
							<font size="5" face="Sylfaen" style="position:relative;top:+2px;">
								<strong>
									&nbsp;Zubereitung
								</strong>
							</font>
						</p>
					</td>
				</tr>
				<tr>
					<td width="90px">&nbsp;</td>
					<td style="position:relative;top:-16px;">
						<table style="width:452px;">
							<tr>
								<th width="30px" style="text-align:center;">Anzahl</th>
								<th width="30px" style="text-align:left;">Einheit</th>
								<th style="text-align:left;">Zutaten</th>
							</tr>
							<%
							AliceSortMap zutatenListe = manager.getZutaten();
							for (int index=0;index<zutatenListe.getSize();index++) {
								String anzStr = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_ANZAHL).get(index);
								String einheit = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_EINHEIT).get(index);
								String zutaten = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_BEZ).get(index);
								%>																		
								<tr>
									<td width="30px" align="center"><%=anzStr%></td>
									<td width="30px"><%=einheit%></td>
									<td><%=zutaten%></td>
								</tr>
								<%
							}
							%>
						</table>
					</td>
					
					<td rowspan="2" valign="top" style="position:relative;top:-34px;">
						<table width="90%" valign="top">
							<tr>
								<td style="text-align:left;" valign="top"">		
									<pre class="kb"><%=manager.getZubereitung()%></pre>
								</td>
							</tr>
						</table>			
					</td>
				</tr>
				
				<tr>
					<td width="90px">&nbsp;</td>
					<td>
						
						<table>
							<tr>
								<td valign="top">
									<p id = "pKom" style="border-width:0px;padding:2px;background-color:silver;height:28px;width:230px;position:relative;top:-16px;text-align:left;">
										<font size="5" face="Sylfaen" style="position:relative;top:2px;">
											<strong>
												&nbsp;Kommentar
											</strong>
										</font>
									</p>
								</td>
								<% 
								int topPic = 0;
								if (client.isMobileVersion()) topPic = -22;
								int topKom = -46;
								if (client.isMobileVersion()) topKom = -46;
								%>
								<td valign="top" rowspan="2">
									&nbsp;<img id="pic1" src="<%=manager.getPicName()%>" width="210px" height="188px" ALT="" style="position:relative;top:<%=topPic%>px;">
								</td>
							</tr>
							<tr valign="top">
								<td style="text-align:left;width:210px;position:relative;top:<%=topKom%>px;">		
									<pre class="kb"><%=manager.getKommentar()%></pre>
								</td>
							</tr>
						</table>	
					
					</td>
					
				</tr>
				
				
			</table>

		</td>
	</tr>
</table>

<%@ include file="footer.jsp"%>
