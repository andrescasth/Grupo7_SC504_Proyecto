package com.ferreteria.dao;

import com.ferreteria.domain.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteDao {

    private final JdbcTemplate jdbcTemplate;

    public ClienteDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

     public List<Cliente> obtenerClientes() {
        String sql = "SELECT id_cliente, nombre FROM grupo7.Cliente"; // Actualizado para usar id_cliente
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getLong("id_cliente")); // Actualizado para usar id_cliente
            cliente.setNombre(rs.getString("nombre"));
            return cliente;
        });
    }
    

    public String agregarCliente(Cliente cliente) {
        String mensaje = "";
        String sql = "{call GRUPO7.Insertar_Cliente_sp(?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setString(1, cliente.getNombre());
            cstmt.setString(2, cliente.getDireccion());
            cstmt.setString(3, cliente.getTelefono());
            cstmt.setString(4, cliente.getCorreo());
            cstmt.setString(5, cliente.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar cliente: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarCliente(Long id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Cliente_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, id);

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar cliente: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarCliente(Cliente cliente) {
        String mensaje = "";
        String sql = "{call GRUPO7.Actualizar_Cliente_sp(?, ?, ?, ?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, cliente.getId());
            cstmt.setString(2, cliente.getNombre());
            cstmt.setString(3, cliente.getDireccion());
            cstmt.setString(4, cliente.getTelefono());
            cstmt.setString(5, cliente.getCorreo());
            cstmt.setString(6, cliente.getEstado());

            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al actualizar cliente: " + e.getMessage();
        }
        return mensaje;
    }
}
