package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegistrarPedido_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link  rel=\"shortcut icon\"   href=\"img/log.jpg\" type=\"image/png\" />\n");
      out.write("        <script type=\"module\" src=\"https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js\"></script>\n");
      out.write("        <script nomodule src=\"https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"path/to/font-awesome/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap\" rel=\"stylesheet\">   \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <title>Pedido</title>\n");
      out.write("        <style>\n");
      out.write("            @media print{\n");
      out.write("                .parte01,img, .btn, .accion{\n");
      out.write("                    display: none;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body{\n");
      out.write("                background:rgba(249, 225, 195, 0.3);\n");
      out.write("            }\n");
      out.write("            *{\n");
      out.write("                font-family: 'Montserrat', sans-serif;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            input[type=\"text\"], input[type=\"submit\"],input[type=\"number\"]{\n");
      out.write("                font-family: 'Montserrat', sans-serif;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: black;\n");
      out.write("                letter-spacing: 1px;\n");
      out.write("            }\n");
      out.write("            .card h1{\n");
      out.write("                font-family: 'Montserrat', sans-serif;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: black;\n");
      out.write("                letter-spacing: 1px;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 10px;\n");
      out.write("            }\n");
      out.write("            thead th:nth-child(7) {\n");
      out.write("                background-color: #414140;\n");
      out.write("                color: white;\n");
      out.write("                border-radius: 20px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <br/>\n");
      out.write("        <br/>\n");
      out.write("        <h1 style=\"text-align: center;margin-bottom: 25px;font-weight: bold;\">INGRESAR PEDIDO NUEVO</h1>\n");
      out.write("        <div class=\"d-flex\">\n");
      out.write("            <div class=\"col-lg-5 parte01\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <form id=\"generarPedido\" onSubmit=\"return validarCantidad(event);\" action=\"ControladorPedido?menu=NuevoPedido\" method=\"POST\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <!--DATOS DEL PRODUCTO-->\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Datos del Proveedor</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group d-flex\">\n");
      out.write("                                <div class=\"col-sm-6 d-flex\">\n");
      out.write("                                    <input type=\"text\" id=\"nomProveedor\" name=\"codigoproveedor\" maxlength=\"8\" minlength=\"8\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.getNom()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" placeholder=\"NOMBRE\">\n");
      out.write("                                    <button type=\"submit\" name=\"accion\" value=\"BuscarProveedor\" class=\"btn btn-outline-success\"><ion-icon name=\"search\"></ion-icon></button>\n");
      out.write("                                </div>                           \n");
      out.write("                                <div class=\"col-sm-6\">\n");
      out.write("                                    <input type=\"text\" id=\"nombreDelProveedor\" name=\"nombresproveedor\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.getNom()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Datos proveedor\" class=\"form-control\">\n");
      out.write("                                </div>                           \n");
      out.write("                            </div>\n");
      out.write("                            <!--DATOS DEL PRODUCTO-->\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Datos Producto</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"buscarProducto\" class=\"form-group d-flex\">\n");
      out.write("                                <div class=\"col-sm-6 d-flex\">\n");
      out.write("                                    <input type=\"text\" id=\"codProducto\" name=\"codigoproducto\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${producto.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" placeholder=\"Codigo\">\n");
      out.write("                                    <button type=\"submit\" name=\"accion\" value=\"BuscarProducto\" class=\"btn btn-outline-success\"><ion-icon name=\"search\"></ion-icon></button>\n");
      out.write("                                </div>                           \n");
      out.write("                                <div class=\"col-sm-6\">\n");
      out.write("                                    <input type=\"text\" name=\"nomproducto\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${producto.getNom()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Datos Producto\" class=\"form-control\">\n");
      out.write("                                </div>  \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group d-flex\">\n");
      out.write("                                <div class=\"col-sm-6 d-flex\">\n");
      out.write("                                    <input type=\"text\" name=\"precio\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${producto.getPre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" placeholder=\"S/.0.00\">                                \n");
      out.write("                                </div>                           \n");
      out.write("                                <div class=\"col-sm-3\">\n");
      out.write("                                    <input id=\"cant\" type=\"number\" value=\"1\" name=\"cant\" placeholder=\"\" class=\"form-control \">\n");
      out.write("                                </div>  \n");
      out.write("                                <div class=\"col-sm-3\">\n");
      out.write("                                    <input id=\"stock\" type=\"text\" name=\"stock\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${producto.getStock()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Stock\" class=\"form-control\">\n");
      out.write("                                </div>  \n");
      out.write("                            </div>\n");
      out.write("                            <!--BOTON AGREGAR PRODUCTO AL REGISTRO-->\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <div class=\"col-sm\">\n");
      out.write("                                    <button type=\"submit\" name=\"accion\" value=\"Agregar\" class=\"btn btn-outline-warning\">Agregar Producto</button>\n");
      out.write("                                    <button type=\"submit\" name=\"accion\" value=\"Listar\" class=\"btn btn-outline-warning\">Actualizar</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-7\">\n");
      out.write("                <div class=\"card parte02\">                    \n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>FACTURACIÓN</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"d-flex ml-auto col-sm-12\">\n");
      out.write("                            <label class=\"text-right mt-2 col-sm-6\">NRO. SERIE</label>\n");
      out.write("                            <input readonly=\"\" type=\"text\" name=\"numeroserie\" class=\"form-control text-center\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nserie}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" style=\"font-weight: bold;font-size: 18px\">\n");
      out.write("                        </div>                      \n");
      out.write("                        <br>\n");
      out.write("                        <table class=\"table table-hover\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr class=\"text-center\">\n");
      out.write("                                    <th>Nro</th>\n");
      out.write("                                    <th>IDPRODUCTO</th>\n");
      out.write("                                    <th>PRODUCTO</th>\n");
      out.write("                                    <th>PRECIO</th>\n");
      out.write("                                    <th>CANTIDAD</th>\n");
      out.write("                                    <th>SUBTOTAL</th> \n");
      out.write("                                    <th>EDITAR CANTIDAD</th>   \n");
      out.write("                                    <th class=\"accion\">ACCION</th>                                    \n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-footer\" >\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6\">\n");
      out.write("                                <a href=\"ControladorPedido?menu=NuevoPedido&accion=GenerarPedido\" onclick=\"print()\" class=\"btn btn-success\">Generar Pedido</a>\n");
      out.write("                                <input type=\"submit\" name=\"accion\" value=\"Cancelar\" class=\"btn btn-danger\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-sm-6 ml-auto d-flex\">                                \n");
      out.write("                                <label class=\" col-sm-6 text-right mt-2\">Total a Pagar</label>                                                       \n");
      out.write("                                <input type=\"text\" name=\"txtTotal\" value=\"S/. ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalpagar}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("0\" class=\"form-control text-center font-weight-bold\" style=\"font-size: 18px;\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--        </br>\n");
      out.write("                </br>\n");
      out.write("                <div class=\"d-flex\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <h1>Ventas Recientes</h1>\n");
      out.write("                            <table class=\"table table-hover\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>ID</th>\n");
      out.write("                                            <th>IDEMPLEADO</th>\n");
      out.write("                                            <th>NUMERO DE SERIE</th>\n");
      out.write("                                            <th>FECHA</th>\n");
      out.write("                                            <th>MONTO</th>    \n");
      out.write("                                            <th>ESTADO</th>\n");
      out.write("                                        </tr>\n");
      out.write("        \n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody> \n");
      out.write("        ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>-->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.js\" integrity=\"sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("                                    // Funcion para validar cantidad y stock\n");
      out.write("                                    function validarCantidad(e) {\n");
      out.write("                                        var cant = parseInt(document.getElementById(\"cant\").value);\n");
      out.write("                                        var stock = parseInt(document.getElementById(\"stock\").value);\n");
      out.write("                                        var formulario = document.getElementById(\"generarPedido\");\n");
      out.write("                                        var nomProveedor = document.getElementById(\"nomProveedor\").value;\n");
      out.write("                                        var nombreDelProveedor = document.getElementById(\"nombreDelProveedor\").value;\n");
      out.write("                                        if (stock < cant || stock == 0) {\n");
      out.write("                                            alert(\"Este producto no posee stock o la cantidad solicitada es mayor al stock disponible\");\n");
      out.write("                                            document.getElementById(\"cant\").value = \"0\";\n");
      out.write("                                            document.getElementById(\"stock\").value = \"\";\n");
      out.write("                                            document.getElementById(\"nomProveedor\").value = nomProveedor;\n");
      out.write("                                            document.getElementById(\"nombreDelProveedor\").value = nombreDelProveedor\n");
      out.write("                                            e.preventDefault();\n");
      out.write("                                            return false;\n");
      out.write("                                        } else {\n");
      out.write("                                            formulario.submit();\n");
      out.write("                                            return true;\n");
      out.write("                                        }\n");
      out.write("                                    }\n");
      out.write("        </script>\n");
      out.write("        <script src=\"js/funciones.js\" type=\"text/javascript\"></script>\n");
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
    _jspx_th_c_forEach_0.setVar("list");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lista}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <tr class=\"text-center\">\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getItem()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getIdproducto()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getDescripcionP()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getPrecio()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td><input id=\"cant\" type=\"number\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getCantidad()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name=\"cant\" placeholder=\"\" class=\"form-control\"></td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getSubtotal()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>        \n");
          out.write("                                            <input type=\"hidden\" id=\"item1\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getIdproducto()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                            <input type=\"number\" min=\"1\" max=\"10\"  id=\"Cant\" class=\" form-control text-center\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getCantidad()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                        </td>\n");
          out.write("                                        <td class=\"d-flex\">\n");
          out.write("                                            <input type=\"hidden\" id=\"item2\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.getIdproducto()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                            <a id=\"btnDeleteItem\" href=\"#\" class=\"btn btn-danger\" >Eliminar</a>\n");
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

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("em");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pedido}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            <tr>\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getIdempleado()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getNumserie()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getFecha()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getMonto()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>     \n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${em.getEstado()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>   \n");
          out.write("            </tr>\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
