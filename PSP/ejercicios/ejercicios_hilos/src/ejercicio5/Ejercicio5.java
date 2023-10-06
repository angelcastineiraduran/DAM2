/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5;

/**
 *
 * @author dam2
 */
public class Ejercicio5 extends Thread {

    public Ejercicio5(String str) {
        super(str);
    }

    public void run() {
        
        System.out.println("Hola soy el hilo numero " + getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Ejercicio5 hilo1;
        Ejercicio5 hilo2;
        hilo1 = new Ejercicio5("Hilo1");
        hilo2 = new Ejercicio5("Hilo2");
        
        // apartado a
        
        hilo2.start();
        hilo2.join();
        
        hilo1.start();
        hilo1.join();
        
        System.out.println("*************");
        // apartado b
        Ejercicio5 hilo3;
        Ejercicio5 hilo4;
        hilo3 = new Ejercicio5("Hilo1");
        hilo4 = new Ejercicio5("Hilo2");
        
        
        hilo3.setPriority(MIN_PRIORITY);
        hilo4.setPriority(MAX_PRIORITY);
        
        hilo3.start();
        hilo4.start();
        

        
    }
}
