package com.ferreteria.dao;

import com.ferreteria.domain.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@Repository
public class InventarioDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InventarioDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarInventario(Inventario inventario) {
        String mensaje = "";
        String sql = "{call GRUPO7.Crear_Inventario_SP(?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, inventario.getIdInventario());
            cstmt.setInt(2, inventario.getCantidad());
            cstmt.setInt(3, inventario.getIdProducto());
            cstmt.setInt(4, inventario.getIdSucursal());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar inventario: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarInventario(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Inventario_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar inventario: " + e.getMessage();
        }
        return mensaje;
    }
}
