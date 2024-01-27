/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8;

/**
 *
 * @author dam2
 */
public class Main {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        ascensor.start();

        // Simulación de llamadas al ascensor
        ascensor.llamar(5);
        try {
            Thread.sleep(3000); // Simulación de tiempo entre llamadas
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ascensor.llamar(15);
    }
}
