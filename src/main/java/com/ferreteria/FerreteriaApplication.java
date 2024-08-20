package com.ferreteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Oracle.Conexion;
import com.ferreteria.domain.Categoria;
import com.ferreteria.domain.Cliente;
import com.ferreteria.domain.Cuenta;
import com.ferreteria.domain.Devolucion;
import com.ferreteria.domain.Empleado;
import com.ferreteria.domain.Factura;
import com.ferreteria.domain.Inventario;
import com.ferreteria.domain.Marca;
import com.ferreteria.domain.MetodoPago;
import com.ferreteria.domain.Motivo;
import com.ferreteria.domain.Producto;
import com.ferreteria.domain.Promocion;
import com.ferreteria.domain.Proveedor;
import com.ferreteria.domain.Puesto;
import com.ferreteria.domain.Sucursal;
import com.ferreteria.domain.Venta;
import com.ferreteria.service.CategoriaService;
import com.ferreteria.service.ClienteService;
import com.ferreteria.service.CuentaService;
import com.ferreteria.service.DevolucionService;
import com.ferreteria.service.EmpleadoService;
import com.ferreteria.service.FacturaService;
import com.ferreteria.service.InventarioService;
import com.ferreteria.service.MarcaService;
import com.ferreteria.service.MetodoPagoService;
import com.ferreteria.service.MotivoService;
import com.ferreteria.service.ProductoService;
import com.ferreteria.service.PromocionService;
import com.ferreteria.service.ProveedorService;
import com.ferreteria.service.PuestoService;
import com.ferreteria.service.SucursalService;
import com.ferreteria.service.VentaService;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


//NOTA: CAMBIAR LOS ELIMINAR POR GETPRODUCTOID

@SpringBootApplication
public class FerreteriaApplication {

