package com.ferreteria.domain;

public class Puesto {
    private int ID_Puesto;
    private String Nombre;
    private double Salario;
    private String Estado;

    public Puesto() {
    }

    public Puesto(int ID_Puesto, String Nombre, double Salario, String Estado) {
        this.ID_Puesto = ID_Puesto;
        this.Nombre = Nombre;
        this.Salario = Salario;
        this.Estado = Estado;
    }

    public int getID_Puesto() {
        return ID_Puesto;
    }

    public void setID_Puesto(int ID_Puesto) {
        this.ID_Puesto = ID_Puesto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Puesto{" +
                "ID_Puesto=" + ID_Puesto +
                ", Nombre='" + Nombre + '\'' +
                ", Salario=" + Salario +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
