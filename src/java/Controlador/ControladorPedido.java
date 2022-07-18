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
public class ControladorPedido extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Proveedor pro = new Proveedor();
    ProveedorDAO prodao = new ProveedorDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idpro;
    int idp;
    int idprov;
    
    Pedido pe = new Pedido();
    Pedido idpe = new Pedido();
    List<Pedido> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;

    String numeroserie;
    PedidoDAO pedao = new PedidoDAO();

    Detalle dpe = new Detalle();
    DetalleDAO dpedao = new DetalleDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("NuevoPedido")) {
            switch (accion) {

                case "BuscarProveedor":
                    try {
                        int idpro = Integer.parseInt(request.getParameter("codigoproveedor"));
                        pro.setId(idpro);
                        pro = prodao.buscar(idpro);
                        request.setAttribute("proveedor", pro);
                        request.setAttribute("nserie", numeroserie);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Proveedor no encontrado");
                    }
                     
                    break;
                    
                case "BuscarProducto":
                    try {
                        int id = Integer.parseInt(request.getParameter("codigoproducto"));
                        p = pdao.listarId(id);
                        request.setAttribute("proveedor", pro);
                        request.setAttribute("producto", p);
                        request.setAttribute("lista", lista);
                        request.setAttribute("totalpagar", totalPagar);
                        request.setAttribute("nserie", numeroserie);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Producto no encontrado");
                    }
                    
                    break;
                    
                case "Listar":
                    try {
                         request.setAttribute("nserie", numeroserie);
                        request.setAttribute("proveedor", pro);
                        totalPagar = 0.0;
                        item = item + 1;
                        subtotal = precio * cant;
                        for (int i = 0; i < lista.size(); i++) {
                            totalPagar = totalPagar + lista.get(i).getSubtotal();
                        }
                        request.setAttribute("totalpagar", totalPagar);
                        request.setAttribute("lista", lista);
                    } catch (Exception e) {
                    }
                   
                    break;
                    
                case "Delete":
                    try {
                        int idProducto = Integer.parseInt(request.getParameter("id"));
                        if (lista != null) {
                            for (int i = 0; i < lista.size(); i++) {
                                if (lista.get(i).getIdproducto() == idProducto) {
                                    lista.remove(i);
                                }
                            }
                        }
                        request.setAttribute("lista", lista);
                    } catch (Exception e) {
                    }
                    
                    break;               
                case "updateCantidad":
                    try {
                        int idProducto = Integer.parseInt(request.getParameter("id"));
                        int cant = Integer.parseInt(request.getParameter("cantidad"));
                        for (int i = 0; i < lista.size(); i++) {
                            if (lista.get(i).getIdproducto() == idProducto) {
                                lista.get(i).setCantidad(cant);
                                lista.get(i).setSubtotal(lista.get(i).getPrecio() * cant);
                            }
                        }
                    } catch (Exception e) {
                    }
                    
                    break;
                case "Agregar":
                    try {
                        request.setAttribute("nserie", numeroserie);
                        request.setAttribute("proveedor", pro);
                        totalPagar = 0.0;
                        item = item + 1;
                        cod = p.getId();
                        descripcion = request.getParameter("nomproducto");
                        precio = Double.parseDouble(request.getParameter("precio"));
                        cant = Integer.parseInt(request.getParameter("cant"));
                        subtotal = precio * cant;
                        pe = new Pedido();
                        pe.setItem(item);
                        pe.setIdproducto(cod);
                        pe.setDescripcionP(descripcion);
                        pe.setPrecio(precio);
                        pe.setCantidad(cant);
                        pe.setSubtotal(subtotal);
                        lista.add(pe);
                        for (int i = 0; i < lista.size(); i++) {
                            totalPagar = totalPagar + lista.get(i).getSubtotal();
                        }
                        request.setAttribute("totalpagar", totalPagar);
                        request.setAttribute("lista", lista);
                    } catch (Exception e) {
                    }
                    
                    
                    break;                       
                case "GenerarPedido":
                    
                    //Actualizacion del Stock parte separada 
                    //for (int i = 0; i < lista.size(); i++) {
                        //Producto pr = new Producto();
                        //int cantidad = lista.get(i).getCantidad();
                        //int idproducto = lista.get(i).getIdproducto();
                        //ProductoDAO aO = new ProductoDAO();
                        //pr = aO.buscar(idproducto);
                        //int sac = pr.getStock() + cantidad;
                        //aO.actualizarstock(idproducto, sac);
                    //}
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
  
                    //Guardar pedido                                         
                    pe.setIdproveedor(pro.getId());
                    pe.setRuc(pro.getRuc());
                    pe.setIdempleado(1);
                    pe.setNumserie(numeroserie);
                    pe.setFecha(dtf.format(LocalDateTime.now()));
                    pe.setMonto(totalPagar);
                    pe.setEstado("Valido");
                    pedao.guardarPedido(pe);
//                    //Guardar Detalle pedido

                    idpe = pedao.ultimoID();
                    int ultimoId = idpe.getId();

                    for (int i = 0; i < lista.size(); i++) {
                        try {
                            int idproducto = lista.get(i).getIdproducto();
                            String DescripcionP = lista.get(i).getDescripcionP();
                            int cantidad = lista.get(i).getCantidad();
                            double precio = lista.get(i).getPrecio();
                            pe = new Pedido();
                            pe.setId(ultimoId);
                            pe.setIdproducto(idproducto);
                            pe.setDescripcionP(DescripcionP);
                            pe.setCantidad(cantidad);
                            pe.setPrecio(precio);
                            pedao.guardarDetallepedido(pe);
                        } catch (Exception e) {
                            System.out.println("error" + e);
                        }

                    }
                    lista = new ArrayList<>();
                    break;                    
                default:
                    pe = new Pedido();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar = 0.0;
                    numeroserie = pedao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "000000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarPedido.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarPedido.jsp").forward(request, response);
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
