package com.ferreteria.controller;

import com.ferreteria.domain.Motivo;
import com.ferreteria.service.MotivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/motivos")
public class MotivoController {

    private final MotivoService motivoService;

    @Autowired
    public MotivoController(MotivoService motivoService) {
        this.motivoService = motivoService;
    }

    @PostMapping("/agregar")
    public String agregarMotivo(@RequestBody Motivo motivo) {
        return motivoService.agregarMotivo(motivo);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarMotivo(@PathVariable int id) {
        return motivoService.eliminarMotivo(id);
    }
}
