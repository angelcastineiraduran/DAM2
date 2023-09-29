/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
public class Copybytesimaxe_1 {
    FileInputStream entrada;
    FileOutputStream salida;
    // imagen pesa:  2,621,440 Byte
    byte[] almacenBytes = new byte [2609246];
    
    public boolean leer(String rutaCopiar){
        try{
            int contador = 0;
            byte byte_leido;
            entrada = new FileInputStream(rutaCopiar);
            while((byte_leido = (byte)entrada.read()) != -1){
                almacenBytes[contador] = byte_leido;
                contador++;
                } 
            System.out.println('\n' + "Ya no leemos mas");
            entrada.close();
            return true;
        }catch(IOException ex){
            ex.getMessage();
            return false;
        }
    }
    
    int contador = 0;
    int[] almacenBytes_v2 = new int[2609246];
    
    public boolean escribir(String rutaPegar){
        try{
            salida = new FileOutputStream(rutaPegar); // sobreescribimos
            for(int i = 0;i < almacenBytes_v2.length; i++){
                salida.write(almacenBytes_v2[i]);
            }
            salida.close();
            System.out.println("Ya no escribimos mas");
            return true;
        }catch(IOException ex){
            ex.getMessage();
            return false;
        }
    }
     public void leer_v2 (String ruta) {
        try{
            FileInputStream entrada = new FileInputStream(ruta);
            int bytesImagen = 0;
            while (bytesImagen != -1){
                bytesImagen = entrada.read();
                if (bytesImagen != -1){
                    System.out.println(bytesImagen);
                    almacenBytes_v2[contador] = bytesImagen;
                    this.contador++;
                }
            }
            System.out.println(contador);
            entrada.close();
        } catch (FileNotFoundException ex){
            ex.getMessage();
            System.out.println("no encontrado");
        } catch (IOException ex){
            ex.getMessage();
            System.out.println("no leido");
        }
    }
    
    public void escribir_v2(String rutaCopia) {
        try {
            FileOutputStream salida_v2 = new FileOutputStream(rutaCopia); // crea archivo
            for(int i = 0;i < almacenBytes_v2.length; i++){
                salida.write(almacenBytes_v2[i]);
            }
            salida.close();
        } catch(IOException ex) {
            ex.getMessage();
            System.out.println("error salida");
        }
    }
    
    
}
