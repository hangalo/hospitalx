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
public class Cama {

    private int idCama;
    private String numeroCama;
    
    public Cama() {
    }

    public Cama(int idCama, String numeroCama) {
        this.idCama = idCama;
        this.numeroCama = numeroCama;
        
    }

    public int getIdCama() {
        return idCama;
    }

    public void setIdCama(int idCama) {
        this.idCama = idCama;
    }

    public String getNumeroCama() {
        return numeroCama;
    }

    public void setNumeroCama(String numeroCama) {
        this.numeroCama = numeroCama;
    }

    
}
