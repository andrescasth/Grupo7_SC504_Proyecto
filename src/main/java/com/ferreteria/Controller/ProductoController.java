package com.ferreteria.controller;

import com.ferreteria.domain.Producto;
import com.ferreteria.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/agregar")
    public String agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }
}
