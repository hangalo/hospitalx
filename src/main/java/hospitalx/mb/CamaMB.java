/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.mb;

import hospitalx.dao.CamaDAO;
import hospitalx.modelo.Cama;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

@Named(value = "camaMB")
@RequestScoped
public class CamaMB {

    Cama cama = new Cama();
    CamaDAO camadao = new CamaDAO();
    List<Cama> listaCama = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        listaCama = camadao.findAll();
    }

    public Cama getCama() {
        return cama;
    }

    public void setCama(Cama cama) {
        this.cama = cama;
    }

    public List<Cama> getListaCama() {
        
        return listaCama;
    }

    public void setListaCama(List<Cama> listaCama) {
        this.listaCama = listaCama;
    }

    public String insert() {
        camadao.insert(cama);
        cama = new Cama();
        return "cama?faces-redirect=true";
    }

    public String startEdit() {
        return "cama-edit";
    }

    public String finishEdit() {
        camadao.update(cama);
        return "cama";
    }
    
    public String delete() {
        camadao.delete(cama);
        return "cama?faces-redirect=true";
    }
    
    public List<SelectItem> getSelectCamas() {
        List<SelectItem> lista = new ArrayList<>();
        for (Cama m : camadao.findAll()) {
            lista.add(new SelectItem(m, m.getNumeroCama()));
        }
        return lista;
    }


}
