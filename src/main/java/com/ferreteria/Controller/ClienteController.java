package com.ferreteria.controller;

import com.ferreteria.domain.Cliente;
import com.ferreteria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes"; // Nombre del archivo clientes.html
    }

    @PostMapping("/agregar")
    public String agregarCliente(Cliente cliente, Model model) {
        String resultado = clienteService.agregarCliente(cliente);
        model.addAttribute("resultado", resultado);
        return "resultado"; // Nombre del archivo resultado.html para mostrar el resultado
    }
}
