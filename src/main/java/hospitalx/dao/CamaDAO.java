/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.dao;

import hospitalx.dbutil.ConexaoDB;
import hospitalx.modelo.Cama;
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
public class CamaDAO {
    private String SELECT_ALL = "SELECT p.id_cama, p.numero_cama FROM cama p";
    private String INSERT = "INSERT INTO cama (`numero_cama`) VALUES(?)";
    private String EDITE= "UPDATE cama SET numero_cama = ? WHERE id_cama = ?";
    private String DELETE = "DELETE FROM cama WHERE id_cama = ?;";
    private String LIST_BY_NAME="SELECT p.id_cama, p.numero_cama FROM cama WHERE p.numero_cama LIKE ?";
    private String INSERTE = "INSERT INTO `cama` (`numero_cama`) VALUES (?);";
    ConexaoDB conexao = new ConexaoDB();
    
    public void update(Cama pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(EDITE);
            ps.setString(1, pac.getNumeroCama());
            ps.setInt(2, pac.getIdCama());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Actualizar o Registro: "+e.getLocalizedMessage());
        }
    }
    
    public void insert(Cama pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(INSERTE);
            ps.setString(1, pac.getNumeroCama());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Inserir os dados no Banco de Dados: "+e.getLocalizedMessage());
        }
    }
    
    public void delete(Cama pac){
        
        PreparedStatement ps;
        try {
            Connection con = conexao.ligarBB();
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, pac.getIdCama());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao Eliminar o Registro: "+e.getLocalizedMessage());
        }
    }
    
   public List<Cama> findAll(){
       List<Cama> lista = new ArrayList<>();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       try {
          con = conexao.ligarBB();
          ps = con.prepareStatement(SELECT_ALL);
          rs = ps.executeQuery();
           while (rs.next()) {               
               Cama pac = new Cama();
               pac.setIdCama(rs.getInt("p.id_cama"));
               pac.setNumeroCama(rs.getString("p.numero_cama"));           
               lista.add(pac);
           }
          
       } catch (SQLException e) {
           System.err.println("Erro ao Listar: "+e.getLocalizedMessage());
       }
       return lista;
   } 
    
   public List<Cama> findByName(String nome){
       List<Cama> lista = new ArrayList<>();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       try {
          con = conexao.ligarBB();
          ps = con.prepareStatement(LIST_BY_NAME);
          ps.setString(1,"%" + nome + "%");
          rs = ps.executeQuery();
           while (rs.next()) {               
               Cama pac = new Cama();
               pac.setIdCama(rs.getInt("p.id_cama"));
               pac.setNumeroCama(rs.getString("p.numero_cama"));               
               lista.add(pac);
  
           }
          
       } catch (SQLException e) {
           System.err.println("Erro ao Listar: "+e.getLocalizedMessage());
       }
       return lista;
   } 


}
