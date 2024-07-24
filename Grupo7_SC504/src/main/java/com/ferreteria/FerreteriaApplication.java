package com.ferreteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Oracle.Conexion;
import com.ferreteria.domain.Producto;
import com.ferreteria.service.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FerreteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FerreteriaApplication.class, args);
                
               
	}
         @Bean
    public CommandLineRunner demo(ProductoService productoService) {
        return (args) -> {
            // Crea un producto para agregar
            Producto producto = new Producto(1, "Producto Ejemplo", "Descripción del producto", 2, 10, 1, 1, "Disponible");
            
            // Llama al método para agregar el producto
            String mensaje = productoService.agregarProducto(producto);
            System.out.println(mensaje);
        };
    }

}
