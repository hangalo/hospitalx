/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.modelo;

/**
 *
 * @author informatica
 */
public class Municipio {
    private Integer idMunicipio;
    private String nomeMunicipio;

    public Municipio() {
    }

    public Municipio(Integer idMunicipio, String nomeMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nomeMunicipio = nomeMunicipio;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }
    
    
}
