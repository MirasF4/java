
<%@ include file="head.include"%>
<%@ include file="body_form.include"%>

<%
AliceSortMap asm = manager.getAsmLaenderCode();
int size = asm.getSize();
%>

<%@ include file="error_start.include"%>

<div  class="workflow">
	<div style="background-color: #CCCCCC">
		<p><b>&nbsp;III. DEMOGRAPHIC DATA</b></p>
	</div>
	<p>&nbsp;</p>
	<p class="title_line">
		<font class="title_number">24. Sex</font>
	</p>	
	
	<p><input type="radio" id="R241" name="R24" <%=manager.getAsmChecked(24,1)%> value="1">Male</p>
	<p><input type="radio" id="R242" name="R24" <%=manager.getAsmChecked(24,2)%> value="2">Female</p>
	<p>&nbsp;</p>
	
	<p class="title_line">
		<font class="title_number">25. Age</font>
	</p>	
	<p>
		<select size="1" id="S251" name="S25" style="with:30px">
			<option> </option>
			<%
			Integer key = manager.getOptionKeyAge(25);
			for (int i=10;i<99;i++) {
				String selected = "";
				if (i == key.intValue()) {
					selected = "selected";
				}
				%>
				<option <%=selected%> value="<%=i%>"><%=i%></option>
			<% 
			} %>
		</select>
	</p>
	
	<p>&nbsp;</p>
	<p class="title_line">
		<font class="title_number">26. Nationality</font>
	</p>	
	<%
	String keyStr = manager.getOptionKeyCountry(26);
	if (keyStr.equals("")) {
		keyStr = request.getLocale().getLanguage().toUpperCase();
	}
	%>
	<p>
		<select size="1" id="S261" name="S26">
			<option> </option>
			<%
			for (int i=0;i<size;i++) {
				String code = (String) asm.getKeys(LiveJournalBean.AsmLaenderCode.KEY_CODE).get(i);
				String bez = (String) asm.getKeys(LiveJournalBean.AsmLaenderCode.KEY_BEZ).get(i);
				String selected = "";
				if (code.equals(keyStr)) {
					selected = "selected";
				}
				%>
				<option <%=selected%> value="<%=code%>"><%=bez%></option>
			<%
			}
			%>
		</select>
	</p>
	<p>&nbsp;</p>

</div>

<%@ include file="error_end.include" %>

<!--
<%@ include file="button.include" %>
-->

<%@ include file="end.include" %>
