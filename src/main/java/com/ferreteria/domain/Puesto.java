package com.ferreteria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "puesto")
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "puesto_seq")
    @SequenceGenerator(name = "puesto_seq", sequenceName = "puesto_seq", allocationSize = 1)
    @Column(name = "id_puesto")
    private Long idPuesto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "salario", nullable = false)
    private Double salario;

    @Column(name = "estado", nullable = false)
    private String estado;

    public Puesto() {
    }
    
    public Puesto(Long idPuesto, String nombre) {
        this.idPuesto = idPuesto;
        this.nombre = nombre;
    }

    public Puesto(String nombre, Double salario, String estado) {
        this.nombre = nombre;
        this.salario = salario;
        this.estado = estado;
    }

    public Long getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Long idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Puesto{" +
                "idPuesto=" + idPuesto +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", estado='" + estado + '\'' +
                '}';
    }
}
