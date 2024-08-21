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

    public String insertarSucursal(Sucursal sucursal) {
        return sucursalDao.insertarSucursal(sucursal);
    }

    public String eliminarSucursal(Long idSucursal) {
        return sucursalDao.eliminarSucursal(idSucursal);
    }

    public String actualizarSucursal(Sucursal sucursal) {
        return sucursalDao.actualizarSucursal(sucursal);
    }
}