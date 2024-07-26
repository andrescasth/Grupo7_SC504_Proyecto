package com.ferreteria.controller;

import com.ferreteria.domain.Categoria;
import com.ferreteria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/agregar")
    public String agregarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.agregarCategoria(categoria);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable int id) {
        return categoriaService.eliminarCategoria(id);
    }
}
