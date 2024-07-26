package com.ferreteria.service;

import com.ferreteria.dao.MarcaDao;
import com.ferreteria.domain.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService {

    private final MarcaDao marcaDao;

    @Autowired
    public MarcaService(MarcaDao marcaDao) {
        this.marcaDao = marcaDao;
    }

    public String agregarMarca(Marca marca) {
        return marcaDao.agregarMarca(marca);
    }

    public String eliminarMarca(int id) {
        return marcaDao.eliminarMarca(id);
    }
}
