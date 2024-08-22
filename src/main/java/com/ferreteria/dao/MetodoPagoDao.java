package com.ferreteria.dao;

import com.ferreteria.domain.MetodoPago;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MetodoPagoDao {

    private final JdbcTemplate jdbcTemplate;

    public MetodoPagoDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarMetodoPago(MetodoPago metodoPago) {
        String mensaje = "";
        String sql = "{call GRUPO7.Insertar_Metodo_Pago_SP(?, ?, ?, ?)}"; // Cambia a PROYECTO

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setString(1, metodoPago.getTipo());
            cstmt.setString(2, metodoPago.getDescripcion());
            cstmt.setString(3, metodoPago.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar método de pago: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarMetodoPago(Long id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Metodo_Pago_SP(?)}"; // Cambia a PROYECTO

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar método de pago: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarMetodoPago(MetodoPago metodoPago) {
        String mensaje = "";
        String sql = "{call GRUPO7.Actualizar_Metodo_Pago_SP(?, ?, ?, ?)}"; // Cambia a PROYECTO

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, metodoPago.getIdMetodoPago());
            cstmt.setString(2, metodoPago.getTipo());
            cstmt.setString(3, metodoPago.getDescripcion());
            cstmt.setString(4, metodoPago.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al actualizar método de pago: " + e.getMessage();
        }
        return mensaje;
    }

    public List<MetodoPago> obtenerMetodosPago() {
        String sql = "SELECT * FROM Metodo_Pago";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            MetodoPago metodoPago = new MetodoPago();
            metodoPago.setIdMetodoPago(rs.getLong("ID_Metodo_Pago"));
            metodoPago.setTipo(rs.getString("Tipo"));
            metodoPago.setDescripcion(rs.getString("Descripcion"));
            metodoPago.setEstado(rs.getString("Estado"));
            return metodoPago;
        });
    }
}
