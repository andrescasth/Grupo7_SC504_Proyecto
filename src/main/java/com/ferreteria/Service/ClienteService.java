package com.ferreteria.service;

import com.ferreteria.dao.ClienteDao;
import com.ferreteria.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteDao clienteDao;

    @Autowired
    public ClienteService(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public String agregarCliente(Cliente cliente) {
        return clienteDao.agregarCliente(cliente);
    }

    public String eliminarCliente(int id) {
        return clienteDao.eliminarCliente(id);
    }
    
}
