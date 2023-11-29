package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hbedv.frame.*;

public final class template_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
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
      			"errorpage.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3.org/TR/html4/frameset.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Client client= (Client)session.getAttribute(session.getId());
	if(client == null) throw new Exception("client == null");
	String idMenueNotValid = "&amp;" + TheApp.ID_MENUE + "=" + TheApp.ID_MENUE_NOT_VALID;	
	String bodyFrameSrc = TheApp.encodeURL(client.getUriForm() + "?cmd="+TheApp.CMD_START,response) + idMenueNotValid;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"STYLESHEET\" type=\"text/css\" href=\"css/livejournal.css\">\r\n");
      out.write("<link rel=\"SHORTCUT ICON\" href=\"images/umfrage.ico\">\r\n");
      out.write("<link rel=\"ICON\" href=\"images/umfrage.ico\" type=\"image/x-icon\">\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"refresh\" content=\"0; URL=");
      out.print(bodyFrameSrc);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<META NAME=\"Title\" CONTENT=\"Umfrage LiveJournal\">\r\n");
      out.write("<META NAME=\"Author\" CONTENT=\"Michaela Beham\">\r\n");
      out.write("<META NAME=\"Publisher\" CONTENT=\"Hubert Beham\">\r\n");
      out.write("<META NAME=\"Copyright\" CONTENT=\"Michaela und Hubert Beham\">\r\n");
      out.write("<META NAME=\"Revisit\" CONTENT=\"After 10 days\">\r\n");
      out.write("<META NAME=\"Keywords\" CONTENT=\"LiveJournal, Umfrage\">\r\n");
      out.write("<META NAME=\"Description\" CONTENT=\"Umgrage für die Diplomarbeit von Michaela Beham\">\r\n");
      out.write("<META NAME=\"Abstract\" CONTENT=\"LiveJournal\">\r\n");
      out.write("<META NAME=\"page-topic\" CONTENT=\"LiveJournal\">\r\n");
      out.write("<META NAME=\"audience\" CONTENT=\" Alle \">\r\n");
      out.write("<META NAME=\"Robots\" CONTENT=\"INDEX,FOLLOW\">\r\n");
      out.write("<META NAME=\"Language\" CONTENT=\"Deutsch\">\r\n");
      out.write("<META NAME=\"Content-language\" content=\"DE\">\r\n");
      out.write("<META NAME=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<META NAME=\"Page-type\" content=\"Private Homepage\">\r\n");
      out.write("\r\n");
      out.write("<META HTTP-EQUIV=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<META HTTP-EQUIV=\"expires\" content=\"0\">\r\n");
      out.write("<META HTTP-EQUIV=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n");
      out.write("<META HTTP-EQUIV=\"Content-Script-Type\" content=\"text/javascript\">\r\n");
      out.write("<META HTTP-EQUIV=\"Content-Style-Type\" content=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>LiveJournal</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- JavaScript main -->\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n");
      out.write("<meta name=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
