/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Registro;
import Modelo.RegistroDAO;
import Modelo.Pedido;
import Modelo.PedidoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus
 */
public class ControladorRegistro extends HttpServlet {

    Registro reg = new Registro();
    RegistroDAO regao = new RegistroDAO();
    int ide;
    int idpro; //proveedor
    int idp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Registro")) {
            switch (accion) {
                case "Listar":
                    try {
                        List lista = regao.listar();
                        request.setAttribute("registros", lista);
                    } catch (Exception e) {
                    }                   
                    break;
                case "Editar":
                    try {
                        idpro = Integer.parseInt(request.getParameter("id"));
                        Registro pd = regao.listarId(idpro);
                        request.setAttribute("registro", pd);
                    } catch (Exception e) {
                    }                   
                    request.getRequestDispatcher("ControladorRegistro?menu=Registro&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    try {
                        idpro = Integer.parseInt(request.getParameter("id"));
                        regao.delete(idpro);
                    } catch (Exception e) {
                    }
                    
                    request.getRequestDispatcher("ControladorRegistro?menu=Registro&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Registro.jsp").forward(request, response);
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
