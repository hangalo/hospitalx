/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.converter;

import hospitalx.modelo.Municipio;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("municipioConverver")
public class MunicipioConverter implements Converter {

    private static Map<String, Municipio> mapa = new HashMap<String, Municipio>();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
        return mapa.get(valor);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object valor) {
        if (valor instanceof Municipio) {
            Municipio mun = (Municipio) valor;
            mapa.put(String.valueOf(mun.getIdMunicipio()), mun);
            return String.valueOf(mun.getIdMunicipio());
        } else {

            return "";
        }
    }
    
}
