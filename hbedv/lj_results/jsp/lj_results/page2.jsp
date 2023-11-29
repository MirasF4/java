
<%@ include file="head.include"%>
<%@ include file="body_form.include"%>

<%@ include file="error_start.include"%>

<div  class="workflow">
	<div style="background-color: #CCCCCC">
		<p><b>&nbsp;II. LIVE JOURNAL FRIENDS</b></p>
	</div>
	<p>&nbsp;</p>
	<%
	//Hauptfragen
	for (int question=10;question<24;question++) {
		manager.generateFile(question);
		%>
		<p align="center">
			<img src="<%=TheApp.encodeURL(manager.getPicFile(question,false),response)%>" border="0" alt="<%=question + ". " + manager.getQuestionName(question)%>">
		</p>
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

