/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.mb;

import hospitalx.dao.QuartoDAO;
import hospitalx.modelo.Quarto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "quartoMB")
@RequestScoped
public class QuartoMB {

    Quarto quarto = new Quarto();
    QuartoDAO quartodao = new QuartoDAO();
    List<Quarto> listaQuarto = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        listaQuarto = quartodao.findAll();
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public List<Quarto> getListaQuarto() {
        
        return listaQuarto;
    }

    public void setListaQuarto(List<Quarto> listaQuarto) {
        this.listaQuarto = listaQuarto;
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

}
