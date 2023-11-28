/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionconcurrente.sincronizacionHilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En el caso de que nos interese que los hilos se sincronicen entre ellos para
 * que nosotros no le tengamos que dar un orden de ejecucion.
 *
 * Ej. nos conviene liberar el hilo principal de los otros procesos que si que
 * quiero que se sincronicen.
 *
 * @author ubuntu
 */
public class Sincronizacion2Automatica {

    public static void main(String[] args) throws InterruptedException {

        HilosVarios hilo1 = new HilosVarios();
        HilosVarios2 hilo2 = new HilosVarios2(hilo1);

        // ahora da igual en que orden lo pongamos, 
        // siempre se ejecuta primero el hilo1 y despues el hilo2.
        hilo2.start();
        hilo1.start();

        System.out.println("Terminadas las tareas");

    }

}

class HilosVarios2 extends Thread {

    private Thread hilo;

    // el constructor va a recibir por parametro
    // el nombre de un hilo el cual va a esperar.
    public HilosVarios2(Thread hilo) throws InterruptedException {
        this.hilo = hilo;
    }

    @Override
    public void run() {

        try {
            // le decimos que esta tarea no comience hasta que el hilo que le hemos
            // pasado por parametro al constructor finalice.
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < 3; i++) {

            System.out.println("Ejecutanto hilo: " + getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
