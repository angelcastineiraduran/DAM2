/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg27_copybytescaracteres2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author dam2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String ruta = "/home/dam2/DAM2/AD/27_copyBytesCaracteres2/texto1.txt";
        String ruta_copia = "/home/dam2/DAM2/AD/27_copyBytesCaracteres2/texto2.txt";
        
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(ruta)));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(ruta)));
        PrintWriter printWriter = new PrintWriter(new File(ruta_copia));
        
        String linea;
        while((linea = bufferedReader.readLine()) != null) {
           printWriter.println(linea);
        }
        
        bufferedReader.close();
        printWriter.close();
    }
    
}
