package com.ferreteria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Metodo_Pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "metodo_pago_seq")
    @SequenceGenerator(name = "metodo_pago_seq", sequenceName = "metodo_pago_seq", allocationSize = 1)
    @Column(name = "ID_Metodo_Pago")
    private Long idMetodoPago;

    @Column(name = "Tipo", nullable = false)
    private String tipo;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @Column(name = "Estado", nullable = false)
    private String estado;

    // Getters and Setters

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "MetodoPago{" +
                "idMetodoPago=" + idMetodoPago +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
