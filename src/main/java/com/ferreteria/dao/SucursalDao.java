package com.ferreteria.dao;

import com.ferreteria.domain.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class SucursalDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SucursalDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarSucursal(Sucursal sucursal) {
        String mensaje = "";
        String sql = "{call GRUPO7.Crear_Sucursal_SP(?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer los parámetros de entrada
            cstmt.setInt(1, sucursal.getID_Sucursal());
            cstmt.setString(2, sucursal.getNombre());
            cstmt.setString(3, sucursal.getDireccion());
            cstmt.setString(4, sucursal.getTelefono());
            cstmt.setString(5, sucursal.getEstado());

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar sucursal: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarSucursal(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Sucursal_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer los parámetros de entrada
            cstmt.setInt(1, id);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar sucursal: " + e.getMessage();
        }
        return mensaje;
    }
}
