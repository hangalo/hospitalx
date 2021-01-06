
package hospitalx.dao;

import hospitalx.dbutil.ConexaoDB;
import hospitalx.modelo.Funcionario;
import hospitalx.modelo.Especialidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO {

    private String INSERIR;
    private String ACTUALIZAR;
    private String ELIMINAR;
    private String LISTAR_TUDO;
    private String BUSCAR_POR_NOME;
    private List<Especialidade> especialidade;

    public EspecialidadeDAO() {
    }

    
    public void insert(Especialidade Especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void delete(Especialidade Especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void update(Especialidade Especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   
    private static class especialidade {

        public especialidade() {
        }

        private String getNomeEspecialidade() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private int getIdEspecialidade() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    }

    private static class especialidades {

        private static void add(Especialidade especialidade) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        public especialidades() {
        }
    }

    public class especialidadeDAO {

        private static final String INSERIR = "INSERT INTO medicamento(nome_especialidade)VALUES(?,)";
        private static final String ACTUALIZAR = "UPDATE especialidade SET nome_especialidade = ?, = ? WHERE id_funcionario = ?";
        private static final String ELIMINAR = "DELETE FROM especialidade WHERE id_especialidade = ?";
        private static final String BUSCAR_POR_CODIGO = "SELECT id_especialidade, nome_especialidade, nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = f.id_municipio WHERE id_funcionario = ?";
        private static final String BUSCAR_POR_NOME = "SELECT id_especialidade, nome_especialidade,nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = f.id_municipio WHERE nome_funcionario LIKE ? OR sobrenom_funcionario LIKE ?";
        private static final String LISTAR_TUDO = "SELECT id_especialidade, nome_especialidade,nome_municipio FROM funcionario f INNER JOIN municipio m ON f.id_municipio = f.id_municipio";

    }

    ConexaoDB conexaoDB = new ConexaoDB();

 
    public void insert(especialidade e) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, e.getNomeEspecialidade());
            ps.setInt(2, e.getIdEspecialidade());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }

 
        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, e.getNomeEspecialidade());
            ps.setInt(2, e.getIdEspecialidade());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, e.getIdEspecialidade());
            ps.setString(2, e.getNomeEspecialidade());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        } finally {

            ConexaoDB.fecharConexao(conn, ps);
        }

    }

    public List<Especialidade> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Especialidade> Especialidade = new ArrayList<>();
        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {

                Especialidade = (List<Especialidade>) new EspecialidadeDAO.especialidade();
                popularComDados((Especialidade) especialidade, rs);
                EspecialidadeDAO.especialidades.add((Especialidade) Especialidade);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return especialidade;
    }

    public List<Especialidade> findByNome(String valor) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Especialidade> Especialidades = new ArrayList<>();
        try {
            conn = conexaoDB.ligarBB();

            ps = conn.prepareStatement(BUSCAR_POR_NOME);
            ps.setString(1, "%" + valor + "%");
            ps.setString(2, "%" + valor + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Especialidade Especialidade = new Especialidade();
                popularComDados(Especialidade, rs);
                Especialidades.add(Especialidade);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return Especialidades;
    }

    private void popularComDados(Especialidade Especialidade, ResultSet rs) {
        try {
            Especialidade.setIdEspecialidade(rs.getInt("id_Especialidade"));
            Especialidade.setNomeEspecialidade(rs.getString("nome_Especialidade"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
