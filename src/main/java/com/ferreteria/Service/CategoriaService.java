package com.ferreteria.service;

import com.ferreteria.domain.Categoria;
import com.ferreteria.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaDao categoriaDao;

    @Autowired
    public CategoriaService(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public String agregarCategoria(Categoria categoria) {
        return categoriaDao.agregarCategoria(categoria);
    }

    public String eliminarCategoria(int id) {
        return categoriaDao.eliminarCategoria(id);
    }

    public String actualizarCategoria(Categoria categoria) {
        return categoriaDao.actualizarCategoria(categoria);
    }
}
