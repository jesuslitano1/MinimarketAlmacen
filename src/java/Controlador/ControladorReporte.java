/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Jesus
 */
public class ControladorReporte extends HttpServlet {

    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idc;
    int idp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Reporte1")) {
            switch (accion) {
                case "Listar1":
                    List lista = pdao.listar1();
                    request.setAttribute("productos", lista);
                    break;
                    
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("ReporteTop.jsp").forward(request, response);
        }
        if (menu.equals("Reporte2")) {
            switch (accion) {
                case "Listar2":
                    List lista = pdao.listar2();
                    request.setAttribute("productos", lista);
                    break;
                    
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Reporte01PP.jsp").forward(request, response);
        }
        if (menu.equals("Reporte3")) {
            switch (accion) {
                case "Listar3":
                    List lista = pdao.listar3();
                    request.setAttribute("productos", lista);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Reporte02PNP.jsp").forward(request, response);
        }
        if (menu.equals("Reporte4")) {
            switch (accion) {
                case "Listar4":
                    List lista = pdao.listar4();
                    request.setAttribute("productos", lista);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Reporte03PD.jsp").forward(request, response);
        }
        if (menu.equals("Reporte5")) {
            switch (accion) {
                case "Listar5":
                    List lista = pdao.listar5();
                    request.setAttribute("productos", lista);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Reporte04PND.jsp").forward(request, response);
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
