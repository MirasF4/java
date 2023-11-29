<%@ include file="import.jsp" %>

<% 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	KochbuchManager manager = (KochbuchManager) client.getManager();
	client.setUpLoadPic(manager.getPicFileName());
	manager.readMenueList();
	AliceSortMap menueListe = manager.getAsmMenueListe();
	String auswahlErr = "";
%>


<%@ include file="header.jsp" %>
<%@ include file="js.jsp" %>

<script type="text/javascript" language="javascript">

function ResizeWindow(outerWidth,outerHeight) {
	//alert ("OK");
	var innerWidth = window.innerWidth;  
	var innerHeight = window.innerHeight;
	
	var speisenTyp = document.getElementById('speisenTyp');
	var rect = speisenTyp.getBoundingClientRect();
	//alert(rect.width);
	if (rect.width < 400) {
		speisenTyp.style.width = '400px';
	}
	
	var table01 = document.getElementById('table01');
	table01.style.position = "absolute";
	table01.style.top = '30px';
	table01.style.left = '30px';
	
	var wi = innerWidth-60;
	table01.style.width = wi+'px';
	
	var wi = innerHeight-30;
	table01.style.height = wi+'px';
	
	if (typeof includeScriptZutaten === "function") {
		includeScriptZutaten(outerWidth,outerHeight,innerWidth,innerHeight,'table02');
	}
	
	if (typeof includeScriptKommentar === "function") {
		includeScriptKommentar(outerWidth,outerHeight,innerWidth,innerHeight);
	}
	
	if (typeof includeScriptZubereitung === "function") {
		includeScriptZubereitung(outerWidth,outerHeight,innerWidth,innerHeight);
	}
}
</script>

<input type="hidden" name="m_id" value="<%=manager.getMenId()%>">
<input type="hidden" name="r_id" value="<%=manager.getRezId()%>">
<input type="hidden" name="lastMenId" value="<%=manager.getMenId()%>">

<table id="table01" width="100%" border="0" >
	<tr>
		<td width="50%" align="left" valign="middle">
			<p>
				Rezeptname:&nbsp;
				<font size="5" face="Sylfaen">
					<strong><%=manager.getRezeptNameJSP()%></strong>
				</font>
				<input type="hidden" name="rezeptname" value="<%=manager.getRezeptName()%>">
			</p>
		</td>
		<td width="50%" align="left" valign="middle" style="height:30px;">
			<p id="speisenTyp">Typ&nbsp;der&nbsp;Speise:&nbsp;
				<select size="1" name="selectMenues" class="kb" style="width:186px;" onChange="changeMenue(BodyForm,this.value)">
					<%
					String selected = "";
					Integer aktId = manager.getMenId();
					for (int index=0;index<menueListe.getSize();index++) {
						String bez = (String) menueListe.getKeys(KochbuchBean.AsmMenue.KEY_BEZ).get(index);	
						Integer id = (Integer) menueListe.getKeys(KochbuchBean.AsmMenue.KEY_ID).get(index);	
						if (aktId.equals(id)) {
							selected = "selected";
						}
						else {
							selected = "";
						}
						%>
							<option <%=selected%> value=<%=id%>><%=bez%></option>
						<%
					}
					%>
				</select>
			</p>
		</td>
	<tr>
		<td align="left"  valign="top">
			<table id="table02" border="0">
				<tr>
					<td style="width:50%">
						<%@ include file="zutaten.jsp" %>
					</td>
				</tr>
				<tr>
					<td style="width:50%">
						<%@ include file="kommentar.jsp" %>
					</td>
				</tr>
			</table>
		</td>
		<td valign="top">
			<%@ include file="zubereitung.jsp" %>
		</td>
	</tr>
	<tr>
		<td id = "buttonTd" align="center" colspan="2" height="100%" valign="middle" style="position:relative;top:-6px;">
			<table border="0">
				<tr>
					<td align="left" width="128px">
						<input type="button" class="kbbutton2" style="width:120px;" name="upLoadButton" value="Bild hochladen" onClick="javascript:picUpload(BodyForm)" >
					<td>
					<td align="left" width="128px">
						<%
						String vgl = client.getAppRootUrl() + "/images/data/nopic.jpg";
						String bild = manager.getPicName();
						if (!bild.equalsIgnoreCase(vgl)) { %>
							<input type="button" class="kbbutton2" style="width:120px;" name="deleteButton" value="Bild l&ouml;schen" onClick="javascript:picDelete(BodyForm)" >
						<% } %>
					<td>
					<td align="left" width="128px">
						<input type="button" class="kbbutton" style="width:120px;" id="saveButton" name="saveButton" value="Speichern" onClick="javascript:saveRezept(BodyForm)" >
					</td>
					<td align="left" width="128px">
						<input type="button" class="kbbutton2" style="width:120px" name="zurueckButton" value="Zur&uuml;ck" onClick="javascript:zurueckZurAuswahl(BodyForm)" >
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<%@ include file="footer.jsp" %>
