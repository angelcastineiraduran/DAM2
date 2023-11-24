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

    private int prazas[] = {0, 0, 0, 0, 0, 0};
    private int prazasTotales = prazas.length;
    private int coches[] = {1, 2, 3, 4, 5, 6};
    private boolean solicitudEntrada = false;
    private boolean entrando = false;
    private int posicionDisponible = -1;
    private boolean prazaDisponible = false;
    int cocheBuscandoSitio;
    static final int ENTRAR = 1;
    static final int SALIR = -1;
    int tipoAccion = 0;

    public synchronized void timbrar(int coche) {
 
            System.out.println("Solicita entrar el coche " + coche);
            if (buscarPlazas()) {
                cocheBuscandoSitio = coche;
                prazaDisponible = true;
                tipoAccion = ENTRAR; // para saber en el run()
                notify();
            } else {
                posicionDisponible = coche;
            }
            
    }
    
    int cocheQuiereSalir;
    boolean existeCocheEnGaraje = false;
    int prazaQuedaraDisponible;
    int cocheSalida;
    
    public synchronized void timbrarSalida(int coche) {
        System.out.println("Solicita salir el coche " + coche);
        cocheSalida = coche;
        for(int i = 0; i < prazas.length; i++){
            if(coche == prazas[i]){
                System.out.println("Coche saliendo y dejando plaza vacia");
                existeCocheEnGaraje = true;
                tipoAccion = SALIR;
                prazaQuedaraDisponible = i; // devuevel plaza que hay que igualar a cero
                notify();
            }
        } 
        if(existeCocheEnGaraje == false) {
            System.out.println("Ese coche no esta en el garaje!");
        }          
    }

    public synchronized void run() {
        while (true) { // abierto a estar solicitar entrada
            while (!prazaDisponible && !existeCocheEnGaraje) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            if (tipoAccion == ENTRAR) {
                entrar();
            } else {
                salir();
            }
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

    public synchronized void entrar(){
        System.out.println("Entrando vehiculo...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
        }
        prazas[posicionDisponible] = cocheBuscandoSitio;
        imprimirPlazas();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
        }
        prazaDisponible = false;
    }
    
    public synchronized void salir(){
        System.out.println("Saliendo el coche " +  cocheSalida + " que deja libre la plaza " + prazaQuedaraDisponible);
        prazas[prazaQuedaraDisponible] = 0;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
        }
        imprimirPlazas();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
        }
        existeCocheEnGaraje = false;
    }

    public void imprimirPlazas() {
        for (int praza : prazas) {
            System.out.print("[" + praza + "],");
        }
        System.out.println("");
    }

}
