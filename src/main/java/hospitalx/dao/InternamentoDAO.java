/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.dao;

import hospitalx.dbutil.ConexaoDB;
import hospitalx.modelo.Cama;
import hospitalx.modelo.Quarto;
import hospitalx.modelo.Medico;
import hospitalx.modelo.Paciente;
import hospitalx.modelo.Internamento;
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
public class InternamentoDAO {
    private String SELECT_ALL = "SELECT i.id_internamento, i.data, q.sigla_quarto, c.numero_cama, p.nome_paciente, m.nome_medico  FROM internamento i INNER JOIN quarto q ON q.id_quarto = i.id_quarto INNER JOIN cama c ON c.id_cama = i.id_cama INNER JOIN paciente p ON p.id_paciente = i.id_paciente INNER JOIN medico m ON m.id_medico = i.id_medico";
    private String INSERT = "INSERT INTO internamento (`data`,`id_quarto`,`id_cama`,`id_paciente`,`id_medico`) VALUES(?, ?, ?, ?, ?)";
    private String EDITE= "UPDATE internamento SET data = ?, id_quarto = ?, id_cama = ?, id_paciente = ?, id_medico = ? WHERE id_internamento = ?";
    private String DELETE = "DELETE FROM internamento WHERE id_internamento = ?;";
    private String LIST_BY_NAME="SELECT i.id_internamento, i.data, q.sigla_quarto, c.nome_cama, p.nome_paciente, m.nome_medico FROM internamento i INNER JOIN quarto q ON q.id_quarto = i.id_quarto INNER JOIN cama c ON c.id_cama = i.id_cama INNER JOIN paciente p ON p.id_paciente = i.id_paciente INNER JOIN medico m ON m.id_medico = i.id_medico  WHERE p.nome_paciente LIKE ?";
    private String INSERTE = "INSERT INTO `internamento` (`data`,`id_quarto`,`id_cama`,`id_paciente`,`id_medico`) VALUES ( ?, ?, ?, ?, ?);";
    ConexaoDB conexao = new ConexaoDB();
    
    public void update(Internamento pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(EDITE);
            ps.setDate(1, (Date) pac.getData());
            ps.setInt(2, pac.getQuarto().getIdQuarto());
            ps.setInt(3, pac.getCama().getIdCama());
            ps.setInt(4, pac.getPaciente().getIdPaciente());
            ps.setInt(5, pac.getMedico().getIdMedico());
            ps.setInt(6, pac.getIdInternamento());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Actualizar o Registro: "+e.getLocalizedMessage());
        }
    }
    
    public void insert(Internamento pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(INSERTE);
            ps.setDate(1, (Date) pac.getData());
            ps.setInt(2, pac.getQuarto().getIdQuarto());
             ps.setInt(3, pac.getCama().getIdCama());
              ps.setInt(4, pac.getPaciente().getIdPaciente());
               ps.setInt(5, pac.getMedico().getIdMedico());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Inserir os dados no Banco de Dados: "+e.getLocalizedMessage());
        }
    }
    
    public void delete(Internamento pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, pac.getIdInternamento());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Eliminar o Registro: "+e.getLocalizedMessage());
        }
    }
    
   public List<Internamento> findAll(){
       List<Internamento> lista = new ArrayList<>();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       try {
          con = conexao.ligarBB();
          ps = con.prepareStatement(SELECT_ALL);
          rs = ps.executeQuery();
           while (rs.next()) {               
               Internamento pac = new Internamento();
               pac.setIdInternamento(rs.getInt("i.id_internamento"));
               pac.setData(rs.getDate("i.data"));
               
               Quarto q = new Quarto();
               q.setSiglaQuarto(rs.getString("q.sigla_quarto"));
               pac.setQuarto(q);
               Cama c = new Cama();
               c.setNumeroCama(rs.getString("m.nome_cama"));
               pac.setCama(c);
               Paciente p = new Paciente();
               p.setNomePaciente(rs.getString("q.nome_paciente"));
               pac.setPaciente(p);
               Medico m = new Medico();
               m.setNomeMedico(rs.getString("m.nome_medico"));
               pac.setMedico(m);
               
               lista.add(pac);
           }
          
       } catch (SQLException e) {
           System.err.println("Erro ao Listar: "+e.getLocalizedMessage());
       }
       return lista;
   } 
    
   public List<Internamento> findByName(String nome){
       List<Internamento> lista = new ArrayList<>();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       try {
          con = conexao.ligarBB();
          ps = con.prepareStatement(LIST_BY_NAME);
          ps.setString(1,"%" + nome + "%");
          rs = ps.executeQuery();
           while (rs.next()) {               
               Internamento pac = new Internamento();
               pac.setIdInternamento(rs.getInt("i.id_internamento"));
               pac.setData(rs.getDate("i.data"));
               Quarto q = new Quarto();
               q.setSiglaQuarto(rs.getString("m.sigla_quarto"));
               pac.setQuarto(q);
               Cama c = new Cama();
               c.setNumeroCama(rs.getString("m.numero_cama"));
               pac.setCama(c);
               
               Paciente p = new Paciente();
               p.setNomePaciente(rs.getString("m.nome_paciente"));
               pac.setPaciente(p);
               
               Medico m = new Medico();
               m.setNomeMedico(rs.getString("m.nome_medico"));
               pac.setMedico(m);
               
               lista.add(pac);
  
           }
          
       } catch (SQLException e) {
           System.err.println("Erro ao Listar: "+e.getLocalizedMessage());
       }
       return lista;
   } 


}
