/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

/**
 * 
 * Este hilo encuentra la tercera palabra
 *
 * @author dam2
 */
public class Hilo1 extends Thread {
    
    private static String palabraEncontrada = null;
    private String[] palabras;
    
    public Hilo1(String[] palabras) {
        this.palabras= palabras;
    }

    public void run() {
        
        // le digo que me encuentre la palabra que esta en la posicion 3
        
        setPalabraEncontrada(palabras, 3);
        if(palabraEncontrada != null) {
            System.out.println("Palabra tercera posicion = " + palabraEncontrada);
        } else {
            // si es nula
            System.out.println("***Lo siento, la palabra no ha sido encontrada***");
        }

    }
    
    public void setPalabraEncontrada(String[] palabras, int posicionPalabra) {
        
        // ya que para el usuario la palabra en la 2 poscion, su indice es el 1 
        posicionPalabra -= 1;
        
        for(int i = 0; i < palabras.length; i++) {
            if(i == posicionPalabra) {
                // si encuentro la palabra, la seto en la var de obj
                palabraEncontrada = palabras[i];
            } 
            
            // si no encuentro la palabra, seguira teniendo el valor inicial = null
        }
        
    }

    public String getPalabraEncontrada() {
        return palabraEncontrada;
    }
    
    

}
