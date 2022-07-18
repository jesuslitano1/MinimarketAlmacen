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
 */
public class ProveedorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Proveedor buscar(int id) {
        Proveedor pro = new Proveedor();
        String sql = "Select * from proveedor where IdProveedor=" +id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setId(rs.getInt(1));
                pro.setMail(rs.getString(2));
                pro.setNom(rs.getString(3));
                pro.setRuc(rs.getString(4));
                pro.setTel(rs.getString(5));
                pro.setDir(rs.getString(6));
                pro.setEs(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return pro;
    }

//*******Operaciones CRUD***************//
    public List listar() {
        String sql = "select * from proveedor";
        List<Proveedor> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor pro = new Proveedor();
                pro.setId(rs.getInt(1));
                pro.setMail(rs.getString(2));
                pro.setNom(rs.getString(3));
                pro.setRuc(rs.getString(4));
                pro.setTel(rs.getString(5));
                pro.setDir(rs.getString(6));
                pro.setEs(rs.getString(7));
                lista.add(pro);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    

    public int agregar(Proveedor pro) {
        String sql = "insert into proveedor(Mail, Nombres, Ruc, Telefono, Direccion,Estado)values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getMail());
            ps.setString(2, pro.getNom());
            ps.setString(3, pro.getRuc());
            ps.setString(4, pro.getTel());
            ps.setString(5, pro.getDir());
            ps.setString(6, pro.getEs());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;

    }

    public Proveedor listarId(int id) {
        Proveedor pro = new Proveedor();
        String sql = "select * from proveedor where IdProveedor=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setMail(rs.getString(2));
                pro.setNom(rs.getString(3));
                pro.setRuc(rs.getString(4));
                pro.setTel(rs.getString(5));
                pro.setDir(rs.getString(6));
                pro.setEs(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return pro;
    }

    public int actualizar(Proveedor em) {
        String sql = "update proveedor set Mail=?, Nombres=?, Ruc=?, Telefono=?, Direccion=?, Estado=? where IdProveedor=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getMail());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getRuc());
            ps.setString(4, em.getTel());
            ps.setString(5, em.getDir());
            ps.setString(6, em.getEs());
            ps.setInt(7, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "update proveedor set estado = 'Inactivo' where IdProveedor=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
