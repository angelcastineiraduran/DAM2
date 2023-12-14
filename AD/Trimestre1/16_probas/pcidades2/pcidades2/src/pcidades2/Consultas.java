/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcidades2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

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
    
    public ArrayList<String> pisosPorZona(String codz) throws SQLException {
        ArrayList<String> pisos = new ArrayList();
        Connection conn = conexion();
        String sql = "select * from propiedades where codz=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, codz);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            pisos.add(rs.getString("codp"));
        }
        return pisos;
    }
    
    public int m2sPorPiso(String codp) throws SQLException {
        int m2s = -1;
        Connection conn = conexion();
        String sql = "select * from pisos where codp=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, codp);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            m2s = (rs.getInt("m2"));
        }
        return m2s;
    }
    
    public int anosPorPiso(String codp) throws SQLException {
        int anos = -1;
        Connection conn = conexion();
        String sql = "select * from pisos where codp=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, codp);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            anos = rs.getInt("ano");
        }
        return anos;
    }

}
