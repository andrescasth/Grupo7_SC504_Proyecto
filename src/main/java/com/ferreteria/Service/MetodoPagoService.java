package com.ferreteria.service;

import com.ferreteria.dao.MetodoPagoDAO;
import com.ferreteria.domain.MetodoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagoService {

    private final MetodoPagoDAO metodoPagoDAO;

    @Autowired
    public MetodoPagoService(MetodoPagoDAO metodoPagoDAO) {
        this.metodoPagoDAO = metodoPagoDAO;
    }

    public String agregarMetodoPago(MetodoPago metodoPago) {
        return metodoPagoDAO.agregarMetodoPago(metodoPago);
    }

    public String eliminarMetodoPago(Long id) {
        return metodoPagoDAO.eliminarMetodoPago(id);
    }

    public String actualizarMetodoPago(MetodoPago metodoPago) {
        return metodoPagoDAO.actualizarMetodoPago(metodoPago);
    }

    public List<MetodoPago> obtenerMetodosPago() {
        return metodoPagoDAO.obtenerMetodosPago();
    }
}
