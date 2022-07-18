package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String GenerarSerie() {
        String numeroserie = "";
        String sql = "select max(NumeroSerie) from pedido";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroserie = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return numeroserie;
    }

    public String IdPedido() {
        String idpedido = "";
        String sql = "select ifnull(max(IdPedido), 0) from pedido";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idpedido = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idpedido;
    }

    public int actualizar(Pedido pe){
        String sql="update pedido set IdProveedor=?, Ruc=?, idEmpleado=?, NumeroSerie=?,FechaPedido=?, Monto=?, Estado=? where IdPedido=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, pe.getIdproveedor());
            ps.setString(2, pe.getRuc());
            ps.setInt(3, pe.getIdempleado());
            ps.setString(4, pe.getNumserie());
            ps.setString(5, pe.getFecha());           
            ps.setDouble(6, pe.getMonto());
            ps.setString(7, pe.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public int guardarPedido(Pedido pe) {
        String sql;
        sql = "INSERT INTO Pedido(IdProveedor,Ruc,IdEmpleado,NumeroSerie,FechaPedido,Monto,Estado)VALUES(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pe.getIdproveedor());
            ps.setString(2, pe.getRuc());
            ps.setInt(3, pe.getIdempleado());
            ps.setString(4, pe.getNumserie());
            ps.setString(5, pe.getFecha());
            ps.setDouble(6, pe.getMonto());
            ps.setString(7, pe.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    public int guardarDetallepedido(Pedido pedido) {
        String sql = "insert into detalle_pedido(IdPedido, IdProducto, NomProducto, Cantidad, PrecioTotal)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getId());
            ps.setInt(2, pedido.getIdproducto());
            ps.setString(3, pedido.getDescripcionP());
            ps.setInt(4, pedido.getCantidad());
            ps.setDouble(5, pedido.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return r;
    }

    public void delete(int id) {
        String sql = "update pedido set estado = 'Anulado' where IdPedido=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
    }

    //OBTENER ULTIMO ID PARA INSERTAR EN DETALLE FACTURA - store procedure
    public Pedido ultimoID() {
        Pedido p = new Pedido();
        String sql = "SELECT IdPedido FROM pedido ORDER BY IdPedido DESC LIMIT 1;";
        try { //Conexion a la bd
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ResultSet rss = ps.executeQuery();//Ejecutamos el query en la bd
            //Cargamos el resulSet mientras exista un registro
            while (rss.next()) {
                p.setId(rss.getInt(1)); //Asignamos los valores a cada columb
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
        return p;
    }

}
