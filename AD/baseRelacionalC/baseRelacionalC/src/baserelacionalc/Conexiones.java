/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baserelacionalc;

import java.sql.*;

/**
 *
 * @author dam2
 */
public class Conexiones {

    String SENTENZA_INSERIR = "insert into produtos (codigo,descricion,prezo,datac) values (?,?,?,?);";
    String SENTENZA_LISTAR = "SELECT * FROM produtos";
    String SENTENZA_ACTUALIZAR = "UPDATE produtos SET descricion=? WHERE codigo=?;";
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

    public void listar() throws SQLException {
        Connection conn = conexion();
        PreparedStatement ps = conn.prepareStatement(SENTENZA_LISTAR);

        //ps.setString(1, "tenda"); //NO LO PUEDO HACER CON NOMBRE TABLAS Y/O COLUMNAS
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            // Obtener los valores de cada columna en el registro
            String codigo = rs.getString("codigo");
            String descricion = rs.getString("descricion");
            Double prezo = rs.getDouble("prezo");
            String datac = rs.getString("datac");

            // Imprimir o procesar los valores como desees
            System.out.println("Código: " + codigo);
            System.out.println("Descripción: " + descricion);
            System.out.println("Precio: " + prezo);
            System.out.println("Fecha: " + datac);
            System.out.println();
        }
        
        conn.close();
        ps.close();
        rs.close();
    }
    
    public void inserir() throws SQLException {
        Connection conn = conexion();
        System.out.println(SENTENZA_INSERIR);
        PreparedStatement ps = conn.prepareStatement(SENTENZA_INSERIR);
        ps.setString(1, "111");
        ps.setString(2, "duwidi");
        ps.setDouble(3, 3.8);
        Date data = new Date(2022, 2, 3);
        ps.setDate(4, data);
        int filasInseridas = ps.executeUpdate();
        System.out.println("Filas inseridas: " + filasInseridas);
        
    }
    
    public void actualizar() throws SQLException{
        Connection conn = conexion();
        System.out.println(SENTENZA_ACTUALIZAR);
        PreparedStatement ps = conn.prepareStatement(SENTENZA_ACTUALIZAR);
        ps.setString(1, "descrion_new");
        ps.setString(2, "111");
        int filasInseridas = ps.executeUpdate();
        System.out.println("filasInseridas = " + filasInseridas);
    }
    
    
}
