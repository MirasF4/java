
<%
int breite = 450;
int picBreite = 210;
int picHoehe = 154;
int topZub = -7;
if (client.getBsWidth().intValue() < 1152) {
	breite = 405;
	picBreite = 162;
	picHoehe = 130;
	topZub = -6;
}
%>

<script type="text/javascript" language="javascript">

function ResizeWindow(outerWidth,outerHeight) {
	//alert ("OK");
	var innerWidth = window.innerWidth;  
	var innerHeight = window.innerHeight;

	<%
	if (client.isMobileVersion()) {
	%>
		var w = 290;
		var h = 136;
		var mainTable = document.getElementById('mainTable');
		mainTable.style.position = "absolute";
		mainTable.style.top = '6px';
		mainTable.style.left = '26px';
		var wi = innerWidth-60;
		mainTable.style.width = wi+'px';
			
		var s1z1 = document.getElementById('s1z1');
		s1z1.style.width = '75%';
		
		var s2z1 = document.getElementById('s2z1');
		s2z1.style.width = '25%';
		
		var div1  = document.getElementById('div1');
		var e = innerHeight - h + 4;
		div1.style.height = e + "px";
		var e = (innerWidth/2) - 58;
		if (e > w) div1.style.width = e + "px";
		if (e <= w) div1.style.width = w + "px";
		
		var rezTd01 = document.getElementById('rezTd01');
		var rect = div1.getBoundingClientRect();
		var e = rect.width - 4;
		if (e > w) rezTd01.style.width = e + 'px';
		if (e <= w) rezTd01.style.width = w + 'px';
				
		var div2  = document.getElementById('div2');
		var e = innerHeight - h;
		div2.style.height = e + "px";
		
		//width:200px"
		var e = (wi/2) - 20;
		div2.style.width = e + "px";
					
		var rezTd02 = document.getElementById('rezTd02');
		var rect = mainTable.getBoundingClientRect();
		var e = (rect.width/2) - 16;
		rezTd02.style.width = e + 'px';
		
		var rezTd03 = document.getElementById('rezTd03');
		var rect = div3.getBoundingClientRect();
		var e = rect.width - 6;
		rezTd03.style.width = e + 'px';
		
		var browser = getBrowserName();
		var pic1 = document.getElementById('pic1');
		if (pic1 != null) {
			if (browser == isIE || browser == isEdge) {
				pic1.width = "199";
				pic1.height = "152";
			}
			else {
				pic1.width = "200";
				pic1.height = "156";
			}
		}
		
		var div4 = document.getElementById('div4');
		div4.style.width = '200px';
		div4.style.height = '156px';
	<%
	}
	else {	
	%>
		var w = 415;
		var mainTable = document.getElementById('mainTable');
		mainTable.style.position = "absolute";
		mainTable.style.top = '30px';
		mainTable.style.left = '26px';
		var wi = innerWidth-60;
		mainTable.style.width = wi+'px';
			
		var s1z1 = document.getElementById('s1z1');
		s1z1.style.width = '75%';
		
		var s2z1 = document.getElementById('s2z1');
		s2z1.style.width = '25%';
		
		var div1  = document.getElementById('div1');
		var e = innerHeight - 410;
		div1.style.height = e + "px";
		var e = (innerWidth/2) - 58;
		if (e > w) div1.style.width = e + "px";
		if (e <= w) div1.style.width = w + "px";
		
		var rezTd01 = document.getElementById('rezTd01');
		var rect = div1.getBoundingClientRect();
		var e = rect.width - 4;
		if (e > w) rezTd01.style.width = e + 'px';
		if (e <= w) rezTd01.style.width = w + 'px';
		
		var div2  = document.getElementById('div2');
		var e = innerHeight - 204;
		div2.style.height = e + "px";
		
		//width:200px"
		var e = (wi/2) - 20;
		div2.style.width = e + "px";
			
		var rezTd02 = document.getElementById('rezTd02');
		var rect = mainTable.getBoundingClientRect();
		var e = (rect.width/2);
		rezTd02.style.width = e + 'px';
				
		var rezTd03 = document.getElementById('rezTd03');
		var rect = div3.getBoundingClientRect();
		var e = rect.width - 6;
		rezTd03.style.width = e + 'px';
		
		var browser = getBrowserName();
		var pic1 = document.getElementById('pic1');
		if (pic1 != null) {
			if (browser == isIE || browser == isEdge) {
				pic1.width = "199";
				pic1.height = "152";
			}
			else {
				pic1.width = "200";
				pic1.height = "156";
			}
		}
		
		var div4 = document.getElementById('div4');
		div4.style.width = '200px';
		div4.style.height = '156px';
		
	<%
	}
	%>
}


