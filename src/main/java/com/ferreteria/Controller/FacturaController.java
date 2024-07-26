package com.ferreteria.controller;

import com.ferreteria.domain.Factura;
import com.ferreteria.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @PostMapping("/agregar")
    public String agregarFactura(@RequestBody Factura factura) {
        return facturaService.agregarFactura(factura);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarFactura(@PathVariable int id) {
        return facturaService.eliminarFactura(id);
    }
}
