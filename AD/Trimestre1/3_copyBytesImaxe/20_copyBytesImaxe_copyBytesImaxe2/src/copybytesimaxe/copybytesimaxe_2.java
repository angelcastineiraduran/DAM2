/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package copybytesimaxe;

import java.io.*;

/**
 *
 * @author dam2
 */
public class copybytesimaxe_2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String rutaFoto = "/home/dam2/DAM2/AD/20 copybytesimaxe_copybytesimaxe2/foto.jpg";
        String rutaFoto_copia = "/home/dam2/DAM2/AD/20 copybytesimaxe_copybytesimaxe2/foto2_copia.jpg";
       
        BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(rutaFoto));
        BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(rutaFoto_copia));
        
        int c = 0;
        while((c = entrada.read()) != -1){
            salida.write(c);
        }
        
        entrada.close();
        salida.close();
        
        System.out.println("PROCESO FINALIZADO");

        
    }
    
}
