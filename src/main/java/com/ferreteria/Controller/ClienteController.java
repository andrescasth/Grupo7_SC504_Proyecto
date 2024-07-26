package com.ferreteria.controller;

import com.ferreteria.domain.Cliente;
import com.ferreteria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/agregar")
    public String agregarCliente(@RequestBody Cliente cliente) {
        return clienteService.agregarCliente(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable int id) {
        return clienteService.eliminarCliente(id);
    }
}
