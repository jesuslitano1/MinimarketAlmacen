/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ubicacion;
import Modelo.UbicacionDAO;
import Modelo.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorUbicacion extends HttpServlet {

    Ubicacion ubi=new Ubicacion();
    UbicacionDAO ubidao=new UbicacionDAO();
    
    int ide; 
    int idc; 
    int idp; 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Ubicacion")) {
            switch (accion) {
                case "Listar":
                    try {
                        List lista = ubidao.listar();
                        request.setAttribute("ubicaciones", lista);
                    } catch (Exception e) {
                    }
                    
                    break;
                case "Agregar":
                    try {
                        //int id = Integer.parseInt(request.getParameter("txtid"));
                        String nom = request.getParameter("txtNombre");
                        //ubi.setId(id);
                        ubi.setNom(nom);
                        ubidao.agregar(ubi);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al agregar nueva ubicacion");
                    }
                    
                    request.getRequestDispatcher("ControladorUbicacion?menu=Ubicacion&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    try {
                        idc = Integer.parseInt(request.getParameter("id"));
                        Ubicacion ub = ubidao.listarId(idc);
                        request.setAttribute("ubicacion", ub);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al obtener los datos de la ubicacion seleccionada");
                    }
                    
                    request.getRequestDispatcher("ControladorUbicacion?menu=Ubicacion&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    try {
                        //int id1 = Integer.parseInt(request.getParameter("txtid"));
                        String nom1 = request.getParameter("txtNombre");
                        //ubi.setId(id1);
                        ubi.setNom(nom1);
                        ubi.setId(idc);
                        ubidao.actualizar(ubi);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al actualizar los datos de la ubicacion seleccionada");
                    }
                    
                    request.getRequestDispatcher("ControladorUbicacion?menu=Ubicacion&accion=Listar").forward(request, response);
                    break;
                    
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Ubicacion.jsp").forward(request, response);
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
