package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Proveedor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("        <link  rel=\"shortcut icon\"   href=\"img/log.jpg\" type=\"image/png\" />\n");
      out.write("        <script src=\"js/BuscadorTabla.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <title>Proveedor</title>\n");
      out.write("        <style>\n");
      out.write("            @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap');\n");
      out.write("            *{\n");
      out.write("                font-family: 'Montserrat', sans-serif;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                background-color: #DCF0E9;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            input[type=\"text\"], input[type=\"submit\"]{\n");
      out.write("                font-family: 'Montserrat', sans-serif;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: black;\n");
      out.write("                letter-spacing: 1px;\n");
      out.write("            }\n");
      out.write("            .buscar{\n");
      out.write("                display: flex;\n");
      out.write("                padding-bottom: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form{\n");
      out.write("                display: flex;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <br/>\n");
      out.write("        <br/>\n");
      out.write("        <div class=\"d-flex\">\n");
      out.write("            <div class=\"col-sm-4\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <form action=\"ControladorProveedor?menu=Proveedor\" method=\"POST\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>DATOS DEL PROVEEDOR</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Correo</label>\n");
      out.write("                                <input type=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${proveedor.getMail()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"txtCorreo\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Nombre</label>\n");
      out.write("                                <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${proveedor.getNom()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"txtNombres\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>RUC</label>\n");
      out.write("                                <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${proveedor.getRuc()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"txtRuc\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Telefono</label>\n");
      out.write("                                <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${proveedor.getTel()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"txtTelefono\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Direccion</label>\n");
      out.write("                                <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${proveedor.getDir()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"txtDireccion\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Estado</label>\n");
      out.write("                                <select value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${proveedor.getEs()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"txtEstado\" class=\"form-control\">\n");
      out.write("                                    <option value=\"Activo\">Activo</option>\n");
      out.write("                                    <option value=\"Inactivo\">Inactivo</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div> \n");
      out.write("                            <div class=\"text-center\">\n");
      out.write("                                <input type=\"submit\" name=\"accion\" value=\"Agregar\" class=\"btn btn-outline-warning\">\n");
      out.write("                                <input type=\"submit\" name=\"accion\" value=\"Actualizar\" class=\"btn btn-outline-warning\">\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>                         \n");
      out.write("                </div>\n");
      out.write("            </div>                     \n");
      out.write("            <div class=\"col-sm-8\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <label style=\"background: #B6E7D8; padding: 10px; border-radius: 15px;color:black;\" >BUSCAR: </label>\n");
      out.write("                        <input style=\"border-radius: 5px;padding:5px;\" id=\"searchTerm\" type=\"text\" onkeyup=\"doSearch()\" />\n");
      out.write("                        <div class=\"datagrid\">\n");
      out.write("                        <table class=\"table table-hover\" id=\"datos\">\n");
      out.write("                            <thead Class=\"thead\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>ID</th>\n");
      out.write("                                    <th>CORREO</th>\n");
      out.write("                                    <th>NOMBRE</th>\n");
      out.write("                                    <th>RUC</th>\n");
      out.write("                                    <th>Telefono</th>\n");
      out.write("                                    <th>DIRECCION</th>\n");
      out.write("                                    <th>ESTADO</th>    \n");
      out.write("                                    <th>ACCIONES</th>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody> \n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>                  \n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("em");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${proveedores}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <tr>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getMail()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getNom()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getRuc()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getTel()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getDir()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getEs()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>                                      \n");
          out.write("                                        <td>\n");
          out.write("                                            <a class=\"btn btn-warning\" href=\"ControladorProveedor?menu=Proveedor&accion=Editar&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Editar</a>\n");
          out.write("                                            <a class=\"btn btn-danger\" href=\"ControladorProveedor?menu=Proveedor&accion=Delete&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Eliminar</a>\n");
          out.write("                                        </td>\n");
          out.write("                                    </tr>\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
