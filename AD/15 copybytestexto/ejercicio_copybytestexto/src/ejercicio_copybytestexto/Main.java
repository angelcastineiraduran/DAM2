/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_copybytestexto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author postgres
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String MSG_CORRECTO = "**Proceso exitoso**";
        String MSG_INCORRECTO = "**Proceso erroneo**";
        LecturaEscritura lecturaEscritura = new LecturaEscritura();
        boolean puedeLeer = lecturaEscritura.leer();
        boolean puedeEscribir = lecturaEscritura.escribir();
        
        System.out.println("--LECTURA--");
        if(puedeLeer){
            System.out.println(MSG_CORRECTO);
        } else {
            System.out.println(MSG_INCORRECTO);
        }
        System.out.println("--ESCRITURA--");
        if(puedeEscribir){
            System.out.println(MSG_CORRECTO);
        } else {
            System.out.println(MSG_INCORRECTO);
        }

    } 
    
    
}
