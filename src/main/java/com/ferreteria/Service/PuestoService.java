package com.ferreteria.service;

import com.ferreteria.dao.PuestoDao;
import com.ferreteria.domain.Puesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuestoService {

    private final PuestoDao puestoDao;

    @Autowired
    public PuestoService(PuestoDao puestoDao) {
        this.puestoDao = puestoDao;
    }

    public String agregarPuesto(Puesto puesto) {
        return puestoDao.agregarPuesto(puesto);
    }

    public String eliminarPuesto(int id) {
        return puestoDao.eliminarPuesto(id);
    }
}

