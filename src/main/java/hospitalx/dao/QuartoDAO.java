/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.dao;

import hospitalx.dbutil.ConexaoDB;
import hospitalx.modelo.Quarto;
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
public class QuartoDAO {
    private String SELECT_ALL = "SELECT p.id_quarto, p.sigla_quarto FROM quarto p ";
    private String INSERT = "INSERT INTO quarto (`sigla_quarto`) VALUES(?)";
    private String EDITE= "UPDATE quarto SET sigla_quarto = ? WHERE id_quarto = ?";
    private String DELETE = "DELETE FROM quarto WHERE id_quarto = ?;";
    private String LIST_BY_NAME="SELECT p.id_quarto, p.sigla_quarto FROM quarto WHERE p.sigla_quarto LIKE ?";
    private String INSERTE = "INSERT INTO `quarto` (`sigla_quarto`) VALUES (?);";
    ConexaoDB conexao = new ConexaoDB();
    
    public void update(Quarto pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(EDITE);
            ps.setString(1, pac.getSiglaQuarto());
            ps.setInt(2, pac.getIdQuarto());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Actualizar o Registro: "+e.getLocalizedMessage());
        }
    }
    
    public void insert(Quarto pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(INSERTE);
            ps.setString(1, pac.getSiglaQuarto());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Inserir os dados no Banco de Dados: "+e.getLocalizedMessage());
        }
    }
    
    public void delete(Quarto pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, pac.getIdQuarto());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Eliminar o Registro: "+e.getLocalizedMessage());
        }
    }
    
   public List<Quarto> findAll(){
       List<Quarto> lista = new ArrayList<>();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       try {
          con = conexao.ligarBB();
          ps = con.prepareStatement(SELECT_ALL);
          rs = ps.executeQuery();
           while (rs.next()) {               
               Quarto pac = new Quarto();
               pac.setIdQuarto(rs.getInt("p.id_quarto"));
               pac.setSiglaQuarto(rs.getString("p.sigla_quarto"));           
               lista.add(pac);
           }
          
       } catch (SQLException e) {
           System.err.println("Erro ao Listar: "+e.getLocalizedMessage());
       }
       return lista;
   } 
    
   public List<Quarto> findByName(String nome){
       List<Quarto> lista = new ArrayList<>();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       try {
          con = conexao.ligarBB();
          ps = con.prepareStatement(LIST_BY_NAME);
          ps.setString(1,"%" + nome + "%");
          rs = ps.executeQuery();
           while (rs.next()) {               
               Quarto pac = new Quarto();
               pac.setIdQuarto(rs.getInt("p.id_quarto"));
               pac.setSiglaQuarto(rs.getString("p.sigla_quarto"));               
               lista.add(pac);
  
           }
          
       } catch (SQLException e) {
           System.err.println("Erro ao Listar: "+e.getLocalizedMessage());
       }
       return lista;
   } 


}
