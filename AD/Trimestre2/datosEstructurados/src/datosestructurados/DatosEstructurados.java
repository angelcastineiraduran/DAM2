/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datosestructurados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author postgres
 */
public class DatosEstructurados {

    public static void main(String[] args) throws SQLException {
        
        System.out.println("estableciendo conexion...");
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres"; // database-name
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host + porto + "/" + sid;
        Connection conn = DriverManager.getConnection(url, usuario, password);
        
//        String selectAll = "SELECT codigo,descricion,prezo,(ci).cidade,(ci).cp FROM produtos;";
//        PreparedStatement ps = conn.prepareStatement(selectAll);
//        ResultSet rs = ps.executeQuery();
//        
//        String codigo;
//        String descricion;
//        double prezo;
//        // hay que tratarlos como campos individuales
//        String cidade;
//        int cp;
//        
//        while(rs.next()) {
//            codigo = rs.getString("codigo");
//            System.out.println("codigo = " + codigo);
//            descricion = rs.getString("descricion");
//            System.out.println("descricion = " + descricion);
//            prezo = rs.getDouble("prezo");
//            System.out.println("prezo = " + prezo);
//            cidade = rs.getString("cidade");
//            System.out.println("cidade = " + cidade);
//            cp = rs.getInt("cp");
//            System.out.println("cp = " + cp);
//            System.out.println("\n");
//        }
        
        
        String updateCp = "UPDATE produtos SET ci.cp=? WHERE (ci).cidade=?";
        PreparedStatement ps = conn.prepareStatement(updateCp);
        ps.setInt(1, 36);
        ps.setString(2, "vigo");
        int filasAfectadas = ps.executeUpdate();
        System.out.println("Filas modificadas: " + filasAfectadas);
        
//        rs.close();
        ps.close();
        conn.close();
        
        
        
        
        
    }
        
    
}
