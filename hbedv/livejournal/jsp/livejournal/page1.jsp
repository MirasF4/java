
<%@ include file="head.include"%>
<%@ include file="body_form.include"%>

<%@ include file="error_start.include"%>

<script language="JavaScript" type="text/JavaScript">

function onCklick6(cb) {
	if (cb.checked == true) {
		document.getElementById("C62").checked = false;
		document.getElementById("C63").checked = false;
		document.getElementById("C64").checked = false;
		document.getElementById("C65").checked = false;
		document.getElementById("C66").checked = false;
		document.getElementById("C67").checked = false;
		document.getElementById("C68").checked = false; 

		document.getElementById("C62").disabled = true;
		document.getElementById("C63").disabled = true;
		document.getElementById("C64").disabled = true;
		document.getElementById("C65").disabled = true;
		document.getElementById("C66").disabled = true;
		document.getElementById("C67").disabled = true;
		document.getElementById("C68").disabled = true; 
	}
	else {
		document.getElementById("C62").disabled = false;
		document.getElementById("C63").disabled = false;
		document.getElementById("C64").disabled = false;
		document.getElementById("C65").disabled = false;
		document.getElementById("C66").disabled = false;
		document.getElementById("C67").disabled = false;
		document.getElementById("C68").disabled = false; 	
	}
}

function onCklick8(cb) {
	if (cb.checked == true) {
		document.getElementById("C82").checked = false;
		document.getElementById("C83").checked = false;
		document.getElementById("C84").checked = false;
		document.getElementById("C85").checked = false;
		document.getElementById("C86").checked = false;
		document.getElementById("C87").checked = false;

		document.getElementById("C82").disabled = true;
		document.getElementById("C83").disabled = true;
		document.getElementById("C84").disabled = true;
		document.getElementById("C85").disabled = true;
		document.getElementById("C86").disabled = true;
		document.getElementById("C87").disabled = true;
	}
	else {
		document.getElementById("C82").disabled = false;
		document.getElementById("C83").disabled = false;
		document.getElementById("C84").disabled = false;
		document.getElementById("C85").disabled = false;
		document.getElementById("C86").disabled = false;
		document.getElementById("C87").disabled = false;
	}
}

</script>


<div  class="workflow">
	<div style="background-color: #CCCCCC">
		<p><b>&nbsp;I. LIVEJOURNAL</b></p>		
	</div>
	<p>&nbsp;</p>
	<%
	String javaSriptFuction6 = "onclick=\"javascript:onCklick6(this);\"";
	String javaSriptFuction8 = "onclick=\"javascript:onCklick8(this);\"";
	//Hauptfragen
	for (int question=1;question<10;question++) {
		String questionTyp = manager.getQuestionTyp(question);
		String inputTyp = "";
		if (questionTyp.equals("R")) {
			inputTyp = "radio";
		}
		else if (questionTyp.equals("C")) {
			inputTyp = "checkbox";
		}
		ArrayList<String> possibilities = manager.getPossibilitisList(question);
		int sizeP = possibilities.size();
		%>
		<p class="title_line">
			<font class="title_number">				
				<%=question%>. <%=manager.getQuestionName(question)%>
			</font>
		</p>
		<%
		//Detailfragen
		for (int indP=1;indP<=sizeP;indP++) {
			String possibName = possibilities.get(indP-1);
			String funcStr = "";
			if (question==6 && indP == 1) { 
				funcStr = javaSriptFuction6;
			}
			if (question==8 && indP == 1) { 
				funcStr = javaSriptFuction8;
			}
			%>
			<p>
				<input type="<%=inputTyp%>" id="<%=questionTyp%><%=question%><%=indP%>" name="<%=questionTyp%><%=question%>" <%=funcStr%> <%=manager.getAsmChecked(question,indP)%> value="<%=indP%>" >
				<font class="detail_question"><%=possibName%></font>
				<%
				if ((question==6 && indP == 1) || (question==8 && indP == 1)) { %>
					<br><br>	
				<%	
				} %>
			</p>
			<% 
			//Sondertext bei Frage 8
			if (question==8 && indP == 1) { %>
				<p>
					<font class="detail_question">
						<i>Yes, we communicate over (check all that apply)</i>
					</font>
				</p>
			<%	
			} %>
		<%
		} //Ende Detailfragen 
		%>
		<p>&nbsp;</p>
	<%
	} //Ende Hauptfragen 
	%>
	
</div>

<%@ include file="error_end.include" %>

<!--
<%@ include file="button.include" %>
-->
<%@ include file="end.include" %>


