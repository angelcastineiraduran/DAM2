/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfungos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ubuntu
 */
public class Delimitado {
    String rutaDirectorioActual = System.getProperty("user.dir");
    String rutaDelimitado = rutaDirectorioActual + "/../enun/final.txt";
    
    public ArrayList<String[]> getFfinal() throws FileNotFoundException, IOException {
        ArrayList<String[]> ffinal = new ArrayList<>();
        BufferedReader lec = new BufferedReader(new FileReader(rutaDelimitado));
        String lectura = null;
        while((lectura = lec.readLine()) != null) {
            String[] elementoClaveSuma = lectura.split("_");
            ffinal.add(elementoClaveSuma);
        }
        lec.close();
        return ffinal;
    }
    
    public void setFfinal(int coda, String noma, String nomf, double superficiedanada, double porcentaxedanos) throws IOException {
        BufferedWriter esc = new BufferedWriter(new FileWriter(rutaDelimitado, true));
        esc.write("coda=" + coda + ", ");
        esc.write("noma=" + noma + ", ");
        esc.write("nomf=" + nomf + ", ");
        esc.write("superficieafectada=" + superficiedanada + ", ");
        esc.write("porcentaxedanos=" + porcentaxedanos);
        esc.newLine(); // Agrega un salto de línea para separar los datos
        System.out.println("");
        System.out.println("Se ha escrito correctamente en final.txt");
        esc.close();
    }
}
