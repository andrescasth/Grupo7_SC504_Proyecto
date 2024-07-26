package com.ferreteria.controller;

import com.ferreteria.domain.Marca;
import com.ferreteria.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping("/agregar")
    public String agregarMarca(@RequestBody Marca marca) {
        return marcaService.agregarMarca(marca);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarMarca(@PathVariable int id) {
        return marcaService.eliminarMarca(id);
    }
}
