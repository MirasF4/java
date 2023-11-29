package org.apache.jsp.jsp.kochbuch;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hbedv.kochbuch.*;
import com.hbedv.frame.*;
import com.hbedv.db.kochbuch.KochbuchBean;

public final class print_005frezept_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/jsp/kochbuch/import.jsp");
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
	ClientKochbuch client= (ClientKochbuch)request.getAttribute("com.hbedv.client");
	KochbuchManager manager = (KochbuchManager) client.getManager();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(client.getUriCssGlobal("print_kochbuch.css"));
      out.write("\" type=\"text/css\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n");
      out.write("<title>Kochbuch</title>\r\n");
      out.write("\r\n");
      out.write("<script language=\"JavaScript\" type=\"text/JavaScript\">\r\n");
      out.write("onload = function() {\r\n");
      out.write("\twindow.print();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function resizeApp() {\r\n");
      out.write("\t/*\r\n");
      out.write("\tvar pic1 = document.getElementById('pic1');\r\n");
      out.write("\tvar pKom = document.getElementById('pKom');\r\n");
      out.write("\tvar rect = pKom.getBoundingClientRect();\r\n");
      out.write("\tvar e = rect.top;\r\n");
      out.write("\tpic1.position = \"absolute\";\r\n");
      out.write("\tpic1.top = e;\r\n");
      out.write("\t*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>\r\n");
      out.write("<form name=\"BodyFormPrint\" method=\"post\" action=\"");
      out.print(TheApp.encodeURL(client.getUriForm(), response));
      out.write("\" target=\"PrintRezept\">\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t<table width=\"90%\" border=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"90px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"100%\" height=\"60px\" align=\"left\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t<table width=\"100%\" border=\"0\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<em>\r\n");
      out.write("\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t<font size=\"6\" face=\"Sylfaen\" style=\"position:relative;top:+8px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(manager.getRezeptName());
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t</em>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"4\" face=\"Sylfaen\" style=\"position:relative;top:+8px;\">\r\n");
      out.write("\t\t\t\t\t\t\t(");
      out.print(manager.getMenueBez());
      out.write(")&nbsp;\r\n");
      out.write("\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"90px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<p style=\"border-width:0px;padding:2px;background-color:silver;height:28px;width:450px;position:relative;top:-2px;text-align:left;\">\r\n");
      out.write("\t\t\t\t\t\t\t<font size=\"5\" face=\"Sylfaen\" style=\"position:relative;top:+2px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;Zutaten\r\n");
      out.write("\t\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<p style=\"border-width:0px;padding:2px;background-color:silver;height:28px;width:440px;position:relative;top:-2px;text-align:left;\">\r\n");
      out.write("\t\t\t\t\t\t\t<font size=\"5\" face=\"Sylfaen\" style=\"position:relative;top:+2px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;Zubereitung\r\n");
      out.write("\t\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"90px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"position:relative;top:-16px;\">\r\n");
      out.write("\t\t\t\t\t\t<table style=\"width:452px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th width=\"30px\" style=\"text-align:center;\">Anzahl</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th width=\"30px\" style=\"text-align:left;\">Einheit</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th style=\"text-align:left;\">Zutaten</th>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t");

							AliceSortMap zutatenListe = manager.getZutaten();
							for (int index=0;index<zutatenListe.getSize();index++) {
								String anzStr = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_ANZAHL).get(index);
								String einheit = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_EINHEIT).get(index);
								String zutaten = (String) zutatenListe.getKeys(KochbuchBean.AsmZutaten.KEY_BEZ).get(index);
								
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"30px\" align=\"center\">");
      out.print(anzStr);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"30px\">");
      out.print(einheit);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>");
      out.print(zutaten);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

							}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td rowspan=\"2\" valign=\"top\" style=\"position:relative;top:-34px;\">\r\n");
      out.write("\t\t\t\t\t\t<table width=\"90%\" valign=\"top\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:left;\" valign=\"top\"\">\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<pre class=\"kb\">");
      out.print(manager.getZubereitung());
      out.write("</pre>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\t\t\t\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"90px\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p id = \"pKom\" style=\"border-width:0px;padding:2px;background-color:silver;height:28px;width:230px;position:relative;top:-16px;text-align:left;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<font size=\"5\" face=\"Sylfaen\" style=\"position:relative;top:2px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;Kommentar\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 
								int topPic = 0;
								if (client.isMobileVersion()) topPic = -22;
								int topKom = -46;
								if (client.isMobileVersion()) topKom = -46;
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<td valign=\"top\" rowspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;<img id=\"pic1\" src=\"");
      out.print(manager.getPicName());
      out.write("\" width=\"210px\" height=\"188px\" ALT=\"\" style=\"position:relative;top:");
      out.print(topPic);
      out.write("px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr valign=\"top\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:left;width:210px;position:relative;top:");
      out.print(topKom);
      out.write("px;\">\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<pre class=\"kb\">");
      out.print(manager.getKommentar());
      out.write("</pre>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\r\n");
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
