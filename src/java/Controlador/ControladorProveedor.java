/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorProveedor extends HttpServlet {

    Proveedor pro = new Proveedor();
    ProveedorDAO prodao = new ProveedorDAO();
    int ide;
    int idc;
    int idp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Proveedor")) {
            switch (accion) {
                case "Listar":
                    List lista = prodao.listar();
                    request.setAttribute("proveedores", lista);
                    break;
                case "Agregar":
                    try {
                        String mail = request.getParameter("txtCorreo");
                        String nom = request.getParameter("txtNombres");
                        String ruc = request.getParameter("txtRuc");
                        String tel = request.getParameter("txtTelefono");
                        String dir = request.getParameter("txtDireccion");
                        String est = request.getParameter("txtEstado");
                        pro.setMail(mail);
                        pro.setNom(nom);
                        pro.setRuc(ruc);
                        pro.setTel(tel);
                        pro.setDir(dir);
                        pro.setEs(est);
                        prodao.agregar(pro);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al agregar proveedor nuevo");
                    }
                    
                    request.getRequestDispatcher("ControladorProveedor?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    try {
                        idc = Integer.parseInt(request.getParameter("id"));
                        Proveedor pd = prodao.listarId(idc);
                        request.setAttribute("proveedor", pd);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al obtener los datos del proveedor seleccionado");
                    }
                    
                    request.getRequestDispatcher("ControladorProveedor?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    try {
                        String mail1 = request.getParameter("txtCorreo");
                        String nom1 = request.getParameter("txtNombres");
                        String ruc1 = request.getParameter("txtRuc");
                        String tel1 = request.getParameter("txtTelefono");
                        String dir1 = request.getParameter("txtDireccion");
                        String est1= request.getParameter("txtEstado");
                        pro.setMail(mail1);
                        pro.setNom(nom1);
                        pro.setRuc(ruc1);
                        pro.setTel(tel1);
                        pro.setDir(dir1);
                        pro.setEs(est1);
                        pro.setId(idc);
                        prodao.actualizar(pro);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al actualizar datos del proveedor seleccionado");
                    }
                    
                    request.getRequestDispatcher("ControladorProveedor?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    try {
                        idc = Integer.parseInt(request.getParameter("id"));
                        prodao.delete(idc);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al eliminar al proveedor seleccionado");
                    }
                    
                    request.getRequestDispatcher("ControladorProveedor?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
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
