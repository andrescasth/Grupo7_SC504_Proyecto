package com.ferreteria.domain;

import java.math.BigDecimal;

public class Cuenta {
    private int idCuenta;
    private String tipo;
    private int saldo;
    private String estado;

    public Cuenta() {
    }

    public Cuenta(int idCuenta, String tipo, int saldo, String estado) {
        this.idCuenta = idCuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.estado = estado;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "idCuenta=" + idCuenta +
                ", tipo='" + tipo + '\'' +
                ", saldo=" + saldo +
                ", estado='" + estado + '\'' +
                '}';
    }
}
