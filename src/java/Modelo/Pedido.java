package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedido {
    Integer id;
    Integer item;
    Integer idproveedor;
    String ruc;
    Integer idempleado;
    Integer idproducto;
    String nomproveedor;
    String Numserie;
    String DescripcionP;
    String fecha;
    Double precio;
    Integer cantidad;
    Double subtotal;
    Double monto;
    String estado;

    public Pedido() {
    }

    public Pedido(Integer id, Integer item, Integer idproveedor, String ruc, Integer idempleado, Integer idproducto, String nomproveedor, String Numserie, String DescripcionP,String fecha, Double precio, Integer cantidad, Double subtotal, Double monto, String estado) {
        this.id = id;
        this.item = item;
        this.idproveedor = idproveedor;
        this.ruc= ruc;
        this.idempleado = idempleado;
        this.idproducto = idproducto;
        this.nomproveedor = nomproveedor;
        this.Numserie = Numserie;
        this.DescripcionP = DescripcionP;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.monto = monto;
        this.estado = estado;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcionP() {
        return DescripcionP;
    }

    public void setDescripcionP(String DescripcionP) {
        this.DescripcionP = DescripcionP;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNomproveedor() {
        return nomproveedor;
    }

    public void setNomproveedor(String nomproveedor) {
        this.nomproveedor = nomproveedor;
    }

    public String getNumserie() {
        return Numserie;
    }

    public void setNumserie(String Numserie) {
        this.Numserie = Numserie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    
    
}
