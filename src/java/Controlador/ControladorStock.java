package Controlador;

import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Pedido;
import Modelo.PedidoDAO;
import Modelo.Detalle;
import Modelo.DetalleDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 
 */
public class ControladorStock extends HttpServlet {

    
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idpro;
    int idp;


    List<Detalle> detalles = new ArrayList<>();
    
    int item;
    int cod;
    int cant;

    PedidoDAO pedao = new PedidoDAO();

    Detalle dpe = new Detalle();
    DetalleDAO dpedao = new DetalleDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Stock")) {
            switch (accion) {
                
                case "AumentarStock":
                    try {
                        //Actualizacion del Stock                   
                        Detalle dt = new Detalle();
                        int iddetalle = Integer.parseInt(request.getParameter("id"));
                        DetalleDAO dp = new DetalleDAO();
                        dt = dp.buscar(iddetalle);
                        
                        Producto pr = new Producto();  
                        int idproducto = dt.getIdproducto();
                        ProductoDAO aO = new ProductoDAO();
                        pr = aO.buscar(idproducto);                 
                        int pac = pr.getStock() + dt.getCantidad();
                        aO.actualizarstock(idproducto, pac);
                        //listar
                        int idpedido = dt.getIdpedido();
                        List lista = dpedao.listar(idpedido);
                        request.setAttribute("detalles", lista);
                        
                    } catch (Exception e) {
                    }
                
                    
                        request.getRequestDispatcher("Detalle.jsp").forward(request, response);
                    
                    break;                    
                
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
