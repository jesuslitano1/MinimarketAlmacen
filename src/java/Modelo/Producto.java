
package Modelo;

public class Producto {
    int id;
    String nom;
    double pre;
    String med;
    int stock;
    String estado;
    int idcat;
    int idubi;
    String tipo;

    public Producto() {
    }

    public Producto(int id, String nom, double pre,String med, int stock, String estado, int idcat, int idubi, String tipo) {
        this.id = id;
        this.nom = nom;
        this.pre = pre;
        this.med = med;
        this.stock = stock;
        this.estado = estado;
        this.idcat = idcat;
        this.idubi = idubi;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdubi() {
        return idubi;
    }

    public void setIdubi(int idubi) {
        this.idubi = idubi;
    }


    

}
