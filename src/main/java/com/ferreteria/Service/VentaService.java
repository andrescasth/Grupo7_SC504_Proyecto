package com.ferreteria.service;

import com.ferreteria.dao.VentaDao;
import com.ferreteria.domain.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {

    private final VentaDao ventaDao;

    @Autowired
    public VentaService(VentaDao ventaDao) {
        this.ventaDao = ventaDao;
    }

    public String agregarVenta(Venta venta) {
        return ventaDao.agregarVenta(venta);
    }

    public String eliminarVenta(int id) {
        return ventaDao.eliminarVenta(id);
    }
}
