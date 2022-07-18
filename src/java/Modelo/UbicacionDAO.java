/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class UbicacionDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
     
    public Ubicacion buscar(int id){
        Ubicacion ubi=new Ubicacion();
        String sql="Select * from ubicacion where IdUbicacion="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                ubi.setId(rs.getInt(1));
                ubi.setNom(rs.getString(2));
            
            }
        } catch (Exception e) {
        }
        return ubi;
    }

//*******Operaciones CRUD***************//
    public List listar(){
        String sql="select * from ubicacion";
        List<Ubicacion>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Ubicacion ubi=new Ubicacion();
                ubi.setId(rs.getInt(1));
                ubi.setNom(rs.getString(2));
                lista.add(ubi);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Ubicacion ubi){ 
        String sql="insert into ubicacion(Nombre)values(?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            //ps.setInt(1, ubi.getId());
            ps.setString(1, ubi.getNom());         
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
        
    }

        public Ubicacion listarId(int id){
        Ubicacion ubi=new Ubicacion();
        String sql="select * from ubicacion where IdUbicacion="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                ubi.setId(rs.getInt(1));
                ubi.setNom(rs.getString(2));            
            }
        } catch (Exception e) {
        }
        return ubi;
    }
        
    public int actualizar(Ubicacion em){
        String sql="update ubicacion set Nombre=? where IdUbicacion=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);    
            ps.setString(1, em.getNom());
            ps.setInt(2, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    /**public void delete(int id){
        String sql="delete from ubicacion where IdUbicacion="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }*/

    
    
}
