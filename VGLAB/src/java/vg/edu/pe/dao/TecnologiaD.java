package vg.edu.pe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vg.edu.pe.interfaces.TecnologiaI;
import vg.edu.pe.model.TecnologiaM;

public class TecnologiaD extends Dao implements TecnologiaI {

    @Override
    public List<TecnologiaM> listarTecnologia() throws Exception {
        List<TecnologiaM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM TECNOLOGIA";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            TecnologiaM tec;
            while (rs.next()) {
                tec = new TecnologiaM();
                tec.setCODTEC(rs.getString("CODTEC"));
                tec.setDESCTEC(rs.getString("DESCTEC"));
                tec.setTIPOTEC(rs.getString("TIPOTEC"));
                tec.setSUBTIPOTEC(rs.getString("SUBTIPOTEC"));
                lista.add(tec);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public void guardarTecnologia(TecnologiaM tecnologia) throws Exception {
        this.Conexion();
        try {
            String sql = "INSERT INTO TECNOLOGIA(DESCTEC,TIPOTEC,SUBTIPOTEC) values (?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, tecnologia.getDESCTEC());
            ps.setString(2, tecnologia.getTIPOTEC());
            ps.setString(3, tecnologia.getSUBTIPOTEC());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}
