package org.apache.jsp.jsp.kochbuch;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hbedv.kochbuch.*;
import com.hbedv.frame.*;
import com.hbedv.db.kochbuch.KochbuchBean;

public final class load_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(client.getUriCssGlobal("kochbuch.css"));
      out.write("\" type=\"text/css\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n");
      out.write("<title>Kochbuch</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("isIE10=\"IE10\";\r\n");
      out.write("isIE11=\"IE11\"; \r\n");
      out.write("isFireFox=\"FireFox\";\r\n");
      out.write("isEdge=\"Edge\";\r\n");
      out.write("isOpera=\"Opera\";\r\n");
      out.write("isChrome=\"Chrome\";\r\n");
      out.write("isSafari=\"Safari\";\r\n");
      out.write("isUnknown=\"Unknown\";\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function getBrowserName() {\r\n");
      out.write("\r\n");
      out.write("\tvar ret=isUnknown;\r\n");
      out.write("\r\n");
      out.write("\tif((navigator.userAgent.indexOf(\"Opera\") || navigator.userAgent.indexOf('OPR')) != -1 ) \r\n");
      out.write("\t{\r\n");
      out.write("\t\tret=isOpera;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(navigator.userAgent.indexOf(\"Chrome\") != -1 )\r\n");
      out.write("\t{\r\n");
      out.write("\t\tret=isChrome;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(navigator.userAgent.indexOf(\"Safari\") != -1)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tret=isSafari;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(navigator.userAgent.indexOf(\"Firefox\") != -1 ) \r\n");
      out.write("\t{\r\n");
      out.write("\t\tret=isFireFox;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if((navigator.userAgent.indexOf(\"MSIE\") != -1 ) || (document.documentMode == true )) //IF IE < 11\r\n");
      out.write("\t{\r\n");
      out.write("\t\tret=isIE10; \r\n");
      out.write("\t}\r\n");
      out.write("\telse if((navigator.userAgent.indexOf(\"MSIE\") != -1 ) || (!!document.documentMode == true )) //IF IE > 10\r\n");
      out.write("\t{\r\n");
      out.write("\t\tret=isIE11; \r\n");
      out.write("\t}  \r\n");
      out.write("\t \r\n");
      out.write("\telse if (navigator.userAgent.indexOf(\"Edge\") > -1) {\r\n");
      out.write("\t\tret=isEdge;\r\n");
      out.write("\t}\r\n");
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
      out.write("<input type=\"hidden\" name=\"m_id\" value=\"");
      out.print(client.getLoadMenId());
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"r_id\" value=\"");
      out.print(client.getLoadRezId());
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\r\n");
      out.write(" \tBodyForm.cmd.value = \"");
      out.print(client.getLoadCommand());
      out.write("\";\r\n");
      out.write(" \tBodyForm.subcmd.value = \"");
      out.print(client.getLoadSubCommand());
      out.write("\";\r\n");
      out.write(" \tBodyForm.submit();\r\n");
      out.write("</script>\r\n");
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
