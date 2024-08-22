package com.ferreteria.dao;

import com.ferreteria.domain.Categoria;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoriaDao {

    private final JdbcTemplate jdbcTemplate;

    public CategoriaDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Categoria> obtenerCategorias() {
        String sql = "SELECT id_categoria, nombre, descripcion FROM grupo7.Categoria";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getLong("id_categoria"));
            categoria.setNombre(rs.getString("nombre"));
            categoria.setDescripcion(rs.getString("descripcion"));
            return categoria;
        });
    }

    public String agregarCategoria(Categoria categoria) {
        String mensaje = "";
        String sql = "{call GRUPO7.Insertar_Categoria_sp(?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setString(1, categoria.getNombre());
            cstmt.setString(2, categoria.getDescripcion());
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al agregar categoría: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarCategoria(Long id) {
        String mensaje = "";
        String sql = "{call GRUPO7.Eliminar_Categoria_sp(?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, id);
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al eliminar categoría: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarCategoria(Categoria categoria) {
        String mensaje = "";
        String sql = "{call GRUPO7.Actualizar_Categoria_sp(?, ?, ?)}";

        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setLong(1, categoria.getId());
            cstmt.setString(2, categoria.getNombre());
            cstmt.setString(3, categoria.getDescripcion());
            cstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al actualizar categoría: " + e.getMessage();
        }
        return mensaje;
    }
}
