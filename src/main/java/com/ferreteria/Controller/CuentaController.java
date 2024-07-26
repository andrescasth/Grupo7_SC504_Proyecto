package com.ferreteria.controller;

import com.ferreteria.domain.Cuenta;
import com.ferreteria.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    @Autowired
    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping("/agregar")
    public String agregarCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.agregarCuenta(cuenta);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarCuenta(@PathVariable int id) {
        return cuentaService.eliminarCuenta(id);
    }
}
