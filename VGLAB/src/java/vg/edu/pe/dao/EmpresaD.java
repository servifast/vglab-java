package vg.edu.pe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vg.edu.pe.interfaces.EmpresaI;
import vg.edu.pe.model.EmpresaM;

public class EmpresaD extends Dao implements EmpresaI {

    @Override
    public List<EmpresaM> listarEmpresa() throws Exception {
        List<EmpresaM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM EMPRESA";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            EmpresaM emp;
            while (rs.next()) {
                emp = new EmpresaM();
                emp.setCODEMP(rs.getString("CODEMP"));
                emp.setRAZONSOCIAL(rs.getString("RAZONSOCIAL"));
                emp.setRUCEMP(rs.getString("RUCEMP"));
                lista.add(emp);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

}
