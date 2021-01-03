package hospitalx.linguautil;


import javax.faces.context.FacesContext;
import java.util.Locale;
import javax.inject.Named;


@Named(value = "languageSwitcher")

@javax.enterprise.context.RequestScoped
public class LanguageSwitcher {

    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void changeLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }

}
