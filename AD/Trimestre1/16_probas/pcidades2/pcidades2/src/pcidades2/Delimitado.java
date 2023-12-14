/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcidades2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ubuntu
 */
public class Delimitado {
    String directorioActual = System.getProperty("user.dir");
    String rutaFicheroLeer = directorioActual + "/../enun/zonas.txt";
    
    
    public ArrayList<String[]> leerZonas () throws FileNotFoundException, IOException {
        ArrayList<String[]> zonasDatos = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(rutaFicheroLeer));
        String lectura = null;
        while((lectura = br.readLine()) != null) {
            String[] aux = lectura.split("_");
            zonasDatos.add(aux);
        }
        return zonasDatos;
    }
    
}
