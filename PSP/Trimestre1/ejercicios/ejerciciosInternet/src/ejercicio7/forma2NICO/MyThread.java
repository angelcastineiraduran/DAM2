/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7.forma2NICO;

/**
 *
 * @author ubuntu
 */
public class MyThread extends Thread {

    String nombre, cadena;
    Buzon buz;

    public MyThread(String nombre, String cadena, Buzon buz) {
        this.nombre = nombre;
        this.cadena = cadena;
        this.buz = buz;
    }

    public void run() {
        if (nombre.equals("Enviar")) {
            try {
                buz.escribir(cadena);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                buz.lectura(nombre);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
