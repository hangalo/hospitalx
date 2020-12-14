/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.dao;

import hospitalx.dbutil.ConexaoDB;
import hospitalx.modelo.Municipio;
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
public class MunicipioDAO {
    private static final String BUSCAR_POR_CODIGO = "SELECT m.id_municipio, m.nome_municipio WHERE id_municipio =?";
    private static final String LISTAR_TUDO = "SELECT id_municipio, nome_municipio FROM municipio";


    ConexaoDB conexaoDB = new ConexaoDB();


    
     public Municipio findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Municipio municipio = new Municipio();

        try {
            conn = conexaoDB.ligarBB();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(municipio, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
           ConexaoDB.fecharConexao(conn, ps, rs);
        }

        return municipio;
    }
    
    public List<Municipio> findAll() {
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Municipio> municipios = new ArrayList<>();
        try {
            conn =  conexaoDB.ligarBB();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Municipio municipio = new Municipio();
                popularComDados(municipio, rs);
                municipios.add(municipio);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        return municipios;
    }
    
    
     private void popularComDados(Municipio municipio, ResultSet rs) {
        try {
            municipio.setIdMunicipio(rs.getInt("id_municipio"));
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
           

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
