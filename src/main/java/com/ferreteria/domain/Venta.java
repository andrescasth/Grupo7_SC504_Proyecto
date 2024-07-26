package com.ferreteria.domain;

import java.util.Date;

public class Venta {
    private int idVenta;
    private String fecha;
    private double total;
    private int idProducto;
    private int idCliente;
    private int idSucursal;
    private int idMetodoPago;
    private String estado;

    // Constructores, getters y setters

    public Venta() {
    }

    public Venta(int idVenta, String fecha, double total, int idProducto, int idCliente, int idSucursal, int idMetodoPago, String estado) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
        this.idProducto = idProducto;
        this.idCliente = idCliente;
        this.idSucursal = idSucursal;
        this.idMetodoPago = idMetodoPago;
        this.estado = estado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fecha=" + fecha +
                ", total=" + total +
                ", idProducto=" + idProducto +
                ", idCliente=" + idCliente +
                ", idSucursal=" + idSucursal +
                ", idMetodoPago=" + idMetodoPago +
                ", estado='" + estado + '\'' +
                '}';
    }
}
