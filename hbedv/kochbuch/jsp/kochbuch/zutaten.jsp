<%
AliceSortMap zutatenListe = manager.getZutaten();
%>

<script language="JavaScript" type="text/JavaScript">
var aktuelleZeile = 1;

function setZutatenZeile(zeile) {
	aktuelleZeile = zeile;
}
function insertZutat(f) {
	for (index=98;index>=aktuelleZeile;index--) {
		var wertAnzahl = eval(f.name + ".anzahl_" + index + ".value");
		var wertEinheit = eval(f.name + ".einheit_" + index + ".value");
		var wertZutat = eval(f.name + ".zutaten_" + index + ".value");
		
		eval(f.name + ".anzahl_" + (index + 1) + ".value = '" + wertAnzahl + "';");
		eval(f.name + ".einheit_" + (index + 1) + ".value = '" + wertEinheit + "';");
		eval(f.name + ".zutaten_" + (index + 1) + ".value = '" + wertZutat + "';");
	}
	eval(f.name + ".anzahl_" + aktuelleZeile + ".value = '';");
	eval(f.name + ".einheit_" + aktuelleZeile + ".value = '';");
	eval(f.name + ".zutaten_" + aktuelleZeile + ".value = '';");
	eval(f.name + ".anzahl_" + aktuelleZeile + ".focus();");
}

function deleteZutat(f) {
	for (index=aktuelleZeile;index<99;index++) {
		var wertAnzahl = eval(f.name + ".anzahl_" + (index + 1) + ".value");
		var wertEinheit = eval(f.name + ".einheit_" + (index + 1) + ".value");
		var wertZutat = eval(f.name + ".zutaten_" + (index + 1) + ".value");
		
		eval(f.name + ".anzahl_" + index + ".value = '" + wertAnzahl + "';");
		eval(f.name + ".einheit_" + index + ".value = '" + wertEinheit + "';");
		eval(f.name + ".zutaten_" + index + ".value = '" + wertZutat + "';");
	} 
	f.anzahl_99.value = '';
	f.einheit_99.value = '';
	f.zutaten_99.value = '';
	eval(f.name + ".anzahl_" + aktuelleZeile + ".focus();");
}

function includeScriptZutaten(outerWidth,outerHeight,innerWidth,innerHeight,id1) {
	var divZut01 = document.getElementById('divZut01');
	var e = (outerHeight/2) - 240;
	divZut01.style.height = e + "px";

	var e = (innerWidth/2) - 60;
	var divZu = e;
	if (e > 352) divZut01.style.width = e + "px";
	
	var table03 = document.getElementById('table03');
	var e = (innerWidth/2) - 90;
	if (e > 260) table03.style.width = e + "px";
	
	var zut_Td_01 = document.getElementById('zut_Td_01');
	var e = (innerWidth/2) - 60;
	if (e > 260) zut_Td_01.style.width = e + "px";
	
	var th01 = document.getElementById('th01');
	var e = (innerWidth/2) - 220;
	if (e > 200) th01.style.width = e + "px";
	
	var th02 = document.getElementById('th02');
	var e = (divZu/5);
	th02.style.width = e + "px";
		
	var th03 = document.getElementById('th03');
	var e = (divZu/5) * 4;
	if (e > 460) th03.style.width = e + "px";
	
	<%
	for (int index=0;index<zutatenListe.getSize();index++) {
		%>
		var inptxt<%=index%> = document.getElementById('inptxt<%=index%>');
		var e = (innerWidth/2) - 220;
		if (e > 200) inptxt<%=index%>.style.width = e + "px";
		<%
	}
	int startJS = zutatenListe.getSize();
	for (int index=startJS;index<100;index++) {
		%>
		var inptxt<%=index%> = document.getElementById('inptxt<%=index%>');
		var e = (innerWidth/2) - 220;
		if (e > 200) inptxt<%=index%>.style.width = e + "px";
		<%
	}
	%>
}

</script>


	<table>
		<tr>
			<td>
				<table>
					<tr>
						<td id="th02">
							<font size="5" face="Sylfaen">
								<strong>
									Zutaten
								</strong>
							</font>
						</td>
						<td  id="th03" style="text-align:right;">
							<input type="button" class="kbbutton2" accesskey="e" style="width:120px;" name="bZutatInsert" 
							value="Zutat einf&uuml;gen" onClick="javascript:insertZutat(document.BodyForm);" >
							
							<input type="button" class="kbbutton2" accesskey="l" style="width:120px;" name="bZutatDelete" 
							value="Zutat l&ouml;schen" onClick="javascript:deleteZutat(document.BodyForm);" >
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td id="zut_Td_01">
				<div id="divZut01" align="left" style="overflow:auto;border-color:#D9B565; border-width:1px;border-style:solid;padding:2px;">
					<table id="table03" border="0">
						<tr valign="top">
						<tr>
							<th style="text-align:center;">Anzahl</th>
							<th style="text-align:left" >Einheit</th>
							<th id="th01" style="text-align:left;">Zutaten</th>
						</tr>
						<%
						for (int index=0;index<zutatenListe.getSize();index++) {
							String anzStr = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_ANZAHL).get(index);
							String einheit = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_EINHEIT).get(index);
							String zutaten = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_BEZ).get(index);
							%>																		
							<tr>
								<td style="width:50px;">
									<input type="text" maxlength="10" name="anzahl_<%=index%>" value="<%=anzStr%>" 
									onBlur="setZutatenZeile(<%=index%>)" style="width:50px;text-align:center;" class="kbedit"  >
								</td>
								<td style="width:50px;">
									<input type="text" maxlength="10" name="einheit_<%=index%>" value="<%=einheit%>" 
									onBlur="setZutatenZeile(<%=index%>)" style="width:50px" class="kbedit">
								</td>
								<td>
									<input id="inptxt<%=index%>" type="text" maxlength="50" size="50" name="zutaten_<%=index%>" value="<%=zutaten%>" 
									onBlur="setZutatenZeile(<%=index%>)" class="kbedit">	
								</td>
								
							</tr>
							<%
						}
						
						int start = zutatenListe.getSize();
						for (int index=start;index<100;index++) { %>
							<tr>
								<td>
									<input type="text" maxlength="10" name="anzahl_<%=index%>" value="" 
									style="width:50px;text-align:center;" onBlur="setZutatenZeile(<%=index%>)" class="kbedit" >
								</td>
								<td>
									<input type="text" maxlength="10" name="einheit_<%=index%>" value="" 
									style="width:50px;" onBlur="setZutatenZeile(<%=index%>)" class="kbedit" >
								</td>
								<td>
									<input id="inptxt<%=index%>" type="text" maxlength="50" size="50" name="zutaten_<%=index%>" value="" 
									onBlur="setZutatenZeile(<%=index%>)" class="kbedit" >	
								</td>
								
							</tr>
						<%
						}
						%>
					</table>
				</div>
			</td>
		</tr>
	</table>	
						