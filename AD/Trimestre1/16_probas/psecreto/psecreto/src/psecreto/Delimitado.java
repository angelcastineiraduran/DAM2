/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psecreto;

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
    String rutaFicheroLeer = directorioActual + "/../enun/clavesuma";
    
    public ArrayList<String[]> getElementosCS() throws FileNotFoundException, IOException {
        ArrayList<String[]> elementosCS = new ArrayList<>();
        BufferedReader lec = new BufferedReader(new FileReader(rutaFicheroLeer));
        String lectura = null;
        while((lectura = lec.readLine()) != null) {
            String[] elementoClaveSuma = lectura.split("_");
            elementosCS.add(elementoClaveSuma);
        }
        return elementosCS;
    }
    
    
    
    
}
