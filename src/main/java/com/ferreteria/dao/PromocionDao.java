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
        String sql = "{call GRUPO7.Crear_Promocion_SP(?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer los parámetros de entrada
            cstmt.setInt(1, promocion.getID_Promocion());
            cstmt.setDouble(2, promocion.getPorcentaje());
            cstmt.setString(3, promocion.getDescripcion());
            cstmt.setString(4, promocion.getEstado());

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar promoción: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPromocion(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Promocion_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer los parámetros de entrada
            cstmt.setInt(1, id);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar promoción: " + e.getMessage();
        }
        return mensaje;
    }
}
