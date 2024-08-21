package com.ferreteria.controller;

import com.ferreteria.domain.Proveedor;
import com.ferreteria.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "proveedores/proveedores"; // Página principal con botones
    }

    @GetMapping("/insertar")
    public String mostrarFormularioInsertar() {
        return "proveedores/insertar"; // Página para insertar proveedor
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "proveedores/eliminar"; // Página para eliminar proveedor
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar() {
        return "proveedores/actualizar"; // Página para actualizar proveedor
    }

    @PostMapping("/agregar")
    public String agregarProveedor(String nombre, String telefono, String correo, String estado, Model model) {
        Proveedor proveedor = new Proveedor(nombre, telefono, correo, estado);
        String resultado = proveedorService.agregarProveedor(proveedor);
        model.addAttribute("resultado", resultado);
        return "proveedores/resultado"; // Página de resultado
    }

    @PostMapping("/eliminar")
    public String eliminarProveedor(String id, Model model) {
        int proveedorId = Integer.parseInt(id);
        String resultado = proveedorService.eliminarProveedor(proveedorId);
        model.addAttribute("resultado", resultado);
        return "proveedores/resultado"; // Página de resultado
    }

    @PostMapping("/actualizar")
    public String actualizarProveedor(String id, String nombre, String telefono, String correo, String estado, Model model) {
        Proveedor proveedor = new Proveedor(nombre, telefono, correo, estado);
        proveedor.setIdProveedor(Long.parseLong(id));
        String resultado = proveedorService.actualizarProveedor(proveedor);
        model.addAttribute("resultado", resultado);
        return "proveedores/resultado"; // Página de resultado
    }
}
