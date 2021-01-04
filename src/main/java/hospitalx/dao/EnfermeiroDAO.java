/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.dao;

import hospitalx.dbutil.ConexaoDB;
import hospitalx.modelo.Enfermeiro;
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
 * @author Celina Sebastião
 */

public class EnfermeiroDAO {

    private static final String INSERIR = "INSERT INTO enfermeiro(nome_enfermeiro,sobrenom_enfermeiro,data_nascimento_enfermeiro,sexo_enfermeiro,email_enfermeiro,telefone_enfermeiro,rua_enfermeiro,casa_enfermeiro,bairro_enfermeiro,distritito_enfermeiro,id_municipio) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE enfermeiro SET nome_enfermeiro = ?,sobrenom_enfermeiro = ?,data_nascimento_enfermeiro = ?,sexo_enfermeiro = ?,email_enfermeiro = ?,telefone_enfermeiro = ?,rua_enfermeiro = ?,casa_enfermeiro = ?,bairro_enfermeiro = ?,distritito_enfermeiro = ?,id_municipio = ? WHERE id_enfermeiro = ?";
    private static final String ELIMINAR = "DELETE FROM enfermeiro WHERE id_enfermeiro = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_enfermeiro,nome_enfermeiro,sobrenom_enfermeiro,data_nascimento_enfermeiro,sexo_enfermeiro,email_enfermeiro,telefone_enfermeiro,rua_enfermeiro,casa_enfermeiro,bairro_enfermeiro,distritito_enfermeiro, nome_municipio FROM enfermeiro e INNER JOIN municipio m ON e.id_municipio = m.id_municipio WHERE id_enfermeiro = ?";
    private static final String BUSCAR_POR_NOME = "SELECT id_enfermeiro,nome_enfermeiro,sobrenom_enfermeiro,data_nascimento_enfermeiro,sexo_enfermeiro,email_enfermeiro,telefone_enfermeiro,rua_enfermeiro,casa_enfermeiro,bairro_enfermeiro,distritito_enfermeiro, nome_municipio FROM enfermeiro e INNER JOIN municipio m ON e.id_municipio = m.id_municipio WHERE nome_enfermeiro LIKE ? OR sobrenom_enfermeiro LIKE ?";
    private static final String LISTAR_TUDO = "SELECT id_enfermeiro,nome_enfermeiro,sobrenom_enfermeiro,data_nascimento_enfermeiro,sexo_enfermeiro,email_enfermeiro,telefone_enfermeiro,rua_enfermeiro,casa_enfermeiro,bairro_enfermeiro,distritito_enfermeiro, nome_municipio FROM enfermeiro e INNER JOIN municipio m ON e.id_municipio = m.id_municipio";

    ConexaoDB conexaoDB = new ConexaoDB();

    public void insert(Enfermeiro e) {

        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, e.getNomeEnfermeiro());
            ps.setString(2, e.getSobrenomeEnfermeiro());
            ps.setDate(3, new java.sql.Date(e.getDataNascimentoEnfermeiro().getTime()));
            ps.setString(4, e.getSexoEnfermeiro().getAbreviatura());
            ps.setString(5, e.getEmailEnfermeiro());
            ps.setString(6, e.getTelefoneEnfermeiro());
            ps.setString(7, e.getRuaEnfermeiro());
            ps.setString(8, e.getCasaEnfermeiro());
            ps.setString(9, e.getBairroEnfermeiro());
            ps.setString(10, e.getDistritoEnfermeiro());
            ps.setInt(11, e.getMunicipio().getIdMunicipio());
        } catch (SQLException ex) {

            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());

        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }

    }

    public void update(Enfermeiro e) {

        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, e.getNomeEnfermeiro());
            ps.setString(2, e.getSobrenomeEnfermeiro());
            ps.setDate(3, new java.sql.Date(e.getDataNascimentoEnfermeiro().getTime()));
            ps.setString(4, e.getSexoEnfermeiro().getAbreviatura());
            ps.setString(5, e.getEmailEnfermeiro());
            ps.setString(6, e.getTelefoneEnfermeiro());
            ps.setString(7, e.getRuaEnfermeiro());
            ps.setString(8, e.getCasaEnfermeiro());
            ps.setString(9, e.getBairroEnfermeiro());
            ps.setString(10, e.getDistritoEnfermeiro());
            ps.setInt(11, e.getMunicipio().getIdMunicipio());
        } catch (SQLException ex) {

            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());

        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }
    }

    public void delete(Enfermeiro e) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, e.getIdEnfermeiro());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }

    }

    public List<Enfermeiro> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Enfermeiro> enfermeiros = new ArrayList<>();
        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Enfermeiro enfermeiro = new Enfermeiro();
                popularComDados(enfermeiro, rs);
                enfermeiros.add(enfermeiro);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return enfermeiros;
    }

    public List<Enfermeiro> findByNomeSobrenome(String valor) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Enfermeiro> enfermeiros = new ArrayList<>();
        try {
            conn = conexaoDB.ligarBB();

            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setString(1, "%" + valor + "%");
            ps.setString(2, "%" + valor + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Enfermeiro enfermeiro = new Enfermeiro();
                popularComDados(enfermeiro, rs);
                enfermeiros.add(enfermeiro);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return enfermeiros;
    }

    private void popularComDados(Enfermeiro enfermeiro, ResultSet rs) {
        try {

            enfermeiro.setIdEnfermeiro(rs.getInt("id_enfermeiro"));
            enfermeiro.setNomeEnfermeiro(rs.getString("nome_enfermeiro"));
            enfermeiro.setSobrenomeEnfermeiro(rs.getString("sobrenom_enfermeiro"));
            enfermeiro.setDataNascimentoEnfermeiro(rs.getDate("data_nascimento_enfermeiro"));
            enfermeiro.setSexoEnfermeiro(Sexo.getAbreviatura(rs.getString(" sexo_enfermeiro")));
            enfermeiro.setEmailEnfermeiro(rs.getString("email_enfermeiro"));
            enfermeiro.setTelefoneEnfermeiro(rs.getString("telefone_enfermeiro"));
            enfermeiro.setRuaEnfermeiro(rs.getString("rua_enfermeiro"));
            enfermeiro.setCasaEnfermeiro(rs.getString("casa_enfermeiro"));
            enfermeiro.setBairroEnfermeiro(rs.getString("bairro_enfermeiro"));
            enfermeiro.setDistritoEnfermeiro(rs.getString("distritito_enfermeiro"));
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            enfermeiro.setMunicipio(municipio);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

  
}
