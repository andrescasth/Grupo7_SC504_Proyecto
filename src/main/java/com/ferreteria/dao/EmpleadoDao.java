package com.ferreteria.dao;

import com.ferreteria.domain.Empleado;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class EmpleadoDao {

    private final JdbcTemplate jdbcTemplate;

    public EmpleadoDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarEmpleado(Empleado empleado) {
        String mensaje = "";
        String sql = "{call GRUPO7.Insertar_Empleado_sp(?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setString(1, empleado.getDireccion());
            cstmt.setString(2, empleado.getEmail());
            cstmt.setLong(3, empleado.getIdSucursal());
            cstmt.setLong(4, empleado.getIdPuesto());
            cstmt.setString(5, empleado.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar empleado: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarEmpleado(Long id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Empleado_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar empleado: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarEmpleado(Empleado empleado) {
        String mensaje = "";
        String sql = "{call GRUPO7.Actualizar_Empleado_sp(?, ?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, empleado.getIdEmpleado());
            cstmt.setString(2, empleado.getDireccion());
            cstmt.setString(3, empleado.getEmail());
            cstmt.setLong(4, empleado.getIdSucursal());
            cstmt.setLong(5, empleado.getIdPuesto());
            cstmt.setString(6, empleado.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al actualizar empleado: " + e.getMessage();
        }
        return mensaje;
    }
}
