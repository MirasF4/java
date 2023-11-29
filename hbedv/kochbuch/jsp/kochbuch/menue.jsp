<%@ include file="import.jsp" %>

<%
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	if(client == null) throw new Exception("client == null");
	String idMenueNotValid = "&amp;" + TheApp.ID_MENUE + "=" + TheApp.ID_MENUE_NOT_VALID;	
	synchronized (client) {
		KochbuchMenueManager manager = client.getKochbuchMenueManager();
		AliceSortMap asmMenue = manager.getAsmMenue();
		String root = client.getAppRootUrl();
		
		String progStr = "Programm:";
		if (client.getBsHeight().intValue() < 864) {
			progStr = "Progr.:";
		}
%>

<%@ include file="header.jsp"%>

<script type="text/javascript" language="javascript">
		
function ResizeWindow(outerWidth,outerHeight) {
	
	var familypos = document.getElementById('familypos');
	if (familypos != null) {
		var posTop = window.innerHeight - 92;
		familypos.style.position = "absolute";
		if (typeof(startPosFam) == "undefined") {
			var browser = getBrowserName();
			if (browser == isFireFox) {
				startPosFam = 428;
			}
			else if (browser == isSafari) {
				startPosFam = 390;
			}
			else {
				startPosFam = 390;
			}
			familypos.style.top = startPosFam + 'px';
		}
		//var rect = familypos.getBoundingClientRect();
		if (posTop > startPosFam) {
			familypos.style.top = posTop+'px';
		}
	}
}
	
	
</script>

<%
String homePic = "mbutton_home.gif";
String searchPic = "mbutton_suche.gif";
String endPic = "mbutton_ende.gif";
int picWidth = 0;
int picHeight = 0;
if (!client.isMobileVersion()) {
	%>	
	<br>
	<%
	picWidth = 144;
	picHeight = 36;
}
else {
	picWidth = 110;
	picHeight = 30;
}
%>
<table width="100%%" border="0" id="menuetable">
	<tr>
		<td width="100%" align="center">
			<a href="<%=TheApp.encodeURL(root + "/kochbuch?cmd="+TheApp.CMD_BODY + idMenueNotValid,response)%>" target="<%=TheApp.CMD_BODY%>">
				<img src="<%=client.getUriImageGlobal(homePic)%>" border="0" alt="Startseite" width="<%=picWidth%>" height="<%=picHeight%>">
			</a>
		</td>
	</tr>

	<tr>
		<td width="100%" align="center">
			<a href="<%=TheApp.encodeURL(root + "/kochbuch?cmd="+TheApp.CMD_SEARCH + idMenueNotValid,response)%>" target="<%=TheApp.CMD_BODY%>">
				<img src="<%=client.getUriImageGlobal(searchPic)%>" border="0" alt="Suche" width="<%=picWidth%>" height="<%=picHeight%>">
			</a>
		</td>
	</tr>

	<%
	for (int index=0;index<asmMenue.getSize();index++) {
		String command = (String) asmMenue.getKeys(KochbuchBean.AsmMenue.KEY_COMMAND).get(index);
		String pic = (String) asmMenue.getKeys(KochbuchBean.AsmMenue.KEY_PIC).get(index);
		String bez = (String) asmMenue.getKeys(KochbuchBean.AsmMenue.KEY_BEZ).get(index);
		%>
	
		<tr>
			<td width="100%" align="center">
				<a href="<%=TheApp.encodeURL(root + "/kochbuch?cmd=" + command + idMenueNotValid,response)%>" target="<%=TheApp.CMD_BODY%>">
					<img src="<%=client.getUriImageGlobal(pic)%>" border="0" alt="<%=bez%>" width="<%=picWidth%>" height="<%=picHeight%>">
				</a>
			</td>
		</tr>
		<% 
	}
	%>
	
	<tr>
		<td width="100%" align="center">
			<a href="<%=TheApp.encodeURL(root + "/kochbuch?cmd="+TheApp.CMD_LOGOUT + idMenueNotValid,response)%>" target="<%=TheApp.CMD_BODY%>">
				<img src="<%=client.getUriImageGlobal(endPic)%>" border="0" alt="Programmende" width="<%=picWidth%>" height="<%=picHeight%>">
			</a>
		</td>
	</tr>

</table>

<%
if (!client.isMobileVersion()) {
%>
<table width="100%" id = "familypos">
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
						Design: Michaela Primmer
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
<%
}
%>

<script type="text/javascript" language="javascript">

ResizeApp();

//falls das eine Javascript Fehler verursacht... ist auch wurscht. Nachher kommt ja nix mehr.
//parent.frames.body.location.ok = true;

</script>

<%@ include file="footer.jsp"%>

<%
}
%>

