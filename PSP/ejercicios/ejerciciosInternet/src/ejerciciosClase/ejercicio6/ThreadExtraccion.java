/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.ejercicio6;

/**
 *
 * @author ubuntu
 */
public class ThreadExtraccion extends Thread{

    Dineros obxD;
    int dinero;

    public ThreadExtraccion(Dineros obxD, int dinero) {
        this.obxD = obxD;
        this.dinero = dinero;
    }

    public void run() {
        obxD.setDinero((obxD.getDinero()) - dinero);
        System.out.println("Extraccion de " + dinero + "€, ahora quedan: " + obxD.getDinero() + "€");
    }
}
