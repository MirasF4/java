<%@ page import="com.hbedv.frame.*" %>

<%--
  - subjsp, d.h. kann nicht alleine stehen, wir von einer mainjsp eingezogen.
  - kuemmert sich um den Infoonlyview.

--%>

<%
  Client client = (Client)request.getAttribute("com.hbedv.client");
  if(client == null)
    throw new NullPointerException("client == null");

  Informant inf = client.getInformant();
  Informant detInf = inf.getDetail();

%>

<%-- fehlermeldung anzeigen --%>
<%
if (inf.hasUIInformation()) {
  if (inf.isPopup()) {
  %>
  <SCRIPT>
  var oPopup = window.createPopup();
  function ShowPop()
  {
   var oPopBody = oPopup.document.body;

    var y = "<a onClick='javascript:window.print()';>Bestaetigung</a>"

    var y = "<a href='window.print()' class='stdButton' style='width:155px'>Drucken</a>"

    oPopBody.innerHTML = "<div  style='position:absolute; top:0; left:0; " +
    "width:550px; height:100px; padding:10px; color:white; font-family:tahoma; " +
     "font-size:13pt;filter:progid:DXImageTransform.Microsoft.Gradient()'> " +
     "<b><%=inf.getAndRespectConfirmInformation()%></b><BR><BR><FORM><CENTER>"+
     y+"</CENTER></FORM></div>"

    oPopup.show(400, 400, 550, 100, document.body);  }
  ShowPop()
  </SCRIPT>

  <%
  }
  else {
    if (detInf == null) {
      %>
      <script>
      alert('<%=client.getInformant().getAndRespectConfirmInformation()%>');
      </script>
      <%
    }
    else {
      String toAnz = client.getInformant().getAndRespectConfirmInformation()+
      Util.CRLF_in_ALERT+Util.CRLF_in_ALERT + detInf.getAndRespectConfirmInformation();
      %>
      <script>
        alert('<%=toAnz%>');
      </script>
      <%
    }
  }
}
%>
