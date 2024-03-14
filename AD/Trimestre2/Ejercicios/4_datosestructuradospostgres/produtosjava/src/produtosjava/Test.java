/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtosjava;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class Test {

    static Connection conn;
    static Statement st;
    static ResultSet rs;
    static String codigo, descricion, cidade, ci;
    static Double prezo;
    static int cp;

    public static void main(String[] args) throws SQLException {
        getConnection();
        
        getProdutos();
        
        System.out.println("");
        
        getProdutos("vigo");
        
        System.out.println("");
        
        //insertProdutos("p3", "tornillos", 2.4, "valladolid", 36213);
        getProdutos("valladolid");
        
        System.out.println("");
        
        incrementCpProdutos("valladolid");
        getProdutos("valladolid");
        
        close();
    }

    public static void getConnection() throws SQLException {
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tambien puede ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host + porto + "/" + sid;
        conn = DriverManager.getConnection(url, usuario, password);
        if (conn != null) {
            System.out.println("Conexion exitosa!");
        } else {
            System.out.println("**ERROR abriendo conexion**");
        }
    }

    public static void close() {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("**ERROR cerrando conexion**");
            ex.printStackTrace();
        }
    }

    public static void getProdutos() throws SQLException {
        st = conn.createStatement();
        String query = "SELECT * FROM produtos";
        rs = st.executeQuery(query);
        while (rs.next()) {
            ci = rs.getString("ci");
            System.out.println("ci = " + ci);
        }
    }

    public static void getProdutos(String nomeCidade) throws SQLException {
        st = conn.createStatement();
        // LOS SIGUIENTES DAN ERROR:
        //String query = "SELECT * FROM produtos WHERE (ci).cidade='" + nomeCidade + "'";
        //String query = "SELECT (ci).cidade, (ci).cp FROM produtos WHERE (ci).cidade='" + nomeCidade + "'";
        //String query = "SELECT * FROM produtos";
        //String prato = "select codigo,descricion,prezo,(ci).cidade,(ci).cp from produtos where (ci).cidade='vigo'";
        // sin incluir tambien el ci, no puedes acceder a los otros datos
        String query = "SELECT codigo, descricion, prezo, ci, (ci).cidade AS cidade, (ci).cp AS cp FROM produtos WHERE (ci).cidade = '" + nomeCidade + "'";
        rs = st.executeQuery(query);
        while (rs.next()) {
            ci = rs.getString("ci");
            System.out.println("ci = " + ci);
            cidade = rs.getString("cidade"); // (ci).cidade
            System.out.println("cidade = " + cidade);
            cp = rs.getInt("cp"); // (ci).cp
            System.out.println("cp = " + cp);   
        }
    }
    
    public static void insertProdutos(String codigo, String descricion, Double prezo, String cidade, Integer cp) throws SQLException {
        st = conn.createStatement();
        String query = "INSERT INTO produtos (codigo, descricion, prezo, ci) VALUES ('" + codigo + "', '" + descricion + "', " + prezo + ", ('" + cidade + "', " + cp + "))";
        
        // DE ESTA FORMA DA ERROR (hay que hacerlo manualmente):
//        String query = "INSERT INTO produtos (codigo, descricion, prezo, ci) VALUES (?, ?, ?, ?)";
//        PreparedStatement ps = conn.prepareStatement(query);
//        ps.setString(1, codigo);
//        ps.setString(2, descricion);
//        ps.setDouble(3, prezo);
//        String ci = "('" + cidade + "', " + cp + ")";
//        ps.setString(4, ci);
        PreparedStatement ps = conn.prepareStatement(query);
        
        int rowsAffected = ps.executeUpdate();
        if(rowsAffected > 0) {
            System.out.println("Producto insertado exitosamente");
        } else {
            System.out.println("**ERROR: No se pudo insertar el produto**");
        }
        
    }
    
    public static void incrementCpProdutos(String cidade) throws SQLException {
        st = conn.createStatement();
        //String query = "UPDATE produtos SET (ci).cp=(ci).cp+1 WHERE (ci).cidade='"+cidade+"'"; // ERROR!
        String query = "UPDATE produtos SET ci.cp=(ci).cp+1 WHERE (ci).cidade='"+cidade+"'";
        PreparedStatement ps = conn.prepareStatement(query);
        int rowsAffected = ps.executeUpdate();
        if(rowsAffected > 0) {
            System.out.println("cp incrementado exitosamente");
        } else {
            System.out.println("**ERROR: No se pudo incrementa el cp en el produto**");
        }
    }
}
