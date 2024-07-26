package com.ferreteria.domain;

public class Sucursal {
    private int ID_Sucursal;
    private String Nombre;
    private String Direccion;
    private String Telefono;
    private String Estado;

    public Sucursal() {
    }

    public Sucursal(int ID_Sucursal, String Nombre, String Direccion, String Telefono, String Estado) {
        this.ID_Sucursal = ID_Sucursal;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Estado = Estado;
    }

    public int getID_Sucursal() {
        return ID_Sucursal;
    }

    public void setID_Sucursal(int ID_Sucursal) {
        this.ID_Sucursal = ID_Sucursal;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "ID_Sucursal=" + ID_Sucursal +
                ", Nombre='" + Nombre + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
