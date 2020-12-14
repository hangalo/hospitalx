/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.md;

import hospitalx.dao.FuncionarioDAO;
import hospitalx.dao.PacienteDAO;
import hospitalx.modelo.Funcionario;
import hospitalx.modelo.Paciente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

@Named(value = "funcioarioMB")
@SessionScoped
public class FuncioarioMB implements Serializable {

    Funcionario funcionario = new Funcionario();
    FuncionarioDAO funcionarioDao = new FuncionarioDAO();
    List<Funcionario> listaFuncionarios = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        listaFuncionarios = funcionarioDao.findAll();
    }

    public String insert() {
        funcionarioDao.insert(funcionario);
        funcionario = new Funcionario();
        return "funcionario-lista?faces-redirect=true";
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
}
