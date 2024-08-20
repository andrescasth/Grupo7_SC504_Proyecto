package com.ferreteria.controller;

import com.ferreteria.dao.ClienteDao;
import com.ferreteria.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class IndexController {

    private final ClienteDao clienteDao;

    @Autowired
    public IndexController(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }
/*
    @PostMapping("/agregar")
    public ModelAndView agregarCliente(@RequestParam("nombre") String nombre,
                                       @RequestParam("direccion") String direccion,
                                       @RequestParam("telefono") String telefono,
                                       @RequestParam("correo") String correo,
                                       @RequestParam("estado") String estado) {

        Cliente cliente = new Cliente(nombre, direccion, telefono, correo, estado);
        String mensaje = clienteDao.agregarCliente(cliente);

        ModelAndView modelAndView = new ModelAndView("resultado");
        modelAndView.addObject("mensaje", mensaje);

        return modelAndView;
    }*/
}
