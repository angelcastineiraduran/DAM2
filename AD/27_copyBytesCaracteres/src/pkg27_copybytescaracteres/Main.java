/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg27_copybytescaracteres;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author dam2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String ruta = "/home/dam2/DAM2/AD/27_copyBytesCaracteres/texto1.txt";
        String ruta_copia = "/home/dam2/DAM2/AD/27_copyBytesCaracteres/texto2.txt";
        FileReader fileReader = new FileReader(new File(ruta));
        FileWriter fileWriter = new FileWriter(new File(ruta_copia));
        
        int c = 0;
        while ((c = fileReader.read()) != -1) {
            char caracter = (char) c;
            System.out.print(String.valueOf(caracter));
            fileWriter.write(String.valueOf(caracter));
        }
        
        fileReader.close();
        fileWriter.close();
    }
    
}
