package com.ferreteria.service;

import com.ferreteria.domain.Producto;
import com.ferreteria.domain.Categoria;
import com.ferreteria.domain.Marca;
import com.ferreteria.dao.ProductoDao;
import com.ferreteria.dao.CategoriaDao;
import com.ferreteria.dao.MarcaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoDao productoDao;
    private final CategoriaDao categoriaDao;
    private final MarcaDao marcaDao;

    @Autowired
    public ProductoService(ProductoDao productoDao, CategoriaDao categoriaDao, MarcaDao marcaDao) {
        this.productoDao = productoDao;
        this.categoriaDao = categoriaDao;
        this.marcaDao = marcaDao;
    }

    public String agregarProducto(Producto producto) {
        return productoDao.agregarProducto(producto);
    }

    public String eliminarProducto(Long idProducto) {
        return productoDao.eliminarProducto(idProducto);
    }

    public String actualizarProducto(Producto producto) {
        return productoDao.actualizarProducto(producto);
    }

    public List<Categoria> obtenerCategorias() {
        return categoriaDao.obtenerCategorias();
    }

    public List<Marca> obtenerMarcas() {
        return marcaDao.obtenerMarcas();
    }
   
}
