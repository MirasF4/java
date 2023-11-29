/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2019-06-05 08:51:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hbedv.frame.*;

public final class template_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"errorpage.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Client client= (Client)session.getAttribute(session.getId());
	if(client == null) throw new Exception("client == null");
	boolean mobileVersion = client.isMobileVersion();
	String subcmd = request.getParameter("subcmd");
	String idMenueNotValid = "&amp;" + TheApp.ID_MENUE + "=" + TheApp.ID_MENUE_NOT_VALID;
	String bodyFrameSrc = TheApp.encodeURL(client.getUriForm() + "?cmd="+TheApp.CMD_BODY,response) + idMenueNotValid;
	String menuFrameSrc = TheApp.encodeURL(client.getUriForm() + "?cmd="+TheApp.CMD_MENUE,response);
	String bannerFrameSrc = TheApp.encodeURL(client.getUriForm() + "?cmd="+TheApp.CMD_BANNER,response);
	String familyFrameSrc = TheApp.encodeURL(client.getUriForm() + "?cmd="+TheApp.CMD_FAMILY,response);
	
	/*
	Integer bsHeigth = client.getBsHeight();
	Integer bsWidth = client.getBsWidth();
	*/

	Integer bsWidth = new Integer(0);
	Integer bsHeigth = new Integer(0);
	int w = 0;
	int h = 0;
	if (mobileVersion) {
		bsWidth = new Integer(800);
		bsHeigth = new Integer(480);
		w = 800;
		h = 480;
	}
	else {
		bsWidth = new Integer(1152);
		bsHeigth = new Integer(864);
		w = 1152;
		h = 864;
	}
	client.setBsHeight(bsHeigth);
	client.setBsWidth(bsWidth);
		
	boolean kleinerBS = false;
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"STYLESHEET\" type=\"text/css\" href=\"css/kochbuch.css\">\r\n");
      out.write("<link rel=\"SHORTCUT ICON\" href=\"images/favicon.ico\">\r\n");
      out.write("<link rel=\"ICON\" href=\"images/favicon.ico\" type=\"image/x-icon\">\r\n");
      out.write("\r\n");
      out.write("<META NAME=\"Title\" CONTENT=\"Ullis Kochbuch\">\r\n");
      out.write("<META NAME=\"Author\" CONTENT=\"Hubert Beham\">\r\n");
      out.write("<META NAME=\"Publisher\" CONTENT=\"Hubert Beham\">\r\n");
      out.write("<META NAME=\"Copyright\" CONTENT=\"Ulrike, Michaela und Hubert Beham\">\r\n");
      out.write("<META NAME=\"Revisit\" CONTENT=\"After 10 days\">\r\n");
      out.write("<META NAME=\"Keywords\" CONTENT=\"kochen,Kochbuch,braten,backen,essen,Rezept,Zutaten,Kuchen,Kekse,Vorspeisen,Nachspeise,Desert,Hauptspeise,Gericht,Küche,Dinner,speisen,Speise,Menü,Ernährung,Ulrike Beham,Salat,Zubereitung,grillen,Griller,Fleisch,Gemüse,Brot,Obst,Torte,Ei,Tomate,Mehl,Zucker,Schokolade,schmackhaft,Kochrezept\">\r\n");
      out.write("<META NAME=\"Description\" CONTENT=\"Eine Sammlung von Ullis Kochrezepten für alle die es interessiert\">\r\n");
      out.write("<META NAME=\"Abstract\" CONTENT=\"Ullis-Kochbuch\">\r\n");
      out.write("<META NAME=\"page-topic\" CONTENT=\"Kochbuch\">\r\n");
      out.write("<META NAME=\"audience\" CONTENT=\" Alle \">\r\n");
      out.write("<META NAME=\"Robots\" CONTENT=\"INDEX,FOLLOW\">\r\n");
      out.write("<META NAME=\"Language\" CONTENT=\"Deutsch\">\r\n");
      out.write("<META NAME=\"Content-language\" content=\"DE\">\r\n");
      out.write("<META NAME=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<META NAME=\"Page-type\" content=\"Private Homepage\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>Ullis Kochbuch</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- JavaScript main -->\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("// window.opener.ok = true;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("if(top.frames.length > 0) {\r\n");
      out.write("  top.location.href= self.location.href;\r\n");
      out.write("}\r\n");
      out.write("\r\n");

	if (mobileVersion) {
	
      out.write("\r\n");
      out.write("\t\tvar width  = 800;\r\n");
      out.write("\t\tvar height = 480;\r\n");
      out.write("\t");

	}
	else {
	
      out.write("\r\n");
      out.write("\t\tvar width  = 1152;\r\n");
      out.write("\t\tvar height = 864;\r\n");
      out.write("\t");

	}
	
      out.write("\r\n");
      out.write("width = window.outerWidth;  \r\n");
      out.write("height = window.outerHeight;\r\n");
      out.write("\r\n");
      out.write("if (width > ");
      out.print(w);
      out.write(")\r\n");
      out.write("  width = ");
      out.print(w);
      out.write(";\r\n");
      out.write("\r\n");
      out.write("if (height > ");
      out.print(h);
      out.write(")\r\n");
      out.write("  height = ");
      out.print(h);
      out.write(";\r\n");
      out.write("\r\n");
      out.write("window.resizeTo(width, height);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("if (top.toolbar && top.toolbar.visible == true) {\r\n");
      out.write("\ttop.toolbar.visible = false;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("bsWidth = document.getElementById('bs_width');\r\n");
      out.write("if (bsWidth != null) {\r\n");
      out.write("\tbsWidth.value = width;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("bsHeight = document.getElementById('bs_height');\r\n");
      out.write("if (bsHeight != null) {\r\n");
      out.write("\tbsHeight.value = height; \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<meta name=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");

if (mobileVersion) {

      out.write("\r\n");
      out.write("<frameset rows=\"*\" cols=\"*\" frameborder=\"0\" border=\"0\" framespacing=\"1\">\r\n");
      out.write("\t<frameset rows=\"*\" cols=\"120,*\" framespacing=\"0\" frameborder=\"YES\" border=\"0\">\r\n");
      out.write("\t\t<frameset rows=\"*\" cols=\"*\" framespacing=\"0\" frameborder=\"yes\" border=\"0\">\r\n");
      out.write("    \t\t<frame src=\"");
      out.print(menuFrameSrc);
      out.write("\" name=\"");
      out.print(TheApp.CMD_MENUE);
      out.write("\" noresize scrolling=\"no\"> </frame>\r\n");
      out.write("\t\t</frameset>    \t    \r\n");
      out.write("\t\t<frame src=\"");
      out.print(bodyFrameSrc);
      out.write("\" name=\"");
      out.print(TheApp.CMD_BODY);
      out.write("\" noresize scrolling=\"no\"> </frame>\r\n");
      out.write("  \t</frameset>\r\n");
      out.write("</frameset>\r\n");

}
else {

      out.write("\r\n");
      out.write("<frameset rows=\"140,*\" cols=\"*\" frameborder=\"0\" border=\"0\" framespacing=\"1\">\r\n");
      out.write("\t<frame src=\"");
      out.print(bannerFrameSrc);
      out.write("\"  frameborder=\"0\" noresize name=\"");
      out.print(TheApp.CMD_BANNER);
      out.write("\" scrolling=\"no\"> </frame>\r\n");
      out.write("\t<frameset rows=\"*\" cols=\"170,*\" framespacing=\"0\" frameborder=\"YES\" border=\"0\">\r\n");
      out.write("\t\t<frameset rows=\"*\" cols=\"*\" framespacing=\"0\" frameborder=\"yes\" border=\"0\">\r\n");
      out.write("    \t\t<frame src=\"");
      out.print(menuFrameSrc);
      out.write("\" name=\"");
      out.print(TheApp.CMD_MENUE);
      out.write("\" noresize scrolling=\"no\"> </frame>\r\n");
      out.write("\t\t</frameset>    \t    \r\n");
      out.write("\t\t<frame src=\"");
      out.print(bodyFrameSrc);
      out.write("\" name=\"");
      out.print(TheApp.CMD_BODY);
      out.write("\" noresize scrolling=\"no\"> </frame>\r\n");
      out.write("  \t</frameset>\r\n");
      out.write("</frameset>\r\n");

}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<noframes>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</noframes>\r\n");
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
