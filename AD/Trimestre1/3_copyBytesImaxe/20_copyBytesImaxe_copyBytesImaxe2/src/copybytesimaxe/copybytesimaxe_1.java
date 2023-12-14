/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package copybytesimaxe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author dam2
 */
public class copybytesimaxe_1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String rutaFoto = "/home/dam2/DAM2/AD/20 copybytesimaxe_copybytesimaxe2/foto.jpg";
        String rutaFoto_copia = "/home/dam2/DAM2/AD/20 copybytesimaxe_copybytesimaxe2/foto_copia.jpg";
        
        FileInputStream entrada = new FileInputStream(rutaFoto);
        FileOutputStream salida = new FileOutputStream(rutaFoto_copia);
        
        int c = 0;
        while((c = entrada.read()) != -1){
            salida.write(c);
        }
        
        entrada.close();
        salida.close();
        
        System.out.println("PROCESO FINALIZADO");
        
        
        
        
    }
}
