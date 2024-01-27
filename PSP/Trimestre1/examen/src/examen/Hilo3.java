/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

/**
 *
 * Cuenta y muestra el numero de palabras de una array de String
 *
 * @author dam2
 */
public class Hilo3 extends Thread {

    private static String[] palabras;
    private int contadorPalabras = 0;

    public Hilo3(String[] palabras) {
        
        this.palabras = palabras;
        
    }

    public void run() {

        setContadorPalabras(palabras);
        System.out.println("Numero de palabras: " + contadorPalabras);

    }

    public void setContadorPalabras(String[] palabras) {
        for (int i = 0; i < palabras.length; i++) {
            contadorPalabras += 1;
        }
    }
    
    public int getContadorPalabras() {
        return contadorPalabras;
    }
}