	public static void main(String[] args) {
        SpringApplication.run(FerreteriaApplication.class, args);
        }
/*
        // Verificar la conexión a la base de datos
        if (checkDatabaseConnection()) {
            System.out.println("La conexión a la base de datos fue exitosa.");
        } else {
            System.out.println("Error al conectar a la base de datos.");
        }
    }

    private static boolean checkDatabaseConnection() {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            if (connection != null && !connection.isClosed()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
        
    public static void main(String[] args) {
        SpringApplication.run(FerreteriaApplication.class, args);
    }
}

@Component
class DataInitializer implements CommandLineRunner {

    private final ClienteService clienteService;

    @Autowired
    public DataInitializer(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear un nuevo cliente
        Cliente cliente = new Cliente("Juan Pérez", "Av. Principal 123", "555-1234", "juan.perez@example.com", "Activo");

        // Agregar el cliente
        String resultado = clienteService.agregarCliente(cliente);

        // Mostrar el resultado
        System.out.println("Resultado al agregar cliente: " + resultado);
    }
        
         @Bean
    public CommandLineRunner demo(ProductoService productoService) {
        return (args) -> {
            // Crea un producto para agregar
                 
            Producto producto = new Producto(46, "Producto Ejemplo", "Descripción del producto", 2, 10, 1, 1, "Disponible");
            
            // Llama al método para agregar el producto
            String mensaje = productoService.agregarProducto(producto);
            System.out.println(mensaje);
            
            
             // Llama al método para eliminar el producto
            String mensajeEliminar = productoService.eliminarProducto(1);
            System.out.println(mensajeEliminar);
        };   
    }
    
     @Bean
    public CommandLineRunner demo(ClienteService clienteService) {
        return (args) -> {
            
            // Crea un cliente para agregar
            Cliente cliente = new Cliente( "Juan Pérez", "Calle 123", "555-1234", "juan@example.com", "Activo");
            
            // Llama al método para agregar el cliente
            String mensajeAgregar = clienteService.agregarCliente(cliente);
            System.out.println(mensajeAgregar);
/*
            // Llama al método para eliminar el cliente con ID 1
            String mensajeEliminar = clienteService.eliminarCliente(6);
            System.out.println(mensajeEliminar);
        };
    }
   
        
        @Bean
    public CommandLineRunner demo(MotivoService motivoService) {
        return (args) -> {
            // Crea un motivo para agregar
            Motivo motivo = new Motivo(46, "Motivo Ejemplo");

            // Llama al método para agregar el motivo
            String mensajeAgregar = motivoService.agregarMotivo(motivo);
            System.out.println(mensajeAgregar);

            // Llama al método para eliminar el motivo con ID 1
            String mensajeEliminar = motivoService.eliminarMotivo(42);
            System.out.println(mensajeEliminar);
        };
    }
   
    
    @Bean
    public CommandLineRunner demo(PromocionService promocionService) {
        return (args) -> {
            // Crea una promoción para agregar
            Promocion promocion = new Promocion(1, 15, "Descuento de Verano", "Activo");

            // Llama al método para agregar la promoción
            String mensajeAgregar = promocionService.agregarPromocion(promocion);

            // Llama al método para eliminar la promoción con ID 1
            String mensajeEliminar = promocionService.eliminarPromocion(1);
            System.out.println(mensajeEliminar);
        };
    }
    
              

    @Bean
    public CommandLineRunner demo(MetodoPagoService metodoPagoService) {
        return (args) -> {
            // Crea un método de pago para agregar
            MetodoPago metodoPago = new MetodoPago(1, "Tarjeta de Crédito", "Pago con tarjeta de crédito", "Activo");

            // Llama al método para agregar el método de pago
            String mensajeAgregar = metodoPagoService.agregarMetodoPago(metodoPago);
            System.out.println(mensajeAgregar);

            // Llama al método para eliminar el método de pago con ID 1
            String mensajeEliminar = metodoPagoService.eliminarMetodoPago(1);
            System.out.println(mensajeEliminar);
        };
    }
   
        
        
        
    @Bean
    public CommandLineRunner demo(SucursalService sucursalService) {
        return (args) -> {
            // Crea una sucursal para agregar
            Sucursal sucursal = new Sucursal(1, "Sucursal Ejemplo", "Calle 123", "555-5678", "Activo");

            // Llama al método para agregar la sucursal
            String mensajeAgregar = sucursalService.agregarSucursal(sucursal);
            System.out.println(mensajeAgregar);

            // Llama al método para eliminar la sucursal con ID 1
            String mensajeEliminar = sucursalService.eliminarSucursal(sucursal.getID_Sucursal());
            System.out.println(mensajeEliminar);
        };
    
    }
    
    
     @Bean
    public CommandLineRunner demo(PuestoService puestoService) {
        return (args) -> {
            // Crea un puesto para agregar
            Puesto puesto = new Puesto(1, "Gerente", 5000.00, "Activo");

            // Llama al método para agregar el puesto
            String mensajeAgregar = puestoService.agregarPuesto(puesto);
            System.out.println(mensajeAgregar);

            // Llama al método para eliminar el puesto con ID 1
            String mensajeEliminar = puestoService.eliminarPuesto(puesto.getID_Puesto());
            System.out.println(mensajeEliminar);
        };
    }
    
    
    
    @Bean
    public CommandLineRunner demo(CategoriaService categoriaService) {
        return (args) -> {
            // Crear una nueva categoría
            Categoria nuevaCategoria = new Categoria(1, "Electrónica", "Productos electrónicos");

            // Agregar la categoría
            String mensajeAgregar = categoriaService.agregarCategoria(nuevaCategoria);
            System.out.println(mensajeAgregar);

            // Eliminar la categoría
            String mensajeEliminar = categoriaService.eliminarCategoria(1);
            System.out.println(mensajeEliminar);
        };
    }
     
     @Bean
    public CommandLineRunner demo(MarcaService marcaService) {
        return (args) -> {
            // Crear una nueva marca
            Marca nuevaMarca = new Marca(1, "Marca Ejemplo", "Descripción de la marca");

            // Agregar la marca
            String mensajeAgregar = marcaService.agregarMarca(nuevaMarca);
            System.out.println(mensajeAgregar);

            // Eliminar la marca
            String mensajeEliminar = marcaService.eliminarMarca(1);
            System.out.println(mensajeEliminar);
        };
    }
    
    
    @Bean
    public CommandLineRunner demo(ProveedorService proveedorService) {
        return (args) -> {
            // Crear un nuevo proveedor
            Proveedor nuevoProveedor = new Proveedor(1, "Proveedor Ejemplo", "555-6789", "proveedor@example.com", "Activo");

            // Agregar el proveedor
            String mensajeAgregar = proveedorService.agregarProveedor(nuevoProveedor);
            System.out.println(mensajeAgregar);

            // Eliminar el proveedor
            String mensajeEliminar = proveedorService.eliminarProveedor(1);
            System.out.println(mensajeEliminar);
        };
    }
    
     @Bean
    public CommandLineRunner demo(CuentaService cuentaService) {
        return (args) -> {
            // Crear una nueva cuenta
            Cuenta nuevaCuenta = new Cuenta(1, "Ahorro", 150000, "Activo");

            // Agregar la cuenta
            String mensajeAgregar = cuentaService.agregarCuenta(nuevaCuenta);
            System.out.println(mensajeAgregar);

            // Eliminar la cuenta
            String mensajeEliminar = cuentaService.eliminarCuenta(1);
            System.out.println(mensajeEliminar);
        };
    }
    
    @Bean
    public CommandLineRunner demo(EmpleadoService empleadoService) {
        return (args) -> {
            // Crear un nuevo empleado
            Empleado nuevoEmpleado = new Empleado(1, "Juan Pérez", "Calle 456", "555-6789", "juan.perez@example.com", 1, 1, "Activo");

            // Agregar el empleado
            String mensajeAgregar = empleadoService.agregarEmpleado(nuevoEmpleado);
            System.out.println(mensajeAgregar);
            System.out.println(mensajeAgregar);

            // Eliminar el empleado
            String mensajeEliminar = empleadoService.eliminarEmpleado(1);
            System.out.println(mensajeEliminar);
        };
    }
    
     @Bean
    public CommandLineRunner demo(InventarioService inventarioService) {
        return (args) -> {
            // Crear un nuevo inventario
            Inventario nuevoInventario = new Inventario(1, 10, 1, 1, "15-07-2022", "Activo");

            // Agregar el inventario
            String mensajeAgregar = inventarioService.agregarInventario(nuevoInventario);

            // Eliminar el inventario
            String mensajeEliminar = inventarioService.eliminarInventario(1);
            System.out.println(mensajeEliminar);
        };
    }
    
     @Bean
    public CommandLineRunner demo(VentaService ventaService) {
        return (args) -> {
            // Crear una nueva venta
            Venta nuevaVenta = new Venta(1, "15-07-2001", 150.00, 1, 1, 1, 1, "Completada");

            // Agregar la venta
            String mensajeAgregar = ventaService.agregarVenta(nuevaVenta);
            System.out.println(mensajeAgregar);

            // Eliminar la venta
            String mensajeEliminar = ventaService.eliminarVenta(1);
            System.out.println(mensajeEliminar);
        };
    }
  
        @Bean
    public CommandLineRunner demoDevolucion(DevolucionService devolucionService) {
        return (args) -> {
            // Crear una nueva devolución
            Devolucion nuevaDevolucion = new Devolucion(1, "15-07-2022", 50.00, 1, 1, 1,1,1);

            // Agregar la devolución
            String mensajeAgregar = devolucionService.agregarDevolucion(nuevaDevolucion);
            System.out.println(mensajeAgregar);

            // Eliminar la devolución
            String mensajeEliminar = devolucionService.eliminarDevolucion(1);
            System.out.println(mensajeEliminar);
        };
    }
    @Bean
    public CommandLineRunner demoFactura(FacturaService facturaService) {
        return (args) -> {
            // Crear una nueva factura
            Factura nuevaFactura = new Factura(1, 1, 1, 10, 150.00, 1, "15-07-2022", "Activa");

            // Agregar la factura
            String mensajeAgregar = facturaService.agregarFactura(nuevaFactura);
            System.out.println(mensajeAgregar);

            // Eliminar la factura
            String mensajeEliminar = facturaService.eliminarFactura(1);
            System.out.println(mensajeEliminar);
        };
    }*/

}
