/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exa15brevep;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dam2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        DatosSerializados ds = new DatosSerializados();
        String codp_1 = ds.leerPorCodigo("p1");
        
        Consultas consultas = new Consultas();
        ArrayList<String> pesos = consultas.buscarCampoPorCodigo("peso","codp", codp_1, "composicion");
        ArrayList<String> codcs = consultas.buscarCampoPorCodigo("codc", "codp", codp_1, "composicion");
        
    }
    
}
