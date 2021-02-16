/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.mb;

import hospitalx.modelo.Medico;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.FilterMeta;

/**
 *
 * @author Ary
 */
@Named(value = "dtFilterView")
@ViewScoped
public class FilterView implements Serializable{

    private List<Medico> medicos1;
    private List<Medico> filteredMedicos1;
    
    @Inject
    private MedicoMB service;    
    
    private List<FilterMeta> filterBy;
    
    @PostConstruct
    public void init(){
        medicos1 = service.getMedico(10);
    }
    
    public List<Medico> getRepresentatives(){
        return service.getListaMedico();
    }
    
    public List<Medico> getFilteredMedico1(){
        return filteredMedicos1;
    }
    
    public List<FilterMeta> getFilterBy(){
        return filterBy;
    }
    
   
}
