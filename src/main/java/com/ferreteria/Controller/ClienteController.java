package com.ferreteria.controller;

import com.ferreteria.domain.Cliente;
import com.ferreteria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Mostrar formulario principal
    @GetMapping("/form")
    public String mostrarFormulario() {
        return "clientes/clientes"; // Página principal con botones
    }

    // Mostrar formulario para insertar cliente
    @GetMapping("/insertar")
    public String mostrarFormularioInsertar() {
        return "clientes/insertar"; // Página para insertar cliente
    }

    // Mostrar formulario para eliminar cliente
    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "clientes/eliminar"; // Página para eliminar cliente
    }

    // Mostrar formulario para actualizar cliente
    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar(Model model) {
        model.addAttribute("clientes", clienteService.obtenerClientes()); // Enviar la lista de clientes al modelo para el dropdown
        return "clientes/actualizar"; // Página para actualizar cliente
    }

    // Manejar la solicitud de agregar cliente
    @PostMapping("/agregar")
    public String agregarCliente(@RequestParam("nombre") String nombre,
                                 @RequestParam("direccion") String direccion,
                                 @RequestParam("telefono") String telefono,
                                 @RequestParam("correo") String correo,
                                 @RequestParam("estado") String estado,
                                 Model model) {
        Cliente cliente = new Cliente(nombre, direccion, telefono, correo, estado);
        String resultado = clienteService.agregarCliente(cliente);
        model.addAttribute("resultado", resultado);
        return "clientes/resultado"; // Página de resultado
    }

    // Manejar la solicitud de eliminar cliente
    @PostMapping("/eliminar")
    public String eliminarCliente(@RequestParam("id") Long id, Model model) {
        String resultado = clienteService.eliminarCliente(id);
        model.addAttribute("resultado", resultado);
        return "clientes/resultado"; // Página de resultado
    }

    // Manejar la solicitud de actualizar cliente
    @PostMapping("/actualizar")
    public String actualizarCliente(@RequestParam("id") String id,
                                    @RequestParam("nombre") String nombre,
                                    @RequestParam("direccion") String direccion,
                                    @RequestParam("telefono") String telefono,
                                    @RequestParam("correo") String correo,
                                    @RequestParam("estado") String estado,
                                    Model model) {
        Cliente cliente = new Cliente(nombre, direccion, telefono, correo, estado);
        cliente.setId(Long.parseLong(id)); // Convertir el ID de String a Long
        String resultado = clienteService.actualizarCliente(cliente);
        model.addAttribute("resultado", resultado);
        return "clientes/resultado"; // Página de resultado
    }
}
