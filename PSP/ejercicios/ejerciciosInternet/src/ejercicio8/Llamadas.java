/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class Llamadas extends Thread {

    final static int ASCENSOR_PARADO = 0;
    final static int ASCENSOR_EN_MOVIMIENTO = 1;

    int estadoAscensor;

    int pisoInicial = 0;
    int pisoFinal;
    int pisoActual = 0;

    Edificio edificio = new Edificio();

    // este metodo solo lo llamare la primera vez ya que desconozco el piso inicial
    public Llamadas(int pisoInicial, int pisoFinal) {
        this.pisoInicial = pisoInicial;
        this.pisoFinal = pisoFinal;
    }

    // este metodo los llamara las veces que quiere pero despues de la primera llamada
    // no inicializa el pisoInicial ya que se le asignal el pisoFinal de la anterior llamada
    public Llamadas(int pisoFinal) {
        // el piso final es solo propiedad del obj, no de la clase
        // en cada objeto Llamadas quiero que sea UNICO por lo que la propiedad del estado final
        // depende solo de este obj
        this.pisoFinal = pisoFinal;
    }

    public void run() {
        llamada();
    }

    public synchronized void llamada() {
        // mientras esta en movimiento espera
        while (estadoAscensor == ASCENSOR_EN_MOVIMIENTO) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("**Problema en llamada**");
            }
        }
        
        // si no esta en movimiento se comprueba si la llamada es de subida o de bajada
        if (pisoInicial < this.pisoFinal) {
            try {
                System.out.println("Peticion de subir");
                llamadaSubir();
            } catch (InterruptedException ex) {
                System.out.println("**Problema subiendo**");
                ex.printStackTrace();
            }
        } else if (pisoInicial > this.pisoFinal) {
            try {
                System.out.println("Peticion de bajar");
                llamadaBajar();
            } catch (InterruptedException ex) {
                System.out.println("**Problema bajando**");
                ex.printStackTrace();
            }
        } else {
            System.out.println("--Estas en el mismo piso--");
            System.out.println("Enhorabuena, has llegado a tu destino");
        }

    }

    public synchronized void llamadaSubir() throws InterruptedException {
        estadoAscensor = ASCENSOR_EN_MOVIMIENTO;
        edificio.subirPisos(pisoInicial, pisoFinal);
        estadoAscensor = ASCENSOR_PARADO;
        pisoActual = this.pisoFinal;
        notify();
    }

    public synchronized void llamadaBajar() throws InterruptedException {
        estadoAscensor = ASCENSOR_EN_MOVIMIENTO;
        edificio.bajarPisos(pisoInicial, pisoFinal);
        estadoAscensor = ASCENSOR_PARADO;
        pisoActual = this.pisoFinal;
        notify();
    }

}
