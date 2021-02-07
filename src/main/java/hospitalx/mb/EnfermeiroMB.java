/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.mb;

import hospitalx.dao.EnfermeiroDAO;
import hospitalx.modelo.Enfermeiro;
import hospitalx.modelo.Sexo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

/**
 *
 * @author Celina Sebastião
 */
@Named(value = "enfermeiroMB")
@SessionScoped
public class EnfermeiroMB implements Serializable {

    Enfermeiro enfermeiro = new Enfermeiro();
    EnfermeiroDAO enfermeiroDao = new EnfermeiroDAO();
    List<Enfermeiro> listaEnfermeiros = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        listaEnfermeiros = enfermeiroDao.findAll();
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public List<Enfermeiro> getListaEnfermeiros() {
        return listaEnfermeiros;
    }

    public void setListaEnfermeiros(List<Enfermeiro> listaEnfermeiros) {
        this.listaEnfermeiros = listaEnfermeiros;
    }

    
    
    
    
    public String insert() {
        enfermeiroDao.insert(enfermeiro);
        enfermeiro = new Enfermeiro();
        return "staff/enfermeiros/gestao-enfermeiros??faces-redirect=true";
    }

    public String eliminar() {
        enfermeiroDao.delete(enfermeiro);
        enfermeiro = new Enfermeiro();
        return null;
    }

    public String prepararEditar() {
        return "enfermeiro-editar";
    }

    public String editar() {
        enfermeiroDao.update(enfermeiro);
        enfermeiro = new Enfermeiro();
        return "enfermeiro-lista?faces-redirect=true";
    }
    
      public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getExtensao()));
        }
        return list;
    }
}
