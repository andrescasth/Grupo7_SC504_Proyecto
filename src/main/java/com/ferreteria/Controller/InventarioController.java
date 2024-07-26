package com.ferreteria.controller;

import com.ferreteria.domain.Inventario;
import com.ferreteria.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {

    private final InventarioService inventarioService;

    @Autowired
    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @PostMapping("/agregar")
    public String agregarInventario(@RequestBody Inventario inventario) {
        return inventarioService.agregarInventario(inventario);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarInventario(@PathVariable int id) {
        return inventarioService.eliminarInventario(id);
    }
}
