/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baserelacionalb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dam2
 */
public class Conexion {
    String nombreTabla = "produtos";
    String nombreColumnas; // si son varios separar por comas
    String nombreValores; // "" y entrecomillados con la simple "\'"
    ResultSet resultSet = null;
    Statement statement = null;

    public Connection conexion() throws SQLException {
        System.out.println("estableciendo conexion...");
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres";
        String usuario = "dam2";
        String password = "dam2";
        String url = driver + host + porto + "/" + sid;
        Connection conn = DriverManager.getConnection(url, usuario, password);
        return conn;
    }
    
    public ResultSet crearStatement(String consultaSQL){
        System.out.println("estableciendo statement...");
        try (Connection conn = conexion()){
            this.statement= conn.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.resultSet = statement.executeQuery(consultaSQL);
            return this.resultSet;
        } catch(SQLException e){
            e.printStackTrace();
            return this.resultSet;
        }
        
    }
    
    public void cerrarConexion() throws SQLException{
        System.out.println("cerrando conexion...");
        this.statement.close();
        this.resultSet.close();
    }
    
    
    
    
    
    
    
    
    
}
