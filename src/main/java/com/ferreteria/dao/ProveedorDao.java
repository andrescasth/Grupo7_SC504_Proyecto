package com.ferreteria.dao;

import com.ferreteria.domain.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class ProveedorDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProveedorDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarProveedor(Proveedor proveedor) {
        String mensaje = "";
        String sql = "{call GRUPO7.Crear_Proveedor_SP(?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, proveedor.getIdProveedor());
            cstmt.setString(2, proveedor.getNombre());
            cstmt.setString(3, proveedor.getTelefono());
            cstmt.setString(4, proveedor.getCorreo());
            cstmt.setString(5, proveedor.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar proveedor: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarProveedor(int id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Proveedor_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar proveedor: " + e.getMessage();
        }
        return mensaje;
    }
}
