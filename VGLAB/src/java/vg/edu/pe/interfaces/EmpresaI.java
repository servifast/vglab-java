package vg.edu.pe.interfaces;

import java.util.List;
import vg.edu.pe.model.EmpresaM;

public interface EmpresaI {

    void guardarEmpresa(EmpresaM empresa) throws Exception;

    List<EmpresaM> listarEmpresa() throws Exception;
}
