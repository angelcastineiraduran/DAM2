/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfungos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

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
    
    public void updateNumeroFungos (int coda) throws SQLException {
        int numerofungos = selectNumeroFungo(coda);
        numerofungos += 1;
        
        Connection conn = conexion();
        String sql = "UPDATE areas SET numerofungos=? WHERE coda=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, numerofungos);
        ps.setInt(2, coda);
        String sql2 = "UPDATE areas SET numerofungos=" + numerofungos + " WHERE coda=" + coda;
        System.out.println("sql = " + sql2);
        int filasAfectadas = ps.executeUpdate();
        if(filasAfectadas > 0) {
            System.out.println("Filas (numFungos) mod: " + filasAfectadas);
        } else {
            System.out.println("No se ha modificado ninguna fila");
        }
        ps.close();
        conn.close();
    }
    
    public int selectNumeroFungo (int coda) throws SQLException {
        Connection conn = conexion();
        int numeroFungos = -1;
        String sql = "SELECT * FROM areas WHERE coda=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, coda);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            numeroFungos = rs.getInt("numerofungos");
        }
        rs.close();
        ps.close();
        conn.close();
        return numeroFungos;
    }
    
        
    
    public int selectHumMedia (int coda) throws SQLException {
        Connection conn = conexion();
        int hummedia = -1;
        String sql = "SELECT * FROM areas WHERE coda=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, coda);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            hummedia = rs.getInt("hummedia");
        }
        rs.close();
        ps.close();
        conn.close();
        return hummedia;
    }
    
    public int selectHumLimite (int id) throws SQLException {
        Connection conn = conexion();
        int humlimite = -1;
        String sql = "SELECT * FROM fungos WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            humlimite = rs.getInt("humlimite");
        }
        rs.close();
        ps.close();
        conn.close();
        return humlimite;
    }
    
    public String selectNoma (int coda) throws SQLException {
        Connection conn = conexion();
        String noma = null;
        String sql = "SELECT * FROM areas WHERE coda=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, coda);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            noma = rs.getString("noma");
        }
        rs.close();
        ps.close();
        conn.close();
        return noma;
    }
    
    public String selectNomef (int id) throws SQLException {
        Connection conn = conexion();
        String nomf = null;
        String sql = "SELECT * FROM fungos WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            nomf = rs.getString("nomf");
        }
        rs.close();
        ps.close();
        conn.close();
        return nomf;
    }
    
    public int selectId (int codfungo) throws SQLException {
        Connection conn = conexion();
        int id = -1;
        String sql = "SELECT * FROM fungos WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codfungo);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            id = rs.getInt("id");
        }
        rs.close();
        ps.close();
        conn.close();
        return id;
    }
    
    public float selectSuperficie (int coda) throws SQLException {
        Connection conn = conexion();
        float superficie = -1;
        String sql = "SELECT * FROM areas WHERE coda=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, coda);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            superficie = rs.getFloat("superficie");
        }
        rs.close();
        ps.close();
        conn.close();
        return superficie;
    }
    
    
}
