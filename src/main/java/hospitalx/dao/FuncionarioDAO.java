/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.dao;

import hospitalx.dbutil.ConexaoDB;
import hospitalx.modelo.Funcionario;
import hospitalx.modelo.Municipio;
import hospitalx.modelo.Sexo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class FuncionarioDAO {

    private static final String INSERIR = "INSERT INTO funcionario(nome_funcionario, sobrenom_funcionario,data_nascimento_funcionario, sexo_funcionario,email_funcionario,telefone_funcionario,rua_funcionario,casa_funcionario, bairro_funcionario, distritito_funcionario, id_municipio)VALUES(?, ?, ?, ?,?,?,?, ?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE funcionario SET nome_funcionario = ?, sobrenom_funcionario = ?, data_nascimento_funcionario = ?, sexo_funcionario =?, email_funcionario = ?, telefone_funcionario = ?, rua_funcionario = ?, casa_funcionario = ?, bairro_funcionario = ?, distritito_funcionario = ?, id_municipio = ? WHERE id_funcionario = ?";
    private static final String ELIMINAR = "DELETE FROM funcionario WHERE id_funcionario = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_funcionario, nome_funcionario, sobrenom_funcionario, data_nascimento_funcionario, sexo_funcionario, email_funcionario, telefone_funcionario, rua_funcionario, casa_funcionario, bairro_funcionario,  distritito_funcionario,  nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = f.id_municipio WHERE id_funcionario = ?";
    private static final String BUSCAR_POR_NOME = "SELECT id_funcionario, nome_funcionario, sobrenom_funcionario, data_nascimento_funcionario, sexo_funcionario, email_funcionario, telefone_funcionario, rua_funcionario, casa_funcionario, bairro_funcionario,  distritito_funcionario,  nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = f.id_municipio WHERE nome_funcionario LIKE ? OR sobrenom_funcionario LIKE ?";
    private static final String LISTAR_TUDO = "SELECT id_funcionario, nome_funcionario, sobrenom_funcionario, data_nascimento_funcionario, sexo_funcionario, email_funcionario, telefone_funcionario, rua_funcionario, casa_funcionario, bairro_funcionario,  distritito_funcionario,  nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = m.id_municipio";
   
    
    ConexaoDB conexaoDB = new ConexaoDB();

    public void insert(Funcionario f) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, f.getNomeFuncionario());
            ps.setString(2, f.getSobrenomFuncionario());
            ps.setDate(3, new java.sql.Date(f.getDataNascimento().getTime()));
            ps.setString(4, f.getSexoFuncionario().getAbreviatura());
            ps.setString(5, f.getEmailFuncionario());
            ps.setString(6, f.getRuaFuncionario());
            ps.setString(7, f.getCasaFuncionario());
            ps.setString(8, f.getBairroFuncionario());
            ps.setString(9, f.getDistrititoFuncionario());
            ps.setInt(10, f.getMunicipio().getIdMunicipio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }

    }

    public void update(Funcionario f) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, f.getNomeFuncionario());
            ps.setString(2, f.getSobrenomFuncionario());
            ps.setDate(3, new java.sql.Date(f.getDataNascimento().getTime()));
            ps.setString(4, f.getSexoFuncionario().getAbreviatura());
            ps.setString(5, f.getEmailFuncionario());
            ps.setString(6, f.getRuaFuncionario());
            ps.setString(7, f.getCasaFuncionario());
            ps.setString(8, f.getBairroFuncionario());
            ps.setString(9, f.getDistrititoFuncionario());
            ps.setInt(10, f.getMunicipio().getIdMunicipio());
            ps.setInt(11, f.getIdFuncionario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }

    }

    public void delete(Funcionario f) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, f.getIdFuncionario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }

    }

    public List<Funcionario> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                popularComDados(funcionario, rs);
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return funcionarios;
    }

    public List<Funcionario> findByNomeSobrenome(String valor) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = conexaoDB.ligarBB();

            ps = conn.prepareStatement(BUSCAR_POR_NOME);
            ps.setString(1, "%" + valor + "%");
            ps.setString(2, "%" + valor + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                popularComDados(funcionario, rs);
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return funcionarios;
    }

    private void popularComDados(Funcionario funcionario, ResultSet rs) {
        try {
            funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
            funcionario.setNomeFuncionario(rs.getString("nome_funcionario"));
            funcionario.setSobrenomFuncionario(rs.getString("sobrenom_funcionario"));
            funcionario.setDataNascimento(rs.getDate("data_nascimento_funcionario"));
            funcionario.setSexoFuncionario(Sexo.getAbreviatura(rs.getString(" sexo_funcionario")));
            funcionario.setCasaFuncionario(rs.getString("casa_funcionarioo"));
            funcionario.setRuaFuncionario(rs.getString("rua_funcionario"));
            funcionario.setBairroFuncionario(rs.getString("bairro_funcionario"));
            funcionario.setDistrititoFuncionario(rs.getString("distritito_funcionario"));
            funcionario.setEmailFuncionario(rs.getString("email_funcionario"));
            funcionario.setTelefoneFuncionario(rs.getString("telefone_funcionario"));
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            funcionario.setMunicipio(municipio);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
