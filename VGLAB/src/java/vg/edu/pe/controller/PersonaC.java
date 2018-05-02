package vg.edu.pe.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import vg.edu.pe.dao.PersonaD;
import vg.edu.pe.model.PersonaM;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {
    
    PersonaM pm = new PersonaM();
    private PersonaM selectedPersona;
    private List<PersonaM> lstPersonas;

    @PostConstruct
    public void init() {
        try {
            listarPersonas();
        } catch (Exception ex) {
            Logger.getLogger(PersonaC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarPersona() throws Exception{
        PersonaD pd;
        try {
           pd = new PersonaD();
           pd.guardarPersona(pm);
        } catch (Exception e) {
            throw e;
        }   
    }
    public void modificarPersona() throws Exception{
        PersonaD pd;
        try {
            pd = new PersonaD();
            pd.modificarPersona(selectedPersona);
        } catch (Exception e) {
            throw e;
        }   
    }
    public void eliminarPersona() throws Exception{
        PersonaD pd;
        try {
           pd = new PersonaD(); 
           pd.eliminarPersona(selectedPersona);
        } catch (Exception e) {
            throw e;
        }   
    }
    public void listarPersonas() throws Exception{
        PersonaD pd;
        try {
            pd = new PersonaD();
            lstPersonas = pd.listarPersonas();
        } catch (Exception e) {
            throw e;
        }   
    }
    
    
    //Getter and Setter

    public PersonaM getPm() {
        return pm;
    }

    public void setPm(PersonaM pm) {
        this.pm = pm;
    }

    public PersonaM getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(PersonaM selectedPersona) {
        this.selectedPersona = selectedPersona;
    }

    public List<PersonaM> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<PersonaM> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
    
}
