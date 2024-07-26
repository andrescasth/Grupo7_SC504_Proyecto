package com.ferreteria.controller;

import com.ferreteria.domain.Puesto;
import com.ferreteria.service.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/puestos")
public class PuestoController {

    private final PuestoService puestoService;

    @Autowired
    public PuestoController(PuestoService puestoService) {
        this.puestoService = puestoService;
    }

    @PostMapping("/agregar")
    public String agregarPuesto(@RequestBody Puesto puesto) {
        return puestoService.agregarPuesto(puesto);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarPuesto(@PathVariable int id) {
        return puestoService.eliminarPuesto(id);
    }
}
