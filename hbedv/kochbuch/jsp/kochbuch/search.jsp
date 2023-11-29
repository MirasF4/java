<%@ include file="import.jsp"%>

<% 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	KochbuchSearchManager manager = client.getKochbuchSearchManager();
	AliceSortMap asm = manager.readMenueList();
	AliceSortMap suchAsm = manager.getAsmSuchListe();
%>

<%@ include file="header.jsp"%>

<script language="JavaScript" type="text/JavaScript">

//setDefaultButton("searchButton");

function changeMenue(f,wert) {
	f.men_id.value = wert;
	f.searchButton.focus();
}

function suche(f) {
	f.cmd.value = "<%=TheApp.CMD_SEARCH%>";
	f.subcmd.value = "<%=Kochbuch.SUB_CMD_SUCHEN%>";
	f.submit("");
}

function auswahl_zeile(f,mId,rId) {
	f.m_id.value = mId;
	f.r_id.value = rId;
	f.cmd.value = "<%=TheApp.CMD_SEARCH%>";
	f.subcmd.value = "<%=Kochbuch.SUB_CMD_AUSWAHL%>";
	f.submit("");
}


function edit_zeile(f,mId,rId) {
	f.m_id.value = mId;
	f.r_id.value = rId;
	f.cmd.value = "<%=TheApp.CMD_SEARCH%>";
	f.subcmd.value = "<%=Kochbuch.SUB_CMD_EDIT%>";
	f.submit("");
}


function delete_zeile(f,mId,rId) {
	if (window.confirm("<%=manager.getDeleteQuestion()%>")) {
		f.m_id.value = mId;
		f.r_id.value = rId;
		f.cmd.value = "<%=TheApp.CMD_SEARCH%>";
		f.subcmd.value = "<%=Kochbuch.SUB_CMD_DELETE%>";
		f.submit("");
	}
}


function neuesRezept(f) {
	f.m_id.value = 0;
	f.r_id.value = 0;
	f.cmd.value = "<%=TheApp.CMD_SEARCH%>";
	f.subcmd.value = "<%=Kochbuch.SUB_CMD_INSERT%>";
	f.submit("");
}


onload = function() {
	<%
	if (client.isLogonError()) { 
		client.setLogonError(false);
		%>
		alert("<%=manager.getLogonErrMsg()%>");	
		BodyForm.user.focus();
	<% } %>
}


function loginUser(f) {
	f.cmd.value = "<%=TheApp.CMD_SEARCH%>";
	f.subcmd.value = "<%=Kochbuch.SUB_CMD_LOGINUSER%>";
	f.submit("");
}


function logoutUser(f) {
	f.cmd.value = "<%=TheApp.CMD_SEARCH%>";
	f.subcmd.value = "<%=Kochbuch.SUB_CMD_LOGOUTUSER%>";
	f.submit("");
}

function ResizeWindow(outerWidth,outerHeight) {
	var innerWidth = window.innerWidth;  
	var innerHeight = window.innerHeight;
	
	<%
	if (client.isMobileVersion()) {
		%>
		var td01 = document.getElementById('td01');
		td01.style.position = "absolute";
		td01.style.top = '124px';
		td01.style.left = '9px';
		td01.style.width = '94.5%';
		var e = innerHeight - 145;
		td01.style.height = e + 'px';
		
		var divDetail01 = document.getElementById('divDetail01');
		var e = innerHeight - 150;
		divDetail01.style.height = e+'px';
	<%
	}
	else {
		%>
		var td01 = document.getElementById('td01');
		td01.style.position = "absolute";
		td01.style.top = '160px';
		td01.style.left = '9px';
		td01.style.width = '96%';
		var e = innerHeight - 240;
		td01.style.height = e + 'px';
	
		var divDetail01 = document.getElementById('divDetail01');
		var e = innerHeight - 260;
		divDetail01.style.height = e+'px';
		
		var td02 = document.getElementById('td02');
		var e = innerHeight - 60;
		td02.style.position = "absolute";
		td02.style.top =  e + 'px';
		td02.style.left = '8px';
		<%
	}
	%>
}


