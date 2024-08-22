package com.ferreteria.controller;

import com.ferreteria.domain.Cuenta;
import com.ferreteria.domain.Cliente;
import com.ferreteria.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    @Autowired
    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "cuentas/cuentas"; // Página principal con botones
    }

    @GetMapping("/insertar")
    public String mostrarFormularioInsertar(Model model) {
        List<Cliente> clientes = cuentaService.obtenerClientes(); // Obtener lista de clientes
        model.addAttribute("clientes", clientes);
        return "cuentas/insertar"; // Página para insertar cuenta
    }

    @PostMapping("/agregar")
    public String agregarCuenta(
            @RequestParam String usuario,
            @RequestParam String contrasena,
            @RequestParam("fechaCreacion") String fechaCreacion,
            @RequestParam Long idCliente,
            @RequestParam String estado,
            Model model) {

        Cuenta cuenta = new Cuenta(usuario, contrasena, java.sql.Date.valueOf(fechaCreacion), idCliente, estado);
        String resultado = cuentaService.agregarCuenta(cuenta);
        model.addAttribute("resultado", resultado);
        return "cuentas/resultado"; // Página de resultado
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "cuentas/eliminar"; // Página para eliminar cuenta
    }

    @PostMapping("/eliminar")
    public String eliminarCuenta(@RequestParam Long id, Model model) {
        String resultado = cuentaService.eliminarCuenta(id);
        model.addAttribute("resultado", resultado);
        return "cuentas/resultado"; // Página de resultado
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar(Model model) {
        List<Cliente> clientes = cuentaService.obtenerClientes(); // Obtener lista de clientes para el dropdown
        model.addAttribute("clientes", clientes);
        return "cuentas/actualizar"; // Página para actualizar cuenta
    }

    @PostMapping("/actualizar")
    public String actualizarCuenta(
            @RequestParam Long id,
            @RequestParam String usuario,
            @RequestParam String contrasena,
            @RequestParam("fechaCreacion") String fechaCreacion,
            @RequestParam Long idCliente,
            @RequestParam String estado,
            Model model) {

        Cuenta cuenta = new Cuenta(usuario, contrasena, java.sql.Date.valueOf(fechaCreacion), idCliente, estado);
        cuenta.setId(id);
        String resultado = cuentaService.actualizarCuenta(cuenta);
        model.addAttribute("resultado", resultado);
        return "cuentas/resultado"; // Página de resultado
    }
}
