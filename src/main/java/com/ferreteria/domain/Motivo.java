package com.ferreteria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Motivo")
public class Motivo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "motivo_seq")
    @SequenceGenerator(name = "motivo_seq", sequenceName = "motivo_seq", allocationSize = 1)
    @Column(name = "ID_Motivo")
    private Long ID_Motivo;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    public Motivo() {
    }

    public Motivo(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getID_Motivo() {
        return ID_Motivo;
    }

    public void setID_Motivo(Long ID_Motivo) {
        this.ID_Motivo = ID_Motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Motivo{" +
                "ID_Motivo=" + ID_Motivo +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
