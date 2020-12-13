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
 * @author DGTALE
 */
public class Funcionario {
    private Integer idFuncionario;
    private String nomeFuncionario;
    private String sobrenomFuncionario;
    private Date dataNascimento;
    private Sexo sexoFuncionario;
    private String emailFuncionario;
    private String telefoneFuncionario;
    private String ruaFuncionario;
    private String casaFuncionario;
    private String bairroFuncionario;
    private String distrititoFuncionario;
    private Municipio municipio;

    public Funcionario() {
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    
    
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getSobrenomFuncionario() {
        return sobrenomFuncionario;
    }

    public void setSobrenomFuncionario(String sobrenomFuncionario) {
        this.sobrenomFuncionario = sobrenomFuncionario;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexoFuncionario() {
        return sexoFuncionario;
    }

    public void setSexoFuncionario(Sexo sexoFuncionario) {
        this.sexoFuncionario = sexoFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getRuaFuncionario() {
        return ruaFuncionario;
    }

    public void setRuaFuncionario(String ruaFuncionario) {
        this.ruaFuncionario = ruaFuncionario;
    }

    public String getCasaFuncionario() {
        return casaFuncionario;
    }

    public void setCasaFuncionario(String casaFuncionario) {
        this.casaFuncionario = casaFuncionario;
    }

    public String getBairroFuncionario() {
        return bairroFuncionario;
    }

    public void setBairroFuncionario(String bairroFuncionario) {
        this.bairroFuncionario = bairroFuncionario;
    }

    public String getDistrititoFuncionario() {
        return distrititoFuncionario;
    }

    public void setDistrititoFuncionario(String distrititoFuncionario) {
        this.distrititoFuncionario = distrititoFuncionario;
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
        hash = 53 * hash + Objects.hashCode(this.idFuncionario);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.idFuncionario, other.idFuncionario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nomeFuncionario=" + nomeFuncionario + ", sobrenomFuncionario=" + sobrenomFuncionario + '}';
    }

    
    
}
