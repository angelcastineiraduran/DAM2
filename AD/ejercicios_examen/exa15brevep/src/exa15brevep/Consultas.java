/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exa15brevep;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author dam2
 */
public class Consultas {

    //obj
    Conexiones conexiones = new Conexiones();

    String nombreColumnas; // si son varios separar por comas
    String nombreValores; // "" y entrecomillados con la simple "\'"

    public ArrayList buscarRegistrosPorCodigo(String campoDevuelto, String campoIdeal, String valorIdeal, String nombreTabla) throws SQLException {
        ArrayList<String> valoresDevueltos = new ArrayList();
        // campoDevuelto no lo utilizo realmente, deberia eliminarse pero no lo hago pq tendria que corregirlo

        String consultaSQL = "SELECT * FROM " + nombreTabla + " WHERE " + campoIdeal + "='" + valorIdeal + "';";
        System.out.println(consultaSQL);
        Connection conn = conexiones.conexion();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(consultaSQL);
        while (rs.next()) {
            String valorDevuelto = rs.getString(campoDevuelto);
            //System.out.println(campoDevuelto + ": " + valorDevuelto);
            valoresDevueltos.add(valorDevuelto);
        }
        return valoresDevueltos;

    }

    public int buscarIntPorCodigo(String campoDevuelto, String campoIdeal, String valorIdeal, String nombreTabla) throws SQLException {
        String consultaSQL = "SELECT * FROM " + nombreTabla + " WHERE " + campoIdeal + "='" + valorIdeal + "';";
        int valorDevuelto = -1;
        System.out.println(consultaSQL);
        Connection conn = conexiones.conexion();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(consultaSQL);
        while (rs.next()) {
            valorDevuelto = rs.getInt(campoDevuelto);
        }
        return valorDevuelto;
    }
    
    public int buscarIntPorCodigoInt(String campoDevuelto, String campoIdeal, int valorIdeal, String nombreTabla) throws SQLException {
        String consultaSQL = "SELECT * FROM " + nombreTabla + " WHERE " + campoIdeal + "='" + valorIdeal + "';";
        int valorDevuelto = -1;
        System.out.println(consultaSQL);
        Connection conn = conexiones.conexion();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(consultaSQL);
        while (rs.next()) {
            valorDevuelto = rs.getInt(campoDevuelto);
        }
        return valorDevuelto;
    }


    public String buscarStringPorCodigo(String campoDevuelto, String campoIdeal, String valorIdeal, String nombreTabla) throws SQLException {
        String consultaSQL = "SELECT * FROM " + nombreTabla + " WHERE " + campoIdeal + "='" + valorIdeal + "';";
        String valorDevuelto = "";
        System.out.println(consultaSQL);
        Connection conn = conexiones.conexion();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(consultaSQL);
        while (rs.next()) {
            valorDevuelto = rs.getString(campoDevuelto);
        }
        return valorDevuelto;
    }

    // actualizar un campo
    public void actualizarIntPorCodigo(String db, String table,
            String columnaDelValorAReemplazar, int valorAReemplazarAnterior,
            String columnaCondicion, String valorCondicion) throws SQLException {

        // en este caso el valor a reemplazar es uno mas
        int valorAReemplazar = valorAReemplazarAnterior + 1;

        String consultaSQL = "update " + db + "." + table + " set "
                + columnaDelValorAReemplazar + "='" + valorAReemplazar + "' where " + columnaCondicion
                + "='" + valorCondicion + "'";
        System.out.println(consultaSQL);
        Connection conn = conexiones.conexion();
        PreparedStatement pst = conn.prepareStatement(consultaSQL);
        int filasActualizadas = pst.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Se actualizaron " + filasActualizadas + " filas");
        } else {
            System.out.println("No se actualizo ninguna fila");
        }
    }

}
