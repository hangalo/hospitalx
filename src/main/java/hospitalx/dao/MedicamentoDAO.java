/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.dao;

import hospitalx.dbutil.ConexaoDB;
import hospitalx.modelo.Medicamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MedicamentoDAO {

    

    private static final String INSERIR = "INSERT INTO medicamento(nome_medicamento, data_validadeMedicamento)VALUES(?, ?)";
    private static final String ACTUALIZAR = "UPDATE medicamento SET nome_medicamento = ?, = ? WHERE id_funcionario = ?";
    private static final String ELIMINAR = "DELETE FROM medicamento WHERE id_medicamento = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_medicamento, nome_medicamento, nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = f.id_municipio WHERE id_funcionario = ?";
    private static final String BUSCAR_POR_NOME = "SELECT id_medicamento, nome_medicamento, data_validadeMedicamento,nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = f.id_municipio WHERE nome_funcionario LIKE ? OR sobrenom_funcionario LIKE ?";
    private static final String LISTAR_TUDO = "SELECT id_medicamento, nome_medicamento,data_validadeMedicamento,nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = f.id_municipio";
   
    
  
    

   ConexaoDB conexaoDB = new ConexaoDB();

    public void insert(Medicamento m) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1,m.getNomeMedicamento());
           ps.setDate(2, new java.sql.Date(m.getData().getTime()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }

    }

    public void update(Medicamento m) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, m.getNomeMedicamento());
            ps.setDate(2, new java.sql.Date(m.getData().getTime()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }

    }

    public void delete(Medicamento m) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, m.getIdMedicamento());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }

    }

    public List<Medicamento> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Medicamento> medicamentos = new ArrayList<>();
        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Medicamento m = new Medicamento();
                popularComDados(m, rs);
               medicamentos.add(m);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return medicamentos;
    }

    public List<Medicamento> findByNome(String valor) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Medicamento> Medicamentos = new ArrayList<>();
        try {
            conn = conexaoDB.ligarBB();

            ps = conn.prepareStatement(BUSCAR_POR_NOME);
            ps.setString(1, "%" + valor + "%");
            ps.setString(2, "%" + valor + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Medicamento Medicamento = new Medicamento();
                popularComDados(Medicamento, rs);
                Medicamentos.add(Medicamento);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return Medicamentos;
    }

    private void popularComDados(Medicamento Medicamento, ResultSet rs) {
        try {
           Medicamento.setIdMedicamento(rs.getInt("id_Medicamento"));
            Medicamento.setNomeMedicamento(rs.getString("nome_Medicamento"));
            Medicamento.setData(rs.getDate("data_Medicamento"));
           

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
 

