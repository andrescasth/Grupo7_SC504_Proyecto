package com.ferreteria.controller;

import com.ferreteria.domain.Proveedor;
import com.ferreteria.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @PostMapping("/agregar")
    public String agregarProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.agregarProveedor(proveedor);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable int id) {
        return proveedorService.eliminarProveedor(id);
    }
}
