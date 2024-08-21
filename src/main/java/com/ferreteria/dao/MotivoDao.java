package com.ferreteria.dao;

import com.ferreteria.domain.Motivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class MotivoDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MotivoDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarMotivo(Motivo motivo) {
        String mensaje = "";
        String sql = "{call GRUPO7.Crear_Motivo_SP(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer los parámetros de entrada
            cstmt.setString(1, motivo.getDescripcion()); // ID generado automáticamente

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar motivo: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarMotivo(Long id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Motivo_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer los parámetros de entrada
            cstmt.setLong(1, id);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar motivo: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarMotivo(Motivo motivo) {
        String mensaje = "";
        String sql = "{call GRUPO7.Actualizar_Motivo_SP(?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer los parámetros de entrada
            cstmt.setLong(1, motivo.getID_Motivo());
            cstmt.setString(2, motivo.getDescripcion());

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al actualizar motivo: " + e.getMessage();
        }
        return mensaje;
    }
}
