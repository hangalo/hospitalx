/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.converter;

import hospitalx.modelo.Cama;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("camaConverver")
public class CamaConverter implements Converter {

    private static Map<String, Cama> mapa = new HashMap<String, Cama>();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
        return mapa.get(valor);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object valor) {
        if (valor instanceof Cama) {
            Cama cam = (Cama) valor;
            mapa.put(String.valueOf(cam.getIdCama()), cam);
            return String.valueOf(cam.getIdCama());
        } else {

            return "";
        }
    }
    
}
