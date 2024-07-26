package com.ferreteria.domain;

public class Devolucion {
    private int idDevolucion;
    private String fecha;  // 
    private double total;
    private int idCliente;
    private int idEmpleado;
    private int idVenta;
    private int idMotivo;
    private int idProducto;

    // Constructores, getters y setters

    public Devolucion() {
    }

    public Devolucion(int idDevolucion, String fecha, double total, int idCliente, int idEmpleado, int idVenta, int idMotivo, int idProducto) {
        this.idDevolucion = idDevolucion;
        this.fecha = fecha;
        this.total = total;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idVenta = idVenta;
        this.idMotivo = idMotivo;
        this.idProducto = idProducto;
    }

    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "Devolucion{" +
                "idDevolucion=" + idDevolucion +
                ", fecha='" + fecha + '\'' +
                ", total=" + total +
                ", idCliente=" + idCliente +
                ", idEmpleado=" + idEmpleado +
                ", idVenta=" + idVenta +
                ", idMotivo=" + idMotivo +
                ", idProducto=" + idProducto +
                '}';
    }
}
