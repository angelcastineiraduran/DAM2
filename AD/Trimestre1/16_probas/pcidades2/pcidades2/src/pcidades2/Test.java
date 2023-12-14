/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pcidades2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ubuntu
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        Basicos mbasic = new Basicos();
        
        Delimitado delimitado = new Delimitado();
        ArrayList<String[]> datosZonas = delimitado.leerZonas();
        mbasic.iterarArrayStringArreglo(datosZonas);
        
        Consultas consultas = new Consultas();
        ArrayList<String> pisos = consultas.pisosPorZona("z1");
        mbasic.iterarArrayString(pisos);
        
        int m2s = consultas.m2sPorPiso("p1");
        System.out.println("m2s = " + m2s);
        
        int ano = consultas.anosPorPiso("p1");
        System.out.println("ano = " + ano);
        
        
        
    }
    
}
