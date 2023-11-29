package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hbedv.upload.*;
import com.hbedv.kochbuch.*;
import com.hbedv.frame.*;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	ClientKochbuch client = (ClientKochbuch) session.getAttribute(session.getId());
	if (client == null) { 
		throw new NullPointerException("ClientKochbuch==null");
	}
	KbUpload upload = new KbUpload();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(client.getUriCssGlobal("kochbuch.css"));
      out.write("\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction refreshPic(f,pic) {\r\n");
      out.write("\t\t\tf.meinRezept.src=pic;\r\n");
      out.write("\t\t\tf.cmd.value=\"");
      out.print(TheApp.CMD_SEARCH);
      out.write("\";\r\n");
      out.write("\t\t\tf.subcmd.value=\"");
      out.print(Kochbuch.SUB_CMD_EDIT);
      out.write("\";\r\n");
      out.write("\t\t\tf.submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<title>Bilddatei-Upload</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h2>Upload Rezeptbild (max. 1 MB)</h2>\r\n");
      out.write("\r\n");
      out.write("<form action=\"upload.jsp\" name=\"upl\" enctype=\"multipart/form-data\" method=\"POST\">\r\n");
      out.write("<table>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td></td>\r\n");
      out.write("    <td></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>Bilddatei (JPG):</td>\r\n");
      out.write("    <td><input type=\"file\" name=\"myFile\" size=40 maxlength=255 class=\"kbbutton2\">\r\n");
      out.write("        <input type=\"submit\" value=\"Upload\" class=\"kbbutton2\">\r\n");
      out.write("        <input type=\"button\" onClick=\"javascript:window.close()\" value=\"Schlie&szlig;en\" class=\"kbbutton2\">\r\n");
      out.write("    </td>    \r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<br>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.print(upload.readAndShowImage( request,getServletConfig(),getServletContext(),client) );
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
