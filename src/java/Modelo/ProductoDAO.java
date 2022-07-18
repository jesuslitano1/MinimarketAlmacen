
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
  public Producto buscar(int id){
      Producto p=new Producto();
      String sql="select * from producto where idproducto="+id;
      try {
          con=cn.Conexion();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while (rs.next()) {
              p.setId(rs.getInt(1));
              p.setNom(rs.getString(2));
              p.setPre(rs.getDouble(3));
              p.setMed(rs.getString(4));
              p.setStock(rs.getInt(5));
              p.setEstado(rs.getString(6));
              p.setIdcat(rs.getInt(7));
              p.setTipo(rs.getString(8));
          }
      } catch (SQLException e) {
      }
     return p;
  }
  public int actualizarstock(int id, int stock){
      String sql="update producto set Stock=? where idproducto=?";
      try {
          con=cn.Conexion();
          ps=con.prepareStatement(sql);
          ps.setInt(1, stock);
          ps.setInt(2, id);
          ps.executeUpdate();
      } catch (SQLException e) {
      }
      return r;
  }
    
  //*******Operaciones CRUD***************//    
    public List listar(){
        String sql="select * from producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Producto em=new Producto();
                em.setId(rs.getInt(1));
                em.setNom(rs.getString(2));               
                em.setPre(rs.getDouble(3));
                em.setMed(rs.getString(4));
                em.setStock(rs.getInt(5));
                em.setEstado(rs.getString(6));  
                em.setIdcat(rs.getInt(7));
                em.setIdubi(rs.getInt(8));
                em.setTipo(rs.getString(9));
                lista.add(em);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public int agregar(Producto p){ 
        String sql="insert into producto(Nombres, Precio, Medida, Stock, Estado, IdCategoria, IdUbicacion, Tipo)values(?,?,?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPre());
            ps.setString(3, p.getMed());
            ps.setInt(4, p.getStock());
            ps.setString(5, p.getEstado()); 
            ps.setInt(6,p.getIdcat());
            ps.setInt(7,p.getIdubi());
            ps.setString(8, p.getTipo());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
        
    }
    public Producto listarId(int id){
        Producto pr=new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));               
                pr.setPre(rs.getDouble(3));
                pr.setMed(rs.getString(4));
                pr.setStock(rs.getInt(5));
                pr.setEstado(rs.getString(6));  
                pr.setIdcat(rs.getInt(7));
                pr.setIdubi(rs.getInt(8));
                pr.setTipo(rs.getString(9));
            }
        } catch (SQLException e) {
        }
        return pr;
    }
    public int actualizar(Producto em){
        String sql="update producto set Nombres=?, Precio=?, Medida=?, Stock=?, Estado=? , IdCategoria=?, IdUbicacion=?, Tipo=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getNom());
            ps.setDouble(2, em.getPre());
            ps.setString(3, em.getMed());
            ps.setInt(4, em.getStock());
            ps.setString(5, em.getEstado());   
            ps.setInt(6, em.getIdcat());
            ps.setInt(7, em.getIdubi());
            ps.setString(8, em.getTipo());
            ps.setInt(9, em.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    public void delete(int id){
        String sql="update producto set estado = 'Agotado' where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
      //*******Operaciones Listar de los reportes***************//  
    
    public List listar1(){
        String sql="select * from producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Producto em=new Producto();
                em.setId(rs.getInt(1));
                em.setNom(rs.getString(2));               
                em.setPre(rs.getDouble(3));
                em.setMed(rs.getString(4));
                em.setStock(rs.getInt(5));
                em.setEstado(rs.getString(6));  
                em.setIdcat(rs.getInt(7));
                em.setIdubi(rs.getInt(8));
                em.setTipo(rs.getString(9));
                lista.add(em);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public List listar2(){
        String sql="select * from producto where Tipo='perecible'";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Producto em=new Producto();
                em.setId(rs.getInt(1));
                em.setNom(rs.getString(2));               
                em.setPre(rs.getDouble(3));
                //em.setMed(rs.getString(4));
                em.setStock(rs.getInt(5));
                em.setEstado(rs.getString(6));  
                //em.setIdcat(rs.getInt(7));
                //em.setIdubi(rs.getInt(8));
                em.setTipo(rs.getString(9));
                lista.add(em);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public List listar3(){
        String sql="select * from producto where Tipo='No Perecible'";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Producto em=new Producto();
                em.setId(rs.getInt(1));
                em.setNom(rs.getString(2));               
                em.setPre(rs.getDouble(3));
                //em.setMed(rs.getString(4));
                em.setStock(rs.getInt(5));
                em.setEstado(rs.getString(6));  
                //em.setIdcat(rs.getInt(7));
                //em.setIdubi(rs.getInt(8));
                em.setTipo(rs.getString(9));
                lista.add(em);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public List listar4(){
        String sql="select * from producto where Estado='Disponible'";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Producto em=new Producto();
                em.setId(rs.getInt(1));
                em.setNom(rs.getString(2));               
                em.setPre(rs.getDouble(3));
                //em.setMed(rs.getString(4));
                em.setStock(rs.getInt(5));
                em.setEstado(rs.getString(6));  
                //em.setIdcat(rs.getInt(7));
                //em.setIdubi(rs.getInt(8));
                //em.setTipo(rs.getString(9));
                lista.add(em);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public List listar5(){
        String sql="select * from producto where Estado='Agotado'";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Producto em=new Producto();
                em.setId(rs.getInt(1));
                em.setNom(rs.getString(2));               
                em.setPre(rs.getDouble(3));
                //em.setMed(rs.getString(4));
                em.setStock(rs.getInt(5));
                em.setEstado(rs.getString(6));  
                //em.setIdcat(rs.getInt(7));
                //em.setIdubi(rs.getInt(8));
                //em.setTipo(rs.getString(9));
                lista.add(em);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
}
