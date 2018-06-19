package vg.edu.pe.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import vg.edu.pe.dao.CategoriaD;
import vg.edu.pe.model.CategoriaM;

@Named(value = "categoriaC")
@SessionScoped
public class CategoriaC implements Serializable {

    CategoriaM cat = new CategoriaM();
    private List<CategoriaM> listCategorias;

    @PostConstruct
    public void inicio() {
        try {
            listarCategorias();
        } catch (Exception ex) {
            Logger.getLogger(CategoriaC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limpiar() {
        cat = new CategoriaM();
    }

    public void guardarCategoria() throws Exception {
        CategoriaD dao;
        try {
            dao = new CategoriaD();
            dao.guardarCategoria(cat);
            listarCategorias();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarCategorias() throws Exception {
        CategoriaD dao;
        try {
            dao = new CategoriaD();
            listCategorias = dao.listarCategorias();
        } catch (Exception e) {
            throw e;
        }
    }

    public CategoriaM getCat() {
        return cat;
    }

    public void setCat(CategoriaM cat) {
        this.cat = cat;
    }

    public List<CategoriaM> getListCategorias() {
        return listCategorias;
    }

    public void setListCategorias(List<CategoriaM> listCategorias) {
        this.listCategorias = listCategorias;
    }

}
