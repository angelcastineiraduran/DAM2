/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dam2
 */
public class Cadenas {
    
    private String frase;
    private String[] palabras;
    private char[] letras;
    
    
    
    // pregunta por consola la frase
    public void setFrase() {
        Scanner obxScanner = new Scanner (System.in);
        frase = obxScanner.nextLine();
    }

    public String getFrase() {
        return frase;
    }
    
    // crea un elemento por cada un espacio en blanco encontrado
    public void setPalabras(String frase) {
        palabras = frase.split(" ");
    }
    
    public String[] getPalabras() {
        return palabras;
    }
    
    // crea un elemento por cada caracter
    // como no quiero que me cree un elemento por un espacio blanco (ya que es 
    // un tipo de carater), me creo una nueva frase a partir de la array de palabras
    // ya que esta NO contiene espacios en blanco, solo letras.
    public void setLetras(String frase) {
        String fraseSinEspacios = "";
        for(int i = 0; i < palabras.length; i++) {
            fraseSinEspacios += palabras[i];
        }
        letras = fraseSinEspacios.toCharArray();
    }
    
    public char[] getLetras() {
        return letras;
    }
    
    
    
}
