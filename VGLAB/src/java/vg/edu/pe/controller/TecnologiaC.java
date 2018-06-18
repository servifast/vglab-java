package vg.edu.pe.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import vg.edu.pe.dao.TecnologiaD;
import vg.edu.pe.model.TecnologiaM;

@Named(value = "tecnologiaC")
@SessionScoped
public class TecnologiaC implements Serializable {

    TecnologiaM tec = new TecnologiaM();
    private List<TecnologiaM> listTecnologia;

    @PostConstruct
    public void inicio() {
        try {
            listartecnologias();
        } catch (Exception ex) {
            Logger.getLogger(TecnologiaC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listartecnologias() throws Exception {
        TecnologiaD dao;
        try {
            dao = new TecnologiaD();
            listTecnologia = dao.listarTecnologia();
        } catch (Exception e) {
            throw e;
        }
    }

    public TecnologiaM getTec() {
        return tec;
    }

    public void setTec(TecnologiaM tec) {
        this.tec = tec;
    }

    public List<TecnologiaM> getListTecnologia() {
        return listTecnologia;
    }

    public void setListTecnologia(List<TecnologiaM> listTecnologia) {
        this.listTecnologia = listTecnologia;
    }

}
