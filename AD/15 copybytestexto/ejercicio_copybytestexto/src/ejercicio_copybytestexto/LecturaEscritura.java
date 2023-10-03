/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_copybytestexto;
import java.io.*;
/**
 *
 * @author postgres
 */
public class LecturaEscritura {
    FileInputStream entrada;
    FileOutputStream salida;
    
    String rutaCopiar = "/home/dam2/DAM2/AD/15 copybytestexto/texto1.txt";
    String rutaPegar = "/home/dam2/DAM2/AD/15 copybytestexto/texto1_copia.txt";
    
    byte almacenBytes[] = new byte[300000];
    
    public boolean leer(){
        try{
            int c = 0;
            int contador = 0;
            byte byte_leido;
            char letra_leida = 0;
            entrada = new FileInputStream(rutaCopiar);
            salida = new FileOutputStream(rutaPegar,true); // no sobreescribimos
           
            while(( c = entrada.read()) != -1){
                salida.write(c);
//                c = byte_leido;
//                if(c != -1)
//                    //System.out.print(letra); //imprime bytes
//                    almacenBytes[contador] = byte_leido;
//                    letra_leida = (char)byte_leido;
//                    System.out.print(letra_leida);
//                    contador++;
                    
            } 
            System.out.println('\n' + "Ya no leemos mas");
            entrada.close();
            salida.close();
            return true;
        }catch(IOException ex){
            ex.getMessage();
            return false;
        }
    }
    
    public boolean escribir(){
        try{
            //salida = new FileOutputStream(rutaPegar); // sobreescribimos
            salida = new FileOutputStream(rutaPegar,true); // no sobreescribimos
            salida.write(almacenBytes);
            salida.close();
            System.out.println("Ya no escribimos mas");
            return true;
        }catch(IOException ex){
            ex.getMessage();
            return false;
        }
    }
    
}
