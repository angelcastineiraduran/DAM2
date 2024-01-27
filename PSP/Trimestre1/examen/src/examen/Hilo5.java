/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

/**
 *
 * @author dam2
 */
public class Hilo5 extends Thread{
    int numeroCaracteres;
    int numeroPalabras;
    
    public Hilo5(int numeroCaracteres, int numeroPalabras) {
        this.numeroCaracteres = numeroCaracteres;
        this.numeroPalabras = numeroPalabras;
    }
    
    public void run() {
        System.out.println("El numero total de caracteres es " + numeroCaracteres
        + " y el numero de palabras es " +  numeroPalabras);
    }

}
