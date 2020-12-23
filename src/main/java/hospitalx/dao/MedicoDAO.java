package hospitalx.dao;

import hospitalx.dbutil.ConexaoDB;
import hospitalx.modelo.Medico;
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
 * @author Mário N
 */
public class MedicoDAO {

    private String LISTAR_TODOS = "SELECT a.id_medico, a.nome_medico, a.sobrenom_medico, a.data_nascimento_medico,a.sexo_medico,"
            + "a.email_medico, a.telefone_medico, a.rua_medico, a.casa_medico,a.bairro_medico, a.distritito_medico,b.nome_municipio"
            + " FROM medico a INNER JOIN municipio b ON a.id_municipio = b.id_municipio";
    private String PESQUISAR_POR_NOME = "SELECT a.id_medico, a.nome_medico, a.sobrenom_medico, a.data_nascimento_medico,a.sexo_medico,"
            + "a.email_medico, a.telefone_medico, a.rua_medico, a.casa_medico,a.bairro_medico, a.distritito_medico,b.nome_municipio"
            + " FROM medico a INNER JOIN municipio b ON a.id_municipio = b.id_municipio"
            + " WHERE a.nome_medico LIKE ? OR a.sobrenom_medico LIKE ?";
    private String PESQUISAR_POR_SEXO = "SELECT a.id_medico, a.nome_medico, a.sobrenom_medico, a.data_nascimento_medico,a.sexo_medico,"
            + "a.email_medico, a.telefone_medico, a.rua_medico, a.casa_medico,a.bairro_medico, a.distritito_medico,b.nome_municipio "
            + "FROM medico a INNER JOIN municipio b ON a.id_municipio = b.id_municipio "
            + "WHERE a.sexo_medico LIKE ?";
    private String INSERIR = "INSERT INTO medico (nome_medico,sobrenom_medico,data_nascimento_medico,sexo_medico,email_medico,telefone_medico,"
            + "rua_medico,casa_medico,bairro_medico,distritito_medico,id_municipio) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private String EDITAR = "UPDATE medico SET nome_medico = ?,sobrenom_medico = ?,data_nascimento_medico = ?, sexo_medico = ?, email_medico = ?, telefone_medico = ?,rua_medico = ?"
            + ",casa_medico = ?,bairro_medico = ?,distritito_medico = ?,id_municipio = ? WHERE id_medico = ?";
    private String REMOVER = "DELETE FROM medico WHERE id_medico = ?";

    ConexaoDB conexaoDB = new ConexaoDB();

    public List<Medico> findAll() {
        PreparedStatement ps;
        Connection conn = null;
        ResultSet rs;
        List<Medico> medicos = new ArrayList<>();
        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(LISTAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico();
                carregarDadosParaOBJECT(medico, rs);
                medicos.add(medico);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:FuncionarioDAO:findAll: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return medicos;
    }

    public List<Medico> findByNomeSobrenome(String strNome) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Medico> medicos = new ArrayList<>();
        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(PESQUISAR_POR_NOME);
            ps.setString(1, "%" + strNome + "%");
            ps.setString(2, "%" + strNome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Medico med = new Medico();
                carregarDadosParaOBJECT(med, rs);
                medicos.add(med);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:FuncionarioDAO:findByNomeSobrenome: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return medicos;
    }

    public List<Medico> findBySexo(String strSexo) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Medico> medicos = new ArrayList<>();
        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(PESQUISAR_POR_SEXO);
            ps.setString(1, "%" + strSexo + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Medico med = new Medico();
                carregarDadosParaOBJECT(med, rs);
                medicos.add(med);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:FuncionarioDAO:findBySexo: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return medicos;
    }

    public void insert(Medico m) {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(INSERIR);
            carregarDadosParaDB(ps, m);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:FuncionarioDAO:insert: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn, ps);
        }
    }

    public void update(Medico m) {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(EDITAR);
            carregarDadosParaDB(ps, m);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:FuncionarioDAO:update: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn, ps);
        }
    }

    public void delete(Medico m) {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(REMOVER);
            ps.setInt(1, m.getIdMedico());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados:FuncionarioDAO:update: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn, ps);
        }
    }

    private void carregarDadosParaOBJECT(Medico medico, ResultSet rs) {
        try {
            medico.setIdMedico(rs.getInt("id_medico"));
            medico.setNomeMedico(rs.getString("nome_medico"));
            medico.setSobrenomMedico(rs.getString("sobrenom_medico"));
            medico.setDataNascimentoMedico(rs.getDate("data_nascimento_medico"));
            medico.setSexoMedico(Sexo.getAbreviatura(rs.getString("sexo_medico")));
            medico.setEmailMedico(rs.getString("email_medico"));
            medico.setTelefoneMedico(rs.getString("telefone_medico"));
            medico.setRuaMedico(rs.getString("rua_medico"));
            medico.setCasaMedico(rs.getString("casa_medico"));
            medico.setBairroMedico(rs.getString("bairro_medico"));
            medico.setDistrititoMedico(rs.getString("distritito_medico"));
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            medico.setMunicipio(municipio);
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados:carregarDadosParaOBJECT: " + ex.getLocalizedMessage());
        }
    }

    private void carregarDadosParaDB(PreparedStatement ps, Medico m) {
        try {
            ps.setString(1, m.getNomeMedico());
            ps.setString(2, m.getSobrenomMedico());
            ps.setDate(3, new java.sql.Date(m.getDataNascimentoMedico().getTime()));
            ps.setString(4, m.getSexoMedico().getAbreviatura());
            ps.setString(5, m.getEmailMedico());
            ps.setString(6, m.getTelefoneMedico());
            ps.setString(7, m.getRuaMedico());
            ps.setString(8, m.getCasaMedico());
            ps.setString(9, m.getBairroMedico());
            ps.setString(10, m.getDistrititoMedico());
            ps.setInt(11, m.getMunicipio().getIdMunicipio());
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados:carregarDadosParaDB: " + ex.getLocalizedMessage());
        }
    }

}
