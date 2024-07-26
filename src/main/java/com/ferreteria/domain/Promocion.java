package com.ferreteria.domain;

public class Promocion {
    private int ID_Promocion;
    private int Porcentaje;
    private String Descripcion;
    private String Estado;

    public Promocion() {
    }

    public Promocion(int ID_Promocion, int Porcentaje, String Descripcion, String Estado) {
        this.ID_Promocion = ID_Promocion;
        this.Porcentaje = Porcentaje;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public int getID_Promocion() {
        return ID_Promocion;
    }

    public void setID_Promocion(int ID_Promocion) {
        this.ID_Promocion = ID_Promocion;
    }

    public double getPorcentaje() {
        return Porcentaje;
    }

    public void setPorcentaje(int Porcentaje) {
        this.Porcentaje = Porcentaje;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Promocion{" +
                "ID_Promocion=" + ID_Promocion +
                ", Porcentaje=" + Porcentaje +
                ", Descripcion='" + Descripcion + '\'' +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
