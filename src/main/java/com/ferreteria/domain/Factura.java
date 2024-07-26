package com.ferreteria.domain;

public class Factura {
    private int idFactura;
    private int idProducto;
    private int idProveedor;
    private int cantidad;
    private double costoTotal;
    private int idPromocion;
    private String fechaCompra; // Cambiado a String
    private String estado;

    public Factura() {
    }

    public Factura(int idFactura, int idProducto, int idProveedor, int cantidad, double costoTotal, int idPromocion, String fechaCompra, String estado) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.idPromocion = idPromocion;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
    }

    // Getters y Setters

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", idProducto=" + idProducto +
                ", idProveedor=" + idProveedor +
                ", cantidad=" + cantidad +
                ", costoTotal=" + costoTotal +
                ", idPromocion=" + idPromocion +
                ", fechaCompra='" + fechaCompra + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

   
}
