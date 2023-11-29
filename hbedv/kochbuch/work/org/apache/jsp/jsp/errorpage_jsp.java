package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class errorpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/jsp/pre_adjustments.jsp");
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
    Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable(request);
    if (exception != null) {
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"errorpage.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

  com.hbedv.frame.Client client= (com.hbedv.frame.Client)request.getAttribute("com.hbedv.client");
  java.io.StringWriter sw = new java.io.StringWriter();
  java.io.PrintWriter pw = new java.io.PrintWriter(sw);
  exception.printStackTrace (pw);
  String emsg = com.hbedv.frame.Util.convertChars(sw.getBuffer().toString());

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<title>HBEDV Fehlerseite</title>\r\n");
      out.write("<link rel=\"STYLESHEET\" type=\"text/css\" href=\"css/hbedv.css\">\r\n");
      out.write("  <style type=\"text/css\">\r\n");
      out.write("    /* Styles für Body */\r\n");
      out.write("    body \t\t{ background-color:#FFFFFF; padding-top:0px; padding-left:0px; padding-right:0px; }\r\n");
      out.write("    #balken1\t{ position:absolute; left:0px; top:0px; z-index:1; }\r\n");
      out.write("    #LoginMaske\t{ position:absolute; left:296px; top:193px; z-index:1; }\r\n");
      out.write("    A         { color: #000000; text-decoration:underline;}\r\n");
      out.write("    A:Hover\t\t{ color: #000000; text-decoration:underline;}\r\n");
      out.write("    A:Active\t{ color: #000000; text-decoration:underline;}\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body scroll=\"auto\">\r\n");
      out.write("<center>\r\n");
      out.write("<table width='80%' bgcolor=\"#FEFEFE\"><tr bgcolor=\"#EC2700\">\r\n");
      out.write("<td colspan='2' align=\"right\" width=\"100%\" style=\"border: solid 1px #333A48;\" valign=\"top\">\r\n");
      out.write("<center><font color=\"#FEFEFE\" size=\"+1\">HBEDV konnte Ihre Anfrage leider nicht verarbeiten</font></center>\r\n");
      out.write("</td></Tr>\r\n");
      out.write("<tr>\r\n");
      out.write("  <td colspan='2' bgcolor=\"#D4D9DE\" style=\"border:1px solid #333A48; padding-left:19px;\" class=\"LoginText\" height=\"49\" align=\"center\">\r\n");
      out.write("<font size=\"2\">\r\n");
      out.write("Bitte wenden Sie Sich an Miras ;-) <BR>\r\n");
      out.write("</font>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr><td colspan='2'>&nbsp;</td></tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td valign=\"top\" width=\"10%\" bgcolor=\"#708090\"><font color=\"#FEFEFE\" size=\"2\">Problem:</font></td>\r\n");
      out.write("<td bgcolor=\"#D4D9DE\"><font color=\"#000000\" size=\"3\">");
      out.print(exception.getMessage());
      out.write("</font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td valign=\"top\" width=\"10%\" bgcolor=\"#708090\"><font color=\"#FEFEFE\" size=\"2\">Session:</font></td>\r\n");
      out.write("<td bgcolor=\"#D4D9DE\"><font color=\"#000000\" size=\"3\">");
      out.print(request.getSession().getId());
      out.write("</font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td valign=\"top\" width=\"10%\" bgcolor=\"#708090\"><font color=\"#FEFEFE\" size=\"2\">Uhrzeit:</font></td>\r\n");
      out.write("<td bgcolor=\"#D4D9DE\"><font color=\"#000000\" size=\"3\">");
      out.print(new java.sql.Timestamp(System.currentTimeMillis()));
      out.write("</font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td valign=\"top\" width=\"10%\" bgcolor=\"#708090\"><font color=\"#FEFEFE\" size=\"2\">Trace:</font></td>\r\n");
      out.write("<td bgcolor=\"#D4D9DE\"><font color=\"#000000\" size=\"3\"><pre>");
      out.print(emsg);
      out.write("</pre></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</center>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
