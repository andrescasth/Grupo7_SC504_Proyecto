package com.ferreteria.service;

import com.ferreteria.dao.ProveedorDao;
import com.ferreteria.domain.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {

    private final ProveedorDao proveedorDao;

    @Autowired
    public ProveedorService(ProveedorDao proveedorDao) {
        this.proveedorDao = proveedorDao;
    }

    public String agregarProveedor(Proveedor proveedor) {
        return proveedorDao.agregarProveedor(proveedor);
    }

    public String eliminarProveedor(int id) {
        return proveedorDao.eliminarProveedor(id);
    }
}
