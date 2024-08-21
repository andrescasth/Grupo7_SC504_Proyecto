package com.ferreteria.controller;

import com.ferreteria.domain.MetodoPago;
import com.ferreteria.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/metodosPago")
public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    @Autowired
    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "metodosPago/metodosPago"; // Página principal con dropdown
    }

    @GetMapping("/insertar")
    public String mostrarFormularioInsertar() {
        return "metodosPago/insertar"; // Página para insertar método de pago
    }

    @PostMapping("/insertar")
    public String insertarMetodoPago(@RequestParam String tipo, @RequestParam String descripcion, @RequestParam String estado, Model model) {
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setTipo(tipo);
        metodoPago.setDescripcion(descripcion);
        metodoPago.setEstado(estado);
        String resultado = metodoPagoService.agregarMetodoPago(metodoPago);
        model.addAttribute("resultado", resultado);
        return "metodosPago/resultado"; // Página de resultado
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "metodosPago/eliminar"; // Página para eliminar método de pago
    }

    @PostMapping("/eliminar")
    public String eliminarMetodoPago(@RequestParam Long id, Model model) {
        String resultado = metodoPagoService.eliminarMetodoPago(id);
        model.addAttribute("resultado", resultado);
        return "metodosPago/resultado"; // Página de resultado
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar() {
        return "metodosPago/actualizar"; // Página para actualizar método de pago
    }

    @PostMapping("/actualizar")
    public String actualizarMetodoPago(@RequestParam Long id, @RequestParam String tipo, @RequestParam String descripcion, @RequestParam String estado, Model model) {
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setIdMetodoPago(id);
        metodoPago.setTipo(tipo);
        metodoPago.setDescripcion(descripcion);
        metodoPago.setEstado(estado);
        String resultado = metodoPagoService.actualizarMetodoPago(metodoPago);
        model.addAttribute("resultado", resultado);
        return "metodosPago/resultado"; // Página de resultado
        
        
    }
    
    
}
