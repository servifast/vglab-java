package vg.edu.pe.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import vg.edu.pe.dao.EmpresaD;
import vg.edu.pe.model.EmpresaM;

@Named(value = "empresaC")
@SessionScoped
public class EmpresaC implements Serializable {

    EmpresaM emp = new EmpresaM();
    private List<EmpresaM> listEmpresa;

    @PostConstruct
    public void inicio() {
        try {
            listarEmpresa();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarEmpresa() throws Exception {
        EmpresaD dao;
        try {
            dao = new EmpresaD();
            listEmpresa = dao.listarEmpresa();
        } catch (Exception e) {
            throw e;
        }
    }

    public EmpresaM getEmp() {
        return emp;
    }

    public void setEmp(EmpresaM emp) {
        this.emp = emp;
    }

    public List<EmpresaM> getListEmpresa() {
        return listEmpresa;
    }

    public void setListEmpresa(List<EmpresaM> listEmpresa) {
        this.listEmpresa = listEmpresa;
    }

}
