package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Registro buscar(int id) {
        Registro reg = new Registro();
        String sql = "Select * from pedido where IdPedido=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                reg.setRuc(rs.getString(1));
                reg.setNumserie(rs.getString(2));
                reg.setFecha(rs.getString(3));
                reg.setMonto(rs.getDouble(4));
                reg.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return reg;
    }

    public List listar() {
        String sql = "select * from Pedido order by IdPedido desc limit 10";
        List<Registro> lista = new ArrayList<>(4);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Registro reg = new Registro();
                reg.setId(rs.getInt(1));
                reg.setIdproveedor(rs.getInt(2));
                reg.setRuc(rs.getString(3));
                reg.setIdempleado(rs.getInt(4));
                reg.setNumserie(rs.getString(5));
                reg.setFecha(rs.getString(6));
                reg.setMonto(rs.getDouble(7));
                reg.setEstado(rs.getString(8));
                lista.add(reg);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Registro reg) {
        String sql = "insert into pedido(Ruc, NumeroSerie, FechaPedido, Monto,Estado)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getRuc());
            ps.setString(2, reg.getNumserie());
            ps.setString(3, reg.getFecha());
            ps.setDouble(4, reg.getMonto());
            ps.setString(5, reg.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;

    }

    public Registro listarId(int id) {
        Registro reg = new Registro();
        String sql = "select * from pedido where IdPedido=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                reg.setRuc(rs.getString(4));
                reg.setNumserie(rs.getString(5));
                reg.setFecha(rs.getString(6));
                reg.setMonto(rs.getDouble(7));
                reg.setEstado(rs.getString(8));
            }
        } catch (Exception e) {
        }
        return reg;
    }

    public int actualizar(Registro reg) {
        String sql = "update proveedor set NumeroSerie=?, FechaPedido=?, Monto=?,Estado=? where IdPedido=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getRuc());
            ps.setString(2, reg.getNumserie());
            ps.setString(3, reg.getFecha());
            ps.setDouble(4, reg.getMonto());
            ps.setString(5, reg.getEstado());
            ps.setInt(6, reg.getIdpedido());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "update pedido set estado = 'Anulado' where IdPedido=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