</script>
<input type="hidden" name="men_id" value="<%=manager.getSuchMenueId()%>">
<input type="hidden" name="m_id" value="0">
<input type="hidden" name="r_id" value="0">
<%
if (client.isMobileVersion()) {
	%>
<table style="width:98%">
	<tr>
		<td align="center" style="border-color:#D9B565; border-width:1px;border-style:solid;padding:2px;height:80px;width:99%">
		<table id = "table01" width="100%" border="0">
				<tr>
					<td height="20px">
						<font size="2" face="Sylfaen">
							Typauswahl:
						</font>
					</td>
					<td>
						<select size="1" name="selectMenues" class="kb" style="width:128px;" onChange="changeMenue(BodyForm,this.value)">
							<%
							String selected = "";
							if (manager.getSuchMenueId().intValue() == 0) selected = "selected";
							%>
							<option <%=selected%> value=0> </option> 
							<%
							for (int index=0;index<asm.getSize();index++) {
								selected = "";
								Integer id = (Integer) asm.getKeys(KochbuchBean.AsmMenue.KEY_ID).get(index);
								String bez = (String) asm.getKeys(KochbuchBean.AsmMenue.KEY_BEZ).get(index);
								if (manager.getSuchMenueId().equals(id)) selected = "selected";
								%>
								<option <%=selected%> value=<%=id%>><%=bez%></option> 
								<%
							}
							%>
						</select>
					</td>

					<td >
						<font size="2" face="Sylfaen">
							Rezept:
						</font>
					</td>
					<td >
						<input type="text" name="rezeptname" value="<%=manager.getSuchName().replaceAll("%","")%>" style="width:120px;" class="kbedit" >
					</td >
					<td>
						<font size="2" face="Sylfaen">
							Zutat:
						</font>
					</td>
					<td>
						<input type="text" name="zutat" value="<%=manager.getSuchZutat().replaceAll("%","")%>" style="width:120px;" class="kbedit" >
					</td>
				</tr>
	
				<tr>
					<td height="32px">
						<font size="2" face="Sylfaen">
							Beschreibung:
						</font>
					</td>
					<td>
						<input type="text" name="beschreibung" value="<%=manager.getSuchBeschreibung().replaceAll("%","")%>" style="width:120px;" class="kbedit" >
					</td>
					<td >
						<font size="2" face="Sylfaen">
							Kommentar:	
						</font>
					</td>
					<td >
						<input type="text" name="kommentar" value="<%=manager.getSuchKommentar().replaceAll("%","")%>" style="width:120px;" class="kbedit">
					</td >
					<td>&nbsp;</td>
					<td>
						<input type="button" class="kbbutton" style="width:120px;" id="searchButton" name="searchButton" value="Suche&nbsp;starten" onClick="javascript:suche(BodyForm)" >
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" style="position:relative;left:2px;">
				<tr>
					<th width="30px" height="20px" style="text-align:left;" >&nbsp;</th>
					<% if (client.isAngemeldet()) { %>
						<th width="30px" style="text-align:left;" >&nbsp;</th>
						<th width="30px" style="text-align:left;" >&nbsp;</th>
					<% } %>
					<th style="text-align:left;width:120px;">Typ</th>
					<th style="text-align:left;">Name</th>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td id ="td01" style="align:left;text-align:center;overflow:auto;border-color:#D9B565; border-width:1px;border-style:solid;;position:absolute;top:60px;">
		</td>
	</tr>
	<tr>
		<td>
			<div id="divDetail01" align="left" style="width:96%;overflow:auto;position:absolute;top:128px;">
				<table id="table01">
					<tr>
						<td style="align:left;width:100%;">		
							<table width="100%">
								<%
								for (int index=0;index<suchAsm.getSize();index++) {
									String m_bez = (String) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_MEN_BEZ).get(index);
									String r_bez = (String) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_REZ_BEZ).get(index);
									Integer m_id = (Integer) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_MEN_ID).get(index);
									Integer r_id = (Integer) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_REZ_ID).get(index);
									%>																		
									<tr>
										<td align="center" height="20px" width="30px">
											<a href="javascript:auswahl_zeile(BodyForm,<%=m_id%>,<%=r_id%>)">
												<img src="<%=client.getUriImageGlobal("text.gif")%>" border="0" alt="Rezept ansehen">
											</a>
										</td>
										<% if (client.isAngemeldet()) { %>
											<td align="center" width="30px">
												<a href="javascript:edit_zeile(BodyForm,<%=m_id%>,<%=r_id%>)">
													<img src="<%=client.getUriImageGlobal("quill.gif")%>" border="0" alt="Rezept bearbeiten" >
												</a>
											</td>
											<td align="center" width="30px">
												<a href="javascript:delete_zeile(BodyForm,<%=m_id%>,<%=r_id%>)">
													<img src="<%=client.getUriImageGlobal("trashcan.gif")%>" border="0" alt="Rezept l&ouml;schen" >
												</a>
											</td>
										<% } %>
										<td align="left" width="120px"><font><%=m_bez%></font></td>
										<td align="left"><font><%=r_bez%></font></td>
									</tr>
									<%
								}
								%>
								<tr>
									<td width="30px">&nbsp;</td>
									<% if (client.isAngemeldet()) { %>
										<td width="30px">&nbsp;</td>
										<td width="30px">&nbsp;</td>
									<% } %>
									<td width="120px">&nbsp;</td>
									<%
									int sizeR = suchAsm.getSize();
									String msg = " Rezepte gefunden.";
									if (sizeR == 1) {
										msg = " Rezept gefunden.";
									}
									%>
									<td align="left" height="20px">
										<font>
											<b><%=sizeR%><%=msg%></b>
										</font>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</td>
	</tr>
