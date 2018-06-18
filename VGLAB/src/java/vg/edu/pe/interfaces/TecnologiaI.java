package vg.edu.pe.interfaces;

import java.util.List;
import vg.edu.pe.model.TecnologiaM;

public interface TecnologiaI {

    public void guardarTecnologia(TecnologiaM tecnologia) throws Exception;

    List<TecnologiaM> listarTecnologia() throws Exception;
}
