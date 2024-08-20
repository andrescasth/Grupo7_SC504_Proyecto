package com.ferreteria.dao;

import com.ferreteria.domain.Marca;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class MarcaDao {

    private final JdbcTemplate jdbcTemplate;

    public MarcaDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarMarca(Marca marca) {
        String mensaje = "";
        String sql = "{call GRUPO7.Insertar_Marca_sp(?, ?)}"; // Cambia a PROYECTO

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setString(1, marca.getNombre());
            cstmt.setString(2, marca.getDescripcion());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar marca: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarMarca(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Marca_sp(?)}"; // Cambia a PROYECTO

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar marca: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarMarca(Marca marca) {
        String mensaje = "";
        String sql = "{call GRUPO7.Actualizar_Marca_sp(?, ?, ?)}"; // Cambia a PROYECTO

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, marca.getIdMarca());
            cstmt.setString(2, marca.getNombre());
            cstmt.setString(3, marca.getDescripcion());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al actualizar marca: " + e.getMessage();
        }
        return mensaje;
    }
}
