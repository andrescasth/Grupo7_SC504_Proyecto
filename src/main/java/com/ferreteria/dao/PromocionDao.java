package com.ferreteria.dao;

import com.ferreteria.domain.Promocion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class PromocionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PromocionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarPromocion(Promocion promocion) {
        String mensaje = "";
        String sql = "{call GRUPO7.Insertar_Promocion_sp(?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setDouble(1, promocion.getPorcentaje());
            cstmt.setString(2, promocion.getDescripcion());
            cstmt.setString(3, promocion.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar promoción: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPromocion(Long id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Promocion_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar promoción: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarPromocion(Promocion promocion) {
        String mensaje = "";
        String sql = "{call GRUPO7.Actualizar_Promocion_sp(?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, promocion.getIdPromocion());
            cstmt.setDouble(2, promocion.getPorcentaje());
            cstmt.setString(3, promocion.getDescripcion());
            cstmt.setString(4, promocion.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al actualizar promoción: " + e.getMessage();
        }
        return mensaje;
    }
}
