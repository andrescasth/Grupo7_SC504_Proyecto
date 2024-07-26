package com.ferreteria.controller;

import com.ferreteria.domain.Venta;
import com.ferreteria.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    private final VentaService ventaService;

    @Autowired
    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping("/agregar")
    public String agregarVenta(@RequestBody Venta venta) {
        return ventaService.agregarVenta(venta);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable int id) {
        return ventaService.eliminarVenta(id);
    }
}
