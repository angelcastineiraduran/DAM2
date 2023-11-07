/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baserelacionalb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dam2
 */
public class Consultas {
    
    //obj
    Conexiones conexiones = new Conexiones();
    String nombreTabla = "produtos";
    String nombreColumnas; // si son varios separar por comas
    String nombreValores; // "" y entrecomillados con la simple "\'"
    
    public void listaProdutos() throws SQLException {
            String consultaSQL = "SELECT * FROM " + nombreTabla;
            System.out.println(consultaSQL);
            Connection conn = conexiones.conexion();
            Statement st = conexiones.crearStatement(conn);
            ResultSet rs = st.executeQuery(consultaSQL);

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
            conexiones.cerrarConexion(st,rs,conn);
        
    }
    
    public void inserir(String codigo, String descricion, double prezo, String datac) throws SQLException{
        Conexiones conexion = new Conexiones();
        System.out.println("intentado inserir...");
        nombreColumnas = "codigo, descricion, prezo, datac";
        nombreValores = "'" + codigo + "'" + ", " + "'" + descricion + "'" + ", " + prezo + ", " + "'" + datac + "'";
        String consultaSQL = "INSERT INTO " + nombreTabla + " (" + nombreColumnas + ") " + " VALUES " + " (" + nombreValores + ");";
        System.out.println(consultaSQL);
        Connection conn = conexiones.conexion();
        Statement st = conexiones.crearStatement(conn);
        ResultSet rs = st.executeQuery(consultaSQL);
        
        // Movemos el cursor a la fila de inserción (la fila del nuevo registro)
        rs.moveToInsertRow();
        
        // Establecemos valores en la fila de inserción
        rs.updateString("codigo", codigo);
        rs.updateString("descricion", descricion);
        rs.updateInt("prezo", (int)prezo);
        rs.updateString("descricion", datac);
        
        // Insertamos la fila en la base de datos
        conexion.cerrarConexion(st,rs,conn);
    }
}
