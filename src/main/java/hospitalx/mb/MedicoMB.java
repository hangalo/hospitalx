/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.mb;

import hospitalx.dao.MedicoDAO;
import hospitalx.modelo.Medico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

@Named(value = "medicoMB")
@RequestScoped
public class MedicoMB {

    Medico medico = new Medico();
    MedicoDAO medicodao = new MedicoDAO();
    List<Medico> listaMedico = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        listaMedico = medicodao.findAll();
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Medico> getListaMedico() {

        return listaMedico;
    }

    public void setListaMedico(List<Medico> listaMedico) {
        this.listaMedico = listaMedico;
    }

    public String insert() {
        medicodao.insert(medico);
        medico = new Medico();
        return "medico?faces-redirect=true";
    }

    public String startEdit() {
        return "medico-edit";
    }

    public String finishEdit() {
        medicodao.update(medico);
        return "medico";
    }

    public String delete() {
        medicodao.delete(medico);
        return "medico?faces-redirect=true";
    }

    public List<SelectItem> getSelectMedicos() {
        List<SelectItem> lista = new ArrayList<>();
        for (Medico m : medicodao.findAll()) {
            lista.add(new SelectItem(m, m.getNomeMedico() + " " + m.getSobrenomMedico()));
        }
        return lista;
    }

    public List<Medico> getMedico(int number) {
        List<Medico> medicos = new ArrayList<>();

        if (listaMedico.size() > number) {
            for (int i = 0; i < number; i++) {
                medicos.add(listaMedico.get(i));
            }
            return medicos;
        }
        return listaMedico;        
    }

}
