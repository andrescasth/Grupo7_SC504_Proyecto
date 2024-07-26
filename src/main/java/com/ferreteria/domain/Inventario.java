package com.ferreteria.domain;

import java.util.Date;

public class Inventario {
    private int idInventario;
    private int idProducto;
    private int idSucursal;
    private int cantidad;
    private String ultimaActualizacion;
    private String estado;

    // Constructores, getters y setters

    public Inventario() {
    }

    public Inventario(int idInventario, int idProducto, int idSucursal, int cantidad, String ultimaActualizacion, String estado) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.idSucursal = idSucursal;
        this.cantidad = cantidad;
        this.ultimaActualizacion = ultimaActualizacion;
        this.estado = estado;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(String ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "idInventario=" + idInventario +
                ", idProducto=" + idProducto +
                ", idSucursal=" + idSucursal +
                ", cantidad=" + cantidad +
                ", ultimaActualizacion=" + ultimaActualizacion +
                ", estado='" + estado + '\'' +
                '}';
    }
}
