/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.dao;

import hospitalx.dbutil.ConexaoDB;
import hospitalx.modelo.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jofrásio
 */
public class PacienteDAO {
    private String SELECT_ALL = "SELECT p.id_paciente, p.nome_paciente, p.sobrenom_paciente, p.data_nascimento_paciente, p.sexo_paciente, p.email_paciente, p.telefone_paciente, p.rua_paciente, p.casa_medico, p.bairro_paciente, p.distritito_paciente, m.nome_municipio FROM paciente p INNER JOIN municipio m ON p.id_municipio = m.id_municipio";
    private String INSERT = "INSERT INTO paciente (`nome_paciente`,`sobrenom_paciente`,`data_nascimento_paciente`,`sexo_paciente`,`email_paciente`,`telefone_paciente`,`rua_paciente`,`casa_medico,`bairro_paciente`,`distritito_paciente`,`id_municipio`) VALUES(?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
    private String EDITE= "UPDATE paciente SET nome_paciente = ?, sobrenom_paciente = ?, data_nascimento_paciente = ?, sexo_paciente = ?, email_paciente = ?, telefone_paciente = ?, rua_paciente = ?, casa_medico = ?, bairro_paciente = ?, distritito_paciente = ?, id_municipio = ? WHERE id_paciente = ?";
    private String DELETE = "DELETE FROM paciente WHERE id_paciente = ?;";
    private String LIST_BY_NAME="SELECT p.id_paciente, p.nome_paciente, p.sobrenom_paciente, p.data_nascimento_paciente, p.sexo_paciente, p.email_paciente, p.telefone_paciente, p.rua_paciente, p.casa_medico, p.bairro_paciente, p.distritito_paciente, m.nome_municipio FROM paciente p INNER JOIN municipio m ON p.id_municipio = m.id_municipio  WHERE p.nome_paciente LIKE ?";
    
    ConexaoDB conexao = new ConexaoDB();
    
    public void update(Paciente pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(EDITE);
            ps.setString(1, pac.getNomePaciente());
            ps.setString(2, pac.getSobrenomPaciente());
            ps.setDate(3, (Date) pac.getDataNascimentoPaciente());
            ps.setString(4, pac.getSexoPaciente());
            ps.setString(5, pac.getEmailPaciente());
            ps.setString(6, pac.getTelefonePaciente());
            ps.setString(7, pac.getRuaPaciente());
            ps.setString(8, pac.getBairroPaciente());
            ps.setString(9, pac.getDistritoPaciente());
            ps.setInt(10, pac.getIdMunicipio());
            ps.setInt(11, pac.getIdPaciente());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Actualizar o Registro: "+e.getLocalizedMessage());
        }
    }
    
    public void insert(Paciente pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(INSERT);
            ps.setString(1, pac.getNomePaciente());
            ps.setString(2, pac.getSobrenomPaciente());
            ps.setDate(3, (Date) pac.getDataNascimentoPaciente());
            ps.setString(4, pac.getSexoPaciente());
            ps.setString(5, pac.getEmailPaciente());
            ps.setString(6, pac.getTelefonePaciente());
            ps.setString(7, pac.getRuaPaciente());
            ps.setString(8, pac.getBairroPaciente());
            ps.setString(9, pac.getDistritoPaciente());
            ps.setInt(10, pac.getIdMunicipio());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Inserir os dados no Banco de Dados: "+e.getLocalizedMessage());
        }
    }
    
    public void delete(Paciente pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, pac.getIdPaciente());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Eliminar o Registro: "+e.getLocalizedMessage());
        }
    }
    
   public List<Paciente> findAll(){
       List<Paciente> lista = new ArrayList<>();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       try {
          con = conexao.ligarBB();
          ps = con.prepareStatement(SELECT_ALL);
          rs = ps.executeQuery();
           while (rs.next()) {               
               Paciente pac = new Paciente();
               pac.setIdPaciente(rs.getInt("p.id_paciente"));
               pac.setNomePaciente(rs.getString("p.nome_paciente"));
               pac.setSobrenomPaciente(rs.getString("p.sobrenom_paciente"));
               pac.setDataNascimentoPaciente(rs.getDate("p.data_nascimento_paciente"));
               pac.setSexoPaciente(rs.getString("p.sexo_paciente"));
               pac.setEmailPaciente(rs.getString("p.email_paciente"));
               pac.setTelefonePaciente(rs.getString("p.telefone_paciente"));
               pac.setRuaPaciente(rs.getString("p.rua_paciente"));
               pac.setCasaMedico(rs.getString("p.casa_medico"));
               pac.setBairroPaciente(rs.getString("p.bairro_paciente"));
               pac.setDistritoPaciente(rs.getString("p.distritito_paciente"));
               
               // em falta
               //pac.setIdMunicipio(rs.getInt(""));
               
               lista.add(pac);
  
           }
          
       } catch (SQLException e) {
           System.err.println("Erro ao Listar: "+e.getLocalizedMessage());
       }
       return lista;
   } 
    
   public List<Paciente> findByName(String nome){
       List<Paciente> lista = new ArrayList<>();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       try {
          con = conexao.ligarBB();
          ps = con.prepareStatement(LIST_BY_NAME);
          ps.setString(1,"%"+ nome+"%");
          rs = ps.executeQuery();
           while (rs.next()) {               
               Paciente pac = new Paciente();
               pac.setIdPaciente(rs.getInt("p.id_paciente"));
               pac.setNomePaciente(rs.getString("p.nome_paciente"));
               pac.setSobrenomPaciente(rs.getString("p.sobrenom_paciente"));
               pac.setDataNascimentoPaciente(rs.getDate("p.data_nascimento_paciente"));
               pac.setSexoPaciente(rs.getString("p.sexo_paciente"));
               pac.setEmailPaciente(rs.getString("p.email_paciente"));
               pac.setTelefonePaciente(rs.getString("p.telefone_paciente"));
               pac.setRuaPaciente(rs.getString("p.rua_paciente"));
               pac.setCasaMedico(rs.getString("p.casa_medico"));
               pac.setBairroPaciente(rs.getString("p.bairro_paciente"));
               pac.setDistritoPaciente(rs.getString("p.distritito_paciente"));
               
               // em falta
               //pac.setIdMunicipio(rs.getInt(""));
               
               lista.add(pac);
  
           }
          
       } catch (SQLException e) {
           System.err.println("Erro ao Listar: "+e.getLocalizedMessage());
       }
       return lista;
   } 


}
