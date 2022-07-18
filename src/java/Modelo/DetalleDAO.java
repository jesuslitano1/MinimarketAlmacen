package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public int guardarDetallepedido(Detalle dpe) {
        String sql = "insert into detalle_pedido(IdPedido, IdProducto, NomProducto, Cantidad, PrecioTotal)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dpe.getId());
            ps.setInt(2, dpe.getIdproducto());
            ps.setString(3, dpe.getDescripcionP());
            ps.setInt(4, dpe.getCantidad());
            ps.setDouble(5, dpe.getPrecio());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
        return r;
    }

    public List listardetalles(int id) {
        String sql = "select * from detalle_pedido where IdDetallePedido=" + id;
        List<Detalle> lista = new ArrayList<>(4);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Detalle dtpe = new Detalle();
                dtpe.setId(rs.getInt(1));
                dtpe.setIdpedido(rs.getInt(2));
                dtpe.setIdproducto(rs.getInt(3));
                dtpe.setDescripcionP(rs.getString(4));
                dtpe.setCantidad(rs.getInt(5));
                dtpe.setPrecio(rs.getDouble(6));
                lista.add(dtpe);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public List listar(int id) {
        String sql = "select * from detalle_pedido where IdPedido=" + id;
        List<Detalle> lista = new ArrayList<>(5);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Detalle dtpe = new Detalle();
                dtpe.setId(rs.getInt(1));
                dtpe.setIdpedido(rs.getInt(2));
                dtpe.setIdproducto(rs.getInt(3));
                dtpe.setDescripcionP(rs.getString(4));
                dtpe.setCantidad(rs.getInt(5));
                lista.add(dtpe);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public Detalle buscar(int id){
      Detalle d=new Detalle();
      String sql="select * from detalle_pedido where IdDetallePedido="+id;
      try {
          con=cn.Conexion();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while (rs.next()) {
                d.setId(rs.getInt(1));
                d.setIdpedido(rs.getInt(2));
                d.setIdproducto(rs.getInt(3));
                d.setDescripcionP(rs.getString(4));
                d.setCantidad(rs.getInt(5));
                d.setPrecio(rs.getDouble(6));
          }
      } catch (SQLException e) {
      }
     return d;
  }
    
        public void delete(int id){
        String sql="update * from detalle_pedido where IdDetallePedido="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
