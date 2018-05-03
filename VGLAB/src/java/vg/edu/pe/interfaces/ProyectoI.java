package vg.edu.pe.interfaces;

import java.util.List;
import vg.edu.pe.model.ProyectoM;

public interface ProyectoI {

    //Este metodo lista todos los proyectos de la pagina proyectos.xhtml
    List<ProyectoM> listarAllProyectos() throws Exception;

    //Este metodo lista los integrantes de un equipo
    List<ProyectoM> listarIntegrantes(String codPro) throws Exception;
    
}
