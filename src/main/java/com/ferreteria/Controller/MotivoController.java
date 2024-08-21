package com.ferreteria.controller;

import com.ferreteria.domain.Motivo;
import com.ferreteria.service.MotivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motivos")
public class MotivoController {

    private final MotivoService motivoService;

    @Autowired
    public MotivoController(MotivoService motivoService) {
        this.motivoService = motivoService;
    }

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "motivos/motivos"; // Página principal con botones
    }
@GetMapping("/insertar")
    public String mostrarFormularioInsertar() {
        return "motivos/insertar"; // Página para insertar motivo
    }

    @PostMapping("/insertar")
    public String insertarMotivo(@RequestParam String descripcion, Model model) {
        Motivo motivo = new Motivo();
        motivo.setDescripcion(descripcion);
        String resultado = motivoService.agregarMotivo(motivo);
        model.addAttribute("resultado", resultado);
        return "motivos/resultado"; // Página de resultado
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "motivos/eliminar"; // Página para eliminar motivo
    }

    @PostMapping("/eliminar")
    public String eliminarMotivo(@RequestParam Long id, Model model) {
        String resultado = motivoService.eliminarMotivo(id);
        model.addAttribute("resultado", resultado);
        return "motivos/resultado"; // Página de resultado
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar() {
        return "motivos/actualizar"; // Página para actualizar motivo
    }

    @PostMapping("/actualizar")
    public String actualizarMotivo(@RequestParam Long id, @RequestParam String descripcion, Model model) {
        Motivo motivo = new Motivo();
        motivo.setID_Motivo(id);
        motivo.setDescripcion(descripcion);
        String resultado = motivoService.actualizarMotivo(motivo);
        model.addAttribute("resultado", resultado);
        return "motivos/resultado"; // Página de resultado
    }
}