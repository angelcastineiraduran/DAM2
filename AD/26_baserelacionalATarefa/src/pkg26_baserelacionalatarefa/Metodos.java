/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg26_baserelacionalatarefa;

import java.sql.*;

/**
 *
 * @author postgres
 */

public class Metodos {
    
    
    
    String nombreTabla;
    String nombreColumnas; // si son varios separar por comas
    String nombreValores; // ""
    
    private final String INSERTAR_FILA_TABLA = "INSERT INTO " + nombreTabla + " (" + nombreColumnas + ") " + " VALUES " + " (" + nombreValores + ");" ;
        
    public Connection conexion() throws SQLException {
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host + porto + "/" + sid;
        Connection conn = DriverManager.getConnection(url, usuario, password);
        return conn;
    }
    
    public boolean nsireProduto(String codigo, String nome, Double prezo, String dataCaducidade){
        nombreTabla = "";
        nombreColumnas = "codigo, nome, prezo, dataCaducidade";
        nombreValores = codigo + ", " + nome + ", " +  String.valueOf(prezo) + ", " + dataCaducidade;
        return true;
    }
}
