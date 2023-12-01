/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7.forma2NICO;

/**
 *
 * @author ubuntu
 */
public class Buzon {

    private String mensaje = null;

    public synchronized void escribir(String mensaje) throws InterruptedException {
        while (this.mensaje != null) {
            wait();
        }
        // para que se active el while de arriba
        this.mensaje = mensaje;
        notify();
    }

    public synchronized void lectura(String nombre) throws InterruptedException {
        while (this.mensaje == null) {
            wait();
        }
        System.out.println(nombre + ": " + mensaje);
        // para que se active el while de arriba
        mensaje = null;
        notify();
    }

}
