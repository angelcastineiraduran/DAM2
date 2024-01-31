/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introduccion.metodos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Permite que un hilo espere a que se complete el otro.
 * 
 * En este caso, llamando al join() desde el h1 le estoy
 * diciendo al hilo principal (el de la main) que pause la ejecucion
 * hasta que el h1 acabe.
 *
 * @author ubuntu
 */
public class Joins {

    public static void main(String[] args) throws InterruptedException {
        Thread h1 = new Thread(new Ejeccucion("HILO 1"));
        Thread h2 = new Thread(new Ejeccucion("HILO 2"));

        h1.start();
        h1.join();
        h2.start();
    }
}

class Ejeccucion implements Runnable {

    public String nombreHilo;

    public Ejeccucion(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Ejecucion del hilo " + nombreHilo);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejeccucion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
