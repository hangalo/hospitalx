/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.modelo;

import java.util.Date;

/**
 *
 * @author Nécia
 */
public class Internamento {

    private int idInternamento;
    private Date data;
    private Cama cama;
    private Quarto quarto;
    private Paciente paciente;
    private Medico medico;

    public Internamento() {
    }

    public Internamento(int idInternamento, Date data, Cama cama, Quarto quarto, Paciente paciente, Medico medico) {
        this.idInternamento = idInternamento;
        this.data = data;
        this.cama = cama;
        this.quarto = quarto;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    
    

    public int getIdInternamento() {
        return idInternamento;
    }

    public void setIdInternamento(int idInternamento) {
        this.idInternamento = idInternamento;
    }

    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    

    public Cama getCama() {
        return cama;
    }

    public void setCama(Cama cama) {
        this.cama = cama;
    }

}
