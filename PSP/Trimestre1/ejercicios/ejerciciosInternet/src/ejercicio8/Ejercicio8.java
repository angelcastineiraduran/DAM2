/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8;

/**
 *
 * @author ubuntu
 */
public class Ejercicio8 {

    public static void main(String[] args) throws InterruptedException {
        Llamadas llamada1 = new Llamadas(0,10);
        Llamadas llamada2 = new Llamadas(5);
        Llamadas llamada3 = new Llamadas(3);
        Llamadas llamada4 = new Llamadas(15);

        llamada1.start();
        llamada1.join();
        Thread.sleep((long) (2000*Math.random()));

        llamada2.start();
        Thread.sleep((long) (2000*Math.random()));

        llamada3.start();
        Thread.sleep((long) (2000*Math.random()));

        llamada4.start();
        Thread.sleep((long) (2000*Math.random()));

    }
}
