package vg.edu.pe.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import vg.edu.pe.dao.ProyectoD;
import vg.edu.pe.model.ProyectoM;

@Named(value = "proyectoC")
@SessionScoped
public class ProyectoC implements Serializable {

    ProyectoM pro = new ProyectoM();
    private List<ProyectoM> listProyectos;
    private List<ProyectoM> listIntegrantes;
    private ProyectoM selectedPro;

    @PostConstruct
    public void init(){
        try {
            listarProyectos();
        } catch (Exception ex) {
            Logger.getLogger(ProyectoC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listarProyectos() throws Exception{
        ProyectoD dao;
        try {
            dao = new ProyectoD();
            listProyectos = dao.listarAllProyectos();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listarIntegrantes() throws Exception{
        ProyectoD dao;
        try {
            dao = new ProyectoD();
            listIntegrantes = dao.listarIntegrantes(selectedPro.CODPRO);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ProyectoM getPro() {
        return pro;
    }

    public void setPro(ProyectoM pro) {
        this.pro = pro;
    }

    public List<ProyectoM> getListProyectos() {
        return listProyectos;
    }

    public void setListProyectos(List<ProyectoM> listProyectos) {
        this.listProyectos = listProyectos;
    }

    public ProyectoM getSelectedPro() {
        return selectedPro;
    }

    public void setSelectedPro(ProyectoM selectedPro) {
        this.selectedPro = selectedPro;
    }

    public List<ProyectoM> getListIntegrantes() {
        return listIntegrantes;
    }

    public void setListIntegrantes(List<ProyectoM> listIntegrantes) {
        this.listIntegrantes = listIntegrantes;
    }
    
}
