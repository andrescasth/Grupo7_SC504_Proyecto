package com.ferreteria.dao;

import com.ferreteria.domain.MetodoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class MetodoPagoDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MetodoPagoDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarMetodoPago(MetodoPago metodoPago) {
        String mensaje = "";
        String sql = "{call GRUPO7.Crear_Metodo_Pago_SP(?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer los parámetros de entrada
            cstmt.setInt(1, metodoPago.getID_Metodo_Pago());
            cstmt.setString(2, metodoPago.getTipo());
            cstmt.setString(3, metodoPago.getDescripcion());
            cstmt.setString(4, metodoPago.getEstado());

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar método de pago: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarMetodoPago(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Metodo_Pago_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer los parámetros de entrada
            cstmt.setInt(1, id);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar método de pago: " + e.getMessage();
        }
        return mensaje;
    }
}
