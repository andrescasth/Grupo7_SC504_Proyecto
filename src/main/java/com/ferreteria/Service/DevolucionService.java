package com.ferreteria.service;

import com.ferreteria.dao.DevolucionDao;
import com.ferreteria.domain.Devolucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevolucionService {

    private final DevolucionDao devolucionDao;

    @Autowired
    public DevolucionService(DevolucionDao devolucionDao) {
        this.devolucionDao = devolucionDao;
    }

    public String agregarDevolucion(Devolucion devolucion) {
        return devolucionDao.agregarDevolucion(devolucion);
    }

    public String eliminarDevolucion(int id) {
        return devolucionDao.eliminarDevolucion(id);
    }
}
