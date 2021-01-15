/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.mb;

import hospitalx.dao.QuartoDAO;
import hospitalx.modelo.Quarto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

@Named(value = "quartoMB")
@RequestScoped
public class QuartoMB implements Serializable{

    Quarto quarto = new Quarto();
    QuartoDAO quartodao = new QuartoDAO();
    List<Quarto> quartos = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        //quartos = quartodao.findAll();
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public List<Quarto> getListaQuarto() {
        
        return quartos;
    }

    public void setListaQuarto(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public String insert() {
        quartodao.insert(quarto);
        quarto = new Quarto();
        return "quarto?faces-redirect=true";
    }

    public String startEdit() {
        return "quarto-edit";
    }

    public String finishEdit() {
        quartodao.update(quarto);
        return "quarto";
    }
    
    public String delete() {
        quartodao.delete(quarto);
        return "quarto?faces-redirect=true";
    }
    
    public List<SelectItem> getSelectQuartos() {
        List<SelectItem> lista = new ArrayList<>();
        for (Quarto m : quartodao.findAll()) {
            lista.add(new SelectItem(m, m.getSiglaQuarto()));
        }
        return lista;
    }


}
