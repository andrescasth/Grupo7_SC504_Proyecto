package com.ferreteria.dao;

import com.ferreteria.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class EmpleadoDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmpleadoDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarEmpleado(Empleado empleado) {
        String mensaje = "";
        String sql = "{call GRUPO7.Crear_Empleado_SP(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, empleado.getIdEmpleado());
            cstmt.setString(2, empleado.getNombre());
            cstmt.setString(3, empleado.getDireccion());
            cstmt.setString(4, empleado.getTelefono());
            cstmt.setString(5, empleado.getCorreo());
            cstmt.setString(6, empleado.getEstado());
            cstmt.setInt(7, empleado.getIdPuesto());
            cstmt.setInt(8, empleado.getIdSucursal());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar empleado: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarEmpleado(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Empleado_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar empleado: " + e.getMessage();
        }
        return mensaje;
    }
}
