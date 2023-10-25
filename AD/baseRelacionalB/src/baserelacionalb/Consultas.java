/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baserelacionalb;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dam2
 */
public class Consultas {
    String consultaSQL;
    //obj
    Conexion conexion = new Conexion();
    ResultSet resultSet;
    String nombreTabla = "produtos";
    String nombreColumnas; // si son varios separar por comas
    String nombreValores; // "" y entrecomillados con la simple "\'"
    public void inserir(String codigo, String descricion, double prezo, String datac) throws SQLException{
        System.out.println("intentado inserir...");
        nombreColumnas = "codigo, descricion, prezo, datac";
        nombreValores = "'" + codigo + "'" + ", " + "'" + descricion + "'" + ", " + prezo + ", " + "'" + datac + "'";
        consultaSQL = "INSERT INTO " + nombreTabla + " (" + nombreColumnas + ") " + " VALUES " + " (" + nombreValores + ");";
        System.out.println("consulta solicitada: " + consultaSQL);
        this.resultSet = conexion.crearStatement(consultaSQL);
        
        // Movemos el cursor a la fila de inserción (la fila del nuevo registro)
        this.resultSet.moveToInsertRow();
        
        // Establecemos valores en la fila de inserción
        this.resultSet.updateString("codigo", codigo);
        this.resultSet.updateString("descricion", descricion);
        this.resultSet.updateInt("prezo", (int)prezo);
        this.resultSet.updateString("descricion", datac);
        
        // Insertamos la fila en la base de datos
        this.conexion.cerrarConexion();
    }
}
