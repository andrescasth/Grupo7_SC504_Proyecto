package com.ferreteria.controller;

import com.ferreteria.domain.Puesto;
import com.ferreteria.service.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/puestos")
public class PuestoController {

    private final PuestoService puestoService;

    @Autowired
    public PuestoController(PuestoService puestoService) {
        this.puestoService = puestoService;
    }

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "puestos/puestos"; // Página principal con botones
    }

    @GetMapping("/insertar")
    public String mostrarFormularioInsertar() {
        return "puestos/insertar"; // Página para insertar puesto
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "puestos/eliminar"; // Página para eliminar puesto
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar() {
        return "puestos/actualizar"; // Página para actualizar puesto
    }

    @PostMapping("/agregar")
    public String agregarPuesto(String nombre, String salario, String estado, Model model) {
        Puesto puesto = new Puesto(nombre, Double.parseDouble(salario), estado);
        String resultado = puestoService.agregarPuesto(puesto);
        model.addAttribute("resultado", resultado);
        return "puestos/resultado"; // Página de resultado
    }

    @PostMapping("/eliminar")
    public String eliminarPuesto(String id, Model model) {
        int puestoId = Integer.parseInt(id);
        String resultado = puestoService.eliminarPuesto(puestoId);
        model.addAttribute("resultado", resultado);
        return "puestos/resultado"; // Página de resultado
    }

    @PostMapping("/actualizar")
    public String actualizarPuesto(String id, String nombre, String salario, String estado, Model model) {
        Puesto puesto = new Puesto(nombre, Double.parseDouble(salario), estado);
        puesto.setIdPuesto(Long.parseLong(id));
        String resultado = puestoService.actualizarPuesto(puesto);
        model.addAttribute("resultado", resultado);
        return "puestos/resultado"; // Página de resultado
    }
}
