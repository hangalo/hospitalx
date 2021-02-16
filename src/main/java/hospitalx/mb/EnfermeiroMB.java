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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Celina Sebastião
 */

@Named(value = "enfermeiroMB")
@ViewScoped
public class EnfermeiroMB implements Serializable {

    Enfermeiro enfermeiro = new Enfermeiro();
    EnfermeiroDAO enfermeiroDao = new EnfermeiroDAO();
    List<Enfermeiro> listaEnfermeiros = new ArrayList<>();
    List<Enfermeiro> listaNEnfermeiros;
    
    String letrasNomeSobrenome;

    @PostConstruct
    public void inicializar() {
        
        listaEnfermeiros = enfermeiroDao.findAll();
       
        listaNEnfermeiros = new ArrayList<>();
    }

    public List<Enfermeiro> getListaNEnfermeiros() {
        return listaNEnfermeiros;
    }

    public void setListaNEnfermeiros(List<Enfermeiro> listaNEnfermeiros) {
        this.listaNEnfermeiros = listaNEnfermeiros;
    }

    public String getLetrasNomeSobrenome() {
        return letrasNomeSobrenome;
    }

    public void setLetrasNomeSobrenome(String letrasNomeSobrenome) {
        this.letrasNomeSobrenome = letrasNomeSobrenome;
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
        System.out.println("OK1");
        enfermeiroDao.insert(enfermeiro);
        System.out.println("OK2");
        enfermeiro = new Enfermeiro();
        return "gestao-enfermeiros?faces-redirect=true";
    }

    public String eliminar() {
        enfermeiroDao.delete(enfermeiro);
        enfermeiro = new Enfermeiro();
        return "enfermeiro-lista?faces-redirect=true";
    }

    public String prepararEditar() {
        return "enfermeiro-editar?faces-redirect=true";
    }

    public String editar() {
       enfermeiroDao.update(enfermeiro);
        enfermeiro = new Enfermeiro();
        return "enfermeiro-lista?faces-redirect=true";
    }
    
      public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getAbreviatura()));
        }
        return list;
    }
      
      public List<Enfermeiro> getPesquisaNomeSobrenome() {
        listaNEnfermeiros = new ArrayList<>();
        listaNEnfermeiros = enfermeiroDao.findByNomeSobrenome(letrasNomeSobrenome);
        return listaNEnfermeiros;
    }
     
}
