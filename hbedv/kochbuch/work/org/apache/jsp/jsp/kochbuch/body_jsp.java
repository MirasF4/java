/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2019-06-05 08:51:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.kochbuch;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hbedv.kochbuch.*;
import com.hbedv.frame.*;
import com.hbedv.db.kochbuch.KochbuchBean;

public final class body_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/jsp/kochbuch/import.jsp", Long.valueOf(1140871376000L));
    _jspx_dependants.put("/jsp/kochbuch/footer.jsp", Long.valueOf(1538553248384L));
    _jspx_dependants.put("/jsp/kochbuch/header.jsp", Long.valueOf(1559724005801L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
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
	boolean mobileVersion = client.isMobileVersion();
	KochbuchBodyManager manager = client.getKochbuchBodyManager();

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
      out.write("<script type=\"text/JavaScript\">\r\n");
      out.write("function nothingToDo(f) {\r\n");
      out.write("\tf.logo.style.cursor = \"default\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<table width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t<table width=\"95%\" border=\"0\">\r\n");
      out.write("\t\t\t\t");

				if (mobileVersion) {
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"100%\" align=\"center\" valign=\"middle\" height=\"550px\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"javascript:nothingToDo(BodyForm)\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t<IMG SRC=\"");
      out.print(client.getUriImageGlobal("body.jpg"));
      out.write("\" name=\"logo\" disabled=\"true\" border=\"0\" WIDTH=\"450px\" HEIGHT=\"300px\" ALT=\"\" style=\"cursor:default;position:absolute;top:30px;left:90px;\">\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

				}
				else {
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"100%\" align=\"center\" valign=\"middle\" height=\"550px\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"javascript:nothingToDo(BodyForm)\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t<IMG SRC=\"");
      out.print(client.getUriImageGlobal("body.jpg"));
      out.write("\" name=\"logo\" disabled=\"true\" border=\"0\" WIDTH=\"600px\" HEIGHT=\"400px\" ALT=\"\" style=\"cursor:default;\">\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				}
				
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
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
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
