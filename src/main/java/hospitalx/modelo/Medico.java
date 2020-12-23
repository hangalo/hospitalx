
package hospitalx.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Mário N
 */
public class Medico {
    
    private Integer idMedico;
    private String nomeMedico;
    private String sobrenomMedico;
    private Date dataNascimentoMedico;    
    private Sexo sexoMedico;
    private String emailMedico;
    private String telefoneMedico;
    private String ruaMedico;
    private String casaMedico;
    private String bairroMedico;
    private String distrititoMedico;
    private Municipio municipio;

    public Medico() {
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getSobrenomMedico() {
        return sobrenomMedico;
    }

    public void setSobrenomMedico(String sobrenomMedico) {
        this.sobrenomMedico = sobrenomMedico;
    }

    public Date getDataNascimentoMedico() {
        return dataNascimentoMedico;
    }

    public void setDataNascimentoMedico(Date dataNascimentoMedico) {
        this.dataNascimentoMedico = dataNascimentoMedico;
    }
    
    public Sexo getSexoMedico() {
        return sexoMedico;
    }

    public void setSexoMedico(Sexo sexoMedico) {
        this.sexoMedico = sexoMedico;
    }

    public String getEmailMedico() {
        return emailMedico;
    }

    public void setEmailMedico(String emailMedico) {
        this.emailMedico = emailMedico;
    }

    public String getTelefoneMedico() {
        return telefoneMedico;
    }

    public void setTelefoneMedico(String telefoneMedico) {
        this.telefoneMedico = telefoneMedico;
    }

    public String getRuaMedico() {
        return ruaMedico;
    }

    public void setRuaMedico(String ruaMedico) {
        this.ruaMedico = ruaMedico;
    }

    public String getCasaMedico() {
        return casaMedico;
    }

    public void setCasaMedico(String casaMedico) {
        this.casaMedico = casaMedico;
    }

    public String getBairroMedico() {
        return bairroMedico;
    }

    public void setBairroMedico(String bairroMedico) {
        this.bairroMedico = bairroMedico;
    }

    public String getDistrititoMedico() {
        return distrititoMedico;
    }

    public void setDistrititoMedico(String distrititoMedico) {
        this.distrititoMedico = distrititoMedico;
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
        hash = 67 * hash + Objects.hashCode(this.idMedico);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.idMedico, other.idMedico)) {
            return false;
        }
        return true;
    }
            
    
    
    
    
}
