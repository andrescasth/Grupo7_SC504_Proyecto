package com.ferreteria.service;

import com.ferreteria.domain.Cliente;
import com.ferreteria.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteDao clienteDao;

    @Autowired
    public ClienteService(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public List<Cliente> obtenerClientes() {
        return clienteDao.obtenerClientes();
    }

    public String agregarCliente(Cliente cliente) {
        // Implementa la lógica para agregar cliente
        clienteDao.agregarCliente(cliente);
        return "Cliente agregado exitosamente";
    }

    public String eliminarCliente(Long id) {
        // Implementa la lógica para eliminar cliente
        clienteDao.eliminarCliente(id);
        return "Cliente eliminado exitosamente";
    }

    public String actualizarCliente(Cliente cliente) {
        // Implementa la lógica para actualizar cliente
        clienteDao.actualizarCliente(cliente);
        return "Cliente actualizado exitosamente";
    }
}
