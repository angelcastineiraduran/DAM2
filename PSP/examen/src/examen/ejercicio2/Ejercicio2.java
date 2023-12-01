/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.ejercicio2;

/**
 *
 * @author dam2
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        int[] arreglo = new int[100];
        for(int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) Math.random();
        }
    }

}

class Hilos extends Thread {
    
    int[] arreglo;
    Integer valorMaximo;
    
    public Hilos(int[] arreglo) {
        this.arreglo = arreglo;
    }

    public void run() {
        for(int i = 0; i <= arreglo.length; i++) {
            
        }
    }
}
