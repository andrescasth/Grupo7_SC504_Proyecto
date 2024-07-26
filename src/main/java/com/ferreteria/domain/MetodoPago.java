package com.ferreteria.domain;

public class MetodoPago {
    private int ID_Metodo_Pago;
    private String Tipo;
    private String Descripcion;
    private String Estado;

    public MetodoPago() {
    }

    public MetodoPago(int ID_Metodo_Pago, String Tipo, String Descripcion, String Estado) {
        this.ID_Metodo_Pago = ID_Metodo_Pago;
        this.Tipo = Tipo;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public int getID_Metodo_Pago() {
        return ID_Metodo_Pago;
    }

    public void setID_Metodo_Pago(int ID_Metodo_Pago) {
        this.ID_Metodo_Pago = ID_Metodo_Pago;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
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
        return "MetodoPago{" +
                "ID_Metodo_Pago=" + ID_Metodo_Pago +
                ", Tipo='" + Tipo + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
