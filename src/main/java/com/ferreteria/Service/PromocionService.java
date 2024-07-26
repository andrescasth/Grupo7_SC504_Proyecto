package com.ferreteria.service;

import com.ferreteria.dao.PromocionDao;
import com.ferreteria.domain.Promocion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocionService {

    private final PromocionDao promocionDao;

    @Autowired
    public PromocionService(PromocionDao promocionDao) {
        this.promocionDao = promocionDao;
    }

    public String agregarPromocion(Promocion promocion) {
        return promocionDao.agregarPromocion(promocion);
    }

    public String eliminarPromocion(int id) {
        return promocionDao.eliminarPromocion(id);
    }
}
