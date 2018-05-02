package vg.edu.pe.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    @PostConstruct
    public void init() {
    }
    
}
