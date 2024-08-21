package com.ferreteria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Promocion")
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promocion_seq")
    @SequenceGenerator(name = "promocion_seq", sequenceName = "promocion_seq", allocationSize = 1)
    @Column(name = "ID_Promocion")
    private Long idPromocion;

    @Column(name = "Porcentaje", nullable = false)
    private Double porcentaje;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @Column(name = "Estado", nullable = false)
    private String estado;

   

    public Promocion() {
    }

    public Promocion(Double porcentaje, String descripcion, String estado) {
        this.porcentaje = porcentaje;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
     public Promocion(Long idPromocion, Double porcentaje, String descripcion, String estado) {
        this.idPromocion = idPromocion;
        this.porcentaje = porcentaje;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Long idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
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
        return "Promocion{" +
                "idPromocion=" + idPromocion +
                ", porcentaje=" + porcentaje +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
