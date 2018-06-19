package vg.edu.pe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vg.edu.pe.interfaces.CategoriaI;
import vg.edu.pe.model.CategoriaM;

public class CategoriaD extends Dao implements CategoriaI {

    @Override
    public void guardarCategoria(CategoriaM categoria) throws Exception {
        this.Conexion();
        try {
            String sql = "INSERT INTO CATEGORIA(NOMCAT) values (?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, categoria.getNOMCAT());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<CategoriaM> listarCategorias() throws Exception {
        List<CategoriaM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM CATEGORIA";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            CategoriaM cat;
            while (rs.next()) {
                cat = new CategoriaM();
                cat.setCODCAT(rs.getString("CODCAT"));
                cat.setNOMCAT(rs.getString("NOMCAT"));
                lista.add(cat);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

}
