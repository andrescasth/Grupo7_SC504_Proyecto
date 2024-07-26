package com.ferreteria.controller;

import com.ferreteria.domain.MetodoPago;
import com.ferreteria.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metodos_pago")
public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    @Autowired
    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @PostMapping("/agregar")
    public String agregarMetodoPago(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.agregarMetodoPago(metodoPago);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarMetodoPago(@PathVariable int id) {
        return metodoPagoService.eliminarMetodoPago(id);
    }
}
