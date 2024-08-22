package com.ferreteria.controller;

import com.ferreteria.domain.Categoria;
import com.ferreteria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String mostrarFormularioAgregar() {
        return "categorias/insertar"; // Página para agregar una nueva categoría
    }

    @PostMapping("/insertar")
    public String agregarCategoria(@RequestParam String nombre, @RequestParam String descripcion, Model model) {
        Categoria categoria = new Categoria(nombre, descripcion);
        String resultado = categoriaService.agregarCategoria(categoria);
        model.addAttribute("resultado", resultado);
        return "categorias/resultado"; // Página de resultado
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "categorias/eliminar"; // Página para eliminar categoría
    }

    @PostMapping("/eliminar")
    public String eliminarCategoria(@RequestParam Long id, Model model) {
        String resultado = categoriaService.eliminarCategoria(id);
        model.addAttribute("resultado", resultado);
        return "categorias/resultado"; // Página de resultado
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar(Model model) {
        model.addAttribute("categorias", categoriaService.obtenerCategorias()); // Enviar la lista de categorías al modelo para el dropdown
        return "categorias/actualizar"; // Página para actualizar categoría
    }

    @PostMapping("/actualizar")
public String actualizarCategoria(@RequestParam Long id,
                                  @RequestParam String nombre,
                                  @RequestParam String descripcion,
                                  Model model) {
    Categoria categoria = new Categoria(nombre, descripcion);
    categoria.setId(id); // Establecer el ID de la categoría
    String resultado = categoriaService.actualizarCategoria(categoria);
    model.addAttribute("resultado", resultado);
    return "categorias/resultado"; // Página de resultado
}

}
