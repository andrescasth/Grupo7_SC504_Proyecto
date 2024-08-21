package com.ferreteria.controller;

import com.ferreteria.domain.Promocion;
import com.ferreteria.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/promociones")
public class PromocionController {

    private final PromocionService promocionService;

    @Autowired
    public PromocionController(PromocionService promocionService) {
        this.promocionService = promocionService;
    }

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "promociones/promociones"; // Página principal con botones
    }

    @GetMapping("/insertar")
    public String mostrarFormularioInsertar() {
        return "promociones/insertar"; // Página para insertar promoción
    }

    @PostMapping("/insertar")
    public String insertarPromocion(@RequestParam Double porcentaje, @RequestParam String descripcion, @RequestParam String estado, Model model) {
        Promocion promocion = new Promocion(porcentaje, descripcion, estado);
        String resultado = promocionService.agregarPromocion(promocion);
        model.addAttribute("resultado", resultado);
        return "promociones/resultado"; // Página de resultado
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "promociones/eliminar"; // Página para eliminar promoción
    }

    @PostMapping("/eliminar")
    public String eliminarPromocion(@RequestParam Long id, Model model) {
        String resultado = promocionService.eliminarPromocion(id);
        model.addAttribute("resultado", resultado);
        return "promociones/resultado"; // Página de resultado
    }

     @GetMapping("/actualizar")
    public String mostrarFormularioActualizar() {
        return "promociones/actualizar";
    }

    @PostMapping("/actualizar")
    public String actualizarPromocion(@RequestParam Long id, @RequestParam Double porcentaje, @RequestParam String descripcion, @RequestParam String estado, Model model) {
        Promocion promocion = new Promocion(id, porcentaje, descripcion, estado);
        String resultado = promocionService.actualizarPromocion(promocion);
        model.addAttribute("resultado", resultado);
        return "promociones/resultado";
    }
}
