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

/**
 *
 * @author dam2
 */
public class Consultas {

    //obj
    Conexiones conexiones = new Conexiones();

    String nombreColumnas; // si son varios separar por comas
    String nombreValores; // "" y entrecomillados con la simple "\'"
    

    public ArrayList buscarCampoPorCodigo(String campoDevuelto, String tipoCodigoBuscado, String valorDelCodigo, String nombreTabla) throws SQLException {
        ArrayList<String> valoresDevueltos = new ArrayList();
        
        String consultaSQL = "SELECT * FROM " + nombreTabla + " WHERE " + tipoCodigoBuscado + "='" + valorDelCodigo + "';";
        System.out.println(consultaSQL);
        Connection conn = conexiones.conexion();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(consultaSQL);
        while (rs.next()) {
            String valorDevuelto = rs.getString(campoDevuelto);
            System.out.println(campoDevuelto + ": " + valorDevuelto);
            valoresDevueltos.add(valorDevuelto);
        }
        return valoresDevueltos;

    }
    
    public Double buscarGraxaPor_codp(String codc){
        ArrayList<String> graxas = new ArrayList();
        String consultaSQL = "SELECT * FROM componentes WHERE codc='" + codc + "'";
        System.out.println(consultaSQL);

    }

}
