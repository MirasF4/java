
<script type="text/javascript" language="javascript">

function includeScriptKommentar(outerWidth,outerHeight,innerWidth,innerHeight) {
	
	var kommentarId = document.getElementById('kommentarId');
	var e = (innerWidth/2)-276;
	//alert(e); //730
	if (e > 136) kommentarId.style.width = e + "px";
	
	//kommentarId.style.position = "relative";
	//kommentarId.style.left = "-6px";
}

</script>
<table>
	<tr>
		<td>
			<table>
				<tr>
					<td>
						<font size="5" face="Sylfaen">
							<strong>
								Kommentar
							</strong>
						</font>
					</td>
				</tr>
				<tr valign="top">
					<td height="100%" align="center">
						<textarea id="kommentarId" name="kommentar" rows="8" class="kb" wrap="hard"><%=manager.getKommentar()%></textarea>
					</td>
				</tr>
			</table>	
		</td>
		<td>
			<img name="meinRezept" src="<%=manager.getPicName()%>" width="200px" height="180px" ALT=""  style="position:relative;top:10px;">
		</td>
	</tr>
</table>
