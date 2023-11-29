package org.apache.jsp.jsp.kochbuch;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hbedv.kochbuch.*;
import com.hbedv.frame.*;
import com.hbedv.db.kochbuch.KochbuchBean;

public final class vorspeisen_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(5);
    _jspx_dependants.add("/jsp/kochbuch/import.jsp");
    _jspx_dependants.add("/jsp/kochbuch/header.jsp");
    _jspx_dependants.add("/jsp/kochbuch/rezept.jsp");
    _jspx_dependants.add("/jsp/kochbuch/button.jsp");
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
	KochbuchVorspeisenManager manager = client.getKochbuchVorspeisenManager();

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
      out.write('\r');
      out.write('\n');

int breite = 450;
int picBreite = 210;
int picHoehe = 154;
int topZub = -7;
if (client.getBsWidth().intValue() < 1152) {
	breite = 405;
	picBreite = 162;
	picHoehe = 130;
	topZub = -6;
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("function ResizeWindow(outerWidth,outerHeight) {\r\n");
      out.write("\t//alert (\"OK\");\r\n");
      out.write("\tvar innerWidth = window.innerWidth;  \r\n");
      out.write("\tvar innerHeight = window.innerHeight;\r\n");
      out.write("\r\n");
      out.write("\t");

	if (client.isMobileVersion()) {
	
      out.write("\r\n");
      out.write("\t\tvar w = 290;\r\n");
      out.write("\t\tvar h = 136;\r\n");
      out.write("\t\tvar mainTable = document.getElementById('mainTable');\r\n");
      out.write("\t\tmainTable.style.position = \"absolute\";\r\n");
      out.write("\t\tmainTable.style.top = '6px';\r\n");
      out.write("\t\tmainTable.style.left = '26px';\r\n");
      out.write("\t\tvar wi = innerWidth-60;\r\n");
      out.write("\t\tmainTable.style.width = wi+'px';\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tvar s1z1 = document.getElementById('s1z1');\r\n");
      out.write("\t\ts1z1.style.width = '75%';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar s2z1 = document.getElementById('s2z1');\r\n");
      out.write("\t\ts2z1.style.width = '25%';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar div1  = document.getElementById('div1');\r\n");
      out.write("\t\tvar e = innerHeight - h + 4;\r\n");
      out.write("\t\tdiv1.style.height = e + \"px\";\r\n");
      out.write("\t\tvar e = (innerWidth/2) - 58;\r\n");
      out.write("\t\tif (e > w) div1.style.width = e + \"px\";\r\n");
      out.write("\t\tif (e <= w) div1.style.width = w + \"px\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar rezTd01 = document.getElementById('rezTd01');\r\n");
      out.write("\t\tvar rect = div1.getBoundingClientRect();\r\n");
      out.write("\t\tvar e = rect.width - 4;\r\n");
      out.write("\t\tif (e > w) rezTd01.style.width = e + 'px';\r\n");
      out.write("\t\tif (e <= w) rezTd01.style.width = w + 'px';\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\tvar div2  = document.getElementById('div2');\r\n");
      out.write("\t\tvar e = innerHeight - h;\r\n");
      out.write("\t\tdiv2.style.height = e + \"px\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//width:200px\"\r\n");
      out.write("\t\tvar e = (wi/2) - 20;\r\n");
      out.write("\t\tdiv2.style.width = e + \"px\";\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\tvar rezTd02 = document.getElementById('rezTd02');\r\n");
      out.write("\t\tvar rect = mainTable.getBoundingClientRect();\r\n");
      out.write("\t\tvar e = (rect.width/2) - 16;\r\n");
      out.write("\t\trezTd02.style.width = e + 'px';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar rezTd03 = document.getElementById('rezTd03');\r\n");
      out.write("\t\tvar rect = div3.getBoundingClientRect();\r\n");
      out.write("\t\tvar e = rect.width - 6;\r\n");
      out.write("\t\trezTd03.style.width = e + 'px';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar browser = getBrowserName();\r\n");
      out.write("\t\tvar pic1 = document.getElementById('pic1');\r\n");
      out.write("\t\tif (pic1 != null) {\r\n");
      out.write("\t\t\tif (browser == isIE || browser == isEdge) {\r\n");
      out.write("\t\t\t\tpic1.width = \"199\";\r\n");
      out.write("\t\t\t\tpic1.height = \"152\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse {\r\n");
      out.write("\t\t\t\tpic1.width = \"200\";\r\n");
      out.write("\t\t\t\tpic1.height = \"156\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar div4 = document.getElementById('div4');\r\n");
      out.write("\t\tdiv4.style.width = '200px';\r\n");
      out.write("\t\tdiv4.style.height = '156px';\r\n");
      out.write("\t");

	}
	else {	
	
      out.write("\r\n");
      out.write("\t\tvar w = 415;\r\n");
      out.write("\t\tvar mainTable = document.getElementById('mainTable');\r\n");
      out.write("\t\tmainTable.style.position = \"absolute\";\r\n");
      out.write("\t\tmainTable.style.top = '30px';\r\n");
      out.write("\t\tmainTable.style.left = '26px';\r\n");
      out.write("\t\tvar wi = innerWidth-60;\r\n");
      out.write("\t\tmainTable.style.width = wi+'px';\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tvar s1z1 = document.getElementById('s1z1');\r\n");
      out.write("\t\ts1z1.style.width = '75%';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar s2z1 = document.getElementById('s2z1');\r\n");
      out.write("\t\ts2z1.style.width = '25%';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar div1  = document.getElementById('div1');\r\n");
      out.write("\t\tvar e = innerHeight - 410;\r\n");
      out.write("\t\tdiv1.style.height = e + \"px\";\r\n");
      out.write("\t\tvar e = (innerWidth/2) - 58;\r\n");
      out.write("\t\tif (e > w) div1.style.width = e + \"px\";\r\n");
      out.write("\t\tif (e <= w) div1.style.width = w + \"px\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar rezTd01 = document.getElementById('rezTd01');\r\n");
      out.write("\t\tvar rect = div1.getBoundingClientRect();\r\n");
      out.write("\t\tvar e = rect.width - 4;\r\n");
      out.write("\t\tif (e > w) rezTd01.style.width = e + 'px';\r\n");
      out.write("\t\tif (e <= w) rezTd01.style.width = w + 'px';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar div2  = document.getElementById('div2');\r\n");
      out.write("\t\tvar e = innerHeight - 204;\r\n");
      out.write("\t\tdiv2.style.height = e + \"px\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//width:200px\"\r\n");
      out.write("\t\tvar e = (wi/2) - 20;\r\n");
      out.write("\t\tdiv2.style.width = e + \"px\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tvar rezTd02 = document.getElementById('rezTd02');\r\n");
      out.write("\t\tvar rect = mainTable.getBoundingClientRect();\r\n");
      out.write("\t\tvar e = (rect.width/2);\r\n");
      out.write("\t\trezTd02.style.width = e + 'px';\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\tvar rezTd03 = document.getElementById('rezTd03');\r\n");
      out.write("\t\tvar rect = div3.getBoundingClientRect();\r\n");
      out.write("\t\tvar e = rect.width - 6;\r\n");
      out.write("\t\trezTd03.style.width = e + 'px';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar browser = getBrowserName();\r\n");
      out.write("\t\tvar pic1 = document.getElementById('pic1');\r\n");
      out.write("\t\tif (pic1 != null) {\r\n");
      out.write("\t\t\tif (browser == isIE || browser == isEdge) {\r\n");
      out.write("\t\t\t\tpic1.width = \"199\";\r\n");
      out.write("\t\t\t\tpic1.height = \"152\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse {\r\n");
      out.write("\t\t\t\tpic1.width = \"200\";\r\n");
      out.write("\t\t\t\tpic1.height = \"156\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar div4 = document.getElementById('div4');\r\n");
      out.write("\t\tdiv4.style.width = '200px';\r\n");
      out.write("\t\tdiv4.style.height = '156px';\r\n");
      out.write("\t\t\r\n");
      out.write("\t");

	}
	
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");

if (client.isMobileVersion()) {

      out.write("\r\n");
      out.write("<table border=\"0\" id=\"mainTable\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan = \"2\">\r\n");
      out.write("\t\t\t<table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"s1z1\" style=\"text-align:left;height:20px;\">\r\n");
      out.write("\t\t\t\t\t\t<em>\r\n");
      out.write("\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t<font face=\"Sylfaen\" style=\"font-size:150%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(manager.getRezeptNameJSP());
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t</em>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td id=\"s2z1\" style=\"text-align:right;\" >\r\n");
      out.write("\t\t\t\t\t\t<font size=\"2\" face=\"Sylfaen\" style=\"font-size:95%\">\r\n");
      out.write("\t\t\t\t\t\t\t");

							int row = manager.getAsmRow() + 1;
							int size = manager.getSizeRezeptListe();
							if (size < 1) row = 0;
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t(");
      out.print(manager.getMenueBez());
      out.write("&nbsp;");
      out.print(row);
      out.write("&nbsp;von&nbsp;");
      out.print(size);
      out.write(")&nbsp;\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"rezTd01\" style=\"height:20px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;left:2px;\">\r\n");
      out.write("\t\t\t\t\t\t<font id=\"font01\" size=\"4\" face=\"Sylfaen\" >\r\n");
      out.write("\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\tZutaten\r\n");
      out.write("\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"rezTd02\" style=\"height:20px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;left:0px;\"\">\r\n");
      out.write("\t\t\t\t\t\t<font id=\"font02\" size=\"4\" face=\"Sylfaen\" >\r\n");
      out.write("\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\tZubereitung\r\n");
      out.write("\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<div id=\"div1\" style=\"border-color:#D9B565; border-width:1px;border-style:solid;padding:2px;overflow:auto;position:relative;left:2px;\">\r\n");
      out.write("\t\t\t\t<table border=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th width=\"20%\" style=\"text-align:center;\">Anzahl</th>\r\n");
      out.write("\t\t\t\t\t\t<th width=\"20%\" style=\"text-align:left;\">Einheit</th>\r\n");
      out.write("\t\t\t\t\t\t<th width=\"60%\" style=\"text-align:left;\">Zutaten</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");

					AliceSortMap zutatenListe = manager.getZutaten();
					for (int index=0;index<zutatenListe.getSize();index++) {
						String anzStr = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_ANZAHL).get(index);
						String einheit = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_EINHEIT).get(index);
						String zutaten = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_BEZ).get(index);
						
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"20%\" align=\"center\">");
      out.print(anzStr);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"20%\">");
      out.print(einheit);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"60%\">");
      out.print(zutaten);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

					}
					
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td id = \"zubeTD01\" rowspan=\"3\" valign=\"top\">\r\n");
      out.write("\t\t\t<div id=\"div2\" style=\"border-color:#D9B565; border-width:1px;border-style:solid;padding:4px;overflow:auto;\">\r\n");
      out.write("\t\t\t\t<pre class=\"kb\">");
      out.print(manager.getZubereitung());
      out.write("<br></br><strong>Kommentar:</strong></br>");
      out.print(manager.getKommentar());
      out.write("</pre>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t");
      out.write("<script language=\"JavaScript\" type=\"text/JavaScript\">\r\n");
      out.write("\tfunction first(f) {\r\n");
      out.write("\t\tf.target = \"");
      out.print(TheApp.CMD_BODY);
      out.write("\";\r\n");
      out.write("\t\tf.cmd.value = \"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("\t\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_FIRST);
      out.write("\";\r\n");
      out.write("\t\tf.submit(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction last(f) {\r\n");
      out.write("\t\tf.target = \"");
      out.print(TheApp.CMD_BODY);
      out.write("\";\r\n");
      out.write("\t\tf.cmd.value = \"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("\t\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_LAST);
      out.write("\";\r\n");
      out.write("\t\tf.submit(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction back(f) {\r\n");
      out.write("\t\tf.target = \"");
      out.print(TheApp.CMD_BODY);
      out.write("\";\r\n");
      out.write("\t\tf.cmd.value = \"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("\t\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_BACK);
      out.write("\";\r\n");
      out.write("\t\tf.submit(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction next(f) {\r\n");
      out.write("\t\tf.target = \"");
      out.print(TheApp.CMD_BODY);
      out.write("\";\r\n");
      out.write("\t\tf.cmd.value = \"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("\t\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_NEXT);
      out.write("\";\r\n");
      out.write("\t\tf.submit(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction print(f) {\r\n");
      out.write("\t\tf.cmd.value=\"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("    \tf.target = \"PrintRezept\";\r\n");
      out.write("    \twin = window.open(\"\",f.target,\"toolbar=yes,location=no,\"+\r\n");
      out.write("  \t\t\t\"directories=no,status=yes,menubar=yes,scrollbars=yes,resizable=yes,\"+\r\n");
      out.write("  \t\t\t\"copyhistory=no\");\r\n");
      out.write("\t\twin.moveTo(0,0);\r\n");
      out.write("  \t\twin.resizeTo(1140,820);\r\n");
      out.write("  \t\r\n");
      out.write("  \t\tf.cmd.value=\"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("  \t\tf.subcmd.value=\"");
      out.print(Kochbuch.SUB_CMD_PRINT_REZEPT);
      out.write("\";\r\n");
      out.write("  \t\tf.submit(\"\");\r\n");
      out.write("  \t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");

