package com.ferreteria.dao;

import com.ferreteria.domain.Cuenta;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class CuentaDao {

    private final JdbcTemplate jdbcTemplate;

    public CuentaDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarCuenta(Cuenta cuenta) {
        String mensaje = "";
        String sql = "{call GRUPO7.Insertar_Cuenta_sp(?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setString(1, cuenta.getUsuario());
            cstmt.setString(2, cuenta.getContrasena());
            cstmt.setDate(3, cuenta.getFechaCreacion());
            cstmt.setLong(4, cuenta.getIdCliente());
            cstmt.setString(5, cuenta.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar cuenta: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarCuenta(Long id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Cuenta_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar cuenta: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarCuenta(Cuenta cuenta) {
        String mensaje = "";
        String sql = "{call GRUPO7.Actualizar_Cuenta_sp(?, ?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, cuenta.getId());
            cstmt.setString(2, cuenta.getUsuario());
            cstmt.setString(3, cuenta.getContrasena());
            cstmt.setDate(4, cuenta.getFechaCreacion());
            cstmt.setLong(5, cuenta.getIdCliente());
            cstmt.setString(6, cuenta.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al actualizar cuenta: " + e.getMessage();
        }
        return mensaje;
    }
}
