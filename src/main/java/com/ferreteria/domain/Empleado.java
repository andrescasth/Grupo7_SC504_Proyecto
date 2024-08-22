package com.ferreteria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_seq")
    @SequenceGenerator(name = "empleado_seq", sequenceName = "empleado_seq", allocationSize = 1)
    @Column(name = "ID_Empleado")
    private Long idEmpleado;

    @Column(name = "Direccion", nullable = false)
    private String direccion;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "ID_Sucursal", nullable = false)
    private Long idSucursal;

    @Column(name = "ID_Puesto", nullable = false)
    private Long idPuesto;

    @Column(name = "Estado", nullable = false)
    private String estado;

    // Constructor vacío para JPA
    public Empleado() {
    }

    public Empleado(String direccion, String email, Long idSucursal, Long idPuesto, String estado) {
        this.direccion = direccion;
        this.email = email;
        this.idSucursal = idSucursal;
        this.idPuesto = idPuesto;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Long getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Long idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", idSucursal=" + idSucursal +
                ", idPuesto=" + idPuesto +
                ", estado='" + estado + '\'' +
                '}';
    }
}
