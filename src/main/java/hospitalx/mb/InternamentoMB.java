/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.mb;

import hospitalx.dao.InternamentoDAO;
import hospitalx.modelo.Internamento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "internamentoMB")
@RequestScoped
public class InternamentoMB {

    Internamento internamento = new Internamento();
    InternamentoDAO internamentodao = new InternamentoDAO();
    List<Internamento> listaInternamento = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        listaInternamento = internamentodao.findAll();
    }

    public Internamento getInternamento() {
        return internamento;
    }

    public void setInternamento(Internamento internamento) {
        this.internamento = internamento;
    }

    public List<Internamento> getListaInternamento() {
        
        return listaInternamento;
    }

    public void setListaInternamento(List<Internamento> listaInternamento) {
        this.listaInternamento = listaInternamento;
    }

    public String insert() {
        internamentodao.insert(internamento);
        internamento = new Internamento();
        return "internamento?faces-redirect=true";
    }

    public String startEdit() {
        return "internamento-edit";
    }

    public String finishEdit() {
        internamentodao.update(internamento);
        return "internamento";
    }
    
    public String delete() {
        internamentodao.delete(internamento);
        return "internamento?faces-redirect=true";
    }

}
