package vg.edu.pe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vg.edu.pe.interfaces.PersonaI;
import vg.edu.pe.model.PersonaM;

public class PersonaD extends Dao implements PersonaI {

    @Override
    public void guardarPersona(PersonaM persona) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO PERSONAS (NOMPER, APEPER, ESTPER) VALUES (?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, persona.getNOMPER());
            ps.setString(2, persona.getAPEPER());
            ps.setString(3, "A");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificarPersona(PersonaM persona) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE PERSONAS SET NOMPER = ? ,APEPER = ?,ESTPER = ? WHERE CODPER = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, persona.getNOMPER());
            ps.setString(2, persona.getAPEPER());
            ps.setString(3, persona.getESTPER());
            ps.setString(4, persona.getCODPER());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void eliminarPersona(PersonaM persona) throws Exception {
        try {
            this.Conexion();
            String sql = "DELETE FROM PERSONAS WHERE CODPER = ? ";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, persona.getCODPER());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<PersonaM> listarPersonas() throws Exception {
        List<PersonaM> lista;
        ResultSet rs;
        try {
            String sql = "SELECT * FROM PERSONAS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            PersonaM pm;
            lista = new ArrayList<>();
            while (rs.next()) {
                pm = new PersonaM();
                pm.setNOMPER(rs.getString("NOMPER"));
                pm.setAPEPER(rs.getString("APEPER"));
                lista.add(pm);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

}
