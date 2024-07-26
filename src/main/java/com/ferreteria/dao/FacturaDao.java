package com.ferreteria.dao;

import com.ferreteria.domain.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class FacturaDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FacturaDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarFactura(Factura factura) {
        String mensaje = "";
        String sql = "{call GRUPO7.Crear_Factura_SP(?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, factura.getIdFactura());
            cstmt.setString(2, factura.getFechaCompra()); // Cambiado a String
            cstmt.setDouble(3, factura.getCostoTotal());
            cstmt.setInt(4, factura.getIdProducto());
            cstmt.setInt(5, factura.getIdProveedor());
            // Ajusta los parámetros según tu procedimiento almacenado

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar factura: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarFactura(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Factura_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar factura: " + e.getMessage();
        }
        return mensaje;
    }
}
