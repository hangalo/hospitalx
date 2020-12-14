/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.mb;

import hospitalx.dao.MunicipioDAO;
import hospitalx.modelo.Municipio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author informatica
 */
@Named(value = "municipioMB")
@SessionScoped
public class MunicipioMB implements Serializable {

  
     Municipio municipio = new Municipio();
   
    MunicipioDAO municipioDAO = new MunicipioDAO();
   
    List<Municipio> municipios = new ArrayList<>();
 

    @PostConstruct
    public void init() {

      
        municipios = municipioDAO.findAll();
    }

  
   

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
