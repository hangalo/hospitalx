
package hospitalx.mb;

import hospitalx.dao.MedicamentoDAO;
import hospitalx.modelo.Funcionario;
import hospitalx.modelo.Medicamento;
import hospitalx.modelo.Sexo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;

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

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
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
        return "funcionario-editar";
    }

    public String editar() {
        medicamentoDao.update(medicamento);
        medicamento = new Medicamento();
        return "medicamento-lista?faces-redirect=true";
    }
    
     public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getExtensao()));
        }
        return list;
    }
}

