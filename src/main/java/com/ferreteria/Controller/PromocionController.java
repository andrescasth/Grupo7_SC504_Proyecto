package com.ferreteria.controller;

import com.ferreteria.domain.Promocion;
import com.ferreteria.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promociones")
public class PromocionController {

    private final PromocionService promocionService;

    @Autowired
    public PromocionController(PromocionService promocionService) {
        this.promocionService = promocionService;
    }

    @PostMapping("/agregar")
    public String agregarPromocion(@RequestBody Promocion promocion) {
        return promocionService.agregarPromocion(promocion);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarPromocion(@PathVariable int id) {
        return promocionService.eliminarPromocion(id);
    }
}
