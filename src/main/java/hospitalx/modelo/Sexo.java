
package hospitalx.modelo;

public enum Sexo {
    MASCULINO("M", "Masculino"), FEMENINO("F", "Feminino");
    
    private String abreviatura;
    private String extensao;
    
    private Sexo(String abreviatura, String extensao) {
        this.abreviatura = abreviatura;
        this.extensao = extensao;
    }
    
    public String getAbreviatura() {
        return abreviatura;
    }
    
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    
    public String getExtensao() {
        return extensao;
    }
    
    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    //Metodo auxiliar para interagir com o enum
    public static Sexo getAbreviatura(String id) {
        
        for (Sexo s : values()) {
            if(s.getAbreviatura().equals(id)){
            
            return s;
            }
        }
       return null; 
    }
    
}
