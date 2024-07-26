package com.ferreteria.dao;

import com.ferreteria.domain.Puesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class PuestoDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PuestoDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarPuesto(Puesto puesto) {
        String mensaje = "";
        String sql = "{call GRUPO7.Crear_Puesto_SP(?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer los parámetros de entrada
            cstmt.setInt(1, puesto.getID_Puesto());
            cstmt.setString(2, puesto.getNombre());
            cstmt.setDouble(3, puesto.getSalario());
            cstmt.setString(4, puesto.getEstado());

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar puesto: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPuesto(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Puesto_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer el parámetro de entrada
            cstmt.setInt(1, id);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar puesto: " + e.getMessage();
        }
        return mensaje;
    }
}

