/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosClase.ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        Thread r = new Thread();
        Hilos h = new Hilos(r);
        h.start();
    }
}

class Hilos extends Thread {
    
    Thread hilo;
    final static int MAX_NUMERO_HILOS = 5;
    static int numero_hilos = 0;

    public Hilos(Thread hilo) {
        this.hilo = hilo;
    }

    public void run() {

        if (numero_hilos < MAX_NUMERO_HILOS) {
            System.out.println(getName());

            for (int j = 0; j < 10; j++) {
                System.out.println("itercion: " + j);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Thread.sleep((long) (3000 * Math.random()));
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.hilo = new Hilos(hilo);
            this.hilo.start();

            numero_hilos++;
        }
    }

}
