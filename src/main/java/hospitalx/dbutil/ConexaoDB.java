/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalx.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoDB {

    private String URL = "jdbc:mysql://127.0.0.1:3306/hospitalx?useSSL=false&serverTimezone=UTC";
    private String DRIVERMYSQL8 = "com.mysql.cj.jdbc.Driver";
    private String DRIVERMYSQL5 = "com.mysql.jdbc.Driver";
    private String USER = "root";
    private String PASSWORD = "Eng90x?";
    private Connection conn;

    public Connection ligarBB() {

        try {
            Class.forName(DRIVERMYSQL8);
            return conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro de conexao com a base de dados" + ex.getLocalizedMessage());
            return null;
        }

    }

    
    
     public static void fecharConexao(Connection c) {
        fecharConexoes(c, null, null);

    }
    public static void fecharConexao(Connection c, PreparedStatement ps) {
        fecharConexoes(c, ps, null);

    }
    
    

    public static void fecharConexao(Connection c, PreparedStatement ps, ResultSet rs) {
        fecharConexoes(c, ps, rs);

    }

    private static void fecharConexoes(Connection conn, PreparedStatement ps, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao desalocar recurso: " + ex.getLocalizedMessage());
        }

    }

}
