/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parking;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Parking extends Thread {

    private int prazas[] = {1, 1, 0, 1, 1, 0};
    private int prazasTotales = prazas.length;
    private int coches[] = {1, 2, 3, 4, 5, 6};
    private boolean solicitudEntrada = false;
    private boolean entrando = false;
    private int posicionDisponible = -1;
    private boolean prazaDisponible = false;
    int cocheBuscandoSitio;

    public synchronized void timbrar(int coche) {
 
            System.out.println("Solicita entrar el coche " + coche);
            if (buscarPlazas()) {
                cocheBuscandoSitio = coche;
                prazaDisponible = true;
                notify();
            } else {
                posicionDisponible = coche;
            }
            
    }

    public synchronized void run() {
        while (true) { // abierto a estar solicitar entrada
            while (!prazaDisponible) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            entrar();
        }
    }

    public synchronized boolean buscarPlazas() {
        int i = 0; // posicion
            for (int praza : prazas) {
                if (praza == 0) {
                    System.out.println("Hay plazas disponibles");
                    System.out.println("Plaza disponible: " + i);
                    posicionDisponible = i;
                    return true;
                }
                i++;
            }
        return false;
    }

    public synchronized void entrar() {
        System.out.println("Entrando vehiculo...");
        prazas[posicionDisponible] = cocheBuscandoSitio;
        imprimirPlazas();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
        }
        prazaDisponible = false;
    }

    public void imprimirPlazas() {
        for (int praza : prazas) {
            System.out.print("[" + praza + "],");
        }
        System.out.println("");
    }

}
