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

    String nombreTabla = "produtos";
    String nombreColumnas; // si son varios separar por comas
    String nombreValores; // "" y entrecomillados con la simple "\'"

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
    
    public boolean insireProduto(String codigo, String descricion, Double prezo, String datac) {
        nombreColumnas = "codigo, descricion, prezo, datac";
        nombreValores = "'" + codigo + "'" + ", " + "'" + descricion + "'" + ", " + prezo + ", " + "'" + datac + "'";
        String query = "INSERT INTO " + nombreTabla + " (" + nombreColumnas + ") " + " VALUES " + " (" + nombreValores + ");";
        System.out.println(query);
        try (Connection conn = conexion()) {
            Statement statement = conn.createStatement();
            int filasAfectadas = statement.executeUpdate(query);
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean listaProdutos() throws SQLException {
        try (Connection conn = conexion()) {
            Statement statement = conn.createStatement();

            // Consulta SQL para seleccionar todos los registros de la tabla
            String consultaSQL = "SELECT * FROM " + nombreTabla;

            ResultSet resultSet = statement.executeQuery(consultaSQL);

            while (resultSet.next()) {
                // Obtener los valores de cada columna en el registro
                String codigo = resultSet.getString("codigo");
                String descricion = resultSet.getString("descricion");
                Double prezo = resultSet.getDouble("prezo");
                String datac = resultSet.getString("datac");

                // Imprimir o procesar los valores como desees
                System.out.println("Código: " + codigo);
                System.out.println("Descripción: " + descricion);
                System.out.println("Precio: " + prezo);
                System.out.println("Fecha: " + datac);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean listaPorCodigo(String codigoBuscado) throws SQLException {
        String query = "SELECT * FROM " + nombreTabla + " WHERE codigo = " + "'" + codigoBuscado + "'";
        System.out.println(query);
        try (Connection conn = conexion()) {
            Statement statement = conn.createStatement();
            String consultaSQL = "SELECT * FROM " + nombreTabla + " WHERE codigo = " + "'" + codigoBuscado + "'";
            ResultSet resultSet = statement.executeQuery(consultaSQL);
            while (resultSet.next()) {
                // Obtener los valores de cada columna en el registro
                String codigo = resultSet.getString("codigo");
                String descricion = resultSet.getString("descricion");
                Double prezo = resultSet.getDouble("prezo");
                String datac = resultSet.getString("datac");

                // Imprimir o procesar los valores como desees
                System.out.println("Código: " + codigo);
                System.out.println("Descripción: " + descricion);
                System.out.println("Precio: " + prezo);
                System.out.println("Fecha: " + datac);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean actualizaPre(String codigoBuscado, Double prezoNovo) throws SQLException {
        String query = "UPDATE " + nombreTabla + " SET prezo = " + prezoNovo + " WHERE codigo = " + "'" + codigoBuscado + "';" ;
        System.out.println(query);
        try (Connection conn = conexion()) {
            Statement statement = conn.createStatement();
            String consultaSQL = "UPDATE " + nombreTabla + " SET prezo = " + prezoNovo + " WHERE codigo = " + "'" + codigoBuscado + "';" ;
            int filasAfectadas = statement.executeUpdate(consultaSQL);
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminaProduto(String codigoBuscado) throws SQLException {
        String query = "DELETE FROM " + nombreTabla + " WHERE codigo = " + "'" + codigoBuscado + "'";
        System.out.println(query);
        try (Connection conn = conexion()) {
            Statement statement = conn.createStatement();
            String consultaSQL = "DELETE FROM " + nombreTabla + " WHERE codigo = " + "'" + codigoBuscado + "'";
            int filasAfectadas = statement.executeUpdate(query);
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