</table>
	<%
}
else {
	%>
<br>
<table style="width:98%">
	<tr>
		<td align="center" style="border-color:#D9B565; border-width:1px;border-style:solid;padding:2px;height:80px;width:99%">
			<table id = "table01" width="100%" border="0">
				<tr>
					<td height="40px">
						<font size="3" face="Sylfaen">
							Typauswahl:
						</font>
					</td>
					<td>
						<select size="1" name="selectMenues" class="kb" style="width:186px;" onChange="changeMenue(BodyForm,this.value)">
							<%
							String selected = "";
							if (manager.getSuchMenueId().intValue() == 0) selected = "selected";
							%>
							<option <%=selected%> value=0> </option> 
							<%
							for (int index=0;index<asm.getSize();index++) {
								selected = "";
								Integer id = (Integer) asm.getKeys(KochbuchBean.AsmMenue.KEY_ID).get(index);
								String bez = (String) asm.getKeys(KochbuchBean.AsmMenue.KEY_BEZ).get(index);
								if (manager.getSuchMenueId().equals(id)) selected = "selected";
								%>
								<option <%=selected%> value=<%=id%>><%=bez%></option> 
								<%
							}
							%>
						</select>
					</td>

					<td >
						<font size="3" face="Sylfaen">
							Rezept:
						</font>
					</td>
					<td >
						<input type="text" name="rezeptname" value="<%=manager.getSuchName().replaceAll("%","")%>" style="width:180px;" class="kbedit" >
					</td >
					<td>
						<font size="3" face="Sylfaen">
							Zutat:
						</font>
					</td>
					<td>
						<input type="text" name="zutat" value="<%=manager.getSuchZutat().replaceAll("%","")%>" style="width:180px;" class="kbedit" >
					</td>
				</tr>
	
				<tr>
					<td height="32px">
						<font size="3" face="Sylfaen">
							Beschreibung:
						</font>
					</td>
					<td>
						<input type="text" name="beschreibung" value="<%=manager.getSuchBeschreibung().replaceAll("%","")%>" style="width:180px;" class="kbedit" >
					</td>
					<td >
						<font size="3" face="Sylfaen">
							Kommentar:	
						</font>
					</td>
					<td >
						<input type="text" name="kommentar" value="<%=manager.getSuchKommentar().replaceAll("%","")%>" style="width:180px;" class="kbedit">
					</td >
					<td>&nbsp;</td>
					<td>
						<input type="button" class="kbbutton" style="width:180px;" id="searchButton" name="searchButton" value="Suche&nbsp;starten" onClick="javascript:suche(BodyForm)" >
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" style="position:relative;left:2px;">
				<tr>
					<th width="30px" height="30px" style="text-align:left;" >&nbsp;</th>
					<% if (client.isAngemeldet()) { %>
						<th width="30px" style="text-align:left;" >&nbsp;</th>
						<th width="30px" style="text-align:left;" >&nbsp;</th>
					<% } %>
					<th style="text-align:left;width:120px;">Typ</th>
					<th style="text-align:left;">Name</th>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td id ="td01" style="align:left;text-align:center;overflow:auto;border-color:#D9B565; border-width:1px;border-style:solid;width:99%;">
		</td>
	</tr>
	<tr>
		<td>
			<div id="divDetail01" align="left" style="width:96%;overflow:auto;position:absolute;top:168px;">
				<table id="table01">
					<tr>
						<td style="align:left;width:100%;">		
							<table width="100%">
								<%
								for (int index=0;index<suchAsm.getSize();index++) {
									String m_bez = (String) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_MEN_BEZ).get(index);
									String r_bez = (String) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_REZ_BEZ).get(index);
									Integer m_id = (Integer) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_MEN_ID).get(index);
									Integer r_id = (Integer) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_REZ_ID).get(index);
									%>																		
									<tr>
										<td align="center" height="30px" width="30px">
											<a href="javascript:auswahl_zeile(BodyForm,<%=m_id%>,<%=r_id%>)">
												<img src="<%=client.getUriImageGlobal("text.gif")%>" border="0" alt="Rezept ansehen">
											</a>
										</td>
										<% if (client.isAngemeldet()) { %>
											<td align="center" width="30px">
												<a href="javascript:edit_zeile(BodyForm,<%=m_id%>,<%=r_id%>)">
													<img src="<%=client.getUriImageGlobal("quill.gif")%>" border="0" alt="Rezept bearbeiten" >
												</a>
											</td>
											<td align="center" width="30px">
												<a href="javascript:delete_zeile(BodyForm,<%=m_id%>,<%=r_id%>)">
													<img src="<%=client.getUriImageGlobal("trashcan.gif")%>" border="0" alt="Rezept l&ouml;schen" >
												</a>
											</td>
										<% } %>
										<td align="left" width="120px"><font><%=m_bez%></font></td>
										<td align="left"><font><%=r_bez%></font></td>
									</tr>
									<%
								}
								%>
								<tr>
									<td width="30px">&nbsp;</td>
									<% if (client.isAngemeldet()) { %>
										<td width="30px">&nbsp;</td>
										<td width="30px">&nbsp;</td>
									<% } %>
									<td width="120px">&nbsp;</td>
									<%
									int sizeR = suchAsm.getSize();
									String msg = " Rezepte gefunden.";
									if (sizeR == 1) {
										msg = " Rezept gefunden.";
									}
									%>
									<td align="left" height="30px">
										<font>
											<b><%=sizeR%><%=msg%></b>
										</font>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</td>
	</tr>
	<tr>
		<td id = "td02" style="border-color:#D9B565; border-width:1px;border-style:solid;height:38px;width:96%;">
			<table width="100%" border="0">
				<tr>
					<% if (!client.isAngemeldet()) { %>
						<td height="32px" width="70px" align="left">
							<font size="3" face="Sylfaen">
								Benutzer: 
							</font>
						</td>
						<td align="left" width="120px">
							<input type="text" name="user" value="" style="width:100px;" class="kbedit" >
						</td>
						<td width="70px" align="left">
							<font size="3" face="Sylfaen">
								Pa&szlig;wort: 
							</font>
						</td>
						<td align="left" width="120px">
							<input type="password" name="pw" value="" style="width:100px;" class="kbedit" >
						</td>
						<td align="left">
							<input type="button" class="kbbutton2" style="width:120px;" id="loginButton" name="loginButton" value="Anmelden" onClick="javascript:loginUser(BodyForm)" >
						</td>
					<% } else { %>
						<td height="32px" align="left" style="width:120px;">
							<input type="button" class="kbbutton2" style="width:120px;" name="logoutButton" value="Abmelden" onClick="javascript:logoutUser(BodyForm)" >
						</td>
						<td align="left" style="width:120px;">
							<input type="button" class="kbbutton2" style="width:120px;" id="newButton" name="newButton" value="Neues Rezept" onClick="javascript:neuesRezept(BodyForm)" >
						</td>
						<td style="text-align:right">
							Angemeldet ist:
						</td>
						<td align="left" style="width:90px;">
							<input type="text" readonly="readonly" name="aktuser" value="<%=client.getUserName()%>" style="width:80px;" class="kbedit" >
						</td>
						<td>
						</td>
					<%
					}
					%>
				</tr>
			</table>
		</td>
	</tr>
	
</table>
<%
}
%>

<%@ include file="footer.jsp"%>

