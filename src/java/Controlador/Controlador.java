package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado em = new Empleado();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
           
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Proveedor")) {
           
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        
        if (menu.equals("NuevoPedido")) {
            request.getRequestDispatcher("RegistrarPedido.jsp").forward(request, response);
        }
        if (menu.equals("Registro")) {
            request.getRequestDispatcher("Registro.jsp").forward(request, response);
        }
        if (menu.equals("Ubicacion")) {
            request.getRequestDispatcher("Ubicacion.jsp").forward(request, response);
        }
        if (menu.equals("Detalle")) {
            request.getRequestDispatcher("Detalle.jsp").forward(request, response);
        }
        if (menu.equals("Reporte1")) {
            request.getRequestDispatcher("ReporteTop.jsp").forward(request, response);
        }
        if (menu.equals("Reporte2")) {
            request.getRequestDispatcher("Reporte01PP.jsp").forward(request, response);
        }
        if (menu.equals("Reporte3")) {
            request.getRequestDispatcher("Reporte02PNP.jsp").forward(request, response);
        }
        if (menu.equals("Reporte4")) {
            request.getRequestDispatcher("Reporte03PD.jsp").forward(request, response);
        }
        if (menu.equals("Reporte5")) {
            request.getRequestDispatcher("Reporte04PND.jsp").forward(request, response);
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
