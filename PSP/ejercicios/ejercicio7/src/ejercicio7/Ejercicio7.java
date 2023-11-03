/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7;

/**
 *
 * @author ubuntu
 */
public class Ejercicio7 {

    /**
     * El orden en el que se ejecutan los hilos puede variar ya que depende del 
     * SO y el planificador de hilos. Aunque se inicien primero los escritores, no
     * hay garantía ninguna de que se ejecuten antes que los lectores y viceversa
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * instancia que servira como recurso compartido
         */
        Buzon buzon = new Buzon();
        
        // se crean 3 hilos Escritor y 3 hilos Lector que operan en el MISMO objeto "buzon"
        Escritor esc1 = new Escritor(buzon, "msg del 1 hilo");
        Lector lec1  = new Lector(buzon);

        Escritor esc2 = new Escritor(buzon, "msg del 2 hilo");
        Lector lec2 = new Lector(buzon);

        Escritor esc3 = new Escritor(buzon, "msg del 3 hilo");
        Lector lec3 = new Lector(buzon);
        
        // se inician los hilos
        esc1.start();
        esc2.start();
        esc3.start();
        
        lec1.start();
        lec2.start();
        lec3.start();
    }

}
