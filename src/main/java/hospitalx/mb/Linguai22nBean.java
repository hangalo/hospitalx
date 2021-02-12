/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package org.ofmcap.domus.mbean;

package hospitalx.mb;

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
import javax.inject.Inject;

@Named(value = "linguai22nBean")
@SessionScoped
public class Linguai22nBean implements Serializable {

    private String lingua;
    private Map<String, Object> listaLinguas;

    @PostConstruct
    public void init() {
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

    private void carregaLinguas() {
        lingua = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
        listaLinguas = new LinkedHashMap<>();
        listaLinguas.put("Português", new Locale("pt", "PT"));
        listaLinguas.put("Inglês", new Locale("en", "GB"));
        listaLinguas.put("Francês", new Locale("fr", "FR"));

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
