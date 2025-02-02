package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String user, String dni) {
        Empleado em = new Empleado();
        String sql = "SELECT * FROM empleado WHERE User=? AND Dni=? AND Estado= 'Activo' AND Area= 'Almacen'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
                em.setArea(rs.getString("Area"));
                em.setCargo(rs.getString("Cargo"));
            }
        } catch (Exception e) {
        }
        return em;
    }

    
    public List listar(/*boolean mostrarTodo*/) {
        String sql = "select * from empleado";
//        if(!mostrarTodo){
//            sql+=" where estado = 1";
//        }
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                em.setArea(rs.getString(7));
                em.setCargo(rs.getString(8));
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    // Metodo para mostrar todos los empleados

    public int agregar(Empleado em) {
        String sql = "insert into empleado(Dni, Nombres, Telefono, Estado, User, Area, Cargo)values(?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setString(6, em.getArea());
            ps.setString(7, em.getCargo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;

    }

    public Empleado listarId(int id) {
        
        Empleado emp = new Empleado();
        String sql = "select * from empleado where IdEmpleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
                emp.setArea(rs.getString(7));
                emp.setCargo(rs.getString(8));

            }
        } catch (Exception e) {
        }
        return emp;
    }

    public int actualizar(Empleado em) {
        String sql = "update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=?, Area=?, Cargo=? where IdEmpleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setString(6, em.getArea());
            ps.setString(7, em.getCargo());
            ps.setInt(8, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "update empleado set estado = 'Inactivo' where IdEmpleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
