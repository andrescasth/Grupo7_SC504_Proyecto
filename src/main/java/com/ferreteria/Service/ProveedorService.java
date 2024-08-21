package com.ferreteria.service;

import com.ferreteria.domain.Proveedor;
import com.ferreteria.dao.ProveedorDao;
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

    public String actualizarProveedor(Proveedor proveedor) {
        return proveedorDao.actualizarProveedor(proveedor);
    }
}
