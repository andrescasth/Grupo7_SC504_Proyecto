package com.ferreteria.controller;

import com.ferreteria.domain.Marca;
import com.ferreteria.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }
    
    @GetMapping("/form")
    public String mostrarFormulario() {
        return "marcas/marcas"; // Página principal con botones
    }

    @GetMapping
    public String mostrarPaginaMarcas() {
        return "marcas"; // Página con los botones para operaciones de marca
    }

    @GetMapping("/insertar")
    public String mostrarFormularioInsertar() {
        return "marcas/insertar"; // Página para insertar marca
    }

    @PostMapping("/insertar")
    public String insertarMarca(@RequestParam String nombre, @RequestParam String descripcion, Model model) {
        Marca marca = new Marca(nombre, descripcion);
        String resultado = marcaService.agregarMarca(marca);
        model.addAttribute("resultado", resultado);
        return "marcas/resultado"; // Página de resultado
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "marcas/eliminar"; // Página para eliminar marca
    }

    @PostMapping("/eliminar")
    public String eliminarMarca(@RequestParam int id, Model model) {
        String resultado = marcaService.eliminarMarca(id);
        model.addAttribute("resultado", resultado);
        return "marcas/resultado"; // Página de resultado
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar() {
        return "marcas/actualizar"; // Página para actualizar marca
    }

    @PostMapping("/actualizar")
    public String actualizarMarca(@RequestParam Long id, @RequestParam String nombre, @RequestParam String descripcion, Model model) {
        Marca marca = new Marca(nombre, descripcion);
        marca.setIdMarca(id);
        String resultado = marcaService.actualizarMarca(marca);
        model.addAttribute("resultado", resultado);
        return "marcas/resultado"; // Página de resultado
    }
}
