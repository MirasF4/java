
<%@ include file="head.include"%>
<%@ include file="body_form.include"%>

<%@ include file="error_start.include"%>

<div  class="workflow">
	<div style="background-color: #CCCCCC">
		<p><b>&nbsp;II. LIVE JOURNAL FRIENDS</b></p>
	</div>
	<p>&nbsp;</p>
	<%
	
	
	for (int index=10;index<24;index++) { 
		String questionTyp = manager.getQuestionTyp(index);
		String inputTyp = "";
		if (questionTyp.equals("R")) {
			inputTyp = "radio";
		}
		else if (questionTyp.equals("C")) {
			inputTyp = "checkbox";
		}
		ArrayList<String> possibilities = manager.getPossibilitisList(index);
		int sizeP = possibilities.size();
		String txt = index + ". " + manager.getQuestionName(index);
		%>
		<p class="title_line">
			<font class="title_number">
				<%=txt%>
			</font>
		</p>
		<p>
			<%
			for (int indP=1;indP<=sizeP;indP++) {
				String possibName = possibilities.get(indP-1);
				%>
					<input type="<%=inputTyp%>" id="<%=questionTyp%><%=index%><%=indP%>" name="<%=questionTyp%><%=index%>" <%=manager.getAsmChecked(index,indP)%> value="<%=indP%>" >
					<font class="detail_question"><%=possibName%>&nbsp;&nbsp;&nbsp;</font>
				<% 
			} //Ende Detailfragen 
			%>
		</p>
		<p>&nbsp;</p>
	<% 
	} %>
</div>

<%@ include file="error_end.include" %>

<!--
<%@ include file="button.include" %>
-->
<%@ include file="end.include" %>

