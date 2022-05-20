package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Page_005fAddBook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Page_Navigation.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Page_Add.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/addjs.js\"></script>\n");
      out.write("        <title>Add Book Page</title>\n");
      out.write("        <script src=\"js/admin.js\"></script>\n");
      out.write("         <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("          <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <link href=\"css/Page_Admin.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/validateAddUpdateForm.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"navigation\">\n");
      out.write("                <ul>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"adminController\">\n");
      out.write("                            <span class=\"icon\">\n");
      out.write("                                <i class=\"fa fa-book\" aria-hidden=\"true\"></i>\n");
      out.write("                            </span>\n");
      out.write("                            <span class=\"title\"><h2>Admin System</h2></span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"adminController\">\n");
      out.write("                            <span class=\"icon\">\n");
      out.write("                                <i class=\"fa fa-home\" aria-hidden=\"true\"></i>\n");
      out.write("                            </span>\n");
      out.write("                            <span class=\"title\">Dashboard</span>\n");
      out.write("                        </a>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"addBook\"><span class=\"icon\">\n");
      out.write("                                <i class=\"fa fa-plus\" aria-hidden=\"true\"></i>\n");
      out.write("                            </span>\n");
      out.write("                            <span class=\"title\">Add Book</span></a>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"u1\"><span class=\"icon\">\n");
      out.write("                                <i class=\"fa fa-pencil\" aria-hidden=\"true\"></i>\n");
      out.write("                            </span>\n");
      out.write("                            <span class=\"title\">Edit Book</span>\n");
      out.write("                        </a>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                   \n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"LogoutController\"> <span class=\"icon\">\n");
      out.write("                                <i class=\"fa fa-sign-out\" aria-hidden=\"true\"></i>\n");
      out.write("                            </span>\n");
      out.write("                            <span class=\"title\">Signout</span>\n");
      out.write("                        </a>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <div class=\"row d-flex justify-content-center\">\n");
      out.write("                <div class=\"col-xl-7 col-lg-8 col-md-9 col-11 text-center\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <h5 class=\"text-center mb-4\">Add</h5>\n");
      out.write("                        <form  class=\"form-card contact-forms\" name=\"add-form\" id=\"formAU\" method=\"POST\" action=\"addBook\">\n");
      out.write("                            <div class=\"row justify-content-between text-left\">\n");
      out.write("                                <div class=\"form-group col-sm-6 flex-column d-flex vali\"> <label class=\"form-control-label px-3\">Book Title<span class=\"text-danger\"> *</span></label> \n");
      out.write("                                    <input type=\"text\" id=\"title\" name=\"title\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bookTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Enter book title\" onblur=\"validate(1)\"> \n");
      out.write("                                    <div class=\"form-mess\"></div>\n");
      out.write("                                    <span class=\"text-danger\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${exitBook}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-sm-6 flex-column d-flex vali\"> \n");
      out.write("                                    <label class=\"form-control-label px-3\">Author<span class=\"text-danger\"> *</span></label> \n");
      out.write("                                    <input type=\"text\" id=\"author\" name=\"author\" placeholder=\"Enter book author\" onblur=\"validate(2)\"> \n");
      out.write("                                    <div class=\"form-mess\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row justify-content-between text-left\">\n");
      out.write("                                <div class=\"form-group col-sm-6 flex-column d-flex vali\"> \n");
      out.write("                                    <label class=\"form-control-label px-3\">Publisher<span class=\"text-danger\"> *</span></label> \n");
      out.write("                                    <input type=\"text\" id=\"publisher\" name=\"publisher\" placeholder=\"Enter book publisher\" onblur=\"validate(3)\"> \n");
      out.write("                                    <div class=\"form-mess\"></div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-sm-6 flex-column d-flex vali\"> \n");
      out.write("                                    <label class=\"form-control-label px-3\">Category<span class=\"text-danger\"> *</span></label>\n");
      out.write("                                    <input type=\"text\" id=\"category\" name=\"category\" placeholder=\"Enter book category\" onblur=\"validate(10)\">\n");
      out.write("                                    <div class=\"form-mess\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row justify-content-between text-left\">\n");
      out.write("                                <div class=\"form-group col-12 flex-column d-flex vali\"> \n");
      out.write("                                    <label class=\"form-control-label px-3\">Content<span class=\"text-danger\"> *</span></label> \n");
      out.write("                                    <textarea id=\"content\" name=\"content\" placeholder=\"\" onblur=\"validate(5)\"></textarea>\n");
      out.write("                                    <div class=\"form-mess\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row justify-content-between text-left\">\n");
      out.write("                                <div class=\"form-group col-12 flex-column d-flex vali\"> \n");
      out.write("                                    <label class=\"form-control-label px-3\">Brief<span class=\"text-danger\"> *</span></label> \n");
      out.write("                                    <textarea id=\"brief\" name=\"brief\" placeholder=\"\" onblur=\"validate(6)\"></textarea>\n");
      out.write("                                    <div class=\"form-mess\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row justify-content-between text-left\">\n");
      out.write("                                <div class=\"form-group col-12 flex-column d-flex vali\"> \n");
      out.write("                                    <label class=\"form-control-label px-3\">Image<span class=\"text-danger\"> *</span></label> \n");
      out.write("                                    <input type=\"file\" id=\"image\" name=\"image\" placeholder=\"Enter image URL\"> \n");
      out.write("                                    <div class=\"form-mess\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row justify-content-end\">\n");
      out.write("                                <div class=\"form-group col-sm-6\"> <button type=\"submit\" class=\"btn-block btn-primary\">Add</button> </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                                <script src=\"https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${successAd != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <p style=\"color: green; font-size: 25px\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${successAd}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
