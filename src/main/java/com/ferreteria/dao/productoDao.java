package com.ferreteria.dao;

import com.ferreteria.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class productoDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public productoDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarProducto(Producto producto) {
    String mensaje = "";
    String sql = "{call Crear_Producto_SP(?, ?, ?, ?, ?, ?, ?, ?)}";

    try (Connection con = jdbcTemplate.getDataSource().getConnection();
         CallableStatement cstmt = con.prepareCall(sql)) {

        // Establecer los parámetros de entrada
        cstmt.setInt(1, producto.getID_producto());
        cstmt.setString(2, producto.getNombre());
        cstmt.setString(3, producto.getDescripcion());
        cstmt.setDouble(4, producto.getPrecio());
        cstmt.setInt(5, producto.getStock());
        cstmt.setInt(6, producto.getID_categoria());
        cstmt.setInt(7, producto.getID_marca());
        cstmt.setString(8, producto.getEstado());

        // Ejecutar el procedimiento almacenado
        cstmt.execute();

    } catch (SQLException e) {
        e.printStackTrace();
        mensaje = "Error al agregar producto: " + e.getMessage();
    }
    return mensaje;
    
    
}
    public String eliminarProducto(int idProducto) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Producto_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer el parámetro de entrada
            cstmt.setInt(1, idProducto);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar producto: " + e.getMessage();
        }
        return mensaje;
    }
}