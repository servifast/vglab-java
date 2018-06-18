package vg.edu.pe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vg.edu.pe.interfaces.ProyectoI;
import vg.edu.pe.model.ProyectoM;

public class ProyectoD extends Dao implements ProyectoI {

    @Override
    public List<ProyectoM> listarAllProyectos() throws Exception {
        List<ProyectoM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM VW_PROYECTO";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            ProyectoM pro;
            while (rs.next()) {
                pro = new ProyectoM();
                pro.setCODPRO(rs.getString("CODPRO"));
                pro.setTITULOPRO(rs.getString("TITULOPRO"));
                pro.setDESCPRO(rs.getString("DESCPRO"));
                pro.setNOMCAT(rs.getString("NOMCAT"));
                pro.setRAZONSOCIAL(rs.getString("RAZONSOCIAL"));
//                pro.setLOGOPRO(rs.getString("LOGOPRO"));
                pro.setDEMOPRO(rs.getString("DEMOPRO"));
                lista.add(pro);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public List<ProyectoM> listarIntegrantes(String codPro) throws Exception {
        List<ProyectoM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM VW_INTEGRANTES WHERE CODPRO = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, codPro);
            rs = ps.executeQuery();
            lista = new ArrayList();
            ProyectoM pro;
            while (rs.next()) {
                pro = new ProyectoM();
                pro.setCODPER(rs.getString("CODPER"));
                pro.setNOMBRES(rs.getString("NOMBRES"));
                pro.setNOMCARGO(rs.getString("NOMCARGO"));
                lista.add(pro);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

}
