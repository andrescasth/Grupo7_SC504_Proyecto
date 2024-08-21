package com.ferreteria.dao;



import com.ferreteria.domain.Sucursal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class SucursalDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SucursalDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String insertarSucursal(Sucursal sucursal) {
        String mensaje = "";
        String sql = "{call GRUPO7.Insertar_Sucursal_SP(?, ?, ?, ?)}"; // Nombre del procedimiento almacenado

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setString(1, sucursal.getNombre());
            cstmt.setString(2, sucursal.getDireccion());
            cstmt.setString(3, sucursal.getTelefono());
            cstmt.setString(4, sucursal.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al insertar sucursal: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarSucursal(Long idSucursal) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Sucursal_SP(?)}"; // Nombre del procedimiento almacenado

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, idSucursal);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar sucursal: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarSucursal(Sucursal sucursal) {
        String mensaje = "";
        String sql = "{call GRUPO7.Actualizar_Sucursal_SP(?, ?, ?, ?, ?)}"; // Nombre del procedimiento almacenado

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, sucursal.getIdSucursal());
            cstmt.setString(2, sucursal.getNombre());
            cstmt.setString(3, sucursal.getDireccion());
            cstmt.setString(4, sucursal.getTelefono());
            cstmt.setString(5, sucursal.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al actualizar sucursal: " + e.getMessage();
        }
        return mensaje;
    }
}
