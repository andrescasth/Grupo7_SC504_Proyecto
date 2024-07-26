package com.ferreteria.dao;

import com.ferreteria.domain.Devolucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class DevolucionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DevolucionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarDevolucion(Devolucion devolucion) {
        String mensaje = "";
        String sql = "{call GRUPO7.Crear_Devolucion_SP(?, ?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, devolucion.getIdDevolucion());
            cstmt.setString(2, devolucion.getFecha());  // Cambiado de Date a String
            cstmt.setDouble(3, devolucion.getTotal());
            cstmt.setInt(4, devolucion.getIdCliente());
            cstmt.setInt(5, devolucion.getIdEmpleado());
            cstmt.setInt(6, devolucion.getIdVenta());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar devolución: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarDevolucion(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Devolucion_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar devolución: " + e.getMessage();
        }
        return mensaje;
    }
}
