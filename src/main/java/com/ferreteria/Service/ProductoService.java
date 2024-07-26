package com.ferreteria.service;

import com.ferreteria.domain.Producto;
import com.ferreteria.dao.productoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final productoDao productoDao;

    @Autowired
    public ProductoService(productoDao productoDao) {
        this.productoDao = productoDao;
    }

    public String agregarProducto(Producto producto) {
        return productoDao.agregarProducto(producto);
    }
    
    public String eliminarProducto(int idProducto) {
        return productoDao.eliminarProducto(idProducto);
    }
}
