package vg.edu.pe.interfaces;

import java.util.List;
import vg.edu.pe.model.CategoriaM;

public interface CategoriaI {

    void guardarCategoria(CategoriaM categoria) throws Exception;

    List<CategoriaM> listarCategorias() throws Exception;
}
