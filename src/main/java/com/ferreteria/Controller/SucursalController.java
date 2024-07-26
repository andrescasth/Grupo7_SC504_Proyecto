package com.ferreteria.controller;

import com.ferreteria.domain.Sucursal;
import com.ferreteria.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    @Autowired
    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping("/agregar")
    public String agregarSucursal(@RequestBody Sucursal sucursal) {
        return sucursalService.agregarSucursal(sucursal);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarSucursal(@PathVariable int id) {
        return sucursalService.eliminarSucursal(id);
    }
}
