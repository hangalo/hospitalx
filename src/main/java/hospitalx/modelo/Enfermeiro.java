/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Celina Sebastião
 */
public class Enfermeiro {

    private Integer idEnfermeiro;
    private String nomeEnfermeiro;
    private String sobrenomeEnfermeiro;
    private Date dataNascimentoEnfermeiro;
    private Sexo sexoEnfermeiro;
    private String emailEnfermeiro;
    private String telefoneEnfermeiro;
    private String ruaEnfermeiro;
    private String casaEnfermeiro;
    private String bairroEnfermeiro;
    private String distritoEnfermeiro;
    private Municipio municipio;

    public Enfermeiro() {
    }

    public Integer getIdEnfermeiro() {
        return idEnfermeiro;
    }

    public void setIdEnfermeiro(Integer idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }

    public String getNomeEnfermeiro() {
        return nomeEnfermeiro;
    }

    public void setNomeEnfermeiro(String nomeEnfermeiro) {
        this.nomeEnfermeiro = nomeEnfermeiro;
    }

    public String getSobrenomeEnfermeiro() {
        return sobrenomeEnfermeiro;
    }

    public void setSobrenomeEnfermeiro(String sobrenomeEnfermeiro) {
        this.sobrenomeEnfermeiro = sobrenomeEnfermeiro;
    }

    public Date getDataNascimentoEnfermeiro() {
        return dataNascimentoEnfermeiro;
    }

    public void setDataNascimentoEnfermeiro(Date dataNascimentoEnfermeiro) {
        this.dataNascimentoEnfermeiro = dataNascimentoEnfermeiro;
    }

    public Sexo getSexoEnfermeiro() {
        return sexoEnfermeiro;
    }

    public void setSexoEnfermeiro(Sexo sexoEnfermeiro) {
        this.sexoEnfermeiro = sexoEnfermeiro;
    }

    public String getEmailEnfermeiro() {
        return emailEnfermeiro;
    }

    public void setEmailEnfermeiro(String emailEnfermeiro) {
        this.emailEnfermeiro = emailEnfermeiro;
    }

    public String getTelefoneEnfermeiro() {
        return telefoneEnfermeiro;
    }

    public void setTelefoneEnfermeiro(String telefoneEnfermeiro) {
        this.telefoneEnfermeiro = telefoneEnfermeiro;
    }

    public String getRuaEnfermeiro() {
        return ruaEnfermeiro;
    }

    public void setRuaEnfermeiro(String ruaEnfermeiro) {
        this.ruaEnfermeiro = ruaEnfermeiro;
    }

    public String getCasaEnfermeiro() {
        return casaEnfermeiro;
    }

    public void setCasaEnfermeiro(String casaEnfermeiro) {
        this.casaEnfermeiro = casaEnfermeiro;
    }

    public String getBairroEnfermeiro() {
        return bairroEnfermeiro;
    }

    public void setBairroEnfermeiro(String bairroEnfermeiro) {
        this.bairroEnfermeiro = bairroEnfermeiro;
    }

    public String getDistritoEnfermeiro() {
        return distritoEnfermeiro;
    }

    public void setDistritoEnfermeiro(String distritoEnfermeiro) {
        this.distritoEnfermeiro = distritoEnfermeiro;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.idEnfermeiro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Enfermeiro other = (Enfermeiro) obj;
        if (!Objects.equals(this.idEnfermeiro, other.idEnfermeiro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Enfermeiro{" + "nomeEnfermeiro=" + nomeEnfermeiro + ", sobrenomeEnfermeiro=" + sobrenomeEnfermeiro + '}';
    }
    
    
}
