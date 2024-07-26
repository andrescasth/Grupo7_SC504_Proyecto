package com.ferreteria.service;

import com.ferreteria.dao.MotivoDao;
import com.ferreteria.domain.Motivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotivoService {

    private final MotivoDao motivoDao;

    @Autowired
    public MotivoService(MotivoDao motivoDao) {
        this.motivoDao = motivoDao;
    }

    public String agregarMotivo(Motivo motivo) {
        return motivoDao.agregarMotivo(motivo);
    }

    public String eliminarMotivo(int id) {
        return motivoDao.eliminarMotivo(id);
    }
}
