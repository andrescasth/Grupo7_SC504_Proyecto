package com.ferreteria.service;

import com.ferreteria.dao.InventarioDao;
import com.ferreteria.domain.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioService {

    private final InventarioDao inventarioDao;

    @Autowired
    public InventarioService(InventarioDao inventarioDao) {
        this.inventarioDao = inventarioDao;
    }

    public String agregarInventario(Inventario inventario) {
        return inventarioDao.agregarInventario(inventario);
    }

    public String eliminarInventario(int id) {
        return inventarioDao.eliminarInventario(id);
    }
}
