package com.ferreteria.domain;

public class Motivo {
    private int ID_Motivo;
    private String Descripcion;

    public Motivo() {
    }

    public Motivo(int ID_Motivo, String Descripcion) {
        this.ID_Motivo = ID_Motivo;
        this.Descripcion = Descripcion;
    }

    public int getID_Motivo() {
        return ID_Motivo;
    }

    public void setID_Motivo(int ID_Motivo) {
        this.ID_Motivo = ID_Motivo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "Motivo{" + "ID_Motivo=" + ID_Motivo + ", Descripcion='" + Descripcion + '\'' + '}';
    }
}
