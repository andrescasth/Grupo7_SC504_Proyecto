package com.ferreteria.controller;

import com.ferreteria.domain.Devolucion;
import com.ferreteria.service.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devoluciones")
public class DevolucionController {

    private final DevolucionService devolucionService;

    @Autowired
    public DevolucionController(DevolucionService devolucionService) {
        this.devolucionService = devolucionService;
    }

    @PostMapping("/agregar")
    public String agregarDevolucion(@RequestBody Devolucion devolucion) {
        return devolucionService.agregarDevolucion(devolucion);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarDevolucion(@PathVariable int id) {
        return devolucionService.eliminarDevolucion(id);
    }
}