if (client.isMobileVersion()) {
	
      out.write("\r\n");
      out.write("\t<table align=\"center\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"34px\" align=\"center\" style=\"position:relative;top:-6px;\">\r\n");
      out.write("\t\t\t\t");

				if (row > 1) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:first(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_first.gif"));
      out.write("\" style=\"border:0;\" alt=\"Erstes Rezept\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_first_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" align=\"center\" style=\"position:relative;top:-6px;\">\r\n");
      out.write("\t\t\t\t");

				if (row > 1) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:back(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_back.gif"));
      out.write("\" style=\"border:0;\" alt=\"Zur&uuml;ck\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_back_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" align=\"center\" style=\"position:relative;top:-6px;\">\r\n");
      out.write("\t\t\t\t");

				if (row < size) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:next(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_prior.gif"));
      out.write("\" style=\"border:0;\" alt=\"Vor\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_prior_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" align=\"center\" style=\"position:relative;top:-6px;\">\r\n");
      out.write("\t\t\t\t");

				if (row < size) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:last(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_last.gif"));
      out.write("\" style=\"border:0;\" alt=\"Letztes Rezept\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_last_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<p>&nbsp;</p>\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<td width=\"70px\" align=\"center\" style=\"position:relative;top:-6px;\">\r\n");
      out.write("\t\t\t\t");

				if (size > 0) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:print(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_print.gif"));
      out.write("\" style=\"border:0;\" alt=\"Drucken\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t\t\t<!-- <img src=\"");
      out.print(client.getUriImageGlobal("bbutton_print_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\"> -->\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_print_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t");

}
else {
	
      out.write("\r\n");
      out.write("\t<table align=\"center\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"70px\" align=\"center\">\r\n");
      out.write("\t\t\t\t");

				if (row > 1) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:first(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_first.gif"));
      out.write("\" style=\"border:0;\" alt=\"Erstes Rezept\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_first_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"70px\" align=\"center\">\r\n");
      out.write("\t\t\t\t");

				if (row > 1) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:back(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_back.gif"));
      out.write("\" style=\"border:0;\" alt=\"Zur&uuml;ck\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_back_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"70px\" align=\"center\">\r\n");
      out.write("\t\t\t\t");

				if (row < size) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:next(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_prior.gif"));
      out.write("\" style=\"border:0;\" alt=\"Vor\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_prior_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"70px\" align=\"center\">\r\n");
      out.write("\t\t\t\t");

				if (row < size) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:last(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_last.gif"));
      out.write("\" style=\"border:0;\" alt=\"Letztes Rezept\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_last_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<p>&nbsp;</p>\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"70px\" align=\"center\">\r\n");
      out.write("\t\t\t\t");

				if (size > 0) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:print(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_print.gif"));
      out.write("\" style=\"border:0;\" alt=\"Drucken\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_print_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t");

}

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");

}
else {

      out.write("\r\n");
      out.write("<table border=\"0\" id=\"mainTable\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan = \"2\">\r\n");
      out.write("\t\t\t<table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"s1z1\" style=\"text-align:left;height:20px;\">\r\n");
      out.write("\t\t\t\t\t\t<em>\r\n");
      out.write("\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t<font face=\"Sylfaen\" style=\"font-size:150%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(manager.getRezeptNameJSP());
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t</em>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td id=\"s2z1\" style=\"text-align:right;\" >\r\n");
      out.write("\t\t\t\t\t\t<font size=\"2\" face=\"Sylfaen\" style=\"font-size:95%\">\r\n");
      out.write("\t\t\t\t\t\t\t");

							int row = manager.getAsmRow() + 1;
							int size = manager.getSizeRezeptListe();
							if (size < 1) row = 0;
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t(");
      out.print(manager.getMenueBez());
      out.write("&nbsp;");
      out.print(row);
      out.write("&nbsp;von&nbsp;");
      out.print(size);
      out.write(")&nbsp;\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"rezTd01\" style=\"height:32px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;top:+0px;left:1px\">\r\n");
      out.write("\t\t\t\t\t\t<font id=\"font01\" size=\"5\" face=\"Sylfaen\" >\r\n");
      out.write("\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\tZutaten\r\n");
      out.write("\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"rezTd02\" style=\"height:32px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;top:0px;left:-2px;\">\r\n");
      out.write("\t\t\t\t\t\t<font id=\"font02\" size=\"5\" face=\"Sylfaen\" >\r\n");
      out.write("\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\tZubereitung\r\n");
      out.write("\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<div id=\"div1\" style=\"border-color:#D9B565; border-width:1px;border-style:solid;padding:2px;overflow:auto;position:relative;left:2px;\">\r\n");
      out.write("\t\t\t\t<table border=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th width=\"20%\" style=\"text-align:center;\">Anzahl</th>\r\n");
      out.write("\t\t\t\t\t\t<th width=\"20%\" style=\"text-align:left;\">Einheit</th>\r\n");
      out.write("\t\t\t\t\t\t<th width=\"60%\" style=\"text-align:left;\">Zutaten</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");

					AliceSortMap zutatenListe = manager.getZutaten();
					for (int index=0;index<zutatenListe.getSize();index++) {
						String anzStr = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_ANZAHL).get(index);
						String einheit = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_EINHEIT).get(index);
						String zutaten = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_BEZ).get(index);
						
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"20%\" align=\"center\">");
      out.print(anzStr);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"20%\">");
      out.print(einheit);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"60%\">");
      out.print(zutaten);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

					}
					
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td id = \"zubeTD01\" rowspan=\"3\" valign=\"top\">\r\n");
      out.write("\t\t\t<div id=\"div2\" style=\"border-color:#D9B565; border-width:1px;border-style:solid;padding:4px;overflow:auto;\">\r\n");
      out.write("\t\t\t\t<pre class=\"kb\">");
      out.print(manager.getZubereitung());
      out.write("</pre>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"rezTd03\" style=\"height:32px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;top:+2px;left:0px\">\r\n");
      out.write("\t\t\t\t\t\t<font id=\"font01\" size=\"5\" face=\"Sylfaen\" >\r\n");
      out.write("\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\tKommentar\r\n");
      out.write("\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td id=\"rezTd04\" style=\"width:196px;height:32px;align:bottom;overflow:auto;padding:2px;background:#D9B565;position:relative;top:+2px;left:10px\">\r\n");
      out.write("\t\t\t\t\t\t<font id=\"font02\" size=\"5\" face=\"Sylfaen\" >\r\n");
      out.write("\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\tBild\r\n");
      out.write("\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td style= \"width:50%\">\r\n");
      out.write("\t\t\t<table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id = \"komTd03\" >\r\n");
      out.write("\t\t\t\t\t\t<div id=\"div3\" style=\"height:98%;border-color:#D9B565; border-width:1px;border-style:solid;padding:4px;overflow:auto;position:relative;left:-2px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<pre id=\"kom2\" class=\"kb\" style=\"height:116px\" >");
      out.print(manager.getKommentar());
      out.write("</pre>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"left\" width=\"220px\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"div4\" style=\"border-color:#D9B565; border-width:1px;border-style:solid;padding:0px;overflow:auto;position:relative;left:4px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<img id=\"pic1\" src=\"");
      out.print(manager.getPicName());
      out.write("\" ALT=\"");
      out.print(manager.getRezeptNameJSP());
      out.write("\" >\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t");
      out.write("<script language=\"JavaScript\" type=\"text/JavaScript\">\r\n");
      out.write("\tfunction first(f) {\r\n");
      out.write("\t\tf.target = \"");
      out.print(TheApp.CMD_BODY);
      out.write("\";\r\n");
      out.write("\t\tf.cmd.value = \"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("\t\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_FIRST);
      out.write("\";\r\n");
      out.write("\t\tf.submit(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction last(f) {\r\n");
      out.write("\t\tf.target = \"");
      out.print(TheApp.CMD_BODY);
      out.write("\";\r\n");
      out.write("\t\tf.cmd.value = \"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("\t\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_LAST);
      out.write("\";\r\n");
      out.write("\t\tf.submit(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction back(f) {\r\n");
      out.write("\t\tf.target = \"");
      out.print(TheApp.CMD_BODY);
      out.write("\";\r\n");
      out.write("\t\tf.cmd.value = \"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("\t\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_BACK);
      out.write("\";\r\n");
      out.write("\t\tf.submit(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction next(f) {\r\n");
      out.write("\t\tf.target = \"");
      out.print(TheApp.CMD_BODY);
      out.write("\";\r\n");
      out.write("\t\tf.cmd.value = \"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("\t\tf.subcmd.value = \"");
      out.print(Kochbuch.SUB_CMD_NEXT);
      out.write("\";\r\n");
      out.write("\t\tf.submit(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction print(f) {\r\n");
      out.write("\t\tf.cmd.value=\"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("    \tf.target = \"PrintRezept\";\r\n");
      out.write("    \twin = window.open(\"\",f.target,\"toolbar=yes,location=no,\"+\r\n");
      out.write("  \t\t\t\"directories=no,status=yes,menubar=yes,scrollbars=yes,resizable=yes,\"+\r\n");
      out.write("  \t\t\t\"copyhistory=no\");\r\n");
      out.write("\t\twin.moveTo(0,0);\r\n");
      out.write("  \t\twin.resizeTo(1140,820);\r\n");
      out.write("  \t\r\n");
      out.write("  \t\tf.cmd.value=\"");
      out.print(manager.getCmd());
      out.write("\";\r\n");
      out.write("  \t\tf.subcmd.value=\"");
      out.print(Kochbuch.SUB_CMD_PRINT_REZEPT);
      out.write("\";\r\n");
      out.write("  \t\tf.submit(\"\");\r\n");
      out.write("  \t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");

if (client.isMobileVersion()) {
	
      out.write("\r\n");
      out.write("\t<table align=\"center\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"34px\" align=\"center\" style=\"position:relative;top:-6px;\">\r\n");
      out.write("\t\t\t\t");

				if (row > 1) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:first(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_first.gif"));
      out.write("\" style=\"border:0;\" alt=\"Erstes Rezept\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_first_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" align=\"center\" style=\"position:relative;top:-6px;\">\r\n");
      out.write("\t\t\t\t");

				if (row > 1) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:back(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_back.gif"));
      out.write("\" style=\"border:0;\" alt=\"Zur&uuml;ck\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_back_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" align=\"center\" style=\"position:relative;top:-6px;\">\r\n");
      out.write("\t\t\t\t");

				if (row < size) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:next(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_prior.gif"));
      out.write("\" style=\"border:0;\" alt=\"Vor\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_prior_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" align=\"center\" style=\"position:relative;top:-6px;\">\r\n");
      out.write("\t\t\t\t");

				if (row < size) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:last(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_last.gif"));
      out.write("\" style=\"border:0;\" alt=\"Letztes Rezept\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_last_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<p>&nbsp;</p>\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<td width=\"70px\" align=\"center\" style=\"position:relative;top:-6px;\">\r\n");
      out.write("\t\t\t\t");

				if (size > 0) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:print(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_print.gif"));
      out.write("\" style=\"border:0;\" alt=\"Drucken\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t\t\t<!-- <img src=\"");
      out.print(client.getUriImageGlobal("bbutton_print_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\"> -->\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_print_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\" width=\"32\" height=\"32\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t");

}
else {
	
      out.write("\r\n");
      out.write("\t<table align=\"center\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"70px\" align=\"center\">\r\n");
      out.write("\t\t\t\t");

				if (row > 1) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:first(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_first.gif"));
      out.write("\" style=\"border:0;\" alt=\"Erstes Rezept\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_first_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"70px\" align=\"center\">\r\n");
      out.write("\t\t\t\t");

				if (row > 1) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:back(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_back.gif"));
      out.write("\" style=\"border:0;\" alt=\"Zur&uuml;ck\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_back_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"70px\" align=\"center\">\r\n");
      out.write("\t\t\t\t");

				if (row < size) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:next(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_prior.gif"));
      out.write("\" style=\"border:0;\" alt=\"Vor\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_prior_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"70px\" align=\"center\">\r\n");
      out.write("\t\t\t\t");

				if (row < size) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:last(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_last.gif"));
      out.write("\" style=\"border:0;\" alt=\"Letztes Rezept\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_last_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<p>&nbsp;</p>\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<td width=\"70px\" height=\"70px\" align=\"center\">\r\n");
      out.write("\t\t\t\t");

				if (size > 0) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:print(BodyForm)\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_print.gif"));
      out.write("\" style=\"border:0;\" alt=\"Drucken\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(client.getUriImageGlobal("bbutton_print_disabled.gif"));
      out.write("\" style=\"border:0;\" alt=\"\">\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t");

}

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");

}

      out.write("\r\n");
      out.write("\r\n");
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
      out.write('\r');
      out.write('\n');
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
