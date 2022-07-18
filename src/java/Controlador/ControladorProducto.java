package Controlador;

import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class ControladorProducto extends HttpServlet {
    
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idc;
    int idp;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    try {
                        String nom = request.getParameter("txtNombre");
                        double pre = Double.parseDouble(request.getParameter("txtPrecio"));
                        String med = request.getParameter("txtMedida");
                        int st = Integer.parseInt(request.getParameter("txtStock"));
                        String est = request.getParameter("txtEstado");
                        int idcat = Integer.parseInt(request.getParameter("txtCategoria"));
                        int idubi = Integer.parseInt(request.getParameter("txtUbicacion"));
                        String tipo = request.getParameter("txtTipo");
                        p.setNom(nom);
                        p.setPre(pre);
                        p.setMed(med);
                        p.setStock(st);
                        p.setEstado(est);
                        p.setIdcat(idcat);
                        p.setIdubi(idubi);
                        p.setTipo(tipo);
                        pdao.agregar(p);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al agregar el producto");
                    }
                    request.getRequestDispatcher("ControladorProducto?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    try {
                        idp = Integer.parseInt(request.getParameter("id"));
                        Producto pr = pdao.listarId(idp);
                        request.setAttribute("producto", pr);
                        
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al obtener los datos del producto seleccionado");
                    }
                    
                    request.getRequestDispatcher("ControladorProducto?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    try {
                        String nom1 = request.getParameter("txtNombre");
                        double pre1 = Double.parseDouble(request.getParameter("txtPrecio"));
                        String med1 = request.getParameter("txtMedida");
                        int st1 = Integer.parseInt(request.getParameter("txtStock"));
                        String est1 = request.getParameter("txtEstado");
                        int idcat1 = Integer.parseInt(request.getParameter("txtCategoria"));
                        int idubi1 = Integer.parseInt(request.getParameter("txtUbicacion"));
                        String tipo1 = request.getParameter("txtTipo");
                        p.setNom(nom1);
                        p.setPre(pre1);
                        p.setMed(med1);
                        p.setStock(st1);
                        p.setEstado(est1);
                        p.setIdcat(idcat1);
                        p.setIdubi(idubi1);
                        p.setTipo(tipo1);
                        p.setId(idp);
                        pdao.actualizar(p);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al actualizar datos del producto seleccionado");
                    }
                    request.getRequestDispatcher("ControladorProducto?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    try {
                        idp = Integer.parseInt(request.getParameter("id"));
                        pdao.delete(idp);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al eliminar el producto seleccionado");
                    }                    
                    request.getRequestDispatcher("ControladorProducto?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:                    
                    throw new AssertionError();
            }
            
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
