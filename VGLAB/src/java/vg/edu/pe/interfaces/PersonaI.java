package vg.edu.pe.interfaces;

import java.util.List;
import vg.edu.pe.model.PersonaM;

public interface PersonaI {
    
    //Este metodo sirve para guardar registros en la tabla PERSONA de la base de datos VGLAB
    void guardarPersona(PersonaM persona) throws Exception;

    //Este metodo sirve para modificar registros de la tabla PERSONA de la base de datos VGLAB
    void modificarPersona(PersonaM persona) throws Exception;

    //Este metodo sirve para eliminar una persona de la tabla PERSONA de la base de datos VGLAB
    void eliminarPersona(PersonaM persona) throws Exception;

    //Este metodo sirve para listar los registros de la tabla PERSONA de la base de datos VGLAB
    List<PersonaM> listarPersonas() throws Exception;
    
}
