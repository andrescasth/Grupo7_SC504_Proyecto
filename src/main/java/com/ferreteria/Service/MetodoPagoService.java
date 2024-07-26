package com.ferreteria.service;

import com.ferreteria.dao.MetodoPagoDao;
import com.ferreteria.domain.MetodoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodoPagoService {

    private final MetodoPagoDao metodoPagoDao;

    @Autowired
    public MetodoPagoService(MetodoPagoDao metodoPagoDao) {
        this.metodoPagoDao = metodoPagoDao;
    }

    public String agregarMetodoPago(MetodoPago metodoPago) {
        return metodoPagoDao.agregarMetodoPago(metodoPago);
    }

    public String eliminarMetodoPago(int id) {
        return metodoPagoDao.eliminarMetodoPago(id);
    }
}
