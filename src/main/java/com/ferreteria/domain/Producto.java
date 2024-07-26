/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferreteria.domain;

/**
 *
 * @author andre
 */
public class Producto {
    private int ID_producto;
   private String nombre;
   private  String descripcion;
   private  int precio;
   private  int stock;
   private  int ID_categoria;
   private  int ID_marca;
   private  String Estado;

    public Producto() {
    }
    
    
    

    public Producto(int ID_producto, String nombre, String descripcion, int precio, int stock, int ID_categoria, int ID_marca, String Estado) {
        this.ID_producto = ID_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.ID_categoria = ID_categoria;
        this.ID_marca = ID_marca;
        this.Estado = Estado;
    }

    public int getID_producto() {
        return ID_producto;
    }

    public void setID_producto(int ID_producto) {
        this.ID_producto = ID_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getID_categoria() {
        return ID_categoria;
    }

    public void setID_categoria(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }

    public int getID_marca() {
        return ID_marca;
    }

    public void setID_marca(int ID_marca) {
        this.ID_marca = ID_marca;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "registro_producto{" + "ID_producto=" + ID_producto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + ", ID_categoria=" + ID_categoria + ", ID_marca=" + ID_marca + ", Estado=" + Estado + '}';
    }
    
    
    
    
}

