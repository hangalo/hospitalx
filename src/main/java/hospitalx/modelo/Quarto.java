/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.modelo;

import java.util.Date;

/**
 *
 * @author Nécia Caculo
 */
public class Quarto {

    private int idQuarto;
    private String siglaQuarto;
    
    public Quarto() {
    }

    public Quarto(int idQuarto, String siglaQuarto) {
        this.idQuarto = idQuarto;
        this.siglaQuarto = siglaQuarto;
        
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public String getSiglaQuarto() {
        return siglaQuarto;
    }

    public void setSiglaQuarto(String siglaQuarto) {
        this.siglaQuarto = siglaQuarto;
    }

    
}
