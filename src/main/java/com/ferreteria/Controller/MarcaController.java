package com.ferreteria.controller;

import com.ferreteria.domain.Marca;
import com.ferreteria.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    
    @GetMapping("/insertar")
    public String mostrarFormularioAgregar() {
        return "marcas/insertar"; // Página para agregar una nueva marca
    }

    @PostMapping("/insertar")
    public String agregarMarca(@RequestParam String nombre, @RequestParam String descripcion, Model model) {
        Marca marca = new Marca(nombre, descripcion);
        String resultado = marcaService.agregarMarca(marca);
        model.addAttribute("resultado", resultado);
        return "marcas/resultado"; // Página de resultado
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "marcas/eliminar"; // Página para eliminar una marca
    }

    @PostMapping("/eliminar")
    public String eliminarMarca(@RequestParam Long id, Model model) {
        String resultado = marcaService.eliminarMarca(id);
        model.addAttribute("resultado", resultado);
        return "marcas/resultado"; // Página de resultado
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar(Model model) {
        model.addAttribute("marcas", marcaService.obtenerMarcas()); // Enviar la lista de marcas al modelo para el dropdown
        return "marcas/actualizar"; // Página para actualizar una marca
    }

    @PostMapping("/actualizar")
    public String actualizarMarca(@RequestParam Long id,
                                  @RequestParam String nombre,
                                  @RequestParam String descripcion,
                                  Model model) {
        Marca marca = new Marca(nombre, descripcion);
        marca.setId(id); // Establecer el ID de la marca
        String resultado = marcaService.actualizarMarca(marca);
        model.addAttribute("resultado", resultado);
        return "marcas/resultado"; // Página de resultado
    }
}
