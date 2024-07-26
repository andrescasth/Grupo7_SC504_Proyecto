package com.ferreteria.dao;

import com.ferreteria.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class ClienteDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClienteDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String agregarCliente(Cliente cliente) {
        String mensaje = "";
        String sql = "{call Crear_Cliente_SP(?, ?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer los parámetros de entrada
            cstmt.setInt(1, cliente.getID_Cliente());
            cstmt.setString(2, cliente.getNombre());
            cstmt.setString(3, cliente.getDireccion());
            cstmt.setString(4, cliente.getTelefono());
            cstmt.setString(5, cliente.getCorreo());
            cstmt.setString(6, cliente.getEstado());

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar cliente: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarCliente(int id) {
        String mensaje = "";
        String sql = "{call Eliminar_Cliente_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            // Establecer el parámetro de entrada
            cstmt.setInt(1, id);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar cliente: " + e.getMessage();
        }
        return mensaje;
    }
}
