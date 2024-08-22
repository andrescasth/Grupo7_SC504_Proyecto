package com.ferreteria.controller;

import com.ferreteria.domain.Producto;
import com.ferreteria.domain.Categoria;
import com.ferreteria.domain.Marca;
import com.ferreteria.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "productos/productos"; // Página principal con botones
    }
   

    @GetMapping("/insertar")
    public String mostrarFormularioInsertar(Model model) {
        List<Categoria> categorias = productoService.obtenerCategorias(); // Obtener lista de categorías
        List<Marca> marcas = productoService.obtenerMarcas(); // Obtener lista de marcas
        model.addAttribute("categorias", categorias);
        model.addAttribute("marcas", marcas);
        return "productos/insertar"; // Página para insertar producto
    }

    @PostMapping("/agregar")
    public String agregarProducto(
            @RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam Double precio,
            @RequestParam Integer stock,
            @RequestParam Long idCategoria,
            @RequestParam Long idMarca,
            @RequestParam String estado,
            Model model) {

        Producto producto = new Producto(nombre, descripcion, precio, stock, idCategoria, idMarca, estado);
        String resultado = productoService.agregarProducto(producto);
        model.addAttribute("resultado", resultado);
        return "productos/resultado"; // Página de resultado
    }

    @GetMapping("/eliminar")
    public String mostrarFormularioEliminar() {
        return "productos/eliminar"; // Página para eliminar producto
    }

    @PostMapping("/eliminar")
    public String eliminarProducto(@RequestParam Long id, Model model) {
        String resultado = productoService.eliminarProducto(id);
        model.addAttribute("resultado", resultado);
        return "productos/resultado"; // Página de resultado
    }

    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar(Model model) {
        List<Categoria> categorias = productoService.obtenerCategorias(); // Obtener lista de categorías
        List<Marca> marcas = productoService.obtenerMarcas(); // Obtener lista de marcas
        model.addAttribute("categorias", categorias);
        model.addAttribute("marcas", marcas);
        return "productos/actualizar"; // Página para actualizar producto
    }

    @PostMapping("/actualizar")
    public String actualizarProducto(
            @RequestParam Long id,
            @RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam Double precio,
            @RequestParam Integer stock,
            @RequestParam Long idCategoria,
            @RequestParam Long idMarca,
            @RequestParam String estado,
            Model model) {

        Producto producto = new Producto(nombre, descripcion, precio, stock, idCategoria, idMarca, estado);
        producto.setIdProducto(id);
        String resultado = productoService.actualizarProducto(producto);
        model.addAttribute("resultado", resultado);
        return "productos/resultado"; // Página de resultado
    }
}
