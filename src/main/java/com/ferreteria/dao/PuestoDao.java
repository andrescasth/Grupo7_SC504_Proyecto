package com.ferreteria.dao;

import com.ferreteria.domain.Puesto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class PuestoDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PuestoDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarPuesto(Puesto puesto) {
        String mensaje = "";
        String sql = "{call GRUPO7.Insertar_Puesto_sp(?, ?, ?)}"; // Procedimiento de inserción

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setString(1, puesto.getNombre());
            cstmt.setDouble(2, puesto.getSalario());
            cstmt.setString(3, puesto.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar puesto: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPuesto(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Puesto_sp(?)}"; // Procedimiento de eliminación

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar puesto: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarPuesto(Puesto puesto) {
        String mensaje = "";
        String sql = "{call GRUPO7.Actualizar_Puesto_sp(?, ?, ?, ?)}"; // Procedimiento de actualización

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, puesto.getIdPuesto());
            cstmt.setString(2, puesto.getNombre());
            cstmt.setDouble(3, puesto.getSalario());
            cstmt.setString(4, puesto.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al actualizar puesto: " + e.getMessage();
        }
        return mensaje;
    }
}
