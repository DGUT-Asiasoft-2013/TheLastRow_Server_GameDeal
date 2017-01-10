package org.apache.jsp.WEB_002dINF.templates.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class users_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/templates/jsp/common/head.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Member Center - Staff</title>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/bootstrap/css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/private/css/admin.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\n");
      out.write("\t\t\t\t\tdata-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\"\n");
      out.write("\t\t\t\t\taria-controls=\"navbar\">\n");
      out.write("\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" href=\"#\">Member Center</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"navbar\" class=\"collapse navbar-collapse\">\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t\t\t\t\t<li><a href=\"staff\">Staff</a></li>\n");
      out.write("\t\t\t\t\t<li class=\"active\"><a href=\"#\">Users</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"feeds\">Feeds</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</nav>\n");
      out.write("\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<br/>\n");
      out.write("\t\t<div class=\"jumbotron\">\n");
      out.write("\t\t\t<h1>Users controling page.</h1>\n");
      out.write("\t\t\t<p>Here are all the registered users.</p>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<script src=\"resources/jquery/jquery-3.1.1.min.js\"></script>\n");
      out.write("\t<script src=\"resources/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
