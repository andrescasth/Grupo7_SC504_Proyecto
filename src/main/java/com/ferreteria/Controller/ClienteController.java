package com.ferreteria.controller;

import com.ferreteria.domain.Cliente;
import com.ferreteria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/form")
    public String mostrarFormulario() {
        // Devuelve la vista del formulario
        return "clientes"; // Nombre del archivo clientes.html
    }

    @PostMapping("/agregar")
    public ModelAndView agregarCliente(String name, String direccion, String telefono, String email, String estado) {
        Cliente cliente = new Cliente(name, direccion, telefono, email, estado);
        String resultado = clienteService.agregarCliente(cliente);
        
        // Enviar el resultado a la vista
        ModelAndView modelAndView = new ModelAndView("resultado"); // Asegúrate de tener esta vista
        modelAndView.addObject("resultado", resultado);
        return modelAndView;
    }
}
