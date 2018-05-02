package vg.edu.pe.interfaces;

import java.util.List;
import vg.edu.pe.model.PersonaM;

public interface PersonaI {
    
    //Este metodo sierve para guardar registros en la tabla PERSONA de la base de datos VGLAB
    void guardarPersona(PersonaM persona) throws Exception;

    //Este metodo sierve para modificar registros de la tabla PERSONA de la base de datos VGLAB
    void modificarPersona(PersonaM persona) throws Exception;

    //Este metodo sierve para eliminar un cliente de la tabla PERSONA de la base de datos VGLAB
    void eliminarPersona(PersonaM persona) throws Exception;

    //Este metodo sierve para listar los registros de la tabla PERSONA de la base de datos VGLAB
    List<PersonaM> listarPersonas() throws Exception;
    
}
