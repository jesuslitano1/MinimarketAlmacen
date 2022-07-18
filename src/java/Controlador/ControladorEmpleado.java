package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 
 */
public class ControladorEmpleado extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    int ide;
    int idc;
    int idp;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    try {
                        String dni = request.getParameter("txtDni");
                        String nom = request.getParameter("txtNombres");
                        String tel = request.getParameter("txtTel");
                        String est = request.getParameter("txtEstado");
                        String user = request.getParameter("txtUser");
                        String area = request.getParameter("txtArea");
                        String cargo = request.getParameter("txtCargo");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);
                        em.setArea(area);
                        em.setCargo(cargo);
                        edao.agregar(em);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al agregar empleado nuevo");
                    }
                    
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    try {
                        ide = Integer.parseInt(request.getParameter("id"));
                        Empleado e = edao.listarId(ide);
                        request.setAttribute("empleado", e);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al obtener los datos del empleado seleccionado");
                    }
                    
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    try {
                        String dni1 = request.getParameter("txtDni");
                        String nom1 = request.getParameter("txtNombres");
                        String tel1 = request.getParameter("txtTel");
                        String est1 = request.getParameter("txtEstado");
                        String user1 = request.getParameter("txtUser");
                        String area1 = request.getParameter("txtArea");
                        String cargo1 = request.getParameter("txtCargo");
                        em.setDni(dni1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEstado(est1);
                        em.setUser(user1);
                        em.setArea(area1);
                        em.setCargo(cargo1);
                        em.setId(ide);
                        edao.actualizar(em);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error actualizar los datos del empleado seleccionado");
                    }
                    
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    try {
                        ide = Integer.parseInt(request.getParameter("id"));
                        edao.delete(ide);
                    } catch (Exception e) {
                        request.setAttribute("Error", "Error al eliminar al empleado seleccionado");
                    }
                    
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
    }
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
