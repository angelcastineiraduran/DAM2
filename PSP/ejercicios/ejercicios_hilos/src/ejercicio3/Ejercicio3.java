/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author dam2
 */
public class Ejercicio3 extends Thread {
    private int threadCount;

    public Ejercicio3(String str, int threadCount) {
        super(str);
        this.threadCount = threadCount;
    }

    public void run() {
        System.out.println(getName() + " comenzó.");
        if (threadCount < 5) {
            for (int i = 0; i < 10; i++) {
                System.out.println(getName() + " se está procesando...");
                try {
                    sleep((long) (Math.random() * 500) + 100); // Tiempo aleatorio entre 100 y 600 ms
                } catch (InterruptedException ex) {
                    System.out.println("ERROR");
                }
            }

            // Crear un nuevo hilo hijo
            Ejercicio3 childThread = new Ejercicio3(getName() + "-Hijo", threadCount + 1);
            childThread.start();

            try {
                childThread.join(); // Esperar a que el hijo termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(getName() + " finalizó.");
    }

    public static void main(String[] args) {
        Ejercicio3 hilo1 = new Ejercicio3("Hilo-1", 1);

        hilo1.start();

        System.out.println("Fin del main");
    }
}
