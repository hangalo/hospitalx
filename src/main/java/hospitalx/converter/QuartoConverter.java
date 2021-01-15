/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.converter;

import hospitalx.modelo.Quarto;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("quartoConverver")
public class QuartoConverter implements Converter {

    private static Map<String, Quarto> mapa = new HashMap<String, Quarto>();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
        return mapa.get(valor);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object valor) {
        if (valor instanceof Quarto) {
            Quarto quarto = (Quarto) valor;
            mapa.put(String.valueOf(quarto.getIdQuarto()), quarto);
            return String.valueOf(quarto.getIdQuarto());
        } else {

            return "";
        }
    }
    
}
