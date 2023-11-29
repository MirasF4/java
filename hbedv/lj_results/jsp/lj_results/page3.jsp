
<%@ include file="head.include"%>
<%@ include file="body_form.include"%>

<%@ include file="error_start.include"%>

<div  class="workflow">
	<div style="background-color: #CCCCCC">
		<p><b>&nbsp;III. DEMOGRAPHIC DATA</b></p>
	</div>
	<p>&nbsp;</p>
	<%
	manager.generateFile(24);
	manager.generateFile(25,"AGE");
	manager.generateFile(26,"COUNTRY");
	%>
	<p align="center">
		<img src="<%=TheApp.encodeURL(manager.getPicFile(24,false),response)%>" border="0" alt="<%="24. " + manager.getQuestionName(24)%>" >
	</p>
	<p>&nbsp;</p>
	<p align="center">
		<img src="<%=TheApp.encodeURL(manager.getPicFile(25,false),response)%>" border="0" alt="<%="25. " + manager.getQuestionName(25)%>" >
	</p>
	<p>&nbsp;</p>
	<p align="center">
		<img src="<%=TheApp.encodeURL(manager.getPicFile(26,false),response)%>" border="0" alt="<%="26. " + manager.getQuestionName(26)%>" >
	</p>
</div>


<%@ include file="error_end.include" %>

<!--
<%@ include file="button.include" %>
-->

<%@ include file="end.include" %>
