/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.dao;

import hospitalx.dbutil.ConexaoDB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "medicamentoDAO")
@RequestScoped
public class MedicamentoDAO {

    
    public MedicamentoDAO() {
    }
    
    public class medicamentoDAO {

    private static final String INSERIR = "INSERT INTO medicamento(nome_medicamento, data_validadeMedicamento)VALUES(?, ?)";
    private static final String ACTUALIZAR = "UPDATE medicamento SET nome_medicamento = ?, = ? WHERE id_funcionario = ?";
    private static final String ELIMINAR = "DELETE FROM medicamento WHERE id_medicamento = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_medicamento, nome_medicamento, nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = f.id_municipio WHERE id_funcionario = ?";
    private static final String BUSCAR_POR_NOME = "SELECT id_medicamento, nome_medicamento, data_validadeMedicamento,nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = f.id_municipio WHERE nome_funcionario LIKE ? OR sobrenom_funcionario LIKE ?";
    private static final String LISTAR_TUDO = "SELECT id_medicamento, nome_medicamento,data_validadeMedicamento,nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = f.id_municipio";
   
    
  
    }

    

}