</script>
<%
if (client.isMobileVersion()) {
%>
<table border="0" id="mainTable">
	<tr>
		<td colspan = "2">
			<table border="0" width="100%">
				<tr>
					<td id="s1z1" style="text-align:left;height:20px;">
						<em>
							<strong>
								<font face="Sylfaen" style="font-size:150%">
									<%=manager.getRezeptNameJSP()%> 
								</font>
							</strong>
						</em>
					</td>
					<td id="s2z1" style="text-align:right;" >
						<font size="2" face="Sylfaen" style="font-size:95%">
							<%
							int row = manager.getAsmRow() + 1;
							int size = manager.getSizeRezeptListe();
							if (size < 1) row = 0;
							%>
							(<%=manager.getMenueBez()%>&nbsp;<%=row%>&nbsp;von&nbsp;<%=size%>)&nbsp;
						</font>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table>
				<tr>
					<td id="rezTd01" style="height:20px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;left:2px;">
						<font id="font01" size="4" face="Sylfaen" >
							<strong>
								Zutaten
							</strong>
						</font>
					</td>
				</tr>
			</table>
		</td>
		<td>
			<table>
				<tr>
					<td id="rezTd02" style="height:20px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;left:0px;"">
						<font id="font02" size="4" face="Sylfaen" >
							<strong>
								Zubereitung
							</strong>
						</font>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<div id="div1" style="border-color:#D9B565; border-width:1px;border-style:solid;padding:2px;overflow:auto;position:relative;left:2px;">
				<table border="0">
					<tr>
						<th width="20%" style="text-align:center;">Anzahl</th>
						<th width="20%" style="text-align:left;">Einheit</th>
						<th width="60%" style="text-align:left;">Zutaten</th>
					</tr>

					<%
					AliceSortMap zutatenListe = manager.getZutaten();
					for (int index=0;index<zutatenListe.getSize();index++) {
						String anzStr = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_ANZAHL).get(index);
						String einheit = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_EINHEIT).get(index);
						String zutaten = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_BEZ).get(index);
						%>																		
					<tr>
						<td width="20%" align="center"><%=anzStr%></td>
						<td width="20%"><%=einheit%></td>
						<td width="60%"><%=zutaten%></td>
					</tr>
					<%
					}
					%>
				</table>
			</div>
		</td>
		<td id = "zubeTD01" rowspan="3" valign="top">
			<div id="div2" style="border-color:#D9B565; border-width:1px;border-style:solid;padding:4px;overflow:auto;">
				<pre class="kb"><%=manager.getZubereitung()%><br></br><strong>Kommentar:</strong></br><%=manager.getKommentar()%></pre>
			</div>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<%@ include file="button.jsp" %>
		</td>
	</tr>

</table>
<%
}
else {
%>
<table border="0" id="mainTable">
	<tr>
		<td colspan = "2">
			<table border="0" width="100%">
				<tr>
					<td id="s1z1" style="text-align:left;height:20px;">
						<em>
							<strong>
								<font face="Sylfaen" style="font-size:150%">
									<%=manager.getRezeptNameJSP()%> 
								</font>
							</strong>
						</em>
					</td>
					<td id="s2z1" style="text-align:right;" >
						<font size="2" face="Sylfaen" style="font-size:95%">
							<%
							int row = manager.getAsmRow() + 1;
							int size = manager.getSizeRezeptListe();
							if (size < 1) row = 0;
							%>
							(<%=manager.getMenueBez()%>&nbsp;<%=row%>&nbsp;von&nbsp;<%=size%>)&nbsp;
						</font>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table>
				<tr>
					<td id="rezTd01" style="height:32px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;top:+0px;left:1px">
						<font id="font01" size="5" face="Sylfaen" >
							<strong>
								Zutaten
							</strong>
						</font>
					</td>
				</tr>
			</table>
		</td>
		<td>
			<table>
				<tr>
					<td id="rezTd02" style="height:32px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;top:0px;left:-2px;">
						<font id="font02" size="5" face="Sylfaen" >
							<strong>
								Zubereitung
							</strong>
						</font>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<div id="div1" style="border-color:#D9B565; border-width:1px;border-style:solid;padding:2px;overflow:auto;position:relative;left:2px;">
				<table border="0">
					<tr>
						<th width="20%" style="text-align:center;">Anzahl</th>
						<th width="20%" style="text-align:left;">Einheit</th>
						<th width="60%" style="text-align:left;">Zutaten</th>
					</tr>

					<%
					AliceSortMap zutatenListe = manager.getZutaten();
					for (int index=0;index<zutatenListe.getSize();index++) {
						String anzStr = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_ANZAHL).get(index);
						String einheit = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_EINHEIT).get(index);
						String zutaten = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_BEZ).get(index);
						%>																		
					<tr>
						<td width="20%" align="center"><%=anzStr%></td>
						<td width="20%"><%=einheit%></td>
						<td width="60%"><%=zutaten%></td>
					</tr>
					<%
					}
					%>
				</table>
			</div>
		</td>
		<td id = "zubeTD01" rowspan="3" valign="top">
			<div id="div2" style="border-color:#D9B565; border-width:1px;border-style:solid;padding:4px;overflow:auto;">
				<pre class="kb"><%=manager.getZubereitung()%></pre>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<table>
				<tr>
					<td id="rezTd03" style="height:32px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;top:+2px;left:0px">
						<font id="font01" size="5" face="Sylfaen" >
							<strong>
								Kommentar
							</strong>
						</font>
					</td>
					<td id="rezTd04" style="width:196px;height:32px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;top:+2px;left:10px">
						<font id="font02" size="5" face="Sylfaen" >
							<strong>
								Bild
							</strong>
						</font>
					</td>
				</tr>
			</table>
		</td>
		<td>
		</td>
	</tr>
	
	<tr>
		<td style= "width:50%">
			<table border="0" width="100%">
				<tr>
					<td id = "komTd03" >
						<div id="div3" style="height:98%;border-color:#D9B565; border-width:1px;border-style:solid;padding:4px;overflow:auto;position:relative;left:-2px;">
							<pre id="kom2" class="kb" style="height:116px" ><%=manager.getKommentar()%></pre>
						</div>
					</td>
					<td align="left" width="220px">
						<div id="div4" style="border-color:#D9B565; border-width:1px;border-style:solid;padding:0px;overflow:auto;position:relative;left:4px;">
							<img id="pic1" src="<%=manager.getPicName()%>" ALT="<%=manager.getRezeptNameJSP()%>" >
						</div>
					</td>
				</tr>
			</table>
		</td>
		<td>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<%@ include file="button.jsp" %>
		</td>
	</tr>
</table>
<%
}
%>

