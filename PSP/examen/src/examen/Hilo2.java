/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

/**
 * 
 * Cuenta y muestra el numero de letras de una array de caracteres
 *
 * @author dam2
 */
public class Hilo2 extends Thread {

    private static int contadorLetras = 0;
    char[] letras;
    
    public Hilo2(char[] letras) {
        this.letras = letras;
    }
    
    public void run() {
        setContadorLetras(letras);
        System.out.println("Numero de letras: " + contadorLetras);
    }
    
    // itera el array y cada vez que hay un elemento incrementa la variable contador
    public void setContadorLetras(char[] letras) {
        for(int i = 0; i < letras.length; i++) {
            contadorLetras += 1;
        }
    }
    
    public int getContadorLetras() {
        return contadorLetras;
    }
}
