
package hospitalx.mb;

import hospitalx.dao.MedicamentoDAO;
import hospitalx.modelo.Medicamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "MedicamentoMB")
@SessionScoped
public class MedicamentoMB implements Serializable {

    Medicamento medicamento = new Medicamento();
    MedicamentoDAO medicamentoDao = new MedicamentoDAO();
    List<Medicamento> listaMedicamentos = new ArrayList<>();

    @PostConstruct
    public void inicializar() {

    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public List<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }

    public String insert() {
        medicamentoDao.insert(medicamento);
        medicamento = new Medicamento();
        return "medicamento-lista?faces-redirect=true";
    }

    public String eliminar() {
        medicamentoDao.delete(medicamento);
        medicamento = new Medicamento();
        return null;
    }

    public String prepararEditar() {
        return "medicamento-editar";
    }

    public String editar() {
        medicamentoDao.update(medicamento);
        medicamento = new Medicamento();
        return "medicamento-lista?faces-redirect=true";
    }   
}

