/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.mb;

import hospitalx.dao.FuncionarioDAO;
import hospitalx.modelo.Funcionario;
import hospitalx.modelo.Sexo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

@Named(value = "funcioarioMB")
@ViewScoped
public class FuncioarioMB implements Serializable {

    Funcionario funcionario = new Funcionario();
    FuncionarioDAO funcionarioDao = new FuncionarioDAO();
    List<Funcionario> listaFuncionarios = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
    listaFuncionarios = funcionarioDao.findAll();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    
    
    
    
    
    
    public String insert() {
        funcionarioDao.insert(funcionario);
        funcionario = new Funcionario();
        return "staff/funcionarios/gestao-funcionario?faces-redirect=true";
    }

    public String eliminar() {
        funcionarioDao.delete(funcionario);
        funcionario = new Funcionario();
        return null;
    }

    public String prepararEditar() {
        return "funcionario-editar";
    }

    public String editar() {
        funcionarioDao.update(funcionario);
        funcionario = new Funcionario();
        return "funcionario-lista?faces-redirect=true";
    }
    
     public List<SelectItem> getOpSexos() {
        List<SelectItem> list = new ArrayList<>();
        for (Sexo sexo : Sexo.values()) {
            list.add(new SelectItem(sexo, sexo.getExtensao()));
        }
        return list;
    }
}
