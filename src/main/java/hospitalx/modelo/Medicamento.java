/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.modelo;

import java.util.Date;

public class Medicamento {

    private int idMedicamento;
    private String nomeMedicamento;
    private Date validadeMedicamento;
    private Date data;

    public Medicamento() {
    }

    public Medicamento(int idMedicamento, String nomeMedicamento, Date ValidadeMedicamento) {
        this.idMedicamento = idMedicamento;
        this.nomeMedicamento = nomeMedicamento;
        this.validadeMedicamento = validadeMedicamento;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public Date getValidadeMedicamento() {
        return validadeMedicamento;
    }

    public void setValidadeMedicamento(Date validadeMedicamento) {
        this.validadeMedicamento = validadeMedicamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
