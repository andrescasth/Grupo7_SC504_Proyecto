package com.ferreteria.service;

import com.ferreteria.dao.CuentaDao;
import com.ferreteria.domain.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {

    private final CuentaDao cuentaDao;

    @Autowired
    public CuentaService(CuentaDao cuentaDao) {
        this.cuentaDao = cuentaDao;
    }

    public String agregarCuenta(Cuenta cuenta) {
        return cuentaDao.agregarCuenta(cuenta);
    }

    public String eliminarCuenta(int id) {
        return cuentaDao.eliminarCuenta(id);
    }
}
