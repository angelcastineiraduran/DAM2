/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evinop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author dam2
 */
public class Delimitado {
    String directorioActual = System.getProperty("user.dir");
    String rutaFicheroLeer = directorioActual + "/../enun/analisis.txt";
    
    public ArrayList<String[]> leerAnalisis () throws FileNotFoundException, IOException {
        ArrayList<String[]> analisisDatos = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(rutaFicheroLeer));
        String lectura = null;
        while((lectura = br.readLine()) != null) {
            String[] aux = lectura.split(",");
            analisisDatos.add(aux);
        }
        return analisisDatos;
    }
}
