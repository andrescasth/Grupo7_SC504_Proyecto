package com.ferreteria.dao;

import com.ferreteria.domain.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@Repository
public class VentaDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VentaDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarVenta(Venta venta) {
        String mensaje = "";
        String sql = "{call GRUPO7.Crear_Venta_SP(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, venta.getIdVenta());
            cstmt.setString(2, "15-07-2001");
            cstmt.setDouble(3, venta.getTotal());
            cstmt.setInt(4, venta.getIdProducto());
            cstmt.setInt(5, venta.getIdCliente());
            cstmt.setInt(6, venta.getIdSucursal());
            cstmt.setInt(7, venta.getIdMetodoPago());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar venta: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarVenta(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Venta_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar venta: " + e.getMessage();
        }
        return mensaje;
    }
}
