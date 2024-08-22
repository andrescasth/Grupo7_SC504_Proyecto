package com.ferreteria.service;

import com.ferreteria.domain.Cuenta;
import com.ferreteria.domain.Cliente;
import com.ferreteria.dao.CuentaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {

    private final CuentaDao cuentaDao;
    private final ClienteService clienteService;

    @Autowired
    public CuentaService(CuentaDao cuentaDao, ClienteService clienteService) {
        this.cuentaDao = cuentaDao;
        this.clienteService = clienteService;
    }

    public String agregarCuenta(Cuenta cuenta) {
        return cuentaDao.agregarCuenta(cuenta);
    }

    public String eliminarCuenta(Long id) {
        return cuentaDao.eliminarCuenta(id);
    }

    public String actualizarCuenta(Cuenta cuenta) {
        return cuentaDao.actualizarCuenta(cuenta);
    }

    public List<Cliente> obtenerClientes() {
        return clienteService.obtenerClientes();
    }
}
