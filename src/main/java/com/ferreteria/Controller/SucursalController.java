package com.ferreteria.controller;

import com.ferreteria.domain.Sucursal;
import com.ferreteria.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    @Autowired
    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "sucursales/sucursales"; // Página principal con botones
    }

    @GetMapping("/insertar")
    public String mostrarFormularioInsertar() {
        return "sucursales/insertar"; // Página para insertar sucursal
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "sucursales/eliminar"; // Página para eliminar sucursal
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar() {
        return "sucursales/actualizar"; // Página para actualizar sucursal
    }

    @PostMapping("/agregar")
    public String agregarSucursal(String nombre, String direccion, String telefono, String estado, Model model) {
        Sucursal sucursal = new Sucursal(nombre, direccion, telefono, estado);
        String resultado = sucursalService.insertarSucursal(sucursal);
        model.addAttribute("resultado", resultado);
        return "sucursales/resultado"; // Página de resultado
    }

    @PostMapping("/eliminar")
    public String eliminarSucursal(String id, Model model) {
        Long sucursalId = Long.parseLong(id);
        String resultado = sucursalService.eliminarSucursal(sucursalId);
        model.addAttribute("resultado", resultado);
        return "sucursales/resultado"; // Página de resultado
    }

    @PostMapping("/actualizar")
    public String actualizarSucursal(String id, String nombre, String direccion, String telefono, String estado, Model model) {
        Sucursal sucursal = new Sucursal(nombre, direccion, telefono, estado);
        sucursal.setIdSucursal(Long.parseLong(id));
        String resultado = sucursalService.actualizarSucursal(sucursal);
        model.addAttribute("resultado", resultado);
        return "sucursales/resultado"; // Página de resultado
    }
}