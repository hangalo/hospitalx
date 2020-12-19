/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.mb;

import hospitalx.dao.PacienteDAO;
import hospitalx.modelo.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "pacienteMB")
@RequestScoped
public class PacienteMB {

    Paciente paciente = new Paciente();
    PacienteDAO pacientedao = new PacienteDAO();
    List<Paciente> listaPaciente = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        listaPaciente = pacientedao.findAll();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Paciente> getListaPaciente() {
        
        return listaPaciente;
    }

    public void setListaPaciente(List<Paciente> listaPaciente) {
        this.listaPaciente = listaPaciente;
    }

    public String insert() {
        pacientedao.insert(paciente);
        paciente = new Paciente();
        return "paciente?faces-redirect=true";
    }

    public String startEdit() {
        return "paciente-edit";
    }

    public String finishEdit() {
        pacientedao.update(paciente);
        return "paciente";
    }
    
    public String delete() {
        pacientedao.delete(paciente);
        return "paciente?faces-redirect=true";
    }

}
