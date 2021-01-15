/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.linguautil;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author informatica
 */
@Named(value = "linguai18nBean")
@SessionScoped
public class Linguai18nBean implements Serializable {

   private Locale locale;
    private String lingua;
    private Map<String, Object> listaLinguas;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
        carregaLinguas();
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public Map<String, Object> getListaLinguas() {
        return listaLinguas;
    }

    public void setListaLinguas(Map<String, Object> listaLinguas) {
        this.listaLinguas = listaLinguas;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {

        String[] lc = language.split("_");
        this.locale = new Locale(lc[0]);

        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        //  System.out.println("Fica a lingua>>>>>>>>>>>>>>>>>Lingua  "+locale);
    }

    private void carregaLinguas() {
//        lingua = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
        listaLinguas = new LinkedHashMap<>();

        listaLinguas.put("Inglês", new Locale("en", "GB"));
        listaLinguas.put("Francês", new Locale("fr", "FR"));
        listaLinguas.put("Espanhol", new Locale("es", "ES"));
        listaLinguas.put("Polaco", new Locale("pl", "PL"));
        listaLinguas.put("Português", new Locale("it", "IT"));
        listaLinguas.put("Português", new Locale("pt", "PT"));

    }

    public void mudarLingua(ValueChangeEvent event) {
        String linguaSeleccionada = event.getNewValue().toString();
        //percorre o mada para compare o codigo actual com os existentes no map

        for (Map.Entry<String, Object> valorMapa : listaLinguas.entrySet()) {
            if (valorMapa.getValue().toString().equals(linguaSeleccionada)) {
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) valorMapa.getValue());
            }
        }

    }

    public void changeLanguage(String linguaSeleccionada) {
        setLanguage(linguaSeleccionada);
        System.out.println(">>>>>>>>>>>>>Lingua seleccionada" + linguaSeleccionada);
        for (Map.Entry<String, Object> valorMapa : listaLinguas.entrySet()) {
            if (valorMapa.getValue().toString().equals(linguaSeleccionada)) {
                this.lingua = linguaSeleccionada;
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) valorMapa.getValue());
            }
        }

    }

    public void reload() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        ViewHandler handler = context.getApplication().getViewHandler();
        UIViewRoot root = handler.createView(context, viewId);
        root.setViewId(viewId);
        context.setViewRoot(root);

    }

}
