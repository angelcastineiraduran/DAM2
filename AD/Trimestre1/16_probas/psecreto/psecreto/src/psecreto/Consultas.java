/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psecreto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class Consultas {
    
    public Connection conexion() throws SQLException {
        //System.out.println("estableciendo conexion...");
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres"; // database-name
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host + porto + "/" + sid;
        Connection conn = DriverManager.getConnection(url, usuario, password);
        return conn;
    }
    
    public String getLetraRef (int p, String columna) {
        try {
            String letra = null;
            Connection conn = conexion();
            String sql = "select * from referencia where p=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                letra = rs.getString(columna);
            }
            rs.close();
            ps.close();
            conn.close();
            return letra;
            
        } catch (SQLException ex) {
            System.out.println("**ERROR EN CONSULTAS**");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
    
    public int getIntClave2 (String letra, String columna) {
        try {
            int numero = -1;
            Connection conn = conexion();
            String sql = "select * from clave2 where cla2=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, letra);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                numero = rs.getInt(columna);
            }
            rs.close();
            ps.close();
            conn.close();
            return numero;
        }catch(SQLException ex) {
            System.out.println("**ERROR EN CONSULTAS**");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return -1;
    }
    
}
