package com.ferreteria.dao;

import com.ferreteria.domain.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class CuentaDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CuentaDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarCuenta(Cuenta cuenta) {
        String mensaje = "";
        String sql = "{call GRUPO7.Crear_Cuenta_SP(?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, cuenta.getIdCuenta());
            cstmt.setString(2, cuenta.getTipo());
            cstmt.setInt(3, cuenta.getSaldo());
            cstmt.setString(4, cuenta.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar cuenta: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarCuenta(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Cuenta_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar cuenta: " + e.getMessage();
        }
        return mensaje;
    }
}
