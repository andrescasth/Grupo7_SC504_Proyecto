package com.ferreteria.service;

import com.ferreteria.dao.SucursalDao;
import com.ferreteria.domain.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {

    private final SucursalDao sucursalDao;

    @Autowired
    public SucursalService(SucursalDao sucursalDao) {
        this.sucursalDao = sucursalDao;
    }

    public String agregarSucursal(Sucursal sucursal) {
        return sucursalDao.agregarSucursal(sucursal);
    }

    public String eliminarSucursal(int id) {
        return sucursalDao.eliminarSucursal(id);
    }
}
