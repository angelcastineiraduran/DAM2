/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6;

/**
 *
 * @author dam2
 */
public class Ejercicio6 extends Thread {
    private static double capital = 10000.0; // Capital fundacional inicial

    public void realizarIngreso(double monto) {
        synchronized (this) {
            capital += monto;
            System.out.println("Ingreso de $" + monto + ". Capital actual: $" + capital);
        }
    }

    public void realizarExtraccion(double monto) {
        synchronized (this) {
            if (capital >= monto) {
                capital -= monto;
                System.out.println("Extracción de $" + monto + ". Capital actual: $" + capital);
            } else {
                System.out.println("No hay suficiente capital para la extracción de $" + monto);
            }
        }
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Ingresos")) {
            for (int i = 0; i < 10; i++) {
                double montoIngreso = Math.random() * 1000;
                realizarIngreso(montoIngreso);
            }
        } else if (Thread.currentThread().getName().equals("Extracciones")) {
            for (int i = 0; i < 5; i++) {
                double montoExtraccion = Math.random() * 1000;
                realizarExtraccion(montoExtraccion);
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio6 ingresosThread = new Ejercicio6();
        Ejercicio6 extraccionesThread = new Ejercicio6();

        ingresosThread.setName("Ingresos");
        extraccionesThread.setName("Extracciones");

        ingresosThread.start();
        extraccionesThread.start();

        try {
            ingresosThread.join();
            extraccionesThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin de la simulación. Capital final: $" + capital);
    }
}


