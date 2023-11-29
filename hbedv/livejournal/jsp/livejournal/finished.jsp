<html>
<%@ include file="head.include"%>

<BODY>

<p>&nbsp;</p>
<p align="center">
	<font class="finished">	
		Thanks again for your participation! 
	</font>
</p>
<p align="center">
	<font class="finished">
		The results of this study will be published at 
	</font>
</p>
<p align="center">
	<font class="finished">
		<a href="http://mb-0220309.livejournal.com/">
			http://mb-0220309.livejournal.com/
		</a>&nbsp;in January 2008. 
	</font>
</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p align="center">
<br>
<a href="#" onClick="javascript:window.close();" style="font-size:12pt;">
	<img src="<%=client.getUriImageGlobal("close.jpg")%>" style="border:0;" alt="Close">
</a>
</p>

<%
if (request.getSession() != null) request.getSession().invalidate();
%>


</body>
</html>