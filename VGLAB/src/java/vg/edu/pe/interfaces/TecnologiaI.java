package vg.edu.pe.interfaces;

import java.util.List;
import vg.edu.pe.model.TecnologiaM;

public interface TecnologiaI {

    void guardarTecnologia(TecnologiaM tecnologia) throws Exception;

    List<TecnologiaM> listarTecnologia() throws Exception;
}
