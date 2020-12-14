/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.modelo;

import java.util.Date;

/**
 *
 * @author Jofrasio
 */
public class Paciente {

    private int idPaciente;
    private String nomePaciente;
    private String sobrenomPaciente;
    private Date dataNascimentoPaciente;
    private String sexoPaciente;
    private String emailPaciente;
    private String telefonePaciente;
    private String ruaPaciente;
    private String casaMedico;
    private String bairroPaciente;
    private String distritoPaciente;
    private Municipio municipio;

    public Paciente() {
    }

    public Paciente(int idPaciente, String nomePaciente, String sobrenomPaciente, Date dataNascimentoPaciente, String sexoPaciente, String emailPaciente, String telefonePaciente, String ruaPaciente, String casaMedico, String bairroPaciente, String distritoPaciente, Municipio municipio) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.sobrenomPaciente = sobrenomPaciente;
        this.dataNascimentoPaciente = dataNascimentoPaciente;
        this.sexoPaciente = sexoPaciente;
        this.emailPaciente = emailPaciente;
        this.telefonePaciente = telefonePaciente;
        this.ruaPaciente = ruaPaciente;
        this.casaMedico = casaMedico;
        this.bairroPaciente = bairroPaciente;
        this.distritoPaciente = distritoPaciente;
        this.municipio = municipio;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getSobrenomPaciente() {
        return sobrenomPaciente;
    }

    public void setSobrenomPaciente(String sobrenomPaciente) {
        this.sobrenomPaciente = sobrenomPaciente;
    }

    public Date getDataNascimentoPaciente() {
        return dataNascimentoPaciente;
    }

    public void setDataNascimentoPaciente(Date dataNascimentoPaciente) {
        this.dataNascimentoPaciente = dataNascimentoPaciente;
    }

    public String getSexoPaciente() {
        return sexoPaciente;
    }

    public void setSexoPaciente(String sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    public String getRuaPaciente() {
        return ruaPaciente;
    }

    public void setRuaPaciente(String ruaPaciente) {
        this.ruaPaciente = ruaPaciente;
    }

    public String getCasaMedico() {
        return casaMedico;
    }

    public void setCasaMedico(String casaMedico) {
        this.casaMedico = casaMedico;
    }

    public String getBairroPaciente() {
        return bairroPaciente;
    }

    public void setBairroPaciente(String bairroPaciente) {
        this.bairroPaciente = bairroPaciente;
    }

    public void setDistritoPaciente(String distritoPaciente) {
        this.distritoPaciente = distritoPaciente;
    }

    public String getDistritoPaciente() {
        return distritoPaciente;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

}
