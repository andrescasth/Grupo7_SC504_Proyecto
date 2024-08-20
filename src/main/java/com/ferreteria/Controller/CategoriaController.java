package com.ferreteria.controller;

import com.ferreteria.domain.Categoria;
import com.ferreteria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "categorias/categorias"; // Página principal con botones
    }

    @GetMapping("/insertar")
    public String mostrarFormularioInsertar() {
        return "categorias/insertar"; // Página para insertar categoría
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "categorias/eliminar"; // Página para eliminar categoría
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar() {
        return "categorias/actualizar"; // Página para actualizar categoría
    }

    @PostMapping("/agregar")
    public String agregarCategoria(String nombre, String descripcion, Model model) {
        Categoria categoria = new Categoria(nombre, descripcion);
        String resultado = categoriaService.agregarCategoria(categoria);
        model.addAttribute("resultado", resultado);
        return "categorias/resultado"; // Página de resultado
    }

    @PostMapping("/eliminar")
    public String eliminarCategoria(String id, Model model) {
        int categoriaId = Integer.parseInt(id);
        String resultado = categoriaService.eliminarCategoria(categoriaId);
        model.addAttribute("resultado", resultado);
        return "categorias/resultado"; // Página de resultado
    }

    @PostMapping("/actualizar")
    public String actualizarCategoria(String id, String nombre, String descripcion, Model model) {
        Categoria categoria = new Categoria(nombre, descripcion);
        categoria.setIdCategoria(Long.parseLong(id));
        String resultado = categoriaService.actualizarCategoria(categoria);
        model.addAttribute("resultado", resultado);
        return "categorias/resultado"; // Página de resultado
    }
}
