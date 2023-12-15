/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evinop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author dam2
 */
public class Consultas {

    public Connection conexion() throws SQLException {
        System.out.println("estableciendo conexion...");
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres"; // database-name
        String usuario = "dam2";
        String password = "dam2";
        String url = driver + host + porto + "/" + sid;
        Connection conn = DriverManager.getConnection(url, usuario, password);
        return conn;
    }

    public String selectNomeu(String tipo) throws SQLException {
        Connection conn = conexion();
        String nomeu = null;
        String sql = "SELECT * FROM uvas WHERE tipo=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tipo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            nomeu = rs.getString("nomeu");
        }
        rs.close();
        ps.close();
        conn.close();
        return nomeu;
    }

    public int selectAcidezMin(String tipo) throws SQLException {
        Connection conn = conexion();
        int acidezmin = -1;
        String sql = "SELECT * FROM uvas WHERE tipo=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tipo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            acidezmin = rs.getInt("acidezmin");
        }
        rs.close();
        ps.close();
        conn.close();
        return acidezmin;
    }

    public int selectAcidezMax(String tipo) throws SQLException {
        Connection conn = conexion();
        int acidezmax = -1;
        String sql = "SELECT * FROM uvas WHERE tipo=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tipo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            acidezmax = rs.getInt("acidezmax");
        }
        rs.close();
        ps.close();
        conn.close();
        return acidezmax;
    }

    public int selectNumeroDeAnalisis(String dni) throws SQLException {
        Connection conn = conexion();
        int numerodeanalisis = -1;
        String sql = "SELECT * FROM clientes WHERE dni=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            numerodeanalisis = rs.getInt("numerodeanalisis");
        }
        rs.close();
        ps.close();
        conn.close();
        return numerodeanalisis;
    }
    
    public void updateNumeroDeAnalisis(String dni) throws SQLException {
        int numerodeanalisis = selectNumeroDeAnalisis(dni);
        numerodeanalisis += 1;

        Connection conn = conexion();
        String sql = "UPDATE clientes SET numerodeanalisis=? WHERE dni=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, numerodeanalisis);
        ps.setString(2, dni);
        String sql2 = "UPDATE clientes SET numerodeanalisis=" + numerodeanalisis + " WHERE dni=" + dni;
        System.out.println("sql = " + sql2);
        int filasAfectadas = ps.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("Filas (numerodeanalisis) mod: " + filasAfectadas);
        } else {
            System.out.println("No se ha modificado ninguna fila");
        }
        ps.close();
        conn.close();
    }

}
