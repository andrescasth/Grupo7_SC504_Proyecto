package com.ferreteria.dao;

import com.ferreteria.domain.Marca;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MarcaDao {

    private final JdbcTemplate jdbcTemplate;

    public MarcaDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Marca> obtenerMarcas() {
        String sql = "SELECT id_marca, nombre, descripcion FROM grupo7.Marca";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Marca marca = new Marca();
            marca.setId(rs.getLong("id_marca"));
            marca.setNombre(rs.getString("nombre"));
            marca.setDescripcion(rs.getString("descripcion"));
            return marca;
        });
    }

    public String agregarMarca(Marca marca) {
        String mensaje = "";
        String sql = "{call GRUPO7.Insertar_Marca_sp(?,?)}";

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

    public String eliminarMarca(Long id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Marca_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, id);
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar marca: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarMarca(Marca marca) {
        String mensaje = "";
        String sql = "{call GRUPO7.Actualizar_Marca_sp(?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, marca.getId());
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
