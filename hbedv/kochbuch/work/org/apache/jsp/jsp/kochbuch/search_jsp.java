package org.apache.jsp.jsp.kochbuch;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hbedv.kochbuch.*;
import com.hbedv.frame.*;
import com.hbedv.db.kochbuch.KochbuchBean;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/jsp/kochbuch/import.jsp");
    _jspx_dependants.add("/jsp/kochbuch/header.jsp");
    _jspx_dependants.add("/jsp/kochbuch/footer.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = JspFactory.getDefaultFactory().getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"../errorpage.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	KochbuchSearchManager manager = client.getKochbuchSearchManager();
	AliceSortMap asm = manager.readMenueList();
	AliceSortMap suchAsm = manager.getAsmSuchListe();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
 
if (client.isMobileVersion()) {
	
      out.write("\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(client.getUriCssGlobal("kochbuch_mobil.css"));
      out.write("\" type=\"text/css\">\r\n");
      out.write("\t");

}
else {
	
      out.write("\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(client.getUriCssGlobal("kochbuch.css"));
      out.write("\" type=\"text/css\">\r\n");
      out.write("\t");

}

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n");
      out.write("<title>Kochbuch</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("isIE=\"IE\"; \r\n");
      out.write("isFireFox=\"FireFox\";\r\n");
      out.write("isEdge=\"Edge\";\r\n");
      out.write("isOpera=\"Opera\";\r\n");
      out.write("isChrome=\"Chrome\";\r\n");
      out.write("isSafari=\"Safari\";\r\n");
      out.write("isUnknown=\"Unknown\";\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function checkBrowserName(name)\r\n");
      out.write("{\r\n");
      out.write("\tvar agent = navigator.userAgent.toLowerCase();\r\n");
      out.write("\tif (agent.indexOf(name.toLowerCase())>-1) {\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn false;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function getBrowserName() {\r\n");
      out.write("\tvar ret=isUnknown;\r\n");
      out.write("\r\n");
      out.write("\tif(checkBrowserName('edge'))\r\n");
      out.write("\t{\r\n");
      out.write("\t\tret=isEdge;\r\n");
      out.write("\t} \r\n");
      out.write("\telse if(checkBrowserName('like gecko') || checkBrowserName('msi')) {\r\n");
      out.write("\t\tret = isIE;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(checkBrowserName('opera')) {\r\n");
      out.write("\t\tret = isOpera;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(checkBrowserName('chrome'))\r\n");
      out.write("\t{\r\n");
      out.write("\t\tret=isChrome;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(checkBrowserName('safari'))\r\n");
      out.write("\t{\r\n");
      out.write("\t\tret=isSafari;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(checkBrowserName('firefox'))\r\n");
      out.write("\t{\r\n");
      out.write("\t\tret=isFireFox;\r\n");
      out.write("\t} \r\n");
      out.write("\treturn ret;\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("function ResizeApp() {\r\n");
      out.write("\r\n");
      out.write("\tvar outerWidth = window.outerWidth;  \r\n");
      out.write("\tvar outerHeight = window.outerHeight;\r\n");
      out.write("\r\n");
      out.write("\tbsWidth = document.getElementById('bs_width');\r\n");
      out.write("\tif (bsWidth != null) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tbsWidth.value = outerWidth;\r\n");
      out.write("\r\n");
      out.write("\t\tbsHeight = document.getElementById('bs_height');\r\n");
      out.write("\t\tif (bsHeight != null) {\r\n");
      out.write("\t\t\tbsHeight.value = outerHeight; \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tobjTxt1 = document.getElementById('text_width');\r\n");
      out.write("\t\tif (objTxt1 != null) {\r\n");
      out.write("\t\t\tobjTxt1.value = document.getElementById('bs_width').value;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tobjTxt2 = document.getElementById('text_height');\r\n");
      out.write("\t\tif (objTxt2 != null) {\r\n");
      out.write("\t\t\tobjTxt2.value = document.getElementById('bs_height').value;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tif (typeof ResizeWindow === \"function\") {\r\n");
      out.write("\t\tResizeWindow(outerWidth,outerHeight);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("window.addEventListener('resize', ResizeApp);\r\n");
      out.write("</script\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<BODY BGCOLOR=#ECE3BE LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>\r\n");
      out.write("\r\n");
      out.write("<form name=\"BodyForm\" method=\"post\" action=\"");
      out.print(TheApp.encodeURL(client.getUriForm(), response));
      out.write("\" target=\"body\">\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" id=\"bs_width\" name=\"bs_width\" value=\"0\">\r\n");
      out.write("<input type=\"hidden\" id=\"bs_height\" name=\"bs_height\" value=\"0\">\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" id=\"text_width\" name=\"text_width\" >\r\n");
      out.write("<input type=\"hidden\" id=\"text_height\" name=\"text_height\">\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" name=\"cmd\" value=\"\">\r\n");
      out.write("<input type=\"hidden\" name=\"subcmd\" value=\"\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"JavaScript\" type=\"text/JavaScript\">\r\n");
      out.write("\r\n");
      out.write("//setDefaultButton(\"searchButton\");\r\n");
      out.write("\r\n");
      out.write("function changeMenue(f,wert) {\r\n");
      out.write("\tf.men_id.value = wert;\r\n");
      out.write("\tf.searchButton.focus();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function suche(f) {\r\n");
      out.write("\tf.cmd.value = \"");
      out.print(TheApp.CMD_SEARCH);
      out.write("\";\r\n");
      out.write("\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_SUCHEN);
      out.write("\";\r\n");
      out.write("\tf.submit(\"\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function auswahl_zeile(f,mId,rId) {\r\n");
      out.write("\tf.m_id.value = mId;\r\n");
      out.write("\tf.r_id.value = rId;\r\n");
      out.write("\tf.cmd.value = \"");
      out.print(TheApp.CMD_SEARCH);
      out.write("\";\r\n");
      out.write("\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_AUSWAHL);
      out.write("\";\r\n");
      out.write("\tf.submit(\"\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function edit_zeile(f,mId,rId) {\r\n");
      out.write("\tf.m_id.value = mId;\r\n");
      out.write("\tf.r_id.value = rId;\r\n");
      out.write("\tf.cmd.value = \"");
      out.print(TheApp.CMD_SEARCH);
      out.write("\";\r\n");
      out.write("\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_EDIT);
      out.write("\";\r\n");
      out.write("\tf.submit(\"\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function delete_zeile(f,mId,rId) {\r\n");
      out.write("\tif (window.confirm(\"");
      out.print(manager.getDeleteQuestion());
      out.write("\")) {\r\n");
      out.write("\t\tf.m_id.value = mId;\r\n");
      out.write("\t\tf.r_id.value = rId;\r\n");
      out.write("\t\tf.cmd.value = \"");
      out.print(TheApp.CMD_SEARCH);
      out.write("\";\r\n");
      out.write("\t\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_DELETE);
      out.write("\";\r\n");
      out.write("\t\tf.submit(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function neuesRezept(f) {\r\n");
      out.write("\tf.m_id.value = 0;\r\n");
      out.write("\tf.r_id.value = 0;\r\n");
      out.write("\tf.cmd.value = \"");
      out.print(TheApp.CMD_SEARCH);
      out.write("\";\r\n");
      out.write("\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_INSERT);
      out.write("\";\r\n");
      out.write("\tf.submit(\"\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("onload = function() {\r\n");
      out.write("\t");

	if (client.isLogonError()) { 
		client.setLogonError(false);
		
      out.write("\r\n");
      out.write("\t\talert(\"");
      out.print(manager.getLogonErrMsg());
      out.write("\");\t\r\n");
      out.write("\t\tBodyForm.user.focus();\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function loginUser(f) {\r\n");
      out.write("\tf.cmd.value = \"");
      out.print(TheApp.CMD_SEARCH);
      out.write("\";\r\n");
      out.write("\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_LOGINUSER);
      out.write("\";\r\n");
      out.write("\tf.submit(\"\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function logoutUser(f) {\r\n");
      out.write("\tf.cmd.value = \"");
      out.print(TheApp.CMD_SEARCH);
      out.write("\";\r\n");
      out.write("\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_LOGOUTUSER);
      out.write("\";\r\n");
      out.write("\tf.submit(\"\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function ResizeWindow(outerWidth,outerHeight) {\r\n");
      out.write("\tvar innerWidth = window.innerWidth;  \r\n");
      out.write("\tvar innerHeight = window.innerHeight;\r\n");
      out.write("\t\r\n");
      out.write("\t");

	if (client.isMobileVersion()) {
		
      out.write("\r\n");
      out.write("\t\tvar td01 = document.getElementById('td01');\r\n");
      out.write("\t\ttd01.style.position = \"absolute\";\r\n");
      out.write("\t\ttd01.style.top = '124px';\r\n");
      out.write("\t\ttd01.style.left = '9px';\r\n");
      out.write("\t\ttd01.style.width = '94.5%';\r\n");
      out.write("\t\tvar e = innerHeight - 145;\r\n");
      out.write("\t\ttd01.style.height = e + 'px';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar divDetail01 = document.getElementById('divDetail01');\r\n");
      out.write("\t\tvar e = innerHeight - 150;\r\n");
      out.write("\t\tdivDetail01.style.height = e+'px';\r\n");
      out.write("\t");

	}
	else {
		
      out.write("\r\n");
      out.write("\t\tvar td01 = document.getElementById('td01');\r\n");
      out.write("\t\ttd01.style.position = \"absolute\";\r\n");
      out.write("\t\ttd01.style.top = '160px';\r\n");
      out.write("\t\ttd01.style.left = '9px';\r\n");
      out.write("\t\ttd01.style.width = '96%';\r\n");
      out.write("\t\tvar e = innerHeight - 240;\r\n");
      out.write("\t\ttd01.style.height = e + 'px';\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar divDetail01 = document.getElementById('divDetail01');\r\n");
      out.write("\t\tvar e = innerHeight - 260;\r\n");
      out.write("\t\tdivDetail01.style.height = e+'px';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar td02 = document.getElementById('td02');\r\n");
      out.write("\t\tvar e = innerHeight - 60;\r\n");
      out.write("\t\ttd02.style.position = \"absolute\";\r\n");
      out.write("\t\ttd02.style.top =  e + 'px';\r\n");
      out.write("\t\ttd02.style.left = '8px';\r\n");
      out.write("\t\t");

	}
	
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<input type=\"hidden\" name=\"men_id\" value=\"");
      out.print(manager.getSuchMenueId());
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"m_id\" value=\"0\">\r\n");
      out.write("<input type=\"hidden\" name=\"r_id\" value=\"0\">\r\n");

if (client.isMobileVersion()) {
	
      out.write("\r\n");
      out.write("<table style=\"width:98%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\" style=\"border-color:#D9B565; border-width:1px;border-style:solid;padding:2px;height:80px;width:99%\">\r\n");
      out.write("\t\t<table id = \"table01\" width=\"100%\" border=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td height=\"20px\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"2\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\tTypauswahl:\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select size=\"1\" name=\"selectMenues\" class=\"kb\" style=\"width:128px;\" onChange=\"changeMenue(BodyForm,this.value)\">\r\n");
      out.write("\t\t\t\t\t\t\t");

							String selected = "";
							if (manager.getSuchMenueId().intValue() == 0) selected = "selected";
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option ");
      out.print(selected);
      out.write(" value=0> </option> \r\n");
      out.write("\t\t\t\t\t\t\t");

							for (int index=0;index<asm.getSize();index++) {
								selected = "";
								Integer id = (Integer) asm.getKeys(KochbuchBean.AsmMenue.KEY_ID).get(index);
								String bez = (String) asm.getKeys(KochbuchBean.AsmMenue.KEY_BEZ).get(index);
								if (manager.getSuchMenueId().equals(id)) selected = "selected";
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option ");
      out.print(selected);
      out.write(" value=");
      out.print(id);
      out.write('>');
      out.print(bez);
      out.write("</option> \r\n");
      out.write("\t\t\t\t\t\t\t\t");

							}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t<font size=\"2\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\tRezept:\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"rezeptname\" value=\"");
      out.print(manager.getSuchName().replaceAll("%",""));
      out.write("\" style=\"width:120px;\" class=\"kbedit\" >\r\n");
      out.write("\t\t\t\t\t</td >\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<font size=\"2\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\tZutat:\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"zutat\" value=\"");
      out.print(manager.getSuchZutat().replaceAll("%",""));
      out.write("\" style=\"width:120px;\" class=\"kbedit\" >\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td height=\"32px\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"2\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\tBeschreibung:\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"beschreibung\" value=\"");
      out.print(manager.getSuchBeschreibung().replaceAll("%",""));
      out.write("\" style=\"width:120px;\" class=\"kbedit\" >\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t<font size=\"2\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\tKommentar:\t\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"kommentar\" value=\"");
      out.print(manager.getSuchKommentar().replaceAll("%",""));
      out.write("\" style=\"width:120px;\" class=\"kbedit\">\r\n");
      out.write("\t\t\t\t\t</td >\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" class=\"kbbutton\" style=\"width:120px;\" id=\"searchButton\" name=\"searchButton\" value=\"Suche&nbsp;starten\" onClick=\"javascript:suche(BodyForm)\" >\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table width=\"100%\" style=\"position:relative;left:2px;\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th width=\"30px\" height=\"20px\" style=\"text-align:left;\" >&nbsp;</th>\r\n");
      out.write("\t\t\t\t\t");
 if (client.isAngemeldet()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<th width=\"30px\" style=\"text-align:left;\" >&nbsp;</th>\r\n");
      out.write("\t\t\t\t\t\t<th width=\"30px\" style=\"text-align:left;\" >&nbsp;</th>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align:left;width:120px;\">Typ</th>\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align:left;\">Name</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td id =\"td01\" style=\"align:left;text-align:center;overflow:auto;border-color:#D9B565; border-width:1px;border-style:solid;;position:absolute;top:60px;\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<div id=\"divDetail01\" align=\"left\" style=\"width:96%;overflow:auto;position:absolute;top:128px;\">\r\n");
      out.write("\t\t\t\t<table id=\"table01\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"align:left;width:100%;\">\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");

								for (int index=0;index<suchAsm.getSize();index++) {
									String m_bez = (String) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_MEN_BEZ).get(index);
									String r_bez = (String) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_REZ_BEZ).get(index);
									Integer m_id = (Integer) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_MEN_ID).get(index);
									Integer r_id = (Integer) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_REZ_ID).get(index);
									
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"center\" height=\"20px\" width=\"30px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:auswahl_zeile(BodyForm,");
      out.print(m_id);
      out.write(',');
      out.print(r_id);
      out.write(")\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("text.gif"));
      out.write("\" border=\"0\" alt=\"Rezept ansehen\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 if (client.isAngemeldet()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" width=\"30px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:edit_zeile(BodyForm,");
      out.print(m_id);
      out.write(',');
      out.print(r_id);
      out.write(")\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("quill.gif"));
      out.write("\" border=\"0\" alt=\"Rezept bearbeiten\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" width=\"30px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:delete_zeile(BodyForm,");
      out.print(m_id);
      out.write(',');
      out.print(r_id);
      out.write(")\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("trashcan.gif"));
      out.write("\" border=\"0\" alt=\"Rezept l&ouml;schen\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"left\" width=\"120px\"><font>");
      out.print(m_bez);
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"left\"><font>");
      out.print(r_bez);
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

								}
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"30px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 if (client.isAngemeldet()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"30px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"30px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"120px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

									int sizeR = suchAsm.getSize();
									String msg = " Rezepte gefunden.";
									if (sizeR == 1) {
										msg = " Rezept gefunden.";
									}
									
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td align=\"left\" height=\"20px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<b>");
      out.print(sizeR);
      out.print(msg);
      out.write("</b>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\t");

}
else {
	
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<table style=\"width:98%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\" style=\"border-color:#D9B565; border-width:1px;border-style:solid;padding:2px;height:80px;width:99%\">\r\n");
      out.write("\t\t\t<table id = \"table01\" width=\"100%\" border=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td height=\"40px\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"3\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\tTypauswahl:\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select size=\"1\" name=\"selectMenues\" class=\"kb\" style=\"width:186px;\" onChange=\"changeMenue(BodyForm,this.value)\">\r\n");
      out.write("\t\t\t\t\t\t\t");

							String selected = "";
							if (manager.getSuchMenueId().intValue() == 0) selected = "selected";
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option ");
      out.print(selected);
      out.write(" value=0> </option> \r\n");
      out.write("\t\t\t\t\t\t\t");

							for (int index=0;index<asm.getSize();index++) {
								selected = "";
								Integer id = (Integer) asm.getKeys(KochbuchBean.AsmMenue.KEY_ID).get(index);
								String bez = (String) asm.getKeys(KochbuchBean.AsmMenue.KEY_BEZ).get(index);
								if (manager.getSuchMenueId().equals(id)) selected = "selected";
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option ");
      out.print(selected);
      out.write(" value=");
      out.print(id);
      out.write('>');
      out.print(bez);
      out.write("</option> \r\n");
      out.write("\t\t\t\t\t\t\t\t");

							}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t<font size=\"3\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\tRezept:\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"rezeptname\" value=\"");
      out.print(manager.getSuchName().replaceAll("%",""));
      out.write("\" style=\"width:180px;\" class=\"kbedit\" >\r\n");
      out.write("\t\t\t\t\t</td >\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<font size=\"3\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\tZutat:\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"zutat\" value=\"");
      out.print(manager.getSuchZutat().replaceAll("%",""));
      out.write("\" style=\"width:180px;\" class=\"kbedit\" >\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td height=\"32px\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"3\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\tBeschreibung:\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"beschreibung\" value=\"");
      out.print(manager.getSuchBeschreibung().replaceAll("%",""));
      out.write("\" style=\"width:180px;\" class=\"kbedit\" >\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t<font size=\"3\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\tKommentar:\t\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"kommentar\" value=\"");
      out.print(manager.getSuchKommentar().replaceAll("%",""));
      out.write("\" style=\"width:180px;\" class=\"kbedit\">\r\n");
      out.write("\t\t\t\t\t</td >\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" class=\"kbbutton\" style=\"width:180px;\" id=\"searchButton\" name=\"searchButton\" value=\"Suche&nbsp;starten\" onClick=\"javascript:suche(BodyForm)\" >\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table width=\"100%\" style=\"position:relative;left:2px;\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th width=\"30px\" height=\"30px\" style=\"text-align:left;\" >&nbsp;</th>\r\n");
      out.write("\t\t\t\t\t");
 if (client.isAngemeldet()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<th width=\"30px\" style=\"text-align:left;\" >&nbsp;</th>\r\n");
      out.write("\t\t\t\t\t\t<th width=\"30px\" style=\"text-align:left;\" >&nbsp;</th>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align:left;width:120px;\">Typ</th>\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align:left;\">Name</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td id =\"td01\" style=\"align:left;text-align:center;overflow:auto;border-color:#D9B565; border-width:1px;border-style:solid;width:99%;\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<div id=\"divDetail01\" align=\"left\" style=\"width:96%;overflow:auto;position:absolute;top:168px;\">\r\n");
      out.write("\t\t\t\t<table id=\"table01\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"align:left;width:100%;\">\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");

								for (int index=0;index<suchAsm.getSize();index++) {
									String m_bez = (String) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_MEN_BEZ).get(index);
									String r_bez = (String) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_REZ_BEZ).get(index);
									Integer m_id = (Integer) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_MEN_ID).get(index);
									Integer r_id = (Integer) suchAsm.getKeys(KochbuchBean.AsmSuchListe.KEY_REZ_ID).get(index);
									
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"center\" height=\"30px\" width=\"30px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:auswahl_zeile(BodyForm,");
      out.print(m_id);
      out.write(',');
      out.print(r_id);
      out.write(")\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("text.gif"));
      out.write("\" border=\"0\" alt=\"Rezept ansehen\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 if (client.isAngemeldet()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" width=\"30px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:edit_zeile(BodyForm,");
      out.print(m_id);
      out.write(',');
      out.print(r_id);
      out.write(")\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("quill.gif"));
      out.write("\" border=\"0\" alt=\"Rezept bearbeiten\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" width=\"30px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:delete_zeile(BodyForm,");
      out.print(m_id);
      out.write(',');
      out.print(r_id);
      out.write(")\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("trashcan.gif"));
      out.write("\" border=\"0\" alt=\"Rezept l&ouml;schen\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"left\" width=\"120px\"><font>");
      out.print(m_bez);
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"left\"><font>");
      out.print(r_bez);
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

								}
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"30px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 if (client.isAngemeldet()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"30px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"30px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"120px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

									int sizeR = suchAsm.getSize();
									String msg = " Rezepte gefunden.";
									if (sizeR == 1) {
										msg = " Rezept gefunden.";
									}
									
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td align=\"left\" height=\"30px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<b>");
      out.print(sizeR);
      out.print(msg);
      out.write("</b>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td id = \"td02\" style=\"border-color:#D9B565; border-width:1px;border-style:solid;height:38px;width:96%;\">\r\n");
      out.write("\t\t\t<table width=\"100%\" border=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t");
 if (!client.isAngemeldet()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td height=\"32px\" width=\"70px\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<font size=\"3\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\t\tBenutzer: \r\n");
      out.write("\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\" width=\"120px\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"user\" value=\"\" style=\"width:100px;\" class=\"kbedit\" >\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"70px\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<font size=\"3\" face=\"Sylfaen\">\r\n");
      out.write("\t\t\t\t\t\t\t\tPa&szlig;wort: \r\n");
      out.write("\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\" width=\"120px\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"pw\" value=\"\" style=\"width:100px;\" class=\"kbedit\" >\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" class=\"kbbutton2\" style=\"width:120px;\" id=\"loginButton\" name=\"loginButton\" value=\"Anmelden\" onClick=\"javascript:loginUser(BodyForm)\" >\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td height=\"32px\" align=\"left\" style=\"width:120px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" class=\"kbbutton2\" style=\"width:120px;\" name=\"logoutButton\" value=\"Abmelden\" onClick=\"javascript:logoutUser(BodyForm)\" >\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\" style=\"width:120px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" class=\"kbbutton2\" style=\"width:120px;\" id=\"newButton\" name=\"newButton\" value=\"Neues Rezept\" onClick=\"javascript:neuesRezept(BodyForm)\" >\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align:right\">\r\n");
      out.write("\t\t\t\t\t\t\tAngemeldet ist:\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\" style=\"width:90px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" readonly=\"readonly\" name=\"aktuser\" value=\"");
      out.print(client.getUserName());
      out.write("\" style=\"width:80px;\" class=\"kbedit\" >\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t");

					}
					
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("</table>\r\n");

}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("if (typeof ResizeApp === \"function\") {\r\n");
      out.write("\t\tResizeApp();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
