/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosinternet;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class EjerciciosInternet {

    public static void main(String[] args) {
        
        Hilos h1 = new Hilos();
        Hilos h2 = new Hilos();
        h1.start();
        h2.start();
    }

}

class Hilos extends Thread {

    public Hilos() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hilo: " + getName() + ", iteracion: " + i);
            try {
                Thread.sleep((long) (4000 * Math.random()));
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
