/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primitivewritechars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author dam2
 */
public class Primitivewritechars {
    static int tamanioAcumulado;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String rutaOrigen = "/home/dam2/DAM2/AD/20 primitive writechars/texto.txt";
        //String rutaFinal = "/home/dam2/DAM2/AD/20 primitive writechars/texto_copia.txt";
        
        String textoACopiar = "o tempo está xélido";

        BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(rutaOrigen));
        BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(rutaOrigen, true));

        DataInputStream entradaData = new DataInputStream(entrada);
        DataOutputStream salidaData = new DataOutputStream(salida);
        
        // ESCRIBIMOS
        salidaData.writeChars(textoACopiar); // siempre escrime 2 bytes
        //int tamanio = salidaData.size();
        // cerramos salida
        salida.close();
        salidaData.close();
        
        // LEEMOS
        for(int i = 0; i < textoACopiar.length(); i++) {
            System.out.print(entradaData.readChar()); // le un caracter por cada vez
            //tamanioAcumulado += tamanio;
            //System.out.println("tamanio: " + tamanioAcumulado);
        }
        // cerramos entrada
        entrada.close();
        entradaData.close();

    }

}
