/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author dam2
 */
public class Ejercicio2 extends Thread {

    public Ejercicio2(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " " + getName());
            try {
                //sleep((long)Math.random()*1000);
                sleep(1000);
            } catch (Exception ex) {
                System.out.println("error");
            }
            System.out.println("fin hilo de " + getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Ejercicio2 hilo1, hilo2, hilo3, hilo4;
        hilo1 = new Ejercicio2("Juan");
        hilo2 = new Ejercicio2("Pepe");
        hilo3 = new Ejercicio2("Antonio");
        hilo4 = new Ejercicio2("Angel");
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        
        System.out.println("**Principio join**");
        hilo1.join(); // hasta que no acaba hilo1 no se hace el resto (a no ser que acabe antes uno de los bucles hasta llegar aqui)*1
        //hilo2.join();
        //hilo3.join();
        //hilo4.join();
        System.out.println("**Fin del Main**");

    }
}
