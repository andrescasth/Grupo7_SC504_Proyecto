package com.ferreteria.service;

import com.ferreteria.dao.FacturaDao;
import com.ferreteria.domain.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    private final FacturaDao facturaDao;

    @Autowired
    public FacturaService(FacturaDao facturaDao) {
        this.facturaDao = facturaDao;
    }

    public String agregarFactura(Factura factura) {
        return facturaDao.agregarFactura(factura);
    }

    public String eliminarFactura(int id) {
        return facturaDao.eliminarFactura(id);
    }
}
