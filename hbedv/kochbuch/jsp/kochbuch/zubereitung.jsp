<script language="JavaScript" type="text/JavaScript">


function includeScriptZubereitung(outerWidth,outerHeight,innerWidth,innerHeight) {

	var zubTable01 = document.getElementById('zubTable01');
	zubTable01.style.position = "absolute";
	zubTable01.style.top = '72px';
	
	var e = (innerWidth/2) - 30;
	zubTable01.style.width =  e + 'px';
	
	
	var divZut01 = document.getElementById('divZut01');
	if (divZut01 != null) {
		var rect = divZut01.getBoundingClientRect();
		e = rect.height + 214;
		var zubText01 = document.getElementById('zubText01');
		zubText01.style.height = e + 'px';
	}
}	


</script>


	<table id = "zubTable01" width="100%">
		<tr>
			<td width="50%">
				<font size="5" face="Sylfaen">
					<strong>
						Zubereitung
					</strong>
				</font>
			</td>
			<td width="50%" align="right">
				<input class="kbbutton2" type="button" value="Fett" accesskey="f" style="width:60px;" 
					onClick="insertCode('<b>', '</b>','BodyForm','zubereitung')">

				<input class="kbbutton2" type="button" value="Kursiv" accesskey="k" style="width:60px;" 
					onClick="insertCode('<em>', '</em>','BodyForm','zubereitung')">
			</td>
		</tr>
		<tr valign="top" align="center">
			<td colspan="2" width="100%">		
				<textarea id="zubText01" name ="zubereitung" cols="58" rows="20" class="kb" wrap="hard" style="width:98%"><%=manager.getZubereitung()%></textarea>
			</td>
		</tr>
	</table>
	

