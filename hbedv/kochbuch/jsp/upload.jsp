<%--
  Comment to this file see:
 
  Uses Jason Pell's MultipartRequest to upload a file:
 
  Uses Marco Schmidt's ImageInfo to get image file information:
 -%>

<%@ page import = "com.hbedv.upload.*" %>
<%@ page import = "com.hbedv.kochbuch.*" %>
<%@ page import = "com.hbedv.frame.*" %>





<%
	ClientKochbuch client = (ClientKochbuch) session.getAttribute(session.getId());
	if (client == null) { 
		throw new NullPointerException("ClientKochbuch==null");
	}
	KbUpload upload = new KbUpload();
%>

<link rel="stylesheet" href="<%=client.getUriCssGlobal("kochbuch.css")%>" type="text/css">

<html>
<head>

	<script>
		function refreshPic(f,pic) {
			f.meinRezept.src=pic;
			f.cmd.value="<%=TheApp.CMD_SEARCH%>";
			f.subcmd.value="<%=Kochbuch.SUB_CMD_EDIT%>";
			f.submit();
		}
	</script>

	
	<title>Bilddatei-Upload</title>
</head>
<body>


<h2>Upload Rezeptbild (max. 1 MB)</h2>

<form action="upload.jsp" name="upl" enctype="multipart/form-data" method="POST">
<table>
  <tr>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Bilddatei (JPG):</td>
    <td><input type="file" name="myFile" size=40 maxlength=255 class="kbbutton2">
        <input type="submit" value="Upload" class="kbbutton2">
        <input type="button" onClick="javascript:window.close()" value="Schlie&szlig;en" class="kbbutton2">
    </td>    
  </tr>
</table>
<br>
</form>

<%=upload.readAndShowImage( request,getServletConfig(),getServletContext(),client) %>

</body>
</html>